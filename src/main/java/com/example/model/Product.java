package com.example.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
	@NotNull
	@Size(min = 3, max =50)
	@Pattern(regexp = "[A-ZĒŪĪĶĻĢŠĀŽČŅa-zēūīķļģšāžčņ]+")
	private String title;
	@Max(1000)
	@Min(0)
	private int quantity;
	private float price;
	@NotNull
	@Size(min = 3, max =500)
	@Pattern(regexp = "[A-ZĒŪĪĶĻĢŠĀŽČŅa-zēūīķļģšāžčņ]+")
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
