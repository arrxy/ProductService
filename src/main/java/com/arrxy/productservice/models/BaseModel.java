package com.arrxy.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
}
