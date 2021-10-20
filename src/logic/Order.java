package logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<Product> orderList = null;
	private String code="";
	
	public Order(){
		orderList = new ArrayList<Product>();
		//We generate the new code for the order:
		generateCode();
	}

	public void add(Product item, int units){
		Product itemInOrder = null;
	
		for (Product a : orderList){
			if (a.getCode().equals(item.getCode()))
			{
				itemInOrder = a;
				itemInOrder.setUnits(itemInOrder.getUnits()+units);
				break;
			}
		}
		
		if (itemInOrder == null){
			Product itemToOrder = new Product(item);
			itemToOrder.setUnits(units);
			orderList.add(itemToOrder);
		}
	}
	
	public String getCode() {
		return code;
	}

	public float getPrice(){
		float total = 0.0f;
		for (Product a : orderList){
			total += a.getPrice()* a.getUnits();
		}
		return total;
	}
	
	public void saveOrder(){
		FileUtil.saveToFile(code, orderList);
	  }

	public void initialize(){
		orderList.clear();
	}
	
	private void generateCode() {
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for(int i=0; i<longitudCodigo;i++){ 
			int numero = (int)(Math.random()*(base.length())); 
			code += base.charAt(numero);
		}
	}
	
	public String toString() {
		DecimalFormat formato1 = new DecimalFormat("#.00");
		String aux = "";
		for (Product product : orderList) {
			aux += product.getName() + " - uds: " + product.getUnits() + "\n";
			aux += "\n";
		}
		aux += "Final Price: " + formato1.format(getPriceMcHappy()) + " \u20AC";
		return aux;
	}

	public float getPriceMcHappy() {
		float total = 0.0f;
		for (Product a : orderList){
			total += a.getPrice()* a.getUnits();
		}
		if (total > 50.0) {
			float disc = (float) (total * 0.10);
			total = total - disc;
		}
		return total;
	}
}

