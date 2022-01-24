package com.springboot.services;

import com.springboot.models.FilesInfo;
import com.springboot.repositories.FilesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.lang.String;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FileServiceImpl implements FileService {

    @Value("${files.storage.path}")
    private String storageFolder;
    private final FilesRepository filesRepository;

    @Override
    public void saveFile(String description, MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.indexOf("."));
        FilesInfo filesInfo = FilesInfo.builder()
                .originalName(multipartFile.getOriginalFilename())
                .mimeType(multipartFile.getContentType())
                .description(description)
                .uploadDate(LocalDateTime.now())
                .storageName(UUID.randomUUID() + extension)
                .size(multipartFile.getSize())
                .build();
        filesRepository.save(filesInfo);
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(storageFolder, filesInfo.getStorageName()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<FilesInfo> getAllFiles() {
        return filesRepository.findAll();
    }

    @Override
    public void addFileToResponse(String fileName, HttpServletResponse response) {
        FilesInfo filesInfo = filesRepository.findByStorageName(fileName);
        response.setContentType(filesInfo.getMimeType());
        response.setContentLengthLong(filesInfo.getSize());
        response.setHeader("Content-Disposition", "filename=\"" + filesInfo.getOriginalName() + "\"");
        try {
            Files.copy(Paths.get(storageFolder, filesInfo.getStorageName()), response.getOutputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
