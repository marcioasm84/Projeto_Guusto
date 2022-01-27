package com.guusto.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guusto.app.entities.Merchant;
import com.guusto.app.repositories.MerchantRepository;

@Service
public class MerchantService {

	@Autowired
	private MerchantRepository repository;
	
	public List<Merchant> findAll() {
		return repository.findAll();
	}
    
	public Iterable<Merchant> saveAll(List<Merchant> merchants) {
        return repository.saveAll(merchants);
    }
	
	public void saveTest() {
		Merchant merchant = new Merchant();
		merchant.setCardNetwork("Gift Card");
		merchant.setCountry("cad");		
		merchant.setCurrency("CAD");		
		merchant.setDescription("Air Canada");
		merchant.setId("126");
		merchant.setImage("http://images.guusto.com/guusto/img/126.png");
		merchant.setMaxAmount("2000.0");        
		merchant.setMinAmount("25.0");
		merchant.setName("Air Canada");
		merchant.setPartner("BUYATAB");
		merchant.setShoppingOption("STORE_AND_ONLINE");        
		merchant.setStatus("true");
		merchant.setType("SHOPPING");
		merchant.setWebsite("https://www.aircanada.com");
        	
		repository.save(merchant);
    }
	
	public List<Merchant> findByNameAndCountry(String name, String country) {
		if(country.isBlank()) {
			country = null;
		}
		if(name == null && country == null) {
			return repository.findAll();
		}
		
		if(name != null && country == null) {
			return repository.findByNameStartsWithIgnoreCase(name);
		}
		
		if(name == null && country != null) {
			return repository.findByCountryIgnoreCase(name);
		}
		
		return repository.findByNameStartsWithIgnoreCaseAndCountryIgnoreCase(name, country);
	}

	public List<Merchant> findByName(String name) {
		return repository.findByNameStartsWithIgnoreCase(name);
	}

	public List<Merchant> findByCountry(String country) {
		return repository.findByCountryIgnoreCase(country);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
}
