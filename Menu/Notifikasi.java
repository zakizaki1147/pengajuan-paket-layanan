/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Menu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Date;
import TugasBesar.User.User;
/**
 *
 * @author hirzi
 */
public class Notifikasi {
    private int id;
    private String tipe;
    private String pesan;
    private Date tanggal;
    private boolean telahDibaca;
    private User penerima;

    public Notifikasi(int id, String tipe, String pesan, User penerima) {
        this.id = id;
        this.tipe = tipe;
        this.pesan = pesan;
        this.penerima = penerima;
        this.telahDibaca = false;
    }
    
    
    public void kirim(){
        System.out.println("Notifikasi dikirim");
        System.out.println("Tipe: " + tipe);
        System.out.println("Pesan: " + pesan);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Penerima: " + penerima);
    
    }
    
    public void tandaiDibaca(){
        this.telahDibaca = true;
        System.out.println("Notifikasi telah dibaca. ");
    
    }
    
}
