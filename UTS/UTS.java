/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UTS;

/**
 *
 * @author ADMIN
 */
public class UTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Komputer komputer = new Komputer("Asus", 3, 16, "Intel");
        komputer.tampildata();

        System.out.println("\nLaptop:");
        Laptop laptop = new Laptop("HP", 2, 8, "AMD", "Li-ion");
        laptop.tampilLaptop();

        System.out.println("\nPC:");
        Pc pc = new Pc("Dell", 3, 32, "Intel", 24);
        pc.tampilPc();

        System.out.println("\nMac:");
        Mac mac = new Mac("Apple", 4, 16, "M1", "Li-Po", "FaceID");
        mac.tampilMac();

        System.out.println("\nWindows:");
        Windows windows = new Windows("Microsoft", 2, 8, "AMD", "Li-ion", "Cortana");
        windows.tampilWindows();
    
    }
}
