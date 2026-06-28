/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TugasBesar.Menu;

import java.util.ArrayList;
import TugasBesar.User.User;

/**
 *
 * @author hirzi
 */
public interface Autentikasi {
    User login(ArrayList<User> daftarUser, String username, String password);

    boolean register(String namaLengkap, String username, String password);

    void logout();
}
