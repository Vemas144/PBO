/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts;

/**
 *
 * @author ADMIN
 */
public class Laptop extends Komputer{
    public String jnsBatrei;

    public Laptop() {
    }

    public Laptop( String merk, int kecProsezor, int sizeMemory, String jnsProsesor, String jnsBatrei) {
        super(merk, kecProsezor, sizeMemory, jnsProsesor);
        this.jnsBatrei = jnsBatrei;
    }
    
    public void tampilLaptop(){
        super.tampildata();
        System.out.println("Jenis Batrei: " +this.jnsBatrei);
    }
    
    
}
