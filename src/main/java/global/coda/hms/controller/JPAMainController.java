package global.coda.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.models.JPAUser;
import global.coda.hms.repository.UserRepository;


@RestController 
@RequestMapping(path="/demo")
public class JPAMainController {
	  @Autowired 
	 UserRepository userRepository;
		
		@PostMapping(path="/add") 
		  public  String addNewUser (@RequestBody JPAUser jpau) {
		    System.out.println("welcome");
		    JPAUser n = new JPAUser();
		    n.setName(jpau.getName());
		    n.setEmail(jpau.getEmail());
		    userRepository.save(n);
		    return "Saved";
		  }

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<JPAUser> getAllUsers() {
	    return userRepository.findAll();
	  }
	}