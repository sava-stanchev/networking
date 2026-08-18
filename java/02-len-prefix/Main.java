import java.nio.charset.StandardCharsets;

public class Main {
	public static void main(String[] args) {
		String msg = "hello";
		byte[] payload = msg.getBytes(StandardCharsets.UTF_8);
		int len = payload.length;
		int lenByte1 = (len >> 24) & 0xff;
		int lenByte2 = (len >> 16) & 0xff;
		int lenByte3 = (len >> 8) & 0xff;
		int lenByte4 = len & 0xff;

		System.out.println("message: " + msg);
		System.out.println("length: " + len);
		System.out.printf("%02x %02x %02x %02x ", lenByte1, lenByte2, lenByte3, lenByte4);
		
		for (byte b : payload) {
			System.out.printf("%02x ", b & 0xff);
		}
		System.out.println();
	}
}
