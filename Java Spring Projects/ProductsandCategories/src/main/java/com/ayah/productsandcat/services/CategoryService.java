package com.ayah.productsandcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayah.productsandcat.models.Category;
import com.ayah.productsandcat.models.Product;
import com.ayah.productsandcat.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService (CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public List<Category> getAssignedCategories(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> getUnassignedCategories(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}
}
