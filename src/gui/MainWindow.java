package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.Menu;
import logic.Order;
import logic.Product;
import java.awt.Font;

public class MainWindow extends JFrame {

	// ATRIBUTES
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblLogo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbProducts;
	private JSpinner spUnits;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnNext;
	private JLabel lblProducts;
	private JLabel lblOrderPrice;
	private JTextField txtPrice;
	private JLabel lblUnits;
	private RegistryDialog customerInformationDialog;
	private Order order = null;
	private Menu menu = null;
	private JTextArea txtCart;
	private JScrollPane scrollPane;
	private JLabel lblOrder;
	private JButton btnDelete;
	private JLabel lblPicture;
	private JMenuBar menuBar;
	private JMenu mnOrder;
	private JMenu mnHelp;
	private JMenuItem mntmNewOrder;
	private JSeparator separator;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JMenuItem mntmContents;
	private JSeparator separator_1;
	private JPanel panel;
	private JButton btnFilterBurguers;
	private JButton btnFilterDrinks;
	private JButton btnFilterComplements;
	private JButton btnFilterDesserts;
	private JLabel lblNewLabel;
	private JLabel lblDiscountOn;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;

	/**
	 * Create the frame.
	 * 
	 * @param order
	 * @param menu
	 */
	public MainWindow(Menu menu, Order order) {
		this.order = order;
		this.menu = menu;

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MainWindow.class.getResource("/img/logo.PNG")));
		setTitle("McDonald's POS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 451);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(getLblLogo());
		contentPane.add(getCbProducts());
		contentPane.add(getSpUnits());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnCancel());
		contentPane.add(getBtnNext());
		contentPane.add(getLblProducts());
		contentPane.add(getLblOrderPrice());
		contentPane.add(getTxtPrice());
		contentPane.add(getLblUnits());

		getRootPane().setDefaultButton(btnNext);
		contentPane.add(getScrollPane());
		contentPane.add(getLblOrder());
		contentPane.add(getBtnDelete());
		contentPane.add(getLblPicture());
		contentPane.add(getPanel());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblDiscountOn());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_1_1());
		updateComboComponent();
	}

	/**
	 * Returns the logo label
	 * 
	 * @return
	 */
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setIcon(new ImageIcon(
					MainWindow.class.getResource("/img/logo.PNG")));
			lblLogo.setBounds(118, 32, 212, 140);
		}
		return lblLogo;
	}

	/**
	 * Returns the products combobox
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getCbProducts() {
		if (cbProducts == null) {
			cbProducts = new JComboBox();
			cbProducts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateComboComponent();
				}
			});
			cbProducts.setToolTipText("List of availible products");
			cbProducts.setBounds(118, 208, 267, 22);
			DefaultComboBoxModel df = new DefaultComboBoxModel();
			for (Product p : menu.getProducts()) {
				df.addElement(p);
			}
			cbProducts.setModel(df);
		}
		return cbProducts;
	}

	/**
	 * Returns the spiner with the units
	 * 
	 * @return
	 */
	private JSpinner getSpUnits() {
		if (spUnits == null) {
			spUnits = new JSpinner();
			spUnits.setToolTipText("How many units of this product you want");
			spUnits.setModel(new SpinnerNumberModel(new Integer(1),
					new Integer(1), null, new Integer(1)));
			spUnits.setBounds(395, 208, 89, 22);
		}
		return spUnits;
	}

	/**
	 * Returns the add button
	 * 
	 * @return
	 */
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DecimalFormat formato1 = new DecimalFormat("#.00");
					order.add((Product) cbProducts.getSelectedItem(),
							(int) spUnits.getValue());
					String d = formato1.format(order.getPriceMcHappy())
							+ " \u20AC";
					txtPrice.setText(d);
					txtCart.setText(order.toString());
					if (!btnNext.isEnabled()) {
						btnNext.setEnabled(true);
					}
					btnDelete.setEnabled(true);
				}
			});
			btnAdd.setToolTipText("Add the selected product to the order");
			btnAdd.setMnemonic('a');
			btnAdd.setBackground(Color.GREEN);
			btnAdd.setBounds(494, 208, 89, 23);
		}
		return btnAdd;
	}

	/**
	 * Returns the cancel button
	 * 
	 * @return
	 */
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNext.setEnabled(false);
					order.initialize();
					txtPrice.setText("0,0 \u20AC");
					txtCart.setText("");
					DefaultComboBoxModel df = new DefaultComboBoxModel();
					for (Product p : menu.getProducts()) {
						df.addElement(p);
					}
					cbProducts.setModel(df);
				}
			});
			btnCancel.setToolTipText("Cancel your order");
			btnCancel.setMnemonic('c');
			btnCancel.setBackground(Color.RED);
			btnCancel.setBounds(494, 347, 89, 23);
		}
		return btnCancel;
	}

	/**
	 * Returns the next button
	 * 
	 * @return
	 */
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
			btnNext.setToolTipText("Place your order");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCustomerInformationDialog();
				}
			});
			btnNext.setMnemonic('n');
			btnNext.setBackground(Color.GREEN);
			btnNext.setBounds(395, 347, 89, 23);
			btnNext.setEnabled(false);
		}
		return btnNext;
	}

	/**
	 * Getter for Order
	 * 
	 * @return
	 */
	public Order getOrder() {
		return this.order;
	}

	/**
	 * Shows the Registry Dialog
	 */
	private void showCustomerInformationDialog() {
		customerInformationDialog = new RegistryDialog(this);
		customerInformationDialog.setLocationRelativeTo(this);
		customerInformationDialog.setModal(true);
		customerInformationDialog.setVisible(true);
	}

	/**
	 * Returns the products label
	 * 
	 * @return
	 */
	private JLabel getLblProducts() {
		if (lblProducts == null) {
			lblProducts = new JLabel("Products:");
			lblProducts.setDisplayedMnemonic('P');
			lblProducts.setLabelFor(getCbProducts());
			lblProducts.setBounds(118, 183, 122, 14);
		}
		return lblProducts;
	}

	/**
	 * Returns the order label
	 * 
	 * @return
	 */
	private JLabel getLblOrderPrice() {
		if (lblOrderPrice == null) {
			lblOrderPrice = new JLabel("Order price: ");
			lblOrderPrice.setBounds(494, 286, 89, 14);
		}
		return lblOrderPrice;
	}

	/**
	 * Returns the txt field with the price
	 * 
	 * @return
	 */
	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setText("0,0 \u20AC");
			txtPrice.setToolTipText("Total amount of the order");
			txtPrice.setEditable(false);
			txtPrice.setBounds(494, 311, 89, 20);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}

	/**
	 * Returns the label of units
	 * 
	 * @return
	 */
	private JLabel getLblUnits() {
		if (lblUnits == null) {
			lblUnits = new JLabel("Units:");
			lblUnits.setLabelFor(getSpUnits());
			lblUnits.setDisplayedMnemonic('U');
			lblUnits.setBounds(395, 183, 89, 14);
		}
		return lblUnits;
	}

	/**
	 * Returns the actual order in a text pane
	 * 
	 * @return
	 */
	private JTextArea getTxtCart() {
		if (txtCart == null) {
			txtCart = new JTextArea();
			txtCart.setEditable(false);
		}
		return txtCart;
	}

	/**
	 * Returns a Scroll Pane
	 * 
	 * @return
	 */
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(382, 59, 201, 113);
			scrollPane.setViewportView(getTxtCart());
		}
		return scrollPane;
	}

	/**
	 * Returns a label with the order image
	 * 
	 * @return
	 */
	private JLabel getLblOrder() {
		if (lblOrder == null) {
			lblOrder = new JLabel("");
			lblOrder.setIcon(new ImageIcon(
					MainWindow.class.getResource("/img/order (1).png")));
			lblOrder.setBounds(382, 11, 201, 49);
		}
		return lblOrder;
	}

	/**
	 * Returns the button that can delete some products from the order
	 * 
	 * @return
	 */
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.setBackground(Color.GREEN);
			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					order.remove((Product) cbProducts.getSelectedItem());
					txtCart.setText(order.toString());
					txtPrice.setText(
							String.valueOf(order.getPriceMcHappy()) + "€");
				}
			});
			btnDelete.setBounds(494, 242, 89, 23);
		}
		return btnDelete;
	}

	private JLabel getLblPicture() {
		if (lblPicture == null) {
			lblPicture = new JLabel("");
			lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
			lblPicture.setBounds(118, 241, 212, 129);
		}
		return lblPicture;
	}

	private void updateComboComponent() {
		spUnits.setValue(1);
		lblPicture.setIcon(new ImageIcon(MainWindow.class.getResource(
				"/img/" + ((Product) cbProducts.getSelectedItem()).getCode()
						+ ".png")));
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnOrder());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnOrder() {
		if (mnOrder == null) {
			mnOrder = new JMenu("Order");
			mnOrder.setMnemonic('O');
			mnOrder.add(getMntmNewOrder());
			mnOrder.add(getSeparator());
			mnOrder.add(getMntmExit());
		}
		return mnOrder;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.add(getMntmContents());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	@SuppressWarnings("deprecation")
	private JMenuItem getMntmNewOrder() {
		if (mntmNewOrder == null) {
			mntmNewOrder = new JMenuItem("New Order");
			mntmNewOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					initizializate();
				}
			});
			mntmNewOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
					InputEvent.CTRL_MASK));
			mntmNewOrder.setMnemonic('N');
		}
		return mntmNewOrder;
	}

	private void initizializate() {
		txtCart.setText("");
		btnNext.setEnabled(false);
		order.initialize();
		txtPrice.setText("0,0 \u20AC");
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	@SuppressWarnings("deprecation")
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
					InputEvent.CTRL_MASK));
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mntmExit.setMnemonic('E');
		}
		return mntmExit;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(rootPane,
							"App for CPM Fast Food\nMade by Mateo Rico\nV 13.1021",
							"About", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAbout.setMnemonic('A');
		}
		return mntmAbout;
	}

	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents
					.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mntmContents.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(rootPane,
							"Help is not availible");
				}
			});
			mntmContents.setMnemonic('C');
		}
		return mntmContents;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 108, 393);
			panel.setLayout(new GridLayout(4, 0, 0, 0));
			panel.add(getBtnFilterBurguers());
			panel.add(getBtnFilterDrinks());
			panel.add(getBtnFilterComplements());
			panel.add(getBtnFilterDesserts());
		}
		return panel;
	}

	private JButton getBtnFilterBurguers() {
		if (btnFilterBurguers == null) {
			btnFilterBurguers = new JButton("Burguer");
			btnFilterBurguers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultComboBoxModel df = new DefaultComboBoxModel();
					for (Product p : menu.getProductsByType("HA")) {
						df.addElement(p);
					}
					cbProducts.setModel(df);
				}
			});
			btnFilterBurguers.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnFilterBurguers.setHorizontalTextPosition(SwingConstants.CENTER);
			btnFilterBurguers.setIcon(new ImageIcon(
					MainWindow.class.getResource("/img/Burguer.png")));
			btnFilterBurguers.setBackground(Color.WHITE);
		}
		return btnFilterBurguers;
	}

	private JButton getBtnFilterDrinks() {
		if (btnFilterDrinks == null) {
			btnFilterDrinks = new JButton("Drinks");
			btnFilterDrinks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultComboBoxModel df = new DefaultComboBoxModel();
					for (Product p : menu.getProductsByType("BE")) {
						df.addElement(p);
					}
					cbProducts.setModel(df);
				}
			});
			btnFilterDrinks.setHorizontalTextPosition(SwingConstants.CENTER);
			btnFilterDrinks.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnFilterDrinks.setIcon(new ImageIcon(
					MainWindow.class.getResource("/img/Drink.png")));
			btnFilterDrinks.setBackground(Color.WHITE);
		}
		return btnFilterDrinks;
	}

	private JButton getBtnFilterComplements() {
		if (btnFilterComplements == null) {
			btnFilterComplements = new JButton("Complements");
			btnFilterComplements.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultComboBoxModel df = new DefaultComboBoxModel();
					for (Product p : menu.getProductsByType("CO")) {
						df.addElement(p);
					}
					cbProducts.setModel(df);
				}
			});
			btnFilterComplements
					.setHorizontalTextPosition(SwingConstants.CENTER);
			btnFilterComplements.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnFilterComplements.setIcon(new ImageIcon(
					MainWindow.class.getResource("/img/Sides.png")));
			btnFilterComplements.setBackground(Color.WHITE);
		}
		return btnFilterComplements;
	}

	private JButton getBtnFilterDesserts() {
		if (btnFilterDesserts == null) {
			btnFilterDesserts = new JButton("Desserts");
			btnFilterDesserts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultComboBoxModel df = new DefaultComboBoxModel();
					for (Product p : menu.getProductsByType("PO")) {
						df.addElement(p);
					}
					cbProducts.setModel(df);
				}
			});
			btnFilterDesserts.setHorizontalTextPosition(SwingConstants.CENTER);
			btnFilterDesserts.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnFilterDesserts.setIcon(new ImageIcon(
					MainWindow.class.getResource("/img/Dessert.png")));
			btnFilterDesserts.setBackground(Color.WHITE);
		}
		return btnFilterDesserts;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("MC HAPPY DAY!!!");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel.setBounds(364, 258, 143, 20);
		}
		return lblNewLabel;
	}

	private JLabel getLblDiscountOn() {
		if (lblDiscountOn == null) {
			lblDiscountOn = new JLabel("10% DISCOUNT");
			lblDiscountOn.setHorizontalAlignment(SwingConstants.CENTER);
			lblDiscountOn.setForeground(Color.RED);
			lblDiscountOn.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDiscountOn.setVerticalAlignment(SwingConstants.TOP);
			lblDiscountOn.setBounds(364, 277, 143, 20);
		}
		return lblDiscountOn;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("ON PURCHASES");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(Color.RED);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1_1.setBounds(363, 297, 144, 20);
		}
		return lblNewLabel_1_1;
	}

	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("ABOVE 50\u20AC");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setForeground(Color.RED);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1_1_1.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1_1_1.setBounds(363, 316, 144, 20);
		}
		return lblNewLabel_1_1_1;
	}
}
