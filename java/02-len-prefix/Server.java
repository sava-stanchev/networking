import java.io.IOException;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8081);
		System.out.println("listening on port 8081");
		Socket client = server.accept();
		DataInputStream input = new DataInputStream(client.getInputStream());
		
		int byte1 = input.read();
		int byte2 = input.read();
		int byte3 = input.read();
		int byte4 = input.read();
		System.out.printf("%02x %02x %02x %02x%n", byte1, byte2, byte3, byte4);
		
		int len = (byte1 << 24) | (byte2 << 16) | (byte3 << 8) | byte4;
		System.out.println("length: " + len);
		byte[] payload = new byte[len];
		input.readFully(payload);
		String msg = new String(payload, StandardCharsets.UTF_8);
		System.out.println("payload received");
		System.out.println("message: " + msg);

		client.close();
		server.close();
	}
}
