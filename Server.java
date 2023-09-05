import java.io.*;
import java.net.*;

public class Server
{
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

