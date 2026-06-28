package TugasBesar.User;

import TugasBesar.Enums.StatusKeluhan;
import TugasBesar.Enums.StatusPembayaran;
import TugasBesar.Enums.StatusPengajuan;
import TugasBesar.Menu.*;
import java.util.*;

/**
 *
 * @author hapis
 */
public class Customer extends User {
    private ArrayList<Pengajuan> daftarPengajuan = new ArrayList<>();
    private ArrayList<Pemasangan> daftarPemasangan = new ArrayList<>();
    private ArrayList<Tagihan> daftarTagihan = new ArrayList<>();
    private ArrayList<Keluhan> daftarKeluhan = new ArrayList<>();

    public Customer(int id, String nama, String username, String password) {
        super(id, nama, username, password, "Customer");
    }

    public ArrayList<Pengajuan> getDaftarPengajuan() {
        return daftarPengajuan;
    }

    public Pengajuan buatPengajuan(PaketLayanan paket) {
        Pengajuan pengajuan = new Pengajuan(paket);
        daftarPengajuan.add(pengajuan);
        return pengajuan;
    }

    public Pengajuan cariPengajuanById(int id) {
        for (Pengajuan p : daftarPengajuan) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Tagihan> getDaftarTagihan() {
        return daftarTagihan;
    }

    public void tambahTagihan(Tagihan tagihan) {
        daftarTagihan.add(tagihan);
    }

    public Tagihan cariTagihanById(int id) {
        for (Tagihan t : daftarTagihan) {
            if (t.getId() == id) {
                return t;
            }
        }

        return null;
    }

    public ArrayList<Pemasangan> getDaftarPemasangan() {
        return daftarPemasangan;
    }

    public void tambahPemasangan(Pemasangan pemasangan) {
        daftarPemasangan.add(pemasangan);
    }

    public Pemasangan cariPemasanganById(int id) {
        for (Pemasangan p : daftarPemasangan) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public ArrayList<Keluhan> getDaftarKeluhan() {
        return daftarKeluhan;
    }

    // public Pembayaran bayarTagihan(PaketLayanan paketLayanan, Tagihan tagihan,
    // String metode) {
    // Pembayaran pembayaran = new Pembayaran(paketLayanan.getHarga(), "QRIS",
    // StatusPembayaran.BELUM_LUNAS, tagihan);
    // daftarTagihan.remove(tagihan);
    // return pembayaran;
    // }

    // public Keluhan buatKeluhan(String keluhan) {
    // Keluhan k = new Keluhan(keluhan, StatusKeluhan.BELUM_DITINDAK);
    // daftarKeluhan.add(k);
    // return k;
    // }
    public Keluhan buatKeluhan(String keluhan) {
        Keluhan k = new Keluhan(keluhan);
        daftarKeluhan.add(k);
        return k;
    }

    public Keluhan cariKeluhanById(int id) {
        for (Keluhan k : daftarKeluhan) {
            if (k.getId() == id) {
                return k;
            }
        }

        return null;
    }
}