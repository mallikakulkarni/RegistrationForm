package com.springapp.mvc;

import com.mongodb.Mongo;
import org.apache.catalina.connector.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.certpath.OCSPResponse;

import java.net.UnknownHostException;

@Controller
@Configuration
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/index")
public class HelloController {

	public static void main(String[] args) {
		SpringApplication.run(HelloController.class);
	}

	@RequestMapping(value="", method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		return "RegistrationPage";
	}

	@RequestMapping(value="", method = RequestMethod.POST)
	@ResponseBody
	public String printWelcome(@RequestParam(value = "userid") String userid, @RequestParam(value = "password") String password,
								   @RequestParam(value = "email") String email, @RequestParam(value = "secques1", defaultValue = "null") String secques1,
								   @RequestParam(value = "secans1", defaultValue = "null") String secans1,
								   @RequestParam(value = "secques2", defaultValue = "null") String secques2,
								   @RequestParam(value = "secans2", defaultValue = "null") String secans2,
								   @RequestParam(value = "mobile", defaultValue = "null") String mobile,
								   @RequestParam(value = "address", defaultValue = "null") String address,
								   @RequestParam(value = "interests", defaultValue = "null") String interests,
								   Model model) {
		MongoOperations mongoOperations = getMongoOperationInstance();
		User user = new User(userid, password, email, secques1, secans1, secques2, secans2, mobile, address, interests);
		user = user.getPOJOFromInfo();
		if (mongoOperations != null) {
			mongoOperations.insert(user, "user");
		}
		return "success";
	}

	private MongoOperations getMongoOperations() throws UnknownHostException {
		MongoOperations mongoOperations = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "test"));
		return mongoOperations;
	}

	private MongoOperations getMongoOperationInstance() {
		MongoOperations mongoOperations = null;
		try {
			mongoOperations = getMongoOperations();
		} catch (UnknownHostException uhe) {
			System.out.println("Unknown Host");
			return null;
		}
		return mongoOperations;
	}

}