package admin_user.controller;

import java.security.Principal;

import admin_user.dto.PasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import admin_user.dto.UserDto;
import admin_user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}

	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfully!");
		return "redirect:http://localhost:1001";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/user-page")
	public String userPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "redirect:http://localhost:1001";
	}

	@GetMapping("/admin-page")
	public String adminPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "redirect:http://localhost:1001";
	}

	@GetMapping("/change-password")
	public String getChangePasswordPage(Model model) {
		model.addAttribute("passwordDto", new PasswordDto());
		return "change-password";
	}

	@PostMapping("/change-password")
	public String changePassword(@ModelAttribute("passwordDto") PasswordDto passwordDto, Principal principal, Model model) {
		String username = principal.getName();
		if (userService.changePassword(username, passwordDto)) {
			model.addAttribute("message", "Password changed successfully!");
		} else {
			model.addAttribute("error", "Failed to change password. Please check your old password.");
		}
		return "change-password";
	}
}
