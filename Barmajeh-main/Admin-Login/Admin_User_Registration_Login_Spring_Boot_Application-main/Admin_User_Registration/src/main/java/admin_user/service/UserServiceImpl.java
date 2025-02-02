package admin_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admin_user.dto.PasswordDto;
import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole(), userDto.getFullname());
		return userRepository.save(user);
	}

	@Override
	public boolean changePassword(String email, PasswordDto passwordDto) {
		User user = userRepository.findByEmail(email);
		if (user != null && passwordEncoder.matches(passwordDto.getOldPassword(), user.getPassword())
				&& passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
			user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
			userRepository.save(user);
			return true;
		}
		return false;
	}
}
