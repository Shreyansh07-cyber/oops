import java.io.*;
import java.net.*;

public class Client 
{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter choice (max/min/avg): ");
            String choice = userInput.readLine();
            writer.println(choice);

            // System.out.print("Enter salaries for 12 months (comma-separated): ");
            // String salaries = userInput.readLine();
            // writer.println(salaries);
            while (!socket.isClosed()) {
                String response = reader.readLine();
                System.out.println("Server response: " + response);
                String salaries = userInput.readLine();
                writer.println(salaries);
            }

            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
