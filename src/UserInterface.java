import java.awt.EventQueue;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		getIp = new JTextField();
		getIp.setBounds(40, 15, 125, 20);
		contentPane.add(getIp);
		getIp.setColumns(10);

		JLabel lblip = new JLabel("IP:");
		lblip.setBounds(20, 17, 23, 14);
		contentPane.add(lblip);

		lblMask = new JLabel("Mask /");
		lblMask.setBounds(180, 17, 46, 14);
		contentPane.add(lblMask);

		getMask = new JTextField();
		getMask.setBounds(220, 11, 45, 20);
		contentPane.add(getMask);
		getMask.setColumns(10);

		lblBroadcast = new JLabel("Netmask:");
		lblBroadcast.setBounds(10, 54, 74, 14);
		contentPane.add(lblBroadcast);

		ansNetmask = new JTextField();
		ansNetmask.setBounds(75, 51, 122, 20);
		contentPane.add(ansNetmask);
		ansNetmask.setColumns(10);

		lblNewLabel = new JLabel("Network:");
		lblNewLabel.setBounds(10, 82, 74, 14);
		contentPane.add(lblNewLabel);

		ansNetwork = new JTextField();
		ansNetwork.setBounds(75, 79, 122, 20);
		contentPane.add(ansNetwork);
		ansNetwork.setColumns(10);

		lblstHost = new JLabel("Broadcast:");
		lblstHost.setBounds(10, 111, 58, 16);
		contentPane.add(lblstHost);

		ansBroadcast = new JTextField();
		ansBroadcast.setBounds(75, 107, 122, 20);
		contentPane.add(ansBroadcast);
		ansBroadcast.setColumns(10);

		lblLastHost = new JLabel("First host:");
		lblLastHost.setBounds(10, 142, 55, 14);
		contentPane.add(lblLastHost);

		ansFrst = new JTextField();
		ansFrst.setBounds(75, 138, 122, 20);
		contentPane.add(ansFrst);
		ansFrst.setColumns(10);

		btnCount = new JButton("Count");
		btnCount.setBounds(224, 78, 109, 49);
		contentPane.add(btnCount);
		btnCount.addActionListener(new ButtonListener());

		lblNewLabel_1 = new JLabel("Last host:");
		lblNewLabel_1.setBounds(10, 167, 58, 14);
		contentPane.add(lblNewLabel_1);

		ansLast = new JTextField();
		ansLast.setBounds(75, 164, 122, 20);
		contentPane.add(ansLast);
		ansLast.setColumns(10);
	}
}
