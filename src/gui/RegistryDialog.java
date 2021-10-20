package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class RegistryDialog extends JDialog {

	//ATTRIBUTES
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel pnInfo;
	private JPanel pnRadio;
	private JButton btnCancel;
	private JButton btnNext;
	private JLabel lblNameSurname;
	private JLabel lblBirthdate;
	private JLabel lblPassword;
	private JLabel lblRepeatPassword;
	private JRadioButton rdbtnOnSite;
	private JRadioButton rdbtnTakeAway;
	private final ButtonGroup takePlaceButtonGroup = new ButtonGroup();
	private JTextField txtNameSurname;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBirthdate;
	private JPasswordField passwordField;
	private JPasswordField repeatPasswordField;
	private JPanel pnNameSurname;
	private JPanel pnBirthdate;
	private JPanel pnPassword;
	private JPanel pnRepeatPassword;
	private ConfirmationDialog confirmationDialog;
	private MainWindow mw;

	/**
	 * Create the frame.
	 * 
	 * @param mainWindow
	 */
	public RegistryDialog(MainWindow mainWindow) {
		mw = mainWindow;
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Mcdonald's POS : Customer Information");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 669, 431);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnInfo());
		contentPane.add(getPnRadio());
		contentPane.add(getBtnCancel());
		contentPane.add(getBtnNext());
	}

	/**
	 * Returns the info panel
	 * @return
	 */
	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setBackground(Color.WHITE);
			pnInfo.setName("");
			pnInfo.setBorder(new TitledBorder(null, "Customer Information",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnInfo.setBounds(10, 11, 628, 294);
			pnInfo.setLayout(new GridLayout(0, 2, -350, 0));
			pnInfo.add(getLblNameSurname());
			pnInfo.add(getPnNameSurname());
			pnInfo.add(getLblBirthdate());
			pnInfo.add(getPnBirthdate());
			pnInfo.add(getLblPassword());
			pnInfo.add(getPnPassword());
			pnInfo.add(getLblRepeatPassword());
			pnInfo.add(getPnRepeatPassword());
		}
		return pnInfo;
	}

	/**
	 * Returns the panel of the radio buttons
	 * @return
	 */
	private JPanel getPnRadio() {
		if (pnRadio == null) {
			pnRadio = new JPanel();
			pnRadio.setBackground(Color.WHITE);
			pnRadio.setBorder(new TitledBorder(null, "Order",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnRadio.setBounds(10, 316, 430, 62);
			pnRadio.setLayout(new GridLayout(1, 0, 0, 0));
			pnRadio.add(getRdbtnOnSite());
			pnRadio.add(getRdbtnTakeAway());
		}
		return pnRadio;
	}

	/**
	 * Returns the cancel button	
	 * @return
	 */
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			btnCancel.setBackground(Color.RED);
			btnCancel.setMnemonic('C');
			btnCancel.setBounds(549, 337, 89, 23);
		}
		return btnCancel;
	}

	/**
	 * Returns the next button
	 * @return
	 */
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String a = (String.valueOf(passwordField.getPassword()));
					String b = (String
							.valueOf(repeatPasswordField.getPassword()));
					String c = (getTxtNameSurname().getText());
					if (a.equals("") || b.equals("") || c.equals("")) {
						JOptionPane.showMessageDialog(null,
								"Some of the fields are empty, please fill all the form");
					} else if (!(a.equals(b))) {
						JOptionPane.showMessageDialog(null,
								"Password are not equals, please check them");
					} else {
						showConfirmationDialog();
					}
				}
			});
			btnNext.setBackground(Color.GREEN);
			btnNext.setMnemonic('N');
			btnNext.setBounds(450, 337, 89, 23);
		}
		return btnNext;
	}

	/**
	 * Show the Confirmation Dialog
	 */
	private void showConfirmationDialog() {
		confirmationDialog = new ConfirmationDialog(this);
		confirmationDialog.setLocationRelativeTo(this);
		confirmationDialog.setModal(true);
		confirmationDialog.setVisible(true);
	}
	
	/**
	 * Returns the reference to the Main Window
	 * @return
	 */
	public MainWindow getMw() {
		return this.mw;
	}

	/**
	 * Returns the Name and Surname label
	 * @return
	 */
	private JLabel getLblNameSurname() {
		if (lblNameSurname == null) {
			lblNameSurname = new JLabel("Name and Surname:");
			lblNameSurname.setDisplayedMnemonic('N');
			lblNameSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNameSurname;
	}

	/**
	 * Returns the birthdate label
	 * @return
	 */
	private JLabel getLblBirthdate() {
		if (lblBirthdate == null) {
			lblBirthdate = new JLabel("Birthdate");
			lblBirthdate.setDisplayedMnemonic('B');
			lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblBirthdate;
	}

	/**
	 * Returns the password label
	 * @return
	 */
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPassword;
	}

	/**
	 * Returns the repeat password label
	 * @return
	 */
	private JLabel getLblRepeatPassword() {
		if (lblRepeatPassword == null) {
			lblRepeatPassword = new JLabel("Repeat Password:");
			lblRepeatPassword.setDisplayedMnemonic('R');
			lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblRepeatPassword;
	}

	/**
	 * Returns the on site radio button
	 * @return
	 */
	private JRadioButton getRdbtnOnSite() {
		if (rdbtnOnSite == null) {
			rdbtnOnSite = new JRadioButton("On site");
			rdbtnOnSite.setBackground(Color.WHITE);
			rdbtnOnSite.setSelected(true);
			takePlaceButtonGroup.add(rdbtnOnSite);
			rdbtnOnSite.setMnemonic('S');
		}
		return rdbtnOnSite;
	}

	/**
	 * Returns the take away radio button
	 * @return
	 */
	private JRadioButton getRdbtnTakeAway() {
		if (rdbtnTakeAway == null) {
			rdbtnTakeAway = new JRadioButton("Take Away");
			rdbtnTakeAway.setBackground(Color.WHITE);
			rdbtnTakeAway.setMnemonic('T');
			takePlaceButtonGroup.add(rdbtnTakeAway);
		}
		return rdbtnTakeAway;
	}

	/**
	 * Returns the text field for the name and surname
	 * @return
	 */
	private JTextField getTxtNameSurname() {
		if (txtNameSurname == null) {
			txtNameSurname = new JTextField();
			txtNameSurname.setBounds(10, 25, 463, 20);
			txtNameSurname.setColumns(10);
		}
		return txtNameSurname;
	}

	/**
	 * Returns the combobox for the birthdate
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getCbBirthdate() {
		if (cbBirthdate == null) {
			cbBirthdate = new JComboBox();
			cbBirthdate.setBounds(10, 25, 195, 22);
			DefaultComboBoxModel df = new DefaultComboBoxModel();
			for (int i = 1920; i <= 2021; i++) {
				df.addElement(i);
			}
			cbBirthdate.setModel(df);
			cbBirthdate.setSelectedItem(2000);
		}
		return cbBirthdate;
	}

	/**
	 * Returns the password field
	 * @return
	 */
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(10, 25, 463, 20);
		}
		return passwordField;
	}

	/**
	 * Returns the repeated password field
	 * @return
	 */
	private JPasswordField getRepeatPasswordField() {
		if (repeatPasswordField == null) {
			repeatPasswordField = new JPasswordField();
			repeatPasswordField.setBounds(10, 25, 463, 20);
		}
		return repeatPasswordField;
	}

	/**
	 * Returns the panel for name and surname
	 * @return
	 */
	private JPanel getPnNameSurname() {
		if (pnNameSurname == null) {
			pnNameSurname = new JPanel();
			pnNameSurname.setBackground(Color.WHITE);
			pnNameSurname.setLayout(null);
			pnNameSurname.add(getTxtNameSurname());
		}
		return pnNameSurname;
	}

	/**
	 * Returns the panel for the birthdate
	 * @return
	 */
	private JPanel getPnBirthdate() {
		if (pnBirthdate == null) {
			pnBirthdate = new JPanel();
			pnBirthdate.setBackground(Color.WHITE);
			pnBirthdate.setLayout(null);
			pnBirthdate.add(getCbBirthdate());
		}
		return pnBirthdate;
	}

	/**
	 * Returns the panel for the password
	 * @return
	 */
	private JPanel getPnPassword() {
		if (pnPassword == null) {
			pnPassword = new JPanel();
			pnPassword.setBackground(Color.WHITE);
			pnPassword.setLayout(null);
			pnPassword.add(getPasswordField());
		}
		return pnPassword;
	}

	/**
	 * Returns the panel for the repeated password
	 * @return
	 */
	private JPanel getPnRepeatPassword() {
		if (pnRepeatPassword == null) {
			pnRepeatPassword = new JPanel();
			pnRepeatPassword.setBackground(Color.WHITE);
			pnRepeatPassword.setLayout(null);
			pnRepeatPassword.add(getRepeatPasswordField());
		}
		return pnRepeatPassword;
	}
}
