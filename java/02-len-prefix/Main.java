public class Main {
	public static void main(String[] args) {
		int len = 16909060;
		int byte1 = (len >> 24) & 0xff;
		int byte2 = (len >> 16) & 0xff;
		int byte3 = (len >> 8) & 0xff;
		int byte4 = len & 0xff;

		System.out.printf("%02x %02x %02x %02x%n", byte1, byte2, byte3, byte4);
		
		int rebuilt = (byte1 << 24) | (byte2 << 16) | (byte3 << 8) | byte4;
		System.out.println("original: " + len);
		System.out.println("rebuilt: " + rebuilt);
	}
}
