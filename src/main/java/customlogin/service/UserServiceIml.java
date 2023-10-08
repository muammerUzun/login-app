package customlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import customlogin.dto.UserDto;
import customlogin.model.User;
import customlogin.repo.UserRepo;

@Service
public class UserServiceIml implements UserService {
	
	@Autowired private PasswordEncoder passwordEncoder;
	
	private UserRepo userRepo;

	public UserServiceIml(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepo.findUserByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()),userDto.getFullname());
		return userRepo.save(user);
	}

}
