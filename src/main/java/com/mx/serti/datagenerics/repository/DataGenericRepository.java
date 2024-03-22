package com.mx.serti.datagenerics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mx.serti.datagenerics.entity.DataGeneric;

import java.util.List;

@Repository
public interface DataGenericRepository extends JpaRepository<DataGeneric, Long> {

    List<DataGeneric> findByDataTypeDatyId(Long id);

}
