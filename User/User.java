/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package TugasBesar.User;

/**
 *
 * @author hapis
 */
public abstract class User {
    private int id;
    private String namaLengkap;
    private String username;
    private String password;
    private String role;

    public User(int id, String namaLengkap, String username, String password, String role) {
        this.id = id;
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setnamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
