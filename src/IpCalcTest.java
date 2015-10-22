import java.util.Scanner;

public class IpCalcTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("IP: ");
		String ipAddress = sc.next();
		System.out.println("Mask: ");
		int mask = sc.nextInt();
		int[] ip = IpUser.createIp(ipAddress);
		if (ip == null) {
			System.out.println("Invalid IP address!");
		} else {
			int[] netm = Netmask.netmaskCheck(mask);
			if (netm == null) {
				System.out.println("Incorrect mask value!");
			} else {
				System.out.println("Netmask: " + Netmask.toString(netm));
				int[] netw = IpCalc.getNetwork(netm, ip);
				System.out.println("Network: " + IpCalc.toStringNetwork(netw));
				int[] br = IpCalc.getBroadcast(netm, ip);
				System.out.println("Broadcast: " + IpCalc.toStringBroadcast(br));
				int[] fr = IpCalc.getFirstHost(netw);
				System.out.println("First host: " + IpCalc.toStringFirstHost(fr));
				int[] lst = IpCalc.getLastHost(br);
				System.out.println("Last host: " + IpCalc.toStringLastHost(lst));
				sc.close();
			}
		}
	}
}
