package Cocktail;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class CocktailDAO {
	private static final String filename = "WEB-INF/Drinks.csv";
	private List<Cocktail> drinkList = new ArrayList<>();

	@Autowired
	private ApplicationContext ac;

	@PostConstruct
	public void init() {
		try (InputStream is = ac.getResource(filename).getInputStream();
				BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			buf.readLine();
			while ((line = buf.readLine()) != null) {
				List<Ingredient> allParts = new ArrayList<>();
				String[] tokens = line.split(",");
				int numberList = Integer.parseInt(tokens[0].trim());
				String name = tokens[1].trim();
				String instructions = tokens[2].trim();
				String image = "./images/" + name + ".jpg";
				allParts.add(new Ingredient(Double.parseDouble(tokens[3].trim()), tokens[4].trim(), tokens[5].trim()));
				if (tokens.length > 6) {
					allParts.add(
							new Ingredient(Double.parseDouble(tokens[6].trim()), tokens[7].trim(), tokens[8].trim()));
				}
				if (tokens.length > 9) {
					allParts.add(
							new Ingredient(Double.parseDouble(tokens[9].trim()), tokens[10].trim(), tokens[11].trim()));
				}
				if (tokens.length > 12) {
					allParts.add(new Ingredient(Double.parseDouble(tokens[12].trim()), tokens[13].trim(),
							tokens[14].trim()));
				}
				Cocktail drink = new Cocktail(allParts, name, instructions, image);
				drinkList.add(drink);

			}
		} catch (Exception e) {
			System.out.println("exception here");
			System.err.println(e + " hereeeeee");
		}
	}

	// sorted Drink List Method
	public List<Cocktail> getSortedDrinks(String x) {
		List<Cocktail> sorted = new ArrayList<>();
		for (Cocktail drink : drinkList) {
			if (x.equals(drink.getIngredients().get(0).getBase())) {
				sorted.add(drink);
			}
		}
		return sorted;
	}

	// get Drink method
	public Cocktail getDrink(String name) {
		Cocktail newDrink = new Cocktail();
		for (Cocktail drink : drinkList) {
			if (name.equals(drink.getName())) {
				newDrink = drink;
			}
		}
		return newDrink;
	}

	// get Delete Drink method
	public String deleteCocktail(String name) {
		String result = "";
		int num = -1;
		for (Cocktail cocktail : drinkList) {
			if (name.equals(cocktail.getName())) {
				num = drinkList.indexOf(cocktail);
				break;
			}
		}
		if (num != -1) {
			drinkList.remove(num);
			result = "Cocktail Deleted";
		}
		return result;
	}

	public void addDrink(Cocktail cocktail) {
		drinkList.add(cocktail);
	}

	public Cocktail lastDrink() {
		return drinkList.get(drinkList.size() - 1);
	}

	public void changeDrink(String name, ArrayList changed, String instructions) {
		for (Cocktail drink : drinkList) {
			if (name.equals(drink.getName())) {
				drink.setIngredients(changed);
				drink.setInstructions(instructions);
			}
		}

	}
}
