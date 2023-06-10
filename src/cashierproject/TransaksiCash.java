/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashierproject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import static cashierproject.DBConnector.connection;


/**
 *
 * @author ASUS
 */
public class TransaksiCash {
    private LocalDateTime waktu_pembayaran;
    private String id_pembayaran, detail, metode_pembayaran;
    private String total, bayar, kembalian;
    private String bank, nomor_akun;

    public TransaksiCash(String id_pembayaran, String detail, String metode_pembayaran, String total, String bayar, String kembalian) {
        this.waktu_pembayaran = LocalDateTime.now();
        this.id_pembayaran = id_pembayaran;
        this.detail = detail;
        this.metode_pembayaran = metode_pembayaran;
        this.total = total;
        this.bayar = bayar;
        this.kembalian = kembalian;
        
        insertDataTransaksi();
        
    }
    
    
    
    public void insertDataTransaksi(){
        try{
            
            String sql = "INSERT INTO transaksicash (waktu_pembayaran, id_pembayaran, detail, metode_pembayaran, total, bayar, kembalian) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, waktu_pembayaran);
            statement.setString(2, id_pembayaran);
            statement.setString(3, detail);
            statement.setString(4, metode_pembayaran);
            statement.setString(5,total);
            statement.setString(6, bayar);
            statement.setString(7, kembalian);
            
            int rowInserted = statement.executeUpdate();
            if(rowInserted > 0){
                System.out.println("succesfully adding new transaction");
            }
            
            statement.close();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}

