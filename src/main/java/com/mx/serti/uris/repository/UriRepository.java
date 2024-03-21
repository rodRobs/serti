package com.mx.serti.uris.repository;

import com.mx.serti.uris.entity.Uri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UriRepository extends JpaRepository<Uri, Integer> {
}
