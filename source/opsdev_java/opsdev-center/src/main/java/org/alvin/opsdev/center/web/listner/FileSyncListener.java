package org.alvin.opsdev.center.web.listner;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.alvin.opsdev.center.client.FileClient;
import org.alvin.opsdev.center.client.RestfulClient;
import org.alvin.opsdev.center.service.ChannelService;
import org.alvin.opsdev.center.web.listner.event.FileEvent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Administrator on 2017/1/1.
 */
@Component
public class FileSyncListener implements ApplicationListener<FileEvent> {


    @Autowired
    private ChannelService channelService;

    @Autowired
    private RestfulClient restfulClient;


    @Override
    public void onApplicationEvent(FileEvent fileEvent) {
        Path path = fileEvent.getSource();
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), path.toFile());
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", path.toFile().getName(), requestBody);

        this.channelService.findAll().forEach(channel -> {
            FileClient fileClient = restfulClient.getClient(channel.getAddress(), channel.getPort(), FileClient.class);
            try {
                fileClient.upload(body).execute().body();
            } catch (IOException e) {
                Logger.getLogger(this.getClass()).error(e);
            }
        });
    }
}
