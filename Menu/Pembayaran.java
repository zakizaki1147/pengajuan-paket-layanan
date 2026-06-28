/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Menu;

import java.util.*;
import TugasBesar.Enums.StatusPembayaran;

/**
 *
 * @author Jeki
 */
public class Pembayaran {
    private int id;
    private double total;
    private String metode;
    // private StatusPembayaran status;
    private Tagihan tagihan;
    // private ArrayList<Pembayaran> daftarPembayaran;

    private static int pembayaranCounter = 1;

    public Pembayaran(double total, String metode, Tagihan tagihan) {
        if (total == 0.0 && metode == null && tagihan == null) {
            throw new IllegalArgumentException("[!] Data tidak boleh kosong!");
        }

        this.id = pembayaranCounter++;
        this.total = total;
        this.metode = metode;
        this.tagihan = tagihan;
        // this.status = status;
        // this.daftarPembayaran = new ArrayList<>();
    }

    public boolean prosesPembayaran() {
        return true;
    }
}
