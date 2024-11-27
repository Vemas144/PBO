/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum_gui;

import java.awt.Color;
import javax.swing.*;
/**
 *
 * @author ADMIN
 */
public class Praktikum_GUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JOptionPane.showConfirmDialog(null, "Coding itu mudah ker!!.");
        String nama = JOptionPane.showInputDialog(null, "Siapa namamu? ");
        int pilihan = JOptionPane.showConfirmDialog(null, "Coding itu mudah kan, " +nama+ "?");
        if(pilihan==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Tentu saja! " 
                    + "Bahkan anak umur 4 tahun sudah bisa coding");
        }else{
            JOptionPane.showMessageDialog(null, "Susah sih! soalnya saya malah");
        }
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setForeground(Color.BLUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(10, 50);
        frame.setSize(300,100);
        frame.setTitle("Frame coding itu mudah");
        
    }
    
}
