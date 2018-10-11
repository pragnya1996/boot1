package com.microservice.example.microserviceexample.controller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

public interface CommentModelRepository extends MongoRepository<CommentModel, String>{


    public CommentModel findBy_id(ObjectId _id);
}

