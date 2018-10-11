package com.cloud.empconsumer.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerControllerClient {
	@Autowired
	private LoadBalancerClient loadbalancer;
	
	/*@RequestMapping(value="/copy",method=RequestMethod.GET)
	public String copy() throws RestClientException,IOException{
	String baseURL="http://localhost:9008/copy";
	RestTemplate restTemplate=new RestTemplate();
	ResponseEntity<String>response=null;
	try{
		response=restTemplate.exchange(baseURL,HttpMethod.GET,getHeaders1(),String.class);
	}
	catch(Exception ex){
		System.out.println(response.getBody());
	}
	System.out.println(response.getBody());
	return response.getBody();
}
	
	private static HttpEntity<?>getHeaders1() throws IOException{
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	@RequestMapping(value="/move",method=RequestMethod.GET)
	public String move() throws RestClientException,IOException{
	String baseURL="http://localhost:9008/move";
	RestTemplate restTemplate=new RestTemplate();
	ResponseEntity<String>response=null;
	try{
		response=restTemplate.exchange(baseURL,HttpMethod.GET,getHeaders2(),String.class);
	}
	catch(Exception ex){
		System.out.println(response.getBody());
	}
	System.out.println(response.getBody());
	return response.getBody();
}
	
	private static HttpEntity<?>getHeaders2() throws IOException{
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete() throws RestClientException,IOException{
	String baseURL="http://localhost:9008/delete";
	RestTemplate restTemplate=new RestTemplate();
	ResponseEntity<String>response=null;
	try{
		response=restTemplate.exchange(baseURL,HttpMethod.GET,getHeaders3(),String.class);
	}
	catch(Exception ex){
		System.out.println(response.getBody());
	}
	System.out.println(response.getBody());
	return response.getBody();
}
	
	private static HttpEntity<?>getHeaders3() throws IOException{
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}*/
	
	/*@Autowired
	private DiscoveryClient discoveryClient;
@RequestMapping(value="/getemployee",method=RequestMethod.GET)*/
	public void getEmployee() throws RestClientException,IOException{
ServiceInstance serviceInstance=loadbalancer.choose("empproducer");
	System.out.println(serviceInstance.getUri());
	String baseUrl= serviceInstance.getUri().toString();
	baseUrl= baseUrl + "/employee";
	
	
	/*String baseURL="http://localhost:9008/employee";*/
	RestTemplate restTemplate=new RestTemplate();
	ResponseEntity<String>response=null;
	try{
		response=restTemplate.exchange(baseUrl,HttpMethod.GET,getHeaders(),String.class);
	}
	catch(Exception ex){
		System.out.println(response.getBody());
	}
	System.out.println(response.getBody());
	
}
	
	private static HttpEntity<?>getHeaders() throws IOException{
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}

