package com.example.crud_test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ReportProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_accuser")
    private User accuser;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String title;

    @Lob
    @Size(max = 10000)
    private String content;

    private Date dateSend;
    private String status;
    private String reasonReject;
}
