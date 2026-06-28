package TugasBesar.User;

import TugasBesar.Enums.StatusPemasangan;
import TugasBesar.Menu.*;
import java.util.*;

/**
 *
 * @author hapis
 */
public class Teknisi extends User {
    // private ArrayList<Pengajuan> daftarTugas = new ArrayList<>();
    // private ArrayList<Pemasangan> daftarPemasangan = new ArrayList<>();

    public Teknisi(int id, String nama, String username, String password) {
        super(id, nama, username, password, "Teknisi");
    }

    // public ArrayList<Pemasangan> getDaftarPemasangan() {
    // return daftarPemasangan;
    // }

    public void perbaruiStatusPemasangan(Customer customer, Pemasangan pemasangan) {
        // if (daftarPemasangan.contains(pemasangan.getPengajuan())) {
        // pemasangan.perbaruiStatus(StatusPemasangan.SUDAH_SELESAI);
        // System.out.println("Status pemasangan untuk " + pemasangan.getId() + " telah
        // diperbarui menjadi: "
        // + StatusPemasangan.SUDAH_SELESAI);
        // } else {
        // System.out.println("Pengajuan tidak ditemukan dalam daftar tugas.");
        // }

        if (pemasangan == null) {
            System.out.println("\n[!] Data pemasangan tidak ditemukan.");
            return;
        }

        // Cegah update dua kali
        if (pemasangan.getStatus() == StatusPemasangan.SUDAH_SELESAI) {
            System.out.println("\n[!] Pemasangan sudah selesai.");
            return;
        }

        // Update status
        pemasangan.perbaruiStatus(StatusPemasangan.SUDAH_SELESAI);

        // Membuat tagihan baru
        Tagihan tagihan = new Tagihan(customer, 0);

        // Menyimpan tagihan ke customer
        customer.tambahTagihan(tagihan);

        System.out.println("\n[i] Status pemasangan berhasil diperbarui menjadi SUDAH_SELESAI.");
        System.out.println("[i] Tagihan baru berhasil dibuat.\n");
    }
}
