package org.alvin.opsdev.sync.mgr.service;

import org.alvin.opsdev.sync.mgr.bean.FileItem;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/12/28.
 */
@Service
public class TaskService implements InitializingBean {

    @Value("$(sync.task.dir)")
    private String task_dir;

    public List<FileItem> findAll() throws IOException {
        List<File> files = Files.list(Paths.get(task_dir))
                .filter(path -> path.toString().toLowerCase().endsWith(".json"))
                .map(path -> path.toFile())
                .collect(Collectors.toList());
        List<FileItem> list = Lists.emptyList();
        for (int i = 0; i < files.size(); i++) {
            FileItem item = new FileItem();
            item.setId(i + 1);
            item.setName(files.get(i).getName());
            item.setTime(files.get(i).lastModified());
            list.add(item);
        }
        return list;
    }

    public FileItem findOne(Integer id) throws IOException {
        List<File> files = Files.list(Paths.get(task_dir))
                .filter(path -> path.toString().toLowerCase().endsWith(".json"))
                .map(path -> path.toFile())
                .collect(Collectors.toList());
        for (int i = 0; i < files.size(); i++) {
            if (i - 1 != id) {
                continue;
            }
            FileItem item = new FileItem();
            item.setId(i + 1);
            item.setName(files.get(i).getName());
            item.setTime(files.get(i).lastModified());
            return item;
        }
        return null;
    }

    public FileItem modify(FileItem item) {
        return item;
    }

    public void delete(Integer id) throws IOException {
        List<File> files = Files.list(Paths.get(task_dir))
                .filter(path -> path.toString().toLowerCase().endsWith(".json"))
                .map(path -> path.toFile())
                .collect(Collectors.toList());
        for (int i = 0; i < files.size(); i++) {
            if (i - 1 != id) {
                continue;
            }
            files.get(i).delete();
        }
    }

    public void add(FileItem item) {
        System.out.println(item);
    }

    public void uploadFile(MultipartFile file) throws IOException {
        Path path = Paths.get(task_dir, file.getName());
        Files.copy(file.getInputStream(), path);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Files.createDirectories(Paths.get(task_dir));
    }
}
