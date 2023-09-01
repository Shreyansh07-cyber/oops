import java.io.*;
import java.net.*;

public class Server {
    public static boolean check(String data) {
        String[] salariesStr = data.split(",");
        if (salariesStr.length != 12) {
            return false;
        }

        for (String salaryStr : salariesStr) {
            try {
                Double.parseDouble(salaryStr);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);

            System.out.println("Server running ");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter writer = new PrintWriter(outputStream, true);

                String choice = reader.readLine();
                writer.println("Enter 12 months' salaries separated by commas:");
                String data = reader.readLine();
                while (!check(data)) {
                    writer.println("Error in Input! Enter 12 months' salaries separated by commas:");
                    data = reader.readLine();
                }

                if (choice.equalsIgnoreCase("max")) {

                    // String data = reader.readLine();
                    String[] salariesStr = data.split(",");
                    double maxSalary = Double.MIN_VALUE;
                    for (String salaryStr : salariesStr) {
                        double salary = Double.parseDouble(salaryStr);
                        if (salary > maxSalary) {
                            maxSalary = salary;
                        }
                    }
                    writer.println("Maximum salary: " + maxSalary);
                }

                else if (choice.equalsIgnoreCase("min")) {
                    // String data = reader.readLine();
                    String[] salariesStr = data.split(",");
                    double minSalary = Double.MAX_VALUE;
                    for (String salaryStr : salariesStr) {
                        double salary = Double.parseDouble(salaryStr);
                        if (salary < minSalary) {
                            minSalary = salary;
                        }
                    }
                    writer.println("Minimum salary: " + minSalary);

                } else if (choice.equalsIgnoreCase("avg")) {
                    double total, sum = 0;
                    // String data = reader.readLine();
                    String[] salariesStr = data.split(",");
                    for (String salaryStr : salariesStr) {
                        sum += Double.parseDouble(salaryStr);
                        // total = total / salariesStr.length;
                    }
                    total = (sum / salariesStr.length);
                    writer.println("average salary: " + total);
                }
                clientSocket.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}