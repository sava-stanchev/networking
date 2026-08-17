import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("listening on port 8080");

		while (true) {
			Socket client = server.accept();
			System.out.println("client connected: " + client.getRemoteSocketAddress());
			
			Thread thread = new Thread(() -> {
				try {
					BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
					String msg;
					while ((msg = reader.readLine()) != null) {
						System.out.println(client.getRemoteSocketAddress() + ": " + msg);
					}
					
					System.out.println("\nclient disconnected: " + client.getRemoteSocketAddress());
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			thread.start();
		}
	}
}
