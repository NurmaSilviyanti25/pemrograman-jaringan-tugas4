/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum1;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class FilterStream {
    
    public static void main(String[] args) {
        Scanner br = new Scanner (System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Masukan karakter apapun, [tekan keluar tekan `q`]: ");
         String input = "";
         do {
             try {
                 input = br.nextLine();
                 //input =  br.readLine();
                 System.out.print("-> " + input);
             } catch (Exception ex) {
                 Logger.getLogger(ReadInputKeyboard.class.getName()).log(Level.SEVERE, null, ex);
             }
         } while (!input.equals("q"));
    }
    
}
