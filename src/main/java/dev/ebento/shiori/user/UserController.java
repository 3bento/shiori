package dev.ebento.shiori.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ebento.shiori.user.dto.UserDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("{userId}")
	public ResponseEntity<UserDTO> findByUserId(@PathVariable String userId){
		UserDTO userDTO = userService.findById(Integer.parseInt(userId));
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserDTO> saveOrUpdateUser(@RequestBody UserDTO userDTO){
		return new ResponseEntity<>(userService.saveOrUpdate(userDTO), HttpStatus.OK);
	}

}
