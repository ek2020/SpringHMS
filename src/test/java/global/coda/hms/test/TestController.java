package global.coda.hms.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.models.JPAUser;

@RestController
public class TestController {
	
	@RequestMapping(value = "/JPAUser", method = RequestMethod.GET)
	public JPAUser firstPage() {

		JPAUser user = new JPAUser();
		user.setName("karthick");
		user.setEmail("karthickelumalai.4039@gmail.com");
		return user;
	}

}
