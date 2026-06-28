package TugasBesar.User;

import TugasBesar.Enums.StatusKeluhan;
import TugasBesar.Enums.StatusPengajuan;
import TugasBesar.Menu.*;
import java.util.*;

/**
 *
 * @author hapis
 */
public class CustomerService extends User {
    // private ArrayList<Pengajuan> daftarPengajuan = new ArrayList<>();
    // private ArrayList<Tagihan> daftarTagihan = new ArrayList<>();
    // private ArrayList<Keluhan> daftarKeluhan = new ArrayList<>();

    public CustomerService(int id, String nama, String username, String password) {
        super(id, nama, username, password, "Customer Service");
    }

    // public void perbaruiStatusPengajuan(Pengajuan pengajuan) throws
    // IllegalArgumentException {
    // if (pengajuan == null) {
    // throw new IllegalArgumentException("Pengajuan tidak boleh kosong");
    // } else if (pengajuan.getStatus() == StatusPengajuan.DISETUJUI) {
    // System.out.println("Pengajuan sudah disetujui");
    // return;
    // } else if (pengajuan.getStatus() == StatusPengajuan.DITOLAK) {
    // System.out.println("Pengajuan sudah ditolak");
    // return;
    // }
    // }

    public void perbaruiStatusPengajuan(Customer customer, Pengajuan pengajuan) {
        if (customer == null || pengajuan == null) {
            System.out.println("Data tidak valid.");
            return;
        }

        if (pengajuan.getStatus() == StatusPengajuan.DISETUJUI) {
            System.out.println("Pengajuan sudah disetujui.");
            return;
        }

        if (pengajuan.getStatus() == StatusPengajuan.DITOLAK) {
            System.out.println("Pengajuan sudah ditolak.");
            return;
        }

        pengajuan.perbaruiStatus(StatusPengajuan.DISETUJUI);

        Pemasangan pemasanganBaru = new Pemasangan(pengajuan);

        customer.tambahPemasangan(pemasanganBaru);

        System.out.println("Pengajuan berhasil disetujui.");
        System.out.println("Data pemasangan berhasil dibuat.");
    }

    // public void perbaruiStatusKeluhan(Keluhan keluhan, Keluhan status) {
    // if (keluhan == null || status == null) {
    // System.out.println("Data tidak valid");
    // return;
    // } else if (keluhan.getStatus() == StatusKeluhan.SUDAH_SELESAI) {
    // System.out.println("Keluhan sudah selesai ditangani");
    // return;
    // } else {
    // keluhan.perbaruiStatusKeluhan(getId(), null);
    // System.out.println("Status keluhan berhasil diperbarui");
    // }
    // }

    public void perbaruiStatusKeluhan(Keluhan keluhan) {
        if (keluhan == null) {
            System.out.println("\n[!] Keluhan tidak ditemukan.");
            return;
        }

        if (keluhan.getStatus() == StatusKeluhan.SUDAH_SELESAI) {
            System.out.println("\n[!] Keluhan sudah selesai ditangani.");
            return;
        }

        keluhan.perbaruiStatus(StatusKeluhan.SUDAH_SELESAI);

        System.out.println("\n[i] Status keluhan berhasil diperbarui menjadi SUDAH_SELESAI.\n");
    }

    // public ArrayList<Keluhan> lihatDaftarKeluhan() {
    // return daftarKeluhan;
    // }
}
