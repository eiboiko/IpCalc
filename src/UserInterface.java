import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class UserInterface extends JFrame {
	private JPanel contentPane;
	private JTextField getIp;
	private JLabel lblMask;
	private JTextField getMask;
	private JLabel lblBroadcast;
	private JTextField ansNetmask;
	private JLabel lblNewLabel;
	private JTextField ansNetwork;
	private JLabel lblstHost;
	private JTextField ansBroadcast;
	private JLabel lblLastHost;
	private JTextField ansFrst;
	private JButton btnCount;
	private JLabel lblNewLabel_1;
	private JTextField ansLast;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		getIp = new JTextField();
		getIp.setBounds(60, 35, 110, 20);
		contentPane.add(getIp);
		getIp.setColumns(10);

		JLabel lblip = new JLabel("IP:");
		lblip.setBounds(40, 38, 23, 14);
		contentPane.add(lblip);

		lblMask = new JLabel("Mask /");
		lblMask.setBounds(180, 38, 46, 14);
		contentPane.add(lblMask);

		getMask = new JTextField();
		getMask.setBounds(220, 35, 120, 20);
		contentPane.add(getMask);
		getMask.setColumns(10);

		lblBroadcast = new JLabel("Netmask:");
		lblBroadcast.setBounds(15, 83, 74, 14);
		contentPane.add(lblBroadcast);

		ansNetmask = new JTextField();
		ansNetmask.setBounds(80, 80, 110, 20);
		contentPane.add(ansNetmask);
		ansNetmask.setColumns(10);

		lblNewLabel = new JLabel("Network:");
		lblNewLabel.setBounds(15, 113, 74, 14);
		contentPane.add(lblNewLabel);

		ansNetwork = new JTextField();
		ansNetwork.setBounds(80, 110, 110, 20);
		contentPane.add(ansNetwork);
		ansNetwork.setColumns(10);

		lblstHost = new JLabel("Broadcast:");
		lblstHost.setBounds(15, 143, 65, 14);
		contentPane.add(lblstHost);

		ansBroadcast = new JTextField();
		ansBroadcast.setBounds(80, 140, 110, 20);
		contentPane.add(ansBroadcast);
		ansBroadcast.setColumns(10);

		lblLastHost = new JLabel("First host:");
		lblLastHost.setBounds(15, 173, 70, 14);
		contentPane.add(lblLastHost);

		ansFrst = new JTextField();
		ansFrst.setBounds(80, 170, 110, 20);
		contentPane.add(ansFrst);
		ansFrst.setColumns(10);

		btnCount = new JButton("Count");
		btnCount.setBounds(216, 74, 109, 32);
		contentPane.add(btnCount);
		btnCount.addActionListener(new ButtonListener());

		lblNewLabel_1 = new JLabel("Last host:");
		lblNewLabel_1.setBounds(15, 203, 58, 14);
		contentPane.add(lblNewLabel_1);

		ansLast = new JTextField();
		ansLast.setBounds(80, 200, 110, 20);
		contentPane.add(ansLast);
		ansLast.setColumns(10);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try {
				String ipAddress;
				int mask;
				ipAddress = getIp.getText();
				mask = Integer.parseInt(getMask.getText());
				int[] ip = IpUser.createIp(ipAddress);
				if (ip == null) {
					getIp.setText("Invalid IP address!");
				} else {
					int[] netm = Netmask.netmaskCheck(mask);
					if (netm == null) {
						getMask.setText("Incorrect mask value!");
					} else {
						ansNetmask.setText(Netmask.toString(netm));
						int[] netw = IpCalc.getNetwork(netm, ip);
						ansNetwork.setText(IpCalc.toStringNetwork(netw));
						int[] br = IpCalc.getBroadcast(netm, ip);
						ansBroadcast.setText(IpCalc.toStringBroadcast(br));
						int[] fr = IpCalc.getFirstHost(netw);
						ansFrst.setText(IpCalc.toStringFirstHost(fr));
						int[] lst = IpCalc.getLastHost(br);
						ansLast.setText(IpCalc.toStringLastHost(lst));
					}
				}
			} catch (NumberFormatException e) {
			}
		}
	}
}
