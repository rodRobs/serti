package com.mx.serti.requests.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tbl_request")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Request implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "serial")
    private int reqId;

    @Column(name = "req_url", unique = true, nullable = false, length = 150)
    private String reqUrl;

    @Column(name = "req_description", nullable = false, columnDefinition = "LONGTEXT")
    private String reqDescription;

}
