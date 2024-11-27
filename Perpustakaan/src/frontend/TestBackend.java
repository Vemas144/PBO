/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;
import backend.*;
/**
 *
 * @author ADMIN
 */
public class TestBackend {
    public static void main(String[] args)
   {
        
//       Kategori kat1 = new Kategori("Novel", "Koleksi buku novel");
//       Kategori kat2 = new Kategori("Referensi", "Buku referensi ilmiah");
//       Kategori kat3 = new Kategori("Komik", "Komik anak-anak");
        // test insert
//        kat1.save();
//        kat2.save();
//        kat3.save();
//        // test update
//        kat2.setKeterangan("Koleksi buku referensi ilmiah");
//        kat2.save();
//        // test delete
//       kat3.delete();
        // test select all
//        for(Kategori k : new Kategori().getAll())
//        {
//        System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
//        }
        // test search
//        for(Kategori k : new Kategori().search("ilmiah"))
//       {
//       System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
//        }
       
        Anggota ang1 = new Anggota("Yanto", "jln.kenangan", "029826353");
        Anggota ang2 = new Anggota("Sanju", "jln.cinta", "987643233");
        Anggota ang3 = new Anggota("Mawar", "jln.yuk sama aku", "1234566576");
        // test insert
        ang1.save();
        ang2.save();
        ang3.save();

        // test update
        ang2.setAlamat("jln.aja dulu");
        ang2.save();

        // test delete
        ang3.delete();

        // test select all
        for(Anggota a : new Anggota().getAll())
        {
        System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() 
                + ", Telepon: " + a.getTelepon());
        }

        // test search
        for(Anggota a : new Anggota().search("Yanto"))
        {
        System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() 
                + ", Telepon: " + a.getTelepon());
        }

    }
}
