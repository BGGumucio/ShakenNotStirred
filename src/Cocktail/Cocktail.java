package Cocktail;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cocktail {
	private List <Ingredient> ingredients = new ArrayList();
	private String name;
	private String instructions;
	private String image;
	
	public Cocktail(){
		
	}
	
	public Cocktail(List<Ingredient> ingredients, String name, String instructions, String image) {
		this.ingredients = ingredients;
		this.name = name;
		this.instructions = instructions;
		this.image = image;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Cocktail [ingredients=" + ingredients + ", name=" + name + ", instructions=" + instructions + ", image="
				+ image + "]";
	}
	
}
