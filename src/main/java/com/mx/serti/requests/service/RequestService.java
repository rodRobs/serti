package com.mx.serti.requests.service;

import com.mx.serti.requests.dto.RequestDTO;

import java.util.List;

public interface RequestService {

    List<RequestDTO> findAll();

    RequestDTO findById(int id);

}
