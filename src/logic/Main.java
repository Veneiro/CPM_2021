package logic;

import java.awt.EventQueue;

import gui.MainWindow;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Order order = new Order();
		Menu menu = new Menu();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow(menu, order);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
