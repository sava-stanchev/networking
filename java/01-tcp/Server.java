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
			
			Thread thread = new Thread(() -> {
				try {
					InputStream input = client.getInputStream();
					int data;
					
					while ((data = input.read()) != -1) {
						System.out.print((char) data);
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
