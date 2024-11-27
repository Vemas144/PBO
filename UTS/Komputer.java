package UTS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Komputer {
    public String merk;
    public int kecProsezor;
    public int sizeMemory;
    public String jnsProsesor;

    public Komputer() {
    }

    public Komputer(String merk, int kecProsezor, int sizeMemory, String jnsProsesor) {
        this.merk = merk;
        this.kecProsezor = kecProsezor;
        this.sizeMemory = sizeMemory;
        this.jnsProsesor = jnsProsesor;
    }
    
    public void tampildata(){
        System.out.println("=======================================");
        System.out.println("Merk: " +this.merk);
        System.out.println("Kecepatan Prosesor: " +this.kecProsezor + " GHz");
        System.out.println("Size Memory: " +this.sizeMemory + "GB");
        System.out.println("Jenis Prosesor: " +this.jnsProsesor);
    }
}
