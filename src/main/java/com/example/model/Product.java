package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "Product_table")
@Entity
public class Product {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĶĻĢŠĀŽČŅa-zēūīķļģšāžčņ]+")
	@Column(name = "Title")
	private String title;

	@Max(500)
	@Min(0)
	@Column(name = "Quantity")
	private int quantity;

	@Max(1000)
	@Min(0)
	@Column(name = "Price")
	private float price;

	@NotNull
	@Size(min = 3, max = 500)
	@Pattern(regexp = "[A-ZĒŪĪĶĻĢŠĀŽČŅa-zēūīķļģšāžčņ ]+")
	@Column(name = "Description")
	private String description;

	public Product(String title, String description, int quantity, float price) {
		setTitle(title);
		setDescription(description);
		setQuantity(quantity);
		setPrice(price);
	}

}
