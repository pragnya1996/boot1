package com.what;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
	@RequestMapping("/holo")
	String home()
	{
		return "ypo";
	}

}
