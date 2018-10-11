package com.microservice.model.microservicemodel.control;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.model.microservicemodel.model.modelpojo;

	@RestController
	@RequestMapping(value="/model")
	public class modelController {
		@Autowired
		  private CommentModelRepository repository;
		  
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public List<modelpojo> getAllModels() {
			System.out.println(repository.findAll());
		return repository.findAll();
		}
		
		 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
		  public modelpojo getModelById(@PathVariable("id") ObjectId id) {
		    return repository.findBy_id(id);
		  }
		  
		  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		  public void modifyModelById(@PathVariable("id") ObjectId id, @Valid @RequestBody modelpojo model) {
		    model.set_id(id);
		    repository.save(model);
		  }
		  
		  @RequestMapping(value = "/add", method = RequestMethod.POST)
		  public modelpojo createModel(@Valid @RequestBody modelpojo model) {
			  model.set_id(ObjectId.get());
		    repository.save(model);
		    return model;
		  }
		  
		  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		  public void deleteModel(@PathVariable ObjectId id) {
		    repository.delete(repository.findBy_id(id));
		  }


	}

