/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS;

/**
 *
 * @author ADMIN
 */
public class Pc extends Komputer{
    public int ukuranMonitor;

    public Pc() {
    }

    public Pc( String merk, int kecProsezor, int sizeMemory, String jnsProsesor, int ukuranMonitor) {
        super(merk, kecProsezor, sizeMemory, jnsProsesor);
        this.ukuranMonitor = ukuranMonitor;
    }
    
    public void tampilPc(){
       super.tampildata();
       System.out.println("Ukuran Monitor: " +this.ukuranMonitor + " inch");
    }
}
