/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.sql.*;
import java.util.ArrayList;

/**
 * 
 * @author ADMIN
 */
public class Pengembalian {
    private int idPengembalian;
    private Peminjaman peminjaman;
    private String tanggalPengembalian;

    // Konstruktor default
    public Pengembalian() {}

    // Konstruktor dengan parameter
    public Pengembalian(Peminjaman peminjaman, String tanggalPengembalian) {
        this.peminjaman = peminjaman;
        this.tanggalPengembalian = tanggalPengembalian;
    }

    // Getter dan Setter
    public int getIdPengembalian() {
        return idPengembalian;
    }

    public void setIdPengembalian(int idPengembalian) {
        this.idPengembalian = idPengembalian;
    }

    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(String tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    // Menyimpan data pengembalian dan memperbarui status peminjaman
    public void save() {
        // Menyimpan data pengembalian
        String query = "INSERT INTO pengembalian (idpeminjaman, tanggalpengembalian) VALUES ("
                + this.getPeminjaman().getIdpeminjaman() + ", '"
                + this.getTanggalPengembalian() + "')";
        DBHelper.insertQueryGetId(query);
   }

    // Mengambil data pengembalian berdasarkan ID
    public Pengembalian getById(int id) {
        Pengembalian pengembalian = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pengembalian WHERE idpengembalian = " + id);

        try {
            while (rs.next()) {
                pengembalian = new Pengembalian();
                pengembalian.setIdPengembalian(rs.getInt("idpengembalian"));
                pengembalian.setPeminjaman(new Peminjaman().getById(rs.getInt("idpeminjaman")));
                pengembalian.setTanggalPengembalian(rs.getString("tanggalpengembalian"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pengembalian;
    }

    // Mengambil semua data pengembalian
    public ArrayList<Pengembalian> getAll() {
        ArrayList<Pengembalian> list = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pengembalian");

        try {
            while (rs.next()) {
                Pengembalian pengembalian = new Pengembalian();
                pengembalian.setIdPengembalian(rs.getInt("idpengembalian"));
                pengembalian.setPeminjaman(new Peminjaman().getById(rs.getInt("idpeminjaman")));
                pengembalian.setTanggalPengembalian(rs.getString("tanggalpengembalian"));

                list.add(pengembalian);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Mengambil data pengembalian berdasarkan ID peminjaman
        public Pengembalian getByIdPeminjaman(int idPeminjaman) {
            Pengembalian pengembalian = null;
            ResultSet rs = DBHelper.selectQuery("SELECT * FROM pengembalian WHERE idpeminjaman = " + idPeminjaman);

            try {
                while (rs.next()) {
                    pengembalian = new Pengembalian();
                    pengembalian.setIdPengembalian(rs.getInt("idpengembalian"));
                    pengembalian.setPeminjaman(new Peminjaman().getById(rs.getInt("idpeminjaman")));
                    pengembalian.setTanggalPengembalian(rs.getString("tanggalpengembalian"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return pengembalian;
        }

}





