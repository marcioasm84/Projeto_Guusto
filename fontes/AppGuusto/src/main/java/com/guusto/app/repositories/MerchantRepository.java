package com.guusto.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guusto.app.entities.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long>{

	List<Merchant> findByNameStartsWithIgnoreCase(String name);
	
	List<Merchant> findByCountryIgnoreCase(String country);
	
	List<Merchant> findByNameStartsWithIgnoreCaseAndCountryIgnoreCase(String name, String country);
	
}
