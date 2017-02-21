package org.alvin.opsdev.center.web.listner.event;

import org.springframework.context.ApplicationEvent;

import java.nio.file.Path;

/**
 * Created by Administrator on 2017/1/1.
 */
public class FileEvent extends ApplicationEvent {

    public FileEvent(Path source) {
        super(source);
    }

    @Override
    public Path getSource() {
        return (Path) super.getSource();
    }
}
