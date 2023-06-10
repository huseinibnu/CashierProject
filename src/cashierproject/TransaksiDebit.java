/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashierproject;

import static cashierproject.DBConnector.connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class TransaksiDebit {
    private LocalDateTime waktu_pembayaran;
    private String id_pembayaran, detail, metode_pembayaran;
    private String total, bank, nomor_akun;
    
    public TransaksiDebit(String id_pembayaran, String detail, String metode_pembayaran, String total, String bank, String nomor_akun) {
        this.waktu_pembayaran = LocalDateTime.now();
        this.id_pembayaran = id_pembayaran;
        this.detail = detail;
        this.metode_pembayaran = metode_pembayaran;
        this.total = total;
        this.bank = bank;
        this.nomor_akun = nomor_akun;
        
        insertDataTransaksi();
        
    }
    
    public void insertDataTransaksi(){
        try{
            
            String sql = "INSERT INTO transaksidebit (waktu_pembayaran, id_pembayaran, detail, metode_pembayaran, total, bank, nomor_akun) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, waktu_pembayaran);
            statement.setString(2, id_pembayaran);
            statement.setString(3, detail);
            statement.setString(4, metode_pembayaran);
            statement.setString(5,total);
            statement.setString(6, bank);
            statement.setString(7, nomor_akun);
            
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
