package com.microservice.example.microserviceexample.controller;





import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;



public class CommentModel {


  

   @Id
   public ObjectId _id;
   private String id;

   private String username;


private String emailaddress;


   
   
   public CommentModel(){
   }
   
  
   
   public CommentModel(ObjectId _id, String id, String username,
		String emailaddress) {
	super();
	this._id = _id;
	this.id = id;
	this.username = username;
	this.emailaddress = emailaddress;
}



public String get_id() { return _id.toHexString(); }
   public void set_id(ObjectId _id) { this._id = _id; }
   
   public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailAddress() {
		return emailaddress;
	}

	public void setEmailAddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	
}
