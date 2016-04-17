package Cocktail;

public class Ingredient {
	private double measurementQuantity;
	private String measurementType;
	private String base;
	
	public Ingredient(){
		
	}
	
	public Ingredient(double measurementQuantity, String measurementType, String base) {
		this.measurementQuantity = measurementQuantity;
		this.measurementType = measurementType;
		this.base = base;
	}
	public double getMeasurementQuantity() {
		return measurementQuantity;
	}

	public void setMeasurementQuantity(double measurementQuantity) {
		this.measurementQuantity = measurementQuantity;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return  measurementQuantity+ " " + measurementType + " " + base;
	}
	
	
}
