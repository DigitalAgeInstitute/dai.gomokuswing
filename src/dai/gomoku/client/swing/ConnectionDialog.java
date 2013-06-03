package dai.gomoku.client.swing;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class ConnectionDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 5286345467317464614L;

	private int DEFAULT_COMPONENT_LENGTH = 20;

	private String hostname = "localhost";
	private int port = 4010;

	private JLabel lblHost;
	private JTextField txtHost;

	private JLabel lblPort;
	private JSpinner txtPort;

	private JButton btnConnect;
	private JButton btnCancel;

	public ConnectionDialog(Frame frame, String title, boolean mode) {
		super(frame, title, mode);
		initComponents();
		addComponents();
		this.setMinimumSize(new Dimension(400, 200));
		this.setVisible(true);
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCancel) {
			System.exit(0);
		} else if (event.getSource() == btnConnect) {
			if (inputComplete()) {
				this.hostname = txtHost.getText();
				this.port = Integer.parseInt(txtPort.getValue().toString());
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this,
						"Please enter all the relevant information.",
						"Incomplete Input", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void initComponents() {
		initHostComponents();
		initPortComponents();
		initConnectButton();
		initCancelButton();
	}

	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		this.getContentPane().setLayout(new GridBagLayout());
		addHostComponents(gbc);
		addPortComponents(gbc);
		addConnectButton(gbc);
		addCancelButton(gbc);
	}

	private void initHostComponents() {
		lblHost = new JLabel("Host");
		txtHost = new JTextField(DEFAULT_COMPONENT_LENGTH);
		lblHost.setLabelFor(txtHost);
	}

	private void initPortComponents() {
		lblPort = new JLabel("Port");
		txtPort = new JSpinner();
		SpinnerNumberModel model = new SpinnerNumberModel();
		model.setMinimum(1024);
		model.setMaximum(65535);
		model.setValue(4010);
		txtPort.setModel(model);
		lblPort.setLabelFor(txtPort);
	}

	private void initConnectButton() {
		btnConnect = new JButton("Connect");
		btnConnect.setMnemonic(KeyEvent.VK_C);
		btnConnect.addActionListener(this);
	}

	private void initCancelButton() {
		btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic(KeyEvent.VK_A);
		btnCancel.addActionListener(this);
	}

	private void addHostComponents(GridBagConstraints gbc) {
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		this.getContentPane().add(lblHost, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.getContentPane().add(txtHost, gbc);
	}

	private void addPortComponents(GridBagConstraints gbc) {
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		this.getContentPane().add(lblPort, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.getContentPane().add(txtPort, gbc);
	}

	private void addConnectButton(GridBagConstraints gbc) {
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		this.getContentPane().add(btnConnect, gbc);
	}

	private void addCancelButton(GridBagConstraints gbc) {
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		this.getContentPane().add(btnCancel, gbc);
	}
	
	private boolean inputComplete ( ) {
		if ( txtHost.getText().equals("") || (txtHost.getText() == null) ) {
			return false;
		} else {
			return true;
		}
	}

}
