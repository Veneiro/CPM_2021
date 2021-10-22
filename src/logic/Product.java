package logic;


public class Product {
	
	//ATTRIBUTES
	private String code;
	private String type;
	private String name;
	private float price;
	private int units;
	
	/**
	 * Constructor for the Product class
	 * @param code
	 * @param type
	 * @param name
	 * @param price
	 * @param units
	 */
	public Product(String code, String type, String name, float price, int units){
		this.code = code;
		this.type = type;
		this.name = name;
		this.price = price;
		this.units = units;
	}
	
	/**
	 * Constructor for the Product class
	 * @param anotherItem
	 */
	public Product (Product anotherItem) {
        this(anotherItem.code, anotherItem.type, anotherItem.name, anotherItem.price, anotherItem.units);
    }

	/**
	 * Getter for the name field
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the name field
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for the price field
	 * @return
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Setter for the price field
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * Getter for the code field
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter for the code field
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter for the units field
	 * @return
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * Setter for the Units field
	 * @param units
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	
	/**
	 * To string method for the product class
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.type);
		buffer.append(" - ");
		buffer.append(this.name);
		buffer.append(" - ");
		buffer.append(this.price);
		buffer.append(" €");
		if (this.units!=0){
			buffer.append(" (");
			buffer.append(this.units);
			buffer.append(" uds)");
			}
		return buffer.toString();
	   }
}
