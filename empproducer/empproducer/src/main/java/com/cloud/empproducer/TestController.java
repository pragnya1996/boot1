package com.cloud.empproducer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

public class TestController {

	@RequestMapping(value="/employee", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="fallback")
	public empPojo  firstPage(){
		empPojo emp1=new empPojo();
		emp1.setName("pragnya");
		emp1.setDesignation("analyst");
		emp1.setEmpId("155342");
		emp1.setSalary(20000);
		
		if(emp1.getName().equalsIgnoreCase("pragnya"))
			throw new RuntimeException();
		return emp1;
	}
	
	public empPojo fallback(){
		empPojo emp1=new empPojo();
		emp1.setName("fallback-emp1");
		emp1.setDesignation("fallback-manager");
		emp1.setEmpId("fallback-1");
		emp1.setSalary(50000);
		return emp1;
	}
}
