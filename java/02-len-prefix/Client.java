import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException, InterruptedException {
		Socket socket = new Socket("127.0.0.1", 8081);
		OutputStream output = socket.getOutputStream();
		byte[] len = {0x00, 0x00, 0x00, 0x05};
		byte[] part1 = {0x68, 0x65};
		byte[] part2 = {0x6c, 0x6c, 0x6f};
 		
		output.write(len);
		output.flush();
		output.write(part1);
		output.flush();
		System.out.println("sent: he");
		Thread.sleep(3000);
		output.write(part2);
		output.flush();
		System.out.println("sent: llo");

		socket.close();
	}
}
