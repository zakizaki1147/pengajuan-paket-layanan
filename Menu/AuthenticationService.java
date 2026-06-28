/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBesar.Menu;

import java.util.ArrayList;
import TugasBesar.User.*;

/**
 *
 * @author hirzi
 */

public class AuthenticationService implements Autentikasi {
    private int currentId;
    private ArrayList<User> daftarUser;

    public AuthenticationService(ArrayList<User> daftarUser) {
        this.daftarUser = daftarUser;
        initializeId();
    }

    private void initializeId() {
        int maxId = 0;

        for (User user : daftarUser) {
            if (user.getId() > maxId) {
                maxId = user.getId();
            }
        }

        currentId = maxId + 1;
    }

    private int generateId() {
        return currentId++;
    }

    public User login(ArrayList<User> daftarUser, String username, String password) {
        for (User user : daftarUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean register(String namaLengkap, String username, String password) {
        if (namaLengkap == null || username == null || password == null) {
            throw new IllegalArgumentException("[!] Mohon isi seluruh kolom yang dibutuhkan!");
        }

        if (namaLengkap.isBlank() || username.isBlank() || password.isBlank()) {
            return false;
        }

        for (User user : daftarUser) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }

        daftarUser.add(new Customer(generateId(), namaLengkap, username, password));
        return true;
    }

    public void logout() {
        System.out.println("\n[i] Mengeluarkan akun... Sampai bertemu kembali~\n");
    }
}
