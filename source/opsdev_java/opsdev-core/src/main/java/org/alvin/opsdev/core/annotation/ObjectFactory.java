package org.alvin.opsdev.core.annotation;

import org.alvin.opsdev.commons.bean.enums.ExecutorType;
import org.alvin.opsdev.core.executor.CmdExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Administrator on 2016/11/20.
 */
@Component
public class ObjectFactory {

    private Map<ExecutorType, CmdExecutor> instanceMap = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;


    /**
     * 扫描业务类
     *
     * @param packageURL
     * @throws Exception
     */
    public void doScanService(String packageURL) throws Exception {
        List<Class> list = new ArrayList<Class>();
        try {
            String packageName = packageURL;
            packageURL = packageURL.replaceAll("[.]", "/");
            URL baseURL = Thread.currentThread().getContextClassLoader().getResource(packageURL);
            if ("file".equals(baseURL.getProtocol())) {
                list.addAll(doDevScan(baseURL, packageName));
            } else if ("jar".equals(baseURL.getProtocol())) {
                list.addAll(doRuntimeScan(baseURL, packageName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initService(list);
    }

    /**
     * 将扫描的类进行过滤，不是该注解的一律放弃掉
     *
     * @param list
     * @throws Exception
     */
    private void initService(List<Class> list) throws Exception {
        for (Class c : list) {
            // 获取类的所有注解
            Annotation annotation = c.getAnnotation(Executor.class);
            if (annotation == null) {
                continue;
            }
//            OSType type = AccessController.doPrivileged(new PrivilegedAction<OSType>() {
//                @Override
//                public OSType run() {
//                    Class c = annotation.getClass();
//                    try {
//                        Method m = c.getMethod("value");
//                        boolean flag = m.isAccessible();
//                        OSType os = (OSType) m.invoke(annotation);
//                        m.setAccessible(flag);
//                        return os;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//            });

            ExecutorType executorType = AccessController.doPrivileged(new PrivilegedAction<ExecutorType>() {
                @Override
                public ExecutorType run() {
                    Class c = annotation.getClass();
                    try {
                        Method m = c.getMethod("executor");
                        boolean flag = m.isAccessible();
                        ExecutorType os = (ExecutorType) m.invoke(annotation);
                        m.setAccessible(flag);
                        return os;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            });
            if (executorType == null) {
                continue;
            }
            instanceMap.put(executorType, (CmdExecutor) applicationContext.getBean(c));
        }
    }

    /**
     * 运行时只会通过这个方法调用
     *
     * @param baseURL
     * @param packageName
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static List<Class> doRuntimeScan(URL baseURL, String packageName)
            throws IOException, ClassNotFoundException {
        List<Class> classList = new ArrayList<Class>();
        //
        JarFile jar = ((JarURLConnection) baseURL.openConnection()).getJarFile();
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            JarEntry je = entries.nextElement();
            String urlName = je.getName().replace('/', '.');
            if (!urlName.startsWith(packageName)) {
                continue;
            }
            if (!urlName.endsWith(".class")) {
                continue;
            }
            String classUrl = urlName.substring(0, urlName.length() - 6);
            classList.add(Class.forName(classUrl));
        }
        return classList;
    }

    /**
     * 开发时会用到的方法
     *
     * @param baseURL
     * @param packageName
     * @throws Exception
     */
    private static List<Class> doDevScan(URL baseURL, String packageName) throws Exception {
        String filePath = URLDecoder.decode(baseURL.getFile(), "UTF-8");
        List<Class> classList = new ArrayList<Class>();

        LinkedList<File> files = new LinkedList<File>();
        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new Exception("没有找到对应的包");
        }
        files.add(dir);
        // 循环读取目录以及子目录下的所有类文件
        while (!files.isEmpty()) {
            File f = files.removeFirst();
            if (f.isDirectory()) {
                File[] fs = f.listFiles();
                int i = 0;
                for (File childFile : fs) {
                    files.add(i++, childFile);
                }
                continue;
            }
            String subPath = f.getAbsolutePath().substring(dir.getAbsolutePath().length());
            String classUrl = packageName + subPath.replace(File.separatorChar, '.');
            classUrl = classUrl.substring(0, classUrl.length() - 6);
            classList.add(Class.forName(classUrl));
        }
        return classList;
    }

    /**
     * 对外开放的获取和创建实例的方法
     *
     * @return
     * @throws Exception
     */
    public CmdExecutor getInstance(ExecutorType type) throws Exception {
        return instanceMap.get(type);
    }
}
