package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Product;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.ProductRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/all")
	//public String allAccess() {
	//	return "Welcome To Application";
	//}

	// Read All user table Produk //
	public List<Product> getAll() { return productRepository.findAll(); }

	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "Halaman User.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	//public String moderatorAccess() {
	//	return "Dashboard Moderator.";
	//}

	// Read All table user //
	//public List<User> moderatorAccess() { return userRepository.findAll(); }

	// Read Role moderator table produk //
	public List<Product> moderatorAccess() { return productRepository.findAll(); }

	@PostMapping("/tambah")
	public Product createProduct(@RequestBody Product product) { return productRepository.save(product); }

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Halaman Admin.";
	}
}
