package com.example.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	@Setter(value = AccessLevel.NONE)
	private int id;
	private String title;
	private int quantity;
	private float price;
	private String description;

	private static int counter = 0;

	public void setId() {
		id = counter;
		counter++;
	}

	public Product(String title, String description, int quantity, float price) {
		setId();
		setTitle(title);
		setDescription(description);
		setQuantity(quantity);
		setPrice(price);
	}

}
