package org.alvin.opsdev.sync;

import org.alvin.opsdev.sync.service.TaskService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tangzhichao on 2016/12/20.
 */
public class Application {

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(System.getProperty("user.dir"),"data");
        System.out.println("json dir:" +dir.toString());
        if(!Files.exists(dir)){
            Files.createDirectories(dir);
            Files.copy(Application.class.getResourceAsStream("/simple.json"),Paths.get(dir.toString(),"simple.json"));
        }
        TaskService taskService = new TaskService();
        Files.list(dir).filter(path ->
                path.toString().endsWith(".json") && !path.toFile().getName().equalsIgnoreCase("simple.json")
        ).forEach(taskService::sync);
        taskService.waitFor();
        System.exit(0);
    }
}
