/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Menu;

import java.util.*;
import TugasBesar.Enums.StatusPengajuan;
import TugasBesar.User.*;

/**
 *
 * @author Fasha Azhi Putra
 */
public class Pengajuan {
    protected int id;
    private PaketLayanan paket;
    private StatusPengajuan status;

    // private ArrayList<Pengajuan> daftarPengajuan = new ArrayList<>();

    public static int pengajuanIncrement = 1;

    public Pengajuan(PaketLayanan paket) {
        if (paket == null) {
            throw new IllegalArgumentException("[!] Paket tidak boleh null!");
        }

        this.id = pengajuanIncrement++;
        this.paket = paket;
        this.status = StatusPengajuan.MENUNGGU_VERIFIKASI;
    }

    public int getId() {
        return id;
    }

    public StatusPengajuan getStatus() {
        return status;
    }

    public void perbaruiStatus(StatusPengajuan status) {
        if (status == null) {
            throw new IllegalArgumentException("[!] Status tidak boleh null!");
        }

        this.status = status;
    }

    public PaketLayanan getPaket() {
        return paket;
    }

    public boolean validasi() { // cek data pengajuan lengkap atau tidak
        if (this.paket == null)
            return false;
        return true;
    }

    // public ArrayList<Pengajuan> getPengajuan() {
    // return daftarPengajuan;
    // }

    // public void tambahPengajuan(int idPaket) {
    // PaketLayanan paket = PaketLayanan.getDaftarPaket().get(idPaket - 1); // buat
    // ambil id paket
    // daftarPengajuan.add(new Pengajuan(paket));

    // System.out.println("Pengajuan berhasil dibuat");
    // }

    // public void perbaruiStatusPengajuan(int id, StatusPengajuan status) {
    // for (Pengajuan p : daftarPengajuan) {
    // if (p.getId() == id) {
    // p.status = status;
    // System.out.println("Status dengan id " + id + " berhasil diperbarui");
    // return;
    // }
    // }
    // System.out.println("Pengajuan dengan no " + id + " tidak ada");
    // }

    @Override
    public String toString() {

        return "Id : " + getId() + "\n"
                + "Paket : " + getPaket() + "\n"
                + "Status : " + getStatus() + "\n";
    }

}
