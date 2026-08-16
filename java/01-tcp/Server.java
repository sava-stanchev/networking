import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("listening on port 8080");

		while (true) {
			Socket client = server.accept();
			System.out.println("client connected: " + client.getRemoteSocketAddress());
			InputStream input = client.getInputStream();
			int data = input.read();
			System.out.println("received: " + (char) data);
			client.close();
		}
	}
}
