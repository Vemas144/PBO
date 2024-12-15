/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class Peminjaman {
     private int idpeminjaman;
    private Pegawai pegawai;
    private Anggota anggota;
    private Buku buku;
    private String tanggalPinjam;

    public Peminjaman() {
        pegawai = new Pegawai();
        anggota = new Anggota();
        buku    = new Buku();
    }

    public Peminjaman(Pegawai pegawai, Anggota anggota, Buku buku, String tanggalPinjam) {
        this.pegawai = pegawai;
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public Peminjaman getById(int id) {
        Peminjaman pinjam = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("SELECT p.idpeminjaman, a.nama AS nama_anggota, b.judul AS judul_buku, "
                + "pg.nama AS nama_pegawai, p.tanggalpinjam "
                + "FROM peminjaman p "
                + "INNER JOIN anggota a ON p.idanggota = a.idanggota "
                + "INNER JOIN buku b ON p.idbuku = b.idbuku "
                + "INNER JOIN pegawai pg ON p.idpegawai = pg.idpegawai "
                + "WHERE p.idpeminjaman = " + id);

        try {
            while (rs.next()) {
                pinjam = new Peminjaman();
                pinjam.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pinjam.getPegawai().setNama(rs.getString("nama_pegawai"));
                pinjam.getAnggota().setNama(rs.getString("nama_anggota"));
                pinjam.getBuku().setJudul(rs.getString("judul_buku"));                
                pinjam.setTanggalPinjam(rs.getString("tanggalpinjam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pinjam;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT p.idpeminjaman, a.nama AS nama_anggota, b.judul AS judul_buku, "
                + "pg.nama AS nama_pegawai, p.tanggalpinjam "
                + "FROM peminjaman p "
                + "INNER JOIN anggota a ON p.idanggota = a.idanggota "
                + "INNER JOIN buku b ON p.idbuku = b.idbuku " 
                + "INNER JOIN pegawai pg ON p.idpegawai = pg.idpegawai ORDER BY p.idpeminjaman DESC");

        try {
            while (rs.next()) {
                Peminjaman pinjam = new Peminjaman();
                pinjam.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pinjam.getPegawai().setNama(rs.getString("nama_pegawai"));
                pinjam.getAnggota().setNama(rs.getString("nama_anggota"));
                pinjam.getBuku().setJudul(rs.getString("judul_buku"));
                pinjam.setTanggalPinjam(rs.getString("tanggalpinjam"));

                ListPeminjaman.add(pinjam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public void save() {
        if (getById(idpeminjaman).getIdpeminjaman() == 0) {
            String SQL = "INSERT INTO peminjaman (idpegawai, idanggota, idbuku, tanggalpinjam) VALUES ("
                    + "'" + this.getPegawai().getIdPegawai() + "', "
                    + "'" + this.getAnggota().getIdanggota() + "', "
                    + "'" + this.getBuku().getidbuku() + "', "
                    + "'" + this.tanggalPinjam + "'"
                    + ")";
            this.idpeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE peminjaman SET "
                    + "idpegawai = '" + this.getPegawai().getIdPegawai() + "', "
                    + "idanggota = '" + this.getAnggota().getIdanggota() + "', "
                    + "idbuku = '" + this.getBuku().getidbuku() + "', "
                    + "tanggalpinjam = '" + this.tanggalPinjam + "' "
                    + "WHERE idpeminjaman = '" + this.idpeminjaman + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }
}


