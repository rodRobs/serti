package com.mx.serti.requests.service;

import com.mx.serti.exceptions.NotFoundException;
import com.mx.serti.requests.dto.RequestDTO;
import com.mx.serti.requests.entity.Request;
import com.mx.serti.requests.repository.RequestRepository;
import com.mx.serti.util.constants.Entity;
import com.mx.serti.util.constants.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Override
    public List<RequestDTO> findAll() {
        log.debug("RequestServiceImpl::findAll");
        return requestRepository.findAll().stream().map(RequestDTO::new).collect(Collectors.toList());
    }

    @Override
    public RequestDTO findById(int id) {
        log.debug("RequestServiceImpl::findAll");
        Request request = requestRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format(ErrorMessages.NOT_FOUND, Entity.REQUEST) + id);
        });
        return entityToDto(request);
    }

    public RequestDTO entityToDto(Request request) {
        return new RequestDTO(request);
    }
}
