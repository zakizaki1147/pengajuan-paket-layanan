/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import TugasBesar.Enums.StatusPembayaran;
import TugasBesar.Menu.AuthenticationService;
import TugasBesar.Menu.Keluhan;
import TugasBesar.Menu.PaketLayanan;
import TugasBesar.Menu.Pemasangan;
import TugasBesar.Menu.Pembayaran;
import TugasBesar.Menu.Pengajuan;
import TugasBesar.Menu.Tagihan;
import TugasBesar.User.*;

/**
 *
 * @author Gunawan Zaki
 */

public class Main {
    public static ArrayList<User> inisialisasiData() {
        ArrayList<User> daftarUser = new ArrayList<>();
        daftarUser.add(new Customer(1, "Customer Tes", "customerTes", "123"));
        daftarUser.add(new CustomerService(2, "Customer Service Tes", "csTes", "1234"));
        daftarUser.add(new Teknisi(3, "Teknisi Tes", "teknisiTes", "12345"));
        daftarUser.add(new Superadmin(4, "Superadmin Tes", "superadminTes", "123456"));
        return daftarUser;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<User> daftarUser = inisialisasiData();
        AuthenticationService auth = new AuthenticationService(daftarUser);
        boolean sistemAktif = true;
        while (sistemAktif) {
            System.out.println("[i] Selamat datang di Smy.iD!");
            System.out.println("\n[i] Pilih menu: \n 1. Masuk\n 2. Daftar Akun\n 0. Keluar dari Sistem");
            try {
                System.out.print("\n[^] Masukkan pilihan Anda\n--> ");
                int pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("\n[^] Masukkan username akun Anda\n--> ");
                        String username = input.nextLine();
                        System.out.print("[^] Masukkan password akun Anda\n--> ");
                        String password = input.nextLine();
                        // String role = auth.login(daftarUser, username, password);
                        User userAktif = auth.login(daftarUser, username, password);

                        if (userAktif == null) {
                            System.out.println("\n[!] Username atau password salah! Tolong isi dengan benar.\n");
                            break;
                        }

                        System.out.println("\n[i] Login berhasil sebagai " + userAktif.getRole() + "!\n");
                        if (userAktif instanceof Customer) {
                            tampilkanMenuCustomer(input, auth, (Customer) userAktif);
                        } else if (userAktif instanceof CustomerService) {
                            tampilkanMenuCustomerService(input, auth, (CustomerService) userAktif, daftarUser);
                        } else if (userAktif instanceof Teknisi) {
                            tampilkanMenuTeknisi(input, auth, (Teknisi) userAktif, daftarUser);
                        } else if (userAktif instanceof Superadmin) {
                            tampilkanMenuSuperadmin(input, auth, (Superadmin) userAktif, daftarUser);
                        }
                        break;
                    case 2:
                        System.out.println("\n[i] Pembuatan akun baru. Tolong isi semua kolom yang dibutuhkan.\n");
                        // input.nextLine();
                        System.out.print("[^] Masukkan nama lengkap Anda\n--> ");
                        String namaLengkapBaru = input.nextLine();
                        System.out.print("[^] Masukkan username akun Anda\n--> ");
                        String usernameBaru = input.nextLine();
                        System.out.print("[^] Masukkan password akun Anda\n--> ");
                        String passwordBaru = input.nextLine();

                        boolean prosesDaftarAkun = auth.register(namaLengkapBaru, usernameBaru, passwordBaru);

                        if (prosesDaftarAkun) {
                            System.out.println(
                                    "\n[o] Akun berhasil dibuat! Silahkan coba masuk menggunakan akun baru Anda.\n");
                        } else {
                            System.out.println("\n[!] Username sudah digunakan! Silahkan coba lagi.\n");
                        }

                        break;
                    case 0:
                        System.out.println("\n[i] Keluar dari sistem. Sampai bertemu kembali~");
                        sistemAktif = false;
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Mohon masukkan angka sesuai opsi menu yang tersedia!\n");
                input.nextLine();
            }
        }
    }

