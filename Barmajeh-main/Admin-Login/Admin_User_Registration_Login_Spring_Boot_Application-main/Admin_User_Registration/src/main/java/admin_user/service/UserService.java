package admin_user.service;

import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.dto.PasswordDto;

public interface UserService {

	User save(UserDto userDto);

	boolean changePassword(String username, PasswordDto passwordDto);
}
