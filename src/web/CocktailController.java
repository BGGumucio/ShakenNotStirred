package web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Cocktail.Cocktail;
import Cocktail.CocktailDAO;
import Cocktail.Ingredient;
import Cocktail.Ingredient;

@Controller
public class CocktailController {
	
	@Autowired
	private CocktailDAO dao;
	
	private Cocktail cocktail;
	
	@RequestMapping("addDrink.pattern")
	public ModelAndView addData(@RequestParam("measurementQuantity") String quantity, 
			@RequestParam("measurementType") String meastype, 
			@RequestParam("base") String base,
			@RequestParam("measurementQuantity2") String quantity2, 
			@RequestParam("measurementType2") String meastype2, 
			@RequestParam("base2") String base2,
			@RequestParam("measurementQuantity3") String quantity3, 
			@RequestParam("measurementType3") String meastype3, 
			@RequestParam("base3") String base3,
			@RequestParam("measurementQuantity4") String quantity4, 
			@RequestParam("measurementType4") String meastype4, 
			@RequestParam("base4") String base4,
			@RequestParam("instructions") String instructions,
			@RequestParam("name") String name) {
		ArrayList<Ingredient> added = new ArrayList<>();
		Ingredient ingredient = new Ingredient(Double.parseDouble(quantity), meastype, base);
		added.add(ingredient);
		if (!quantity2.equals((""))){
		Ingredient ingredient2 = new Ingredient(Double.parseDouble(quantity2), meastype2, base2);
		added.add(ingredient2);
		}
		if (!quantity3.equals((""))){
		Ingredient ingredient3 = new Ingredient(Double.parseDouble(quantity3), meastype3, base3);
		added.add(ingredient3);
		}
		if (!quantity4.equals((""))){
		Ingredient ingredient4 = new Ingredient(Double.parseDouble(quantity4), meastype4, base4);
		added.add(ingredient4);
		}
		String image = "./images/nophoto.jpg";
		Cocktail cocktail=new Cocktail(added, name, instructions, image);
		dao.addDrink(cocktail);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displaydrink.jsp");
		mv.addObject("Cocktail", dao.lastDrink());
		return mv;
	}
	@RequestMapping("changeDrink.pattern")
	public ModelAndView changeData(@RequestParam("ingredient") String ingredient, 
									@RequestParam("name") String name,
									@RequestParam("Text1") String instructions) {
		String [] placeholder = ingredient.split(",");
		ArrayList<Ingredient> newingreds = new ArrayList<>();
		for (String string : placeholder) {
			String [] place = string.split(" ");
			Ingredient i = new Ingredient(Double.parseDouble(place[0]), place[1], place[2]);
			newingreds.add(i);
		}
		dao.changeDrink(name, newingreds, instructions);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("Cocktail", dao.lastDrink());
		return mv;
	}
	@RequestMapping("editDrink.pattern")
	public ModelAndView editData(@RequestParam("delete") String name) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit.jsp");
		mv.addObject("Cocktail", dao.lastDrink());
		return mv;
	}

	@RequestMapping("deleteDrink.pattern")
	public ModelAndView deleteData(@RequestParam("delete") String name) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("Cocktail", dao.deleteCocktail(name));
		return mv;
	}
	@RequestMapping("getDrink.pattern")
	public ModelAndView processData(@RequestParam("drink") String name) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displaydrink.jsp");
		mv.addObject("Cocktail", dao.getDrink(name));
		return mv;
	}
	@RequestMapping("getSorted.pattern")
	public ModelAndView getSorted(@RequestParam("alcohol") String alcohol) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectdrink.jsp");
		mv.addObject("Cocktails", dao.getSortedDrinks(alcohol));
		return mv;
	}
}