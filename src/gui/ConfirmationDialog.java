package gui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmationDialog extends JDialog {

	//ATTRIBUTES
	private static final long serialVersionUID = 1L;
	private JLabel lblTick;
	private JLabel lblProcessing;
	private JLabel lblCode;
	private JTextField txtOrderCode;
	private JButton btnFinish;
	private RegistryDialog rd;

	/**
	 * Create the dialog.
	 * 
	 * @param registryDialog
	 */
	public ConfirmationDialog(RegistryDialog registryDialog) {
		this.rd = registryDialog;
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblTick());
		getContentPane().add(getLblProcessing());
		getContentPane().add(getLblCode());
		getContentPane().add(getTxtOrderCode());
		getContentPane().add(getBtnFinish());
		setTitle("McDonald's POS: Confirmation Dialog");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ConfirmationDialog.class.getResource("/img/logo.PNG")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 452, 258);

	}

	/**
	 * Returns the label for the
	 * @return
	 */
	private JLabel getLblTick() {
		if (lblTick == null) {
			lblTick = new JLabel("");
			lblTick.setIcon(new ImageIcon(
					ConfirmationDialog.class.getResource("/img/ok.png")));
			lblTick.setBounds(33, 35, 70, 50);
		}
		return lblTick;
	}

	private JLabel getLblProcessing() {
		if (lblProcessing == null) {
			lblProcessing = new JLabel("We are processing your order");
			lblProcessing.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblProcessing.setBounds(113, 35, 294, 50);
		}
		return lblProcessing;
	}

	private JLabel getLblCode() {
		if (lblCode == null) {
			lblCode = new JLabel("The order code is:");
			lblCode.setBounds(33, 118, 111, 14);
		}
		return lblCode;
	}

	private JTextField getTxtOrderCode() {
		if (txtOrderCode == null) {
			txtOrderCode = new JTextField();
			txtOrderCode.setEditable(false);
			txtOrderCode.setBounds(154, 115, 203, 20);
			txtOrderCode.setColumns(10);
			txtOrderCode.setText(rd.getMw().getOrder().getCode());
		}
		return txtOrderCode;
	}

	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Finish");
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rd.getMw().getOrder().saveOrder();
					System.exit(0);
				}
			});
			btnFinish.setBackground(Color.GREEN);
			btnFinish.setBounds(333, 184, 89, 23);
		}
		return btnFinish;
	}
}
