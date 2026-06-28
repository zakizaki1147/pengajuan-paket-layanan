// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package TugasBesar.Menu;

// import java.util.*;

// /**
//  *
//  * @author Fasha Azhi Putra
//  */
// public class LaporanPendapatan {

//     private int id;
//     private String periode;
//     private double totalPendapatan;
//     private Date tanggalDibuat;
//     // private ArrayList<Tagihan> daftarBilling;

//     public LaporanPendapatan(int id, String periode, double totalPendapatan, Date tanggalDibuat,
//             ArrayList<Tagihan> daftarBilling) {
//         this.id = id;
//         this.periode = periode;
//         this.totalPendapatan = totalPendapatan;
//         this.tanggalDibuat = tanggalDibuat;
//         // this.daftarBilling = daftarBilling;
//     }

//     public void infoDaftarBilling() {
//         System.out.println("=== Daftar Billing ===");
//         // for (Tagihan p : daftarBilling) {
//             System.out.println(p);
//         }
//     }

//     public void generate() {
//         totalPendapatan = 0;
//         for (Tagihan t : daftarBilling) {
//             totalPendapatan += t.getTotal();
//         }
//         tanggalDibuat = new Date();
//         System.out.println("Laporan berhasil digenerate");
//     }

//     public void exportPDF() {

//     }

//     public String getPeriode() {
//         return periode;
//     }

//     @Override
//     public String toString() {
//         return "Id           : " + id + "\n"
//                 + "Periode      : " + periode + "\n"
//                 + "Total        : Rp " + String.format("%,.0f", totalPendapatan) + "\n"
//                 + "Tanggal      : " + tanggalDibuat + "\n";
//     }
// }
