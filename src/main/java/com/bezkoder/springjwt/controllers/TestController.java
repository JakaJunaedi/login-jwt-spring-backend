package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.models.Product;
//import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.ProductRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	// Create Role Moderator table produk //
	@PostMapping("/tambah")
	public Product createProduct(@RequestBody Product product) { return productRepository.save(product); }

	// View Product by Id //
	@GetMapping("/detail/{id}")
	public ResponseEntity <Product> getProductById(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("tidak ada :" + id));
		return ResponseEntity.ok(product);
	}

	// Edit Role Moderator table product //
	@PutMapping("/ubah/{id}")
	public ResponseEntity <Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("tidak dapat menampilkan :" + id));
		product.setNama(productDetails.getNama());
		product.setKategori(productDetails.getKategori());
		product.setHarga(productDetails.getHarga());


		Product updatePrduct = productRepository.save(product);
		return ResponseEntity.ok(updatePrduct);
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Halaman Admin.";
	}
}
