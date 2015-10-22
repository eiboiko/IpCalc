public class IpUser {

	public static int[] createIp(String ipAddress) {
		String[] ipAd = ipAddress.split("\\.");
		int[] ipOctet = new int[ipAd.length];
		if (ipOctet.length != 4) {
			return null;
		}
		for (int i = 0; i < ipOctet.length; i++) {
			ipOctet[i] = Integer.parseInt(ipAd[i]);
			if (ipOctet[i] < 0 | ipOctet[i] > 255) {
				return null;
			}
		}
		if (ipOctet[0] == 0) {
			return null;
		}
		return ipOctet;
	}
}