package com.mx.serti.uris.service;

import com.mx.serti.exceptions.NotFoundException;
import com.mx.serti.uris.dto.UriDTO;
import com.mx.serti.uris.entity.Uri;
import com.mx.serti.uris.repository.UriRepository;
import com.mx.serti.util.constants.Entity;
import com.mx.serti.util.constants.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class UriServiceImpl implements UriService {

    @Autowired
    UriRepository requestRepository;

    @Override
    public List<UriDTO> findAll() {
        log.debug("UriServiceImpl::findAll");
        return requestRepository.findAll().stream().map(UriDTO::new).toList();
    }

    @Override
    public UriDTO findById(int id) {
        log.debug("UriServiceImpl::findById {}", id);
        Uri request = requestRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format(ErrorMessages.NOT_FOUND, Entity.URI) + id);
        });
        return entityToDto(request);
    }

    public UriDTO entityToDto(Uri request) {
        return new UriDTO(request);
    }
}
