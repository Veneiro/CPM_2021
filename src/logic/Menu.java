package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	//ATTRIBUTES
	private static final String PRODUCTS_FILE = "files/products.dat";
	private List<Product> productsList = null;
	private Order o = new Order();
	private Scanner sc = new Scanner(System.in);

	/**
	 * Default constructor for Menu class
	 */
	public Menu() {
		productsList = new ArrayList<Product>();
		loadProducts();
	}

	/**
	 * Load the products from a file
	 */
	private void loadProducts() {
		FileUtil.loadFile(PRODUCTS_FILE, productsList);
	}
	
	public List<Product> getProductsByType(String code) {
		List<Product> p = new ArrayList<Product>();
		for (Product product : productsList) {
			if(product.getCode() == code) {
				p.add(product);
			}
		}
		return p;
	}

	/**
	 * Returns an array of products
	 * @return
	 */
	public Product[] getProducts() {
		Product[] products = productsList
				.toArray(new Product[productsList.size()]);
		return products;
	}

	/**
	 * To String for the products list
	 */
	public void pToString() {
		int i = 1;
		for (Product product : productsList) {
			System.out.println(i + " - " + product.toString() + "\n");
			i++;
		}
	}

	/**
	 * Starts the app
	 */
	public void start() {
		initializate();
		String n = sc.next();
		if (Integer.parseInt(n) == 0) {
			System.out.println("Order Canceled!");
			return;
		} else if (Integer.parseInt(n) > 21) {
			System.out.println("The NUMBER introduced is NOT a PRODUCT, "
					+ "please TRY AGAIN");
			n = sc.next();
		}
		System.out.println("How many units you want?");
		String u = sc.next();
		while (true) {
			if (Integer.parseInt(n) > 0 && Integer.parseInt(n) <= 21) {
				selectProducts(n, u);
				System.out.println();
				System.out.println("Select a NUMBER to PICK a PRODUCT: ");
				System.out.println("(Select 0 to FINISH and PLACE YOUR ORDER");
				System.out.println();
				n = sc.next();
				if (Integer.parseInt(n) == 0) {
					showOrder();
					return;
				}
				System.out.println("How many UNITS you WANT?");
				u = sc.next();
			} else {
				System.out.println("The NUMBER introduced is NOT a PRODUCT, "
						+ "please TRY AGAIN");
				n = sc.next();
			}
		}
	}

	/**
	 * Initialize the titles and menu card
	 */
	private void initializate() {
		System.out.println("------------------------------------");
		System.out.println();
		System.out.println("Availible menu: ");
		System.out.println();
		System.out.println("Please choose the products you want");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println();
		pToString();
		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println("Select a NUMBER to PICK a PRODUCT: ");
		System.out.println();
		System.out.println("(Select 0 to CANCEL your order)");
	}

	/**
	 * Saves the order to an archive and prepares the app for the next user
	 */
	private void showOrder() {
		System.out.println();
		System.out.println("Your order code is: " + o.getCode());
		System.out.println("An archive will be generated will your order");
		o.saveOrder();
		reset();
	}

	/**
	 * Reset the app to it's initial state
	 */
	private void reset() {
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println();
		System.out.println("CLEANING...GENERATING NEW ORDER");
		o = new Order();
		start();
	}

	/**
	 * Add a product to the order
	 * @param n
	 * @param u
	 */
	private void selectProducts(String n, String u) {
		o.add(productsList.get(Integer.parseInt(n) - 1), Integer.parseInt(u));
	}

}
