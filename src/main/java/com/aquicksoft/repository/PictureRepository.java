package com.aquicksoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aquicksoft.entities.PictureEntity;

@Repository
public interface PictureRepository extends  MongoRepository<PictureEntity,Long>{

	boolean existsById(Long id);

}
