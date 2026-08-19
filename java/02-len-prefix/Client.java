import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8081);
		OutputStream output = socket.getOutputStream();
		byte[] msg = {0x00, 0x00, 0x00, 0x05, 0x68, 0x65, 0x6c, 0x6c, 0x6f};
		output.write(msg);
		output.flush();
		socket.close();
	}
}
