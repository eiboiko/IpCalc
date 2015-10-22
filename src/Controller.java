import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try {
				String ipAddress, result;
				int mask;
				ipAddress = getIp.getText();
				mask = Integer.parseInt(getMask.getText());
				// btnCount.addActionListener(new ButtonListener());
				Netmask.netmaskCheck(mask);
				Netmask.toString(Netmask.netmask);
				result = Netmask.toString(Netmask.netmask);
				ansNetmask.setText(String.valueOf(result));
				ansNetwork.setText(IpCalc.toStringNetwork(IpCalc.network));
				ansBroadcast.setText(IpCalc.toStringBroadcast(IpCalc.broadcast));
				ansFrst.setText(IpCalc.toStringFirstHost(IpCalc.firstHost));
				ansLast.setText(IpCalc.toStringLastHost(IpCalc.lastHost));
				// showStatus("Successfull!");
			} catch (NumberFormatException e) {
				// showStatus("Input Error!");
			}
		}
	}

}
