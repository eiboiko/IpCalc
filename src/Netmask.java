public class Netmask {
	public static int[] netmask;

	public static int[] netmaskCheck(int mask) {
		if (mask < 8 || mask > 30) {
			return null;
		}
		String[] maskTable = { "255.0.0.0 ", "255.128.0.0", "255.192.0.0", "255.224.0.0", "255.240.0.0", "255.248.0.0",
				"255.252.0.0", "255.254.0.0", "255.255.0.0", "255.255.128.0", "255.255.192.0", "255.255.224.0",
				"255.255.240.0", "255.255.248.0", "255.255.252.0", "255.255.254.0", "255.255.255.0", "255.255.255.128",
				"255.255.255.192", "255.255.255.224", "255.255.255.240", "255.255.255.248", "255.255.255.252" };
		String netMaskLine = maskTable[mask - 8];
		String[] m = netMaskLine.split("\\.");
		int[] netmask = new int[m.length];
		for (int i = 0; i < netmask.length; i++) {
			netmask[i] = Integer.parseInt(m[i].trim());
		}
		return netmask;
	}

	public static String toString(int[] netmask) {
		return netmask[0] + "." + netmask[1] + "." + netmask[2] + "." + netmask[3];
	}
}