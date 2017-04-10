/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher;

/**
 *
 * @author Sugirjan
 */
import java.io.*;

public class ProductCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.append("1.Encrypt\n2.Decrypt\n");
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(obj.readLine());
        if (choice == 1) {
            Encrypt e = new Encrypt();
            e.encrypt();
        } else if (choice == 2) {
            Decrypt d = new Decrypt();
            d.decrypt();
        } else {
            System.out.println("Invalid Choice");
        }
    }

}
