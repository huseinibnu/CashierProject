/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashierproject;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Makanan extends Barang{
    public LocalDate kadaluarsa;
    
    static ArrayList<Makanan> daftarBarang;
    public static void loadBarangFromDB(){
        daftarBarang = new ArrayList<Makanan>();
        Makanan barang;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            
            String sql = "SELECT * FROM barangc";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                barang = new Makanan();
                barang.kode = Integer.toString(rs.getInt("kode"));
                barang.nama = rs.getString("nama");
                barang.harga = rs.getFloat("harga");
                Date temp = rs.getDate("kadaluarsa");
                // Konversi java.sql.Date menjadi java.time.LocalDate
                barang.kadaluarsa = temp.toLocalDate();
//                barang.kadaluarsa = (LocalDate) rs.getDate("kadaluarsa");
                
                daftarBarang.add(barang);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
