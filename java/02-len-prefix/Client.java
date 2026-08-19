import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
	public static void main(String[] args) throws IOException, InterruptedException {
		Socket socket = new Socket("127.0.0.1", 8081);
		OutputStream output = socket.getOutputStream();
		String msg = "€";
		byte[] payload = msg.getBytes(StandardCharsets.UTF_8);
 		int len = payload.length;

		int byte1 = (len >> 24) & 0xff;
		int byte2 = (len >> 16) & 0xff;
		int byte3 = (len >> 8) & 0xff;
		int byte4 = len & 0xff;
		
		output.write(byte1);
		output.write(byte2);
		output.write(byte3);
		output.write(byte4);
		output.write(payload);
		output.flush();

		socket.close();
	}
}
