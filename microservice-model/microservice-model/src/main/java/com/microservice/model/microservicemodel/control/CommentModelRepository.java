package com.microservice.model.microservicemodel.control;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.model.microservicemodel.model.modelpojo;



public interface CommentModelRepository extends MongoRepository<modelpojo, String>{


   modelpojo findBy_id(ObjectId _id);

}
