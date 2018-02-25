package bg.praskovka.examregistration.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bg.praskovka.examregistration.models.ApplicationUser;
import bg.praskovka.examregistration.repositories.ApplicationUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	private ApplicationUserRepository repo;

	public UserController(ApplicationUserRepository repo) {
		this.repo = repo;
	}

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<ApplicationUser>> getUsers() {
		return new ResponseEntity<Iterable<ApplicationUser>>(this.repo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/{userId}")
	public @ResponseBody ResponseEntity<ApplicationUser> getUser(
		@PathVariable Long userId
	) {
		ApplicationUser user = this.repo.findOne(userId);
		
		if (user == null) {
			return new ResponseEntity<ApplicationUser>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ApplicationUser>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<ApplicationUser> saveUser(@RequestBody ApplicationUser user) {
		ApplicationUser createdUser = this.repo.save(user);
		return new ResponseEntity<ApplicationUser>(createdUser, HttpStatus.CREATED);
	}
}
