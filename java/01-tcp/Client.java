import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException, InterruptedException {
		Socket socket = new Socket("127.0.0.1", 8080);
		OutputStream output = socket.getOutputStream();
		output.write("hello".getBytes());
		output.flush();
		System.out.println("sent hello without newline");
		Thread.sleep(5000);
		output.write("\n".getBytes());
		output.flush();
		System.out.println("sent newline");
		Thread.sleep(2000);
		socket.close();
	}
}
