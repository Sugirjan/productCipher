/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher;

import java.io.*;

/**
 *
 * @author Sugirjan
 */
public class Encrypt {

    public void encrypt() throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        System.out.println("Enter Key 1:");
        int key1 = Integer.parseInt(obj.readLine());
        System.out.println("Enter Key 2:");
        int key2 = Integer.parseInt(obj.readLine());
        String ip;
        FileWriter sw = new FileWriter("output.txt", false);
        while ((ip = br.readLine()) != null) {
            String line = "";
            line = add(ip, key1);
            line = transpose(line, key2);
            try (FileWriter fw = new FileWriter("output.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw)) {
                pw.println(line);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    String add(String line, int k) {
        StringBuilder s = new StringBuilder();
        int len = line.length();
        char temp;
        int temp1;
        for (int i = 0; i < len; i++) {
            temp = line.charAt(i);
            if (Character.isUpperCase(temp)) {
                temp1 = (int) temp - (int) 'A';
                temp1 = (temp1 + k) % 26;
                temp1 = temp1 + (int) 'A';
                temp = (char) temp1;
                s.append(temp);
            } else if (Character.isLowerCase(temp)) {
                temp1 = (int) temp - (int) 'a';
                temp1 = (temp1 + k) % 26;
                temp1 = temp1 + (int) 'a';
                temp = (char) temp1;
                s.append(temp);
            } else {
                s.append(temp);
            }
        }
        String output = s.toString();
        return output;
    }

    String transpose(String ip, int matrix_row) {
        char table[][] = new char[100][100];
        int len = ip.length();
        String output2 = "";
        int i1, i2, i;

        //calculate columns from rows
        int matrix_col = (int) Math.ceil((float) len / matrix_row);

        for (i = 0, i1 = 0, i2 = 0; i < len; i++) {
            table[i2][i1] = ip.charAt(i);
            i2++;
            if (i2 == matrix_row) {
                i2 = 0;
                i1++;
            }
        }

        for (i1 = 0; i1 < matrix_row; i1++) {
            for (i2 = 0; i2 < matrix_col; i2++) {
                output2 = output2 + table[i1][i2];
            }
        }

        return (output2);
    }
}
