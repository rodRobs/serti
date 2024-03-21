package com.mx.serti.uris.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tbl_uri")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Uri implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uri_id")
    private int uriId;

    @Column(name = "uri_url", unique = true, nullable = false, length = 150)
    private String uriUrl;

    @Column(name = "uri_description", nullable = false, columnDefinition = "LONGTEXT")
    private String uriDescription;

}
