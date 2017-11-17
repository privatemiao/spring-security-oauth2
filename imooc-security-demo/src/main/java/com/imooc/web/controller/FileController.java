package com.imooc.web.controller;

import com.imooc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {
    private static final String FOLDER = "D:/tmp";

    @PostMapping
    public FileInfo upload(@RequestBody MultipartFile file) throws IOException {
        System.out.println(String.format("Filename: %s, OriginalFile: %s, Size: %d", file.getName(), file.getOriginalFilename(), file.getSize()));

        File localFile = new File(FOLDER, new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (InputStream is = new FileInputStream(new File(FOLDER, id + ".txt"));
             OutputStream os = response.getOutputStream()) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachement;filename=test.txt");
            IOUtils.copy(is, os);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
