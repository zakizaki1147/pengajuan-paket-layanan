/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Menu;

import java.util.*;
// import TugasBesar.User.Teknisi;
import TugasBesar.Enums.StatusPemasangan;

/**
 *
 * @author Fasha Azhi Putra
 */
public class Pemasangan {
    private int id;
    private Pengajuan pengajuan;
    private StatusPemasangan status;

    // private ArrayList<Pemasangan> daftarPemasangan = new ArrayList<>();

    private static int pemasanganIncrement = 1;

    public Pemasangan(Pengajuan pengajuan) {
        if (pengajuan == null) {
            throw new IllegalArgumentException("[!] Pengajuan tidak boleh null!");
        }

        this.id = pemasanganIncrement++;
        this.pengajuan = pengajuan;
        this.status = StatusPemasangan.MENUNGGU_JADWAL;
    }

    public int getId() {
        return id;
    }

    public void perbaruiStatus(StatusPemasangan status) {
        if (status == null) {
            throw new IllegalArgumentException("[!] Status tidak boleh null!");
        }

        this.status = status;
    }

    // public void perbaruiStatusPemasangan(int id, StatusPemasangan status) {
    // for (Pemasangan p : daftarPemasangan) {
    // if (p.getId() == id) {
    // p.status = status;
    // System.out.println("Status berhasil diupdate");
    // return;
    // }
    // }
    // System.out.println("Pemasangan dengan no " + id + " tidak ada");
    // }

    // public void infoPemasangan() {
    // System.out.println("=== Daftar Pemasangan ===");
    // for (Pemasangan p : daftarPemasangan) {
    // System.out.println(p);
    // }
    // }

    public Pengajuan getPengajuan() {
        return pengajuan;
    }

    public StatusPemasangan getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Id : " + getId() + "\n"
                + "Pengajuan : " + getPengajuan() + "\n"
                + "Status : " + getStatus() + "\n";
    }
}
