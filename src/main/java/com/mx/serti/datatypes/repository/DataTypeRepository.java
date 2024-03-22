package com.mx.serti.datatypes.repository;

import com.mx.serti.datatypes.entity.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTypeRepository extends JpaRepository<DataType, Long> {

}
