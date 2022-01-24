package com.springboot.services;

import com.springboot.models.FilesInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileService {
    void saveFile(String description, MultipartFile multipartFile);
    List<FilesInfo> getAllFiles();

    void addFileToResponse(String fileName, HttpServletResponse response);
}
