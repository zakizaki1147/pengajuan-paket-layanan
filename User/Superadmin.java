
package TugasBesar.User;

import TugasBesar.Menu.*;
import java.util.*;

/**
 *
 * @author hapis
 */
public class Superadmin extends User {
    private ArrayList<User> daftarUser = new ArrayList<>();
    private ArrayList<PaketLayanan> daftarPaket = new ArrayList<>();

    public Superadmin(int id, String nama, String username, String password) {
        super(id, nama, username, password, "Superadmin");
    }

    public ArrayList<User> lihatDaftarUser() {
        return daftarUser;
    }

    public ArrayList<PaketLayanan> lihatDaftarPaket() {
        return daftarPaket;
    }

    public int lihatLaporanPendapatan() {
        int totalPendapatan = 0;
        for (PaketLayanan paket : daftarPaket) {
            totalPendapatan += paket.hitungHargaTotal();
        }
        return totalPendapatan;
    }

    public void hapusUser(User user) {
        daftarUser.remove(user);
    }

    public void updateUser(User user, String namaBaru, String usernameBaru, String passwordBaru) {
        user.setnamaLengkap(namaBaru);
        user.setUsername(usernameBaru);
        user.setPassword(passwordBaru);
    }

    public void tambahPaket(PaketLayanan paket, String namaBaru, int hargaBaru) {
        paket.setNama(namaBaru);
        paket.setHarga(hargaBaru);  
        daftarPaket.add(paket);
    }

    public void updatePaket(PaketLayanan paket, String namaBaru, int hargaBaru) {
        paket.setNama(namaBaru);
        paket.setHarga(hargaBaru);
    }

    public void hapusPaket(PaketLayanan paket) {
        daftarPaket.remove(paket);
    }

}
