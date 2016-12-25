package org.alvin.opsdev.core.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by tangzhichao on 2016/12/9.
 */
@RestController
@RequestMapping("api/file")
public class FileController {

    @RequestMapping(value = "/upload")
    public void handleFileUpload(@RequestParam MultipartFile file) throws Exception {
        String name = file.getName();
        if (!file.isEmpty()) {
            try {
                String path = "E:/" + name;
                try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(Paths.get(path)))) {
                    out.write(file.getBytes());
                    out.flush();
                }
            } catch (Exception e) {
               throw e;
            }
        }
        throw new Exception("no file");
    }

//    /**
//     * 可以有验证一类的东西，我这里没做
//     * @param request
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/bigfile")
//    public BigFileResponse uploadBigFile(@RequestBody BigFileRequest request) throws IOException {
//        request.getName();
//        String path = "E:/tt" + request.getName();
//        try (RandomAccessFile raf = new RandomAccessFile(new File(path), "rws")) {
//            raf.seek(raf.length());
//            byte [] buff = CompressUtils.unGZipCompress(request.getBuff());
//            raf.write(buff);
//        }
//        BigFileResponse res = new BigFileResponse();
//        res.setName(request.getName());
//        res.setLenth(request.getLenth());
//        return res;
//    }

}
