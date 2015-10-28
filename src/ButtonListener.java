import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent ev) {
		try {
			String ipAddress;
			int mask;
			ipAddress = UserInterface.getIp.getText();
			mask = Integer.parseInt(UserInterface.getMask.getText());
			Netmask.netmaskCheck(mask);
			IpUser.createIp(ipAddress);
			UserInterface.ansNetmask.setText(Netmask.toString(Netmask.netmask));
			UserInterface.ansNetwork.setText(IpCalc.toStringNetwork(IpCalc.network));
			UserInterface.ansBroadcast.setText(IpCalc.toStringBroadcast(IpCalc.broadcast));
			UserInterface.ansFrst.setText(IpCalc.toStringFirstHost(IpCalc.firstHost));
			UserInterface.ansLast.setText(IpCalc.toStringLastHost(IpCalc.lastHost));
			// showStatus("Successfull!");
		} catch (NumberFormatException e) {
			// showStatus("Input Error!");
		}
	}
}