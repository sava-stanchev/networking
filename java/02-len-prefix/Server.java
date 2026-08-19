import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8081);
		System.out.println("listening on port 8081");
		Socket client = server.accept();
		InputStream input = client.getInputStream();
		
		int data;
		while ((data = input.read()) != -1) {
			System.out.printf("%02x ", data);
		}
		System.out.println();

		client.close();
		server.close();
	}
}
