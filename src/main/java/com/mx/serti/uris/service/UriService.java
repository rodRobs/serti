package com.mx.serti.uris.service;

import com.mx.serti.uris.dto.UriDTO;

import java.util.List;

public interface UriService {

    List<UriDTO> findAll();

    UriDTO findById(int id);

}
