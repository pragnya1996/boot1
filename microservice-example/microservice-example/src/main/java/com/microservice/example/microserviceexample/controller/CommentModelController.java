package com.microservice.example.microserviceexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentModelController {
	@Autowired
	  private CommentModelRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<CommentModel> getAllModel() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public CommentModel getPetById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody CommentModel model) {
	    model.set_id(id);
	    repository.save(model);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public CommentModel createPet(@Valid @RequestBody CommentModel model) {
	    model.set_id(ObjectId.get());
	    repository.save(model);
	    return model;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deletePet(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }
}
