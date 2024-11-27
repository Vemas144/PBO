/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS;

/**
 *
 * @author ADMIN
 */
public class Mac extends Laptop{
    public String security;

    public Mac() {
    }

    public Mac( String merk, int kecProsezor, int sizeMemory, String jnsProsesor, String jnsBatrei, String security) {
        super(merk, kecProsezor, sizeMemory, jnsProsesor, jnsBatrei);
        this.security = security;
    }
    
    public void tampilMac(){
        super.tampilLaptop();
        System.out.println("Security: " +this.security);
    }
    
}
