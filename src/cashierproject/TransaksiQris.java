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
public class TransaksiQris {
    private LocalDateTime waktu_pembayaran, qris_request_time;
    private String id_pembayaran, detail, metode_pembayaran;
    private String total, qris_content, qris_invoiceid, qris_nmid;
    
    public TransaksiQris(String id_pembayaran, String detail, String metode_pembayaran, String total, String qris_invoiceid, String qris_nmid, LocalDateTime qris_request_time) {
        this.waktu_pembayaran = LocalDateTime.now();
        this.id_pembayaran = id_pembayaran;
        this.detail = detail;
        this.metode_pembayaran = metode_pembayaran;
        this.total = total;
        this.qris_content = qris_content;
        this.qris_invoiceid = qris_invoiceid;
        this.qris_nmid = qris_nmid;
        this.qris_request_time = qris_request_time;
        
        insertDataTransaksi();
        
    }
    
    public void insertDataTransaksi(){
        try{
            
            String sql = "INSERT INTO transaksiqris (waktu_pembayaran, id_pembayaran, detail, metode_pembayaran, total, qris_invoiceid, qris_nmid, qris_request_time) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, waktu_pembayaran);
            statement.setString(2, id_pembayaran);
            statement.setString(3, detail);
            statement.setString(4, metode_pembayaran);
            statement.setString(5,total);
            statement.setString(6, qris_invoiceid);
            statement.setString(7, qris_nmid);
            statement.setObject(8, qris_request_time);
            
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
