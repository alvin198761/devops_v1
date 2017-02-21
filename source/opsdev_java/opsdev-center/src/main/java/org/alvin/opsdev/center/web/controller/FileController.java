package org.alvin.opsdev.center.web.controller;

import com.google.common.hash.Hashing;
import org.alvin.opsdev.center.domain.FileItem;
import org.alvin.opsdev.center.domain.enums.FileType;
import org.alvin.opsdev.center.service.FileItemService;
import org.alvin.opsdev.center.web.listner.event.FileEvent;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/18.
 */
@RestController
@RequestMapping("file")
public class FileController implements InitializingBean {

    @Value("${upload.dir}")
    private String uploadDir;
    @Autowired
    private FileItemService fileItemService;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public FileItemBean upload(@RequestParam("upfile") MultipartFile file) throws IOException {
        Assert.isTrue(!file.isEmpty(), "文件内容为空！");
        String uuid = UUID.randomUUID().toString();
        String fileName = Hashing.md5().hashBytes(uuid.getBytes()).toString();
        Path path = Paths.get(uploadDir, uuid, fileName);
        Files.createDirectories(path.getParent());
        FileItemBean item = new FileItemBean();
        item.setPath(uuid.concat(File.separator).concat(fileName));
        item.setName(file.getName());
        try (InputStream is = file.getInputStream()) {
            item.setSize(Files.copy(is, path));
        }
        this.applicationContext.publishEvent(new FileEvent(path));
        return item;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addFile(String type, String name, String path, Principal principal) {
        Assert.notNull(type, "文件类型不能为空");
        Assert.notNull(name, "文件名称不能为空");
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        User user = (User) token.getPrincipal();
        //
        FileItem fileItem = new FileItem();
        fileItem.setName(name);
        fileItem.setType(FileType.valueOf(type));
        fileItem.setMd5Path(path);
        fileItem.setTime(new Date());
        fileItem.setUserName(user.getUsername());
        this.fileItemService.save(fileItem);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<FileItem> list(@PageableDefault(size = 20, sort = {"id", "time"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return this.fileItemService.findAll(pageable);
    }

    @RequestMapping(value = "download/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> dowload(@PathVariable("id") Long id) throws IOException {
        FileItem fileItem = this.fileItemService.findOne(id);
        Assert.notNull(fileItem, "file must not be null");
        Path path = Paths.get(uploadDir, fileItem.getMd5Path());
        FileSystemResource file = new FileSystemResource(path.toFile());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Files.createDirectories(Paths.get(this.uploadDir));
    }

    class FileItemBean {

        private String path;
        private String name;
        private long size;


        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
