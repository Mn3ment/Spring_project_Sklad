package com.springboot.controller;

import com.springboot.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class FilesController {
    private final FileService fileService;

    @GetMapping("/files/upload")
    public String getUploadPage() {
        return "files_upload";
    }

    // GET http://localhost/files/faf94d48-aa7a-440b-830f-0661213685cd.jpg
    @GetMapping("/files/{file:.+}")
    public void getFile(@PathVariable("file") String fileName, HttpServletResponse response) {
        fileService.addFileToResponse(fileName, response);
    }


    @PostMapping("/files/upload")
    public String uploadFile(@RequestParam("description") String description,
                           @RequestParam("file") MultipartFile multipartFile) {
        fileService.saveFile(description, multipartFile);
        return "redirect:/orders/add_order";
    }
}
