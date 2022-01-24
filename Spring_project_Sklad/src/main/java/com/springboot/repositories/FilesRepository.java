package com.springboot.repositories;

import com.springboot.models.FilesInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<FilesInfo, Integer> {
    FilesInfo findByStorageName(String storageName);
}
