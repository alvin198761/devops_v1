package org.alvin.opsdev.sync.mgr.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2016/12/21.
 */
@Service
public class ProcessService {

    @Value("${sync.path}")
    private String syncDir;

    public void exec() throws Exception {
        String os = System.getProperty("os.name");
        Path path;
        String encoding;
        if (os.toLowerCase().contains("windows")) {
            path = Paths.get(syncDir, "bin", "startup.bat");
            encoding = "GBK";
        } else {
            path = Paths.get(syncDir, "bin", "startup");
            encoding = "UTF-8";
        }
        ProcessBuilder processBuilder = new ProcessBuilder("java", "java", "\"" + path.toFile().getName() + "\"");
        processBuilder.directory(path.toFile().getParentFile());
        Process process = processBuilder.start();
        new Thread(() -> outLog(process.getInputStream(), encoding)).start();
        process.waitFor();
        process.destroy();
    }

    private void outLog(InputStream inputStream, String encoding) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, encoding))) {
            String line ;
            while((line = reader.readLine())!= null){
                Logger.getLogger(this.getClass()).debug(line);
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex);
        }
    }
}
