public class IpCalc {
	public static int[] network;
	public static int[] broadcast;
	public static int[] firstHost;
	public static int[] lastHost;

	public static int[] getNetwork(int[] netmask, int[] ipOctet) {
		int[] network = new int[4];
		for (int i = 0; i < network.length; i++) {
			network[i] = netmask[i] & ipOctet[i];
		}
		return network;
	}

	public static int[] getBroadcast(int[] netmask, int[] ipOctet) {
		int[] netmInv = { 255, 255, 255, 255 };
		for (int k = 0; k < netmInv.length; k++) {
			netmInv[k] = netmInv[k] ^ netmask[k];
		}
		int[] broadcast = new int[4];
		for (int i = 0; i < broadcast.length; i++) {
			broadcast[i] = ipOctet[i] | netmInv[i];
		}
		return broadcast;
	}

	public static int[] getFirstHost(int[] network) {
		int[] firstHost = network;
		firstHost[3] = firstHost[3] + 1;
		return firstHost;
	}

	public static int[] getLastHost(int[] broadcast) {
		int[] lastHost = broadcast;
		lastHost[3] = lastHost[3] - 1;
		return lastHost;
	}

	public static String toStringNetwork(int[] network) {
		return network[0] + "." + network[1] + "." + network[2] + "." + network[3];
	}

	public static String toStringBroadcast(int[] broadcast) {
		return broadcast[0] + "." + broadcast[1] + "." + broadcast[2] + "." + broadcast[3];
	}

	public static String toStringFirstHost(int[] firstHost) {
		return firstHost[0] + "." + firstHost[1] + "." + firstHost[2] + "." + firstHost[3];
	}

	public static String toStringLastHost(int[] lastHost) {
		return lastHost[0] + "." + lastHost[1] + "." + lastHost[2] + "." + lastHost[3];
	}
}
