package org.alvin.opsdev.center.service;

import org.alvin.opsdev.center.domain.FileItem;
import org.alvin.opsdev.center.repository.FileItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2016/12/25.
 */
@Service
@Transactional(readOnly = true)
public class FileItemService {

    @Autowired
    private FileItemRepository fileItemRepository;

    @Transactional
    public FileItem save(FileItem item) {
        return this.fileItemRepository.save(item);
    }

    public Page<FileItem> findAll(Pageable pageable) {
        return this.fileItemRepository.findAll(pageable);
    }

    public FileItem findOne(Long id) {
        return this.findOne(id);
    }
}
