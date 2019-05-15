package iducsa.boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import iducsa.boot.domain.User;
import iducsa.boot.repositories.UserRepository;

@Controller
public class WebThymeleafController {
	@Autowired UserRepository userRepo;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("test", "인덕컴소");
		model.addAttribute("ljh", "이지훈");
		model.addAttribute("users", userRepo.findAll());
		return "index";
	}
	@GetMapping("/register")
	public String getRegForm(Model model) {
		return "form";
	}
	@GetMapping("/users")
	public String getAllUser(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "userlist";
	}
	@PostMapping("/users")
	public String createUser(@Valid @RequestBody User user, Model model) {
		userRepo.save(user);
		model.addAttribute("users", userRepo.findAll());
		return "redirect:/users";
	}
}
