package com.microservice.model.microservicemodel.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="model")
public class modelpojo {
       @Id
	   public ObjectId _id;
	   public String id;

	   public String username;
	   public String emailaddress;


	   
	   
	   public modelpojo(){
	   }
	   
	  
	   
	   public modelpojo(ObjectId _id,String id, String username,
			String emailaddress) {
		super();
	    this._id =_id;
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
