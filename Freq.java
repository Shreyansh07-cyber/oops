import java.io.*;
import java.util.*;

class Freq {
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String si = sc.nextLine();
        int n = si.length();
        char s[] = si.toCharArray();
        
	if (s[0] == '\0')
	{
            System.out.println("It is a NULL String");
            System.exit(0);
        }
        int fp = 0, sp = 0;
        for (fp = 0; fp < n - 1; fp++) {
            int count = 1;
            for (sp = fp + 1; sp < n; sp++) {
                if (s[fp] == s[sp]) {
                    count++;
                    s[sp] = '\0';
                }
            }
            System.out.println(s[fp] + " = " + count);
        }
    }
}
