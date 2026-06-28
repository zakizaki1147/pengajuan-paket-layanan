/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Menu;

import java.util.*;
import TugasBesar.User.Customer;
import TugasBesar.Enums.StatusPembayaran;

/**
 *
 * @author Jeki
 */
public class Tagihan {
    private int id;
    private double total;
    private StatusPembayaran status;
    // private String metodePembayaran;
    private Customer customer;
    // private ArrayList<Pembayaran> daftarPembayaran;
    private Pembayaran pembayaran;

    private static int tagihanCounter = 1;

    public Tagihan(Customer customer, double total) {
        if (customer == null && total == 0.0) {
            throw new IllegalArgumentException("[!] Data tidak boleh kosong!");
        }

        this.id = tagihanCounter++;
        this.total = total;
        this.customer = customer;
        this.status = StatusPembayaran.BELUM_LUNAS;
        // this.daftarPembayaran = new ArrayList<Pembayaran>();
    }

    public double hitungTotal() {
        return total;
    }

    // public void updateStatus(StatusPembayaran status) {
    //     this.status = status;
    // }

    public StatusPembayaran getStatus() {
        return status;
    }

    public void bayarTagihan(Pembayaran pembayaran) {
        // daftarPembayaran.add(pembayaran);
        this.pembayaran = pembayaran;
        this.status = StatusPembayaran.SUDAH_LUNAS;
    }

    // public void lihatDaftarTagihan() {
    // for (Pembayaran t : daftarPembayaran) {
    // System.out.println(t);
    // }
    // }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    @Override
    public String toString() {
        return "ID Pembayaran: " + getId() + ", Total: " + getTotal();
    }
}