    public static void tampilkanMenuCustomer(Scanner input, AuthenticationService auth, Customer customerAktif) {
        boolean penggunaAktif = true;
        while (penggunaAktif) {
            System.out.println(
                    "[i] Pilih menu:\n 1. Buat Pengajuan\n 2. Lihat Daftar Pengajuan\n 3. Bayar Tagihan\n 4. Lihat Daftar Tagihan\n 5. Buat Keluhan\n 6. Lihat Daftar Keluhan\n 0. Keluar");

            try {
                System.out.print("\n[^] Masukkan pilihan Anda\n--> ");
                int pilihanC = input.nextInt();
                input.nextLine();
                switch (pilihanC) {
                    case 1:
                        // method buat pengajuan
                        System.out.println("\n[i] Pilih paket:");

                        for (PaketLayanan p : PaketLayanan.getDaftarPaket()) {
                            System.out.println(" " + p.getId() + ". " + p.getNama());
                        }

                        try {
                            System.out.print("[^] Masukkan ID paket\n--> ");
                            int idPaket = input.nextInt();
                            input.nextLine();

                            if (idPaket < 1 || idPaket > PaketLayanan.getDaftarPaket().size()) {
                                System.out.println("\n[!] ID paket tidak valid.\n");
                                continue;
                            }

                            PaketLayanan paketDipilih = PaketLayanan.getDaftarPaket().get(idPaket - 1);
                            Pengajuan pengajuanBaru = customerAktif.buatPengajuan(paketDipilih);
                            System.out.println(
                                    "\n[O] Pengajuan berhasil dibuat!"
                                            + "\nID Pengajuan: " + pengajuanBaru.getId()
                                            + "\nPaket: " + pengajuanBaru.getPaket().getNama()
                                            + "\nStatus: " + pengajuanBaru.getStatus());
                            System.out.println();

                        } catch (InputMismatchException e) {
                            System.out.println("\n[!] Mohon masukkan angka sesuai opsi paket yang tersedia!\n");
                            input.nextLine();
                        }
                        break;
                    case 2:
                        // method lihat daftar pengajuan
                        tampilkanDaftarPengajuan(customerAktif);
                        break;
                    case 3:
                        // method bayar tagihan
                        bayarTagihan(input, customerAktif);
                        break;
                    case 4:
                        // method lihat daftar tagihan
                        tampilkanDaftarTagihan(customerAktif);
                        break;
                    case 5:
                        // method buat keluhan
                        System.out.print("[^] Masukkan keluhan Anda\n--> ");
                        input.nextLine();
                        String isi = input.nextLine();

                        Keluhan keluhanBaru = customerAktif.buatKeluhan(isi);

                        System.out.println("\n[O] Keluhan berhasil dibuat!");
                        System.out.println("ID Keluhan: " + keluhanBaru.getId());
                        System.out.println("Status: " + keluhanBaru.getStatus());
                        System.out.println();
                        break;
                    case 6:
                        // method lihat daftar keluhan
                        tampilkanDaftarKeluhan(customerAktif);
                        break;
                    case 0:
                        auth.logout();
                        penggunaAktif = false;
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Mohon masukkan angka sesuai opsi menu yang tersedia!\n");
                input.nextLine();
            }
        }
    }

    public static void tampilkanMenuCustomerService(Scanner input, AuthenticationService auth,
            CustomerService csAktif, ArrayList<User> daftarUser) {
        boolean penggunaAktif = true;
        while (penggunaAktif) {
            Customer customer = getCustomer(daftarUser);
            System.out
                    .println(
                            "[i] Pilih menu:\n 1. Lihat Daftar Pengajuan\n 2. Perbarui Status Pengajuan\n 3. Lihat Daftar Keluhan\n 4. Perbarui Status Keluhan\n 5. Lihat Daftar Pemasangan\n 0. Keluar");

            try {
                System.out.print("\n[^] Masukkan pilihan Anda\n--> ");
                int pilihanCS = input.nextInt();
                input.nextLine();
                switch (pilihanCS) {
                    case 1:
                        // method lihat daftar pengajuan
                        tampilkanDaftarPengajuan(customer);
                        break;
                    case 2:
                        // method perbarui status pengajuan
                        perbaruiStatusPengajuan(input, csAktif, customer);
                        break;
                    case 3:
                        // method lihat daftar keluhan
                        tampilkanDaftarKeluhan(customer);
                        break;
                    case 4:
                        // method perbarui status keluhan
                        perbaruiStatusKeluhan(input, csAktif, customer);
                        break;
                    case 5:
                        // method lihat daftar pemasangan
                        tampilkanDaftarPemasangan(customer);
                        break;
                    case 0:
                        auth.logout();
                        penggunaAktif = false;
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Mohon masukkan angka sesuai opsi menu yang tersedia!\n");
                input.nextLine();
            }
        }
    }

    public static void tampilkanMenuTeknisi(Scanner input, AuthenticationService auth, Teknisi teknisiAktif,
            ArrayList<User> daftarUser) {
        boolean penggunaAktif = true;
        while (penggunaAktif) {
            Customer customer = getCustomer(daftarUser);
            System.out
                    .println(
                            "[i] Pilih menu:\n 1. Lihat Daftar Pemasangan\n 2. Perbarui Status Pemasangan\n 0. Keluar");

            try {
                System.out.print("\n[^] Masukkan pilihan Anda\n--> ");
                int pilihanT = input.nextInt();
                input.nextLine();
                switch (pilihanT) {
                    case 1:
                        // method lihat daftar pemasangan
                        tampilkanDaftarPemasangan(customer);
                        break;
                    case 2:
                        // method perbarui status pemasangan
                        perbaruiStatusPemasangan(input, teknisiAktif, customer);
                        break;
                    case 0:
                        auth.logout();
                        penggunaAktif = false;
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Mohon masukkan angka sesuai opsi menu yang tersedia!\n");
                input.nextLine();
            }
        }
    }

    public static void tampilkanMenuSuperadmin(Scanner input, AuthenticationService auth, Superadmin superadminAktif,
            ArrayList<User> daftarUser) {
        boolean penggunaAktif = true;
        while (penggunaAktif) {
            System.out.println(
                    "[i] Pilih menu:\n 1. Lihat Daftar User\n 2. Perbarui Role User\n 3. Hapus User\n 4. Lihat Daftar Paket Layanan\n 5. Buat Paket Layanan Baru\n 6. Perbarui Paket Layanan\n 7. Hapus Paket Layanan\n 8. Lihat Laporan Pendapatan\n 0. Keluar");

            try {
                System.out.print("\n[^] Masukkan pilihan Anda\n--> ");
                int pilihanS = input.nextInt();
                input.nextLine();
                switch (pilihanS) {
                    case 1:
                        // method lihat daftar user
                        break;
                    case 2:
                        // method update role user
                        break;
                    case 3:
                        // method hapus user
                        break;
                    case 4:
                        // method lihat daftar paket layanan
                        break;
                    case 5:
                        // method buat paket layanan
                        break;
                    case 6:
                        // method perbarui paket layanan
                        break;
                    case 7:
                        // method hapus paket layanan
                        break;
                    case 8:
                        // method lihat laporan pendapatan
                        break;
                    case 0:
                        auth.logout();
                        penggunaAktif = false;
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Mohon masukkan angka sesuai opsi menu yang tersedia!\n");
                input.nextLine();
            }
        }
    }

    public static void tampilkanDaftarPengajuan(Customer customer) {
        ArrayList<Pengajuan> daftarPengajuan = customer.getDaftarPengajuan();

        if (daftarPengajuan == null || daftarPengajuan.isEmpty()) {
            System.out.println("\n[!] Belum ada pengajuan yang dibuat.\n");
            return;
        }

        System.out.println("\n==============================================================");
        System.out.printf("%-5s %-25s %-20s\n",
                "ID", "Paket", "Status");
        System.out.println("==============================================================");

        for (Pengajuan p : daftarPengajuan) {
            String namaPaket = (p.getPaket() != null)
                    ? p.getPaket().getNama()
                    : "-";

            System.out.printf("%-5d %-25s %-20s\n",
                    p.getId(),
                    namaPaket,
                    p.getStatus());
        }

        System.out.println("==============================================================\n");
    }

    public static void tampilkanDaftarPemasangan(Customer customer) {
        ArrayList<Pemasangan> daftarPemasangan = customer.getDaftarPemasangan();

        if (daftarPemasangan == null || daftarPemasangan.isEmpty()) {
            System.out.println("\n[!] Belum ada data pemasangan.\n");
            return;
        }

        System.out.println("\n====================================================================================");
        System.out.printf("%-5s %-15s %-20s %-25s%n",
                "ID",
                "ID Pengajuan",
                "Paket",
                "Status");
        System.out.println("====================================================================================");

        for (Pemasangan pemasangan : daftarPemasangan) {

            Pengajuan pengajuan = pemasangan.getPengajuan();

            System.out.printf("%-5d %-15d %-20s %-25s%n",
                    pemasangan.getId(),
                    pengajuan.getId(),
                    pengajuan.getPaket().getNama(),
                    pemasangan.getStatus());
        }

        System.out.println("====================================================================================\n");
    }

    public static void bayarTagihan(Scanner input, Customer customer) {
        if (customer.getDaftarTagihan().isEmpty()) {
            System.out.println("\n[!] Belum ada tagihan yang harus dibayar.\n");
            return;
        }

        tampilkanDaftarTagihan(customer);

        try {
            System.out.print("[^] Masukkan ID tagihan yang ingin dibayar\n--> ");
            int idTagihan = input.nextInt();
            input.nextLine();

            Tagihan tagihan = customer.cariTagihanById(idTagihan);

            if (tagihan == null) {
                System.out.println("\n[!] Tagihan tidak ditemukan.\n");
                return;
            }

            if (tagihan.getStatus() == StatusPembayaran.SUDAH_LUNAS) {
                System.out.println("\n[!] Tagihan ini sudah dibayar.\n");
                return;
            }

            System.out.println("\n[i] Pilih metode pembayaran:");
            System.out.println(" 1. Transfer Bank");
            System.out.println(" 2. QRIS");
            System.out.println(" 3. E-Wallet");

            try {
                System.out.print("\n[^] Masukkan metode pembayaran Anda\n--> ");
                int pilihan = input.nextInt();
                input.nextLine();

                String metode;

                switch (pilihan) {
                    case 1:
                        metode = "Transfer Bank";
                        break;
                    case 2:
                        metode = "QRIS";
                        break;
                    case 3:
                        metode = "E-Wallet";
                        break;
                    default:
                        System.out.println("\n[!] Metode pembayaran tidak valid.\n");
                        return;
                }

                Pembayaran pembayaran = new Pembayaran(
                        tagihan.getTotal(),
                        metode,
                        tagihan);

                if (pembayaran.prosesPembayaran()) {
                    tagihan.bayarTagihan(pembayaran);

                    System.out.println("\n[O] Pembayaran berhasil!");
                    System.out.println("[i] Tagihan #" + tagihan.getId()
                            + " telah berubah menjadi "
                            + tagihan.getStatus() + ".\n");
                } else {
                    System.out.println("\n[!] Pembayaran gagal.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Mohon masukkan angka sesuai opsi metode pembayaran yang tersedia!\n");
                input.nextLine();
            }
        } catch (InputMismatchException e) {
            System.out.println("\n[!] Mohon masukkan angka sesuai opsi ID tagihan yang tersedia!\n");
            input.nextLine();
        }
    }

    public static void tampilkanDaftarTagihan(Customer customer) {
        ArrayList<Tagihan> daftarTagihan = customer.getDaftarTagihan();

        if (daftarTagihan == null || daftarTagihan.isEmpty()) {
            System.out.println("\n[!] Belum ada tagihan yang tersedia.\n");
            return;
        }

        System.out.println("\n==========================================================================");
        System.out.printf("%-5s %-15s %-20s%n",
                "ID", "Total Tagihan", "Status");
        System.out.println("==========================================================================");

        for (Tagihan tagihan : daftarTagihan) {
            System.out.printf("%-5d Rp %-12.0f %-20s%n",
                    tagihan.getId(),
                    tagihan.getTotal(),
                    tagihan.getStatus());
        }

        System.out.println("==========================================================================\n");
    }

    public static void tampilkanDaftarKeluhan(Customer customer) {
        ArrayList<Keluhan> daftarKeluhan = customer.getDaftarKeluhan();

        if (daftarKeluhan == null || daftarKeluhan.isEmpty()) {
            System.out.println("\n[!] Belum ada keluhan.\n");
            return;
        }

        System.out.println("\n==============================================================");
        System.out.printf("%-5s %-25s %-20s\n", "ID", "Keluhan", "Status");
        System.out.println("==============================================================");

        for (Keluhan k : daftarKeluhan) {
            String isi = k.getIsiKeluhan();
            String status = String.valueOf(k.getStatus());

            System.out.printf("%-5d %-25s %-20s\n",
                    k.getId(),
                    isi,
                    status);
        }

        System.out.println("==============================================================\n");
    }

    public static void perbaruiStatusPengajuan(Scanner input, CustomerService cs, Customer customer) {
        if (customer.getDaftarPengajuan().isEmpty()) {
            System.out.println("\n[!] Belum ada data pengajuan.\n");
            return;
        }

        tampilkanDaftarPengajuan(customer);

        try {
            System.out.print("\n[^] Masukkan ID pengajuan\n--> ");
            int idPengajuan = input.nextInt();
            input.nextLine();

            Pengajuan pengajuan = customer.cariPengajuanById(idPengajuan);

            if (pengajuan == null) {
                System.out.println("\n[!] Pengajuan tidak ditemukan.\n");
                return;
            }

            cs.perbaruiStatusPengajuan(customer, pengajuan);
        } catch (InputMismatchException e) {
            System.out.println("\n[!] Mohon masukkan angka sesuai opsi ID pengajuan yang tersedia!\n");
            input.nextLine();
        }
    }

    public static void perbaruiStatusPemasangan(Scanner input, Teknisi teknisi, Customer customer) {
        if (customer.getDaftarPemasangan().isEmpty()) {
            System.out.println("\n[!] Belum ada data pengajuan.\n");
            return;
        }

        tampilkanDaftarPemasangan(customer);

        try {
            System.out.print("\n[^] Masukkan ID pemasangan yang akan diperbarui\n-->");
            int idPemasangan = input.nextInt();
            input.nextLine();

            Pemasangan pemasangan = customer.cariPemasanganById(idPemasangan);

            if (pemasangan == null) {
                System.out.println("\n[!] ID pemasangan tidak ditemukan.\n");
                return;
            }

            teknisi.perbaruiStatusPemasangan(customer, pemasangan);
        } catch (InputMismatchException e) {
            System.out.println("\n[!] Mohon masukkan angka sesuai opsi ID pemasangan yang tersedia!\n");
            input.nextLine();
        }
    }

    public static void perbaruiStatusKeluhan(Scanner input, CustomerService csAktif, Customer customer) {
        if (customer.getDaftarKeluhan().isEmpty()) {
            System.out.println("\n[!] Belum ada data keluhan.\n");
            return;
        }

        tampilkanDaftarKeluhan(customer);

        try {
            System.out.print("[^] Masukkan ID keluhan : ");
            int idKeluhan = input.nextInt();
            input.nextLine();

            Keluhan keluhan = customer.cariKeluhanById(idKeluhan);

            if (keluhan == null) {
                System.out.println("\n[!] ID keluhan tidak ditemukan.\n");
                return;
            }

            csAktif.perbaruiStatusKeluhan(keluhan);
        } catch (InputMismatchException e) {
            System.out.println("\n[!] Mohon masukkan angka sesuai opsi ID keluhan yang tersedia!\n");
            input.nextLine();
        }
    }

    public static Customer getCustomer(ArrayList<User> daftarUser) {
        for (User user : daftarUser) {
            if (user instanceof Customer) {
                return (Customer) user;
            }
        }

        return null;
    }
}
