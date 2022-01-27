package com.guusto.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * 
 * @author Márcio
 * 
 * {
        "cardNetwork": "Gift Card",
        "country": "cad",
        "currency": "CAD",        
        "description": "Air Canada",
        "id": 126,
        "image": "http://images.guusto.com/guusto/img/126.png",
        "maxAmount": 2000.0,        
        "minAmount": 25.0,
        "name": "Air Canada",
        "partner": "BUYATAB",
        "shoppingOption": "STORE_AND_ONLINE",        
        "status": true,
        "type": "SHOPPING",
        "website": "https://www.aircanada.com"
    }
 *
 */

@JsonIgnoreProperties(value = {
        "balanceCheckUrl",
        "customMerchant",
        "defaultMessage",
        "denominations",
        "fees",
        "functionalities",
        "mastercardAvailable",
        "metadata",
        "note",
        "order",
        "sort"        
})
@Data
@AllArgsConstructor
@Entity
@Table(name = "merchant")
public class Merchant {
		
	@Id
	private String id;	
	@Column
	private String cardNetwork;
	@Column
	private String country;
	@Column
	private String currency;	
	@Column
	private String description;	
	@Column
	private String image;	
	@Column
	private String maxAmount;	
	@Column
	private String minAmount;
	@Column
	private String name;	
	@Column
	private String partner;
	@Column
	private String shoppingOption;	
	@Column
	private String status;
	@Column
	private String type;
	@Column
	private String website;
		
	public Merchant() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardNetwork() {
		return cardNetwork;
	}

	public void setCardNetwork(String cardNetwork) {
		this.cardNetwork = cardNetwork;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(String minAmount) {
		this.minAmount = minAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getShoppingOption() {
		return shoppingOption;
	}

	public void setShoppingOption(String shoppingOption) {
		this.shoppingOption = shoppingOption;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
		
	
}
