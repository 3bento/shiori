package dev.ebento.shiori.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.ebento.shiori.user.dto.UserDTO;
import dev.ebento.shiori.user.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRepository userRepository;

	public UserDTO findById(Integer userId) {
		Optional<User> opUser = userRepository.findById(userId);

		if(opUser.isPresent())
			return userMapper.toUserDto(opUser.get());

		// TODO i18n here!
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User "+userId+" not found.");
	}

	public UserDTO saveOrUpdate(@UserDTO userDTO) {
		User user = userRepository.save(userMapper.toUser(userDTO));
		return userMapper.toUserDto(user);
	}
	
}
