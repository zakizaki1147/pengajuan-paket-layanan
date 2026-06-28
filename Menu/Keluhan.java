/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Menu;

import java.util.Date;
import TugasBesar.User.Customer;
import TugasBesar.Enums.StatusKeluhan;

/**
 *
 * @author Jeki
 */
public class Keluhan {
    private int id;
    // private Customer customer;
    private String isiKeluhan;
    private StatusKeluhan status;
    // private String tanggapan;

    private static int keluhanCounter = 1;

    public Keluhan(String isiKeluhan) {
        if (isiKeluhan == null) {
            throw new IllegalArgumentException("[i] Keluhan tidak boleh null!");
        }

        this.id = keluhanCounter++;
        // this.customer = customer;
        this.isiKeluhan = isiKeluhan;
        this.status = StatusKeluhan.BELUM_DITINDAK;
    }

    // public void perbaruiStatusKeluhan(int id, StatusKeluhan status) {
    // // this.id = id;
    // this.status = status;
    // }

    // public void tampilkanDaftarKeluhan() {
    // System.out.println("Keluhan : " + isiKeluhan);
    // System.out.println("Status : " + status);
    // }

    public void perbaruiStatus(StatusKeluhan status) {
        if (status == null) {
            throw new IllegalArgumentException("[!] Status tidak boleh null!");
        }

        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getIsiKeluhan() {
        return isiKeluhan;
    }

    public StatusKeluhan getStatus() {
        return status;
    }
}
