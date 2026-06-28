/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Menu;

import java.util.*;

/**
 *
 * @author Fasha Azhi Putra
 */
public class PaketLayanan {

    private int id;
    private String nama;
    private String deskripsi;
    private double harga;
    private static ArrayList<PaketLayanan> daftarPaket = new ArrayList<>();

    static {
        daftarPaket.add(new PaketLayanan(1, "Paket 1", "Layanan low", 10000)); 
        daftarPaket.add(new PaketLayanan(2, "Paket 2", "Layanan mid", 20000)); 
        daftarPaket.add(new PaketLayanan(3, "Paket 3", "Layanan hard", 12000));
        daftarPaket.add(new PaketLayanan(4, "Paket 4", "Layanan nightmare", 40000));
    }

    public PaketLayanan(int id, String nama, String deskripsi, double harga) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setNama(String namaBaru) {
        this.nama = namaBaru;
    }

    public void setHarga(double hargaBaru) {
        this.harga = hargaBaru;
    }

    public static ArrayList<PaketLayanan> getDaftarPaket() { //
        return daftarPaket;
    }

    public void lihatDaftarPaket() {
        System.out.println("=== Daftar Paket Layanan ===");
        for (PaketLayanan p : daftarPaket) {
            System.out.println(p);
        }
    }

    public void tambahPaket(String nama, String deskripsi, double harga) {
        int newId = daftarPaket.size() + 1;
        daftarPaket.add(new PaketLayanan(newId, nama, deskripsi, harga));
    }

    public void updateHarga(double harga) {
        this.harga = harga;
    }

    public void updateHarga(int id, double harga) {
        for (PaketLayanan p : daftarPaket) {
            if (p.getId() == id) {
                p.updateHarga(harga);
                System.out.println("Harga dengan id " + id + " berhasil diupdate");
                return;
            }
        }
        System.out.println("Paket dengan id " + id + " tidak ditemukan");
    }

    public void updateInfo(String nama, String deskripsi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public void updateInfo(int id, String nama, String deskripsi) {
        for (PaketLayanan p : daftarPaket) {
            if (p.getId() == id) {
                p.updateInfo(nama, deskripsi);
                System.out.println("Nama dan deskripsi dengan id " + id + " berhasil diupdate");
                return;
            }
        }
        System.out.println("Paket dengan " + id + " tidak ditemukan");
    }

    public void deletePaket(int id) {
        for (PaketLayanan p : daftarPaket) {
            if (p.getId() == id) {
                daftarPaket.remove(p);
                System.out.println("Data dengan id " + id + " berhasil dihapus");
                return;
            }
        }
        System.out.println("Paket dengan " + id + " tidak ditemukan");
    }

    public double hitungHargaTotal() {
        double total = 0.0;
        for (PaketLayanan p : daftarPaket) {
            total += p.getHarga();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Id :" + id + "\n"
                + "Nama  : " + nama + "\n"
                + "Deskripsi : " + deskripsi + "\n"
                + "Harga : Rp." + String.format("%.0f", harga) + "\n";
    }
}
