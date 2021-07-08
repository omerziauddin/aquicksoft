package com.aquicksoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aquicksoft.entities.ImageEntity;

@Repository
public interface ImageRepository extends MongoRepository<ImageEntity, Long> {

}
