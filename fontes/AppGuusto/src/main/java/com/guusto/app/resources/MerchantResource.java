package com.guusto.app.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.app.entities.Merchant;
import com.guusto.app.services.MerchantService;

@CrossOrigin
@RestController
@RequestMapping(value = "/merchant")
public class MerchantResource {

	@Autowired
	private MerchantService service;
		
	@GetMapping(value = "/find")
	public ResponseEntity<List<Merchant>> find(@RequestParam(name = "name", required = false) String name, 
											   @RequestParam(name = "country", required = false) String country) {
		List<Merchant> list = null;
		
		list = service.findByNameAndCountry(name, country);
		return ResponseEntity.ok(list);
	}
	
}
