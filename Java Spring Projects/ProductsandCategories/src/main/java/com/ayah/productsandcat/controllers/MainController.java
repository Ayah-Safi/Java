package com.ayah.productsandcat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ayah.productsandcat.models.Category;
import com.ayah.productsandcat.models.Product;
import com.ayah.productsandcat.services.CategoryService;
import com.ayah.productsandcat.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public String showHome(Model model) {
		List<Product> allProducts = productService.allProducts();
		List<Category> allCat = categoryService.allCategories();
		model.addAttribute("allCat", allCat);
		model.addAttribute("allProducts", allProducts);
		return "home.jsp";
	}

	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct.jsp";
	}

	@PostMapping("/addProduct")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct.jsp";
		} else {
			productService.addProduct(product);
			return "redirect:/";
		}

	}

	@GetMapping("/addCat")
	public String addCat(Model model) {
		model.addAttribute("category", new Category());
		return "addCat.jsp";
	}

	@PostMapping("/addCat")
	public String addCat(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "addCat.jsp";
		} else {
			categoryService.addCategory(category);
			return "redirect:/";
		}
	}

	@GetMapping("/showProduct/{productId}")
	public String showProduct(@PathVariable("productId") Long productId, Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("product", product);
		model.addAttribute("assignedCategories", categoryService.getAssignedCategories(product));
		model.addAttribute("unassignedCategories", categoryService.getUnassignedCategories(product));
		return "showProduct.jsp";
	}

	@PostMapping("/showProduct/{productId}")
	public String addCatToProduct(@PathVariable("productId") Long productId,
			@RequestParam(value = "categoryId") Long categoryId, Model model) {

		Product product = productService.findById(productId);
		Category category = categoryService.findById(categoryId);
		product.getCategories().add(category);
		productService.updateProduct(product);
		return "redirect:/showProduct/" + productId;

	}

	@GetMapping("/showCat/{categoryId}")
	public String showCat(@PathVariable("categoryId") Long categoryId, Model model) {
		Category category = categoryService.findById(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("assignedProducts", productService.getAssignedProducts(category));
		model.addAttribute("unassignedProducts", productService.getUnassignedProducts(category));
		return "showCat.jsp";
	}

	@PostMapping("/showCat/{categoryId}")
	public String addProductToCat(@PathVariable("categoryId") Long categoryId,
			@RequestParam(value = "productId") Long productId, Model model) {
		Category category = categoryService.findById(categoryId);
		Product product = productService.findById(productId);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		return "redirect:/showCat"+categoryId;
	}
}
