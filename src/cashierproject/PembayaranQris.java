/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashierproject;

import com.google.gson.Gson;
import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class PembayaranQris implements Pembayaran {
    private float totalHarga;
    private LocalDateTime waktuPembayaran;
    private String IDPembayaran;
    private String detail;
    private String qris_content, qris_invoiceid, qris_nmid;
    private LocalDateTime qris_request_date;

    @Override
    public float getTotalHarga() {
        return totalHarga; // Implementasi sesuai kebutuhan
    }

    @Override
    public void setTotalHarga(float totalHarga) {
        this.totalHarga = totalHarga;
    }

    @Override
    public LocalDateTime getWaktuPembayaran() {
        return waktuPembayaran;
    }

    @Override
    public void setWaktuPembayaran(LocalDateTime waktuPembayaran) {
        this.waktuPembayaran = waktuPembayaran;
    }

    @Override
    public String getIDPembayaran() {
        return IDPembayaran;
    }

    @Override
    public void setIDPembayaran(String IDPembayaran) {
        this.IDPembayaran = IDPembayaran;
    }
    
    @Override
    public String getDetail(){
        return this.detail;
    }
    
    @Override
    public void setDetail(String detail){
        this.detail = detail;
    }

    public void setQris_content(String qris_content){
        this.qris_content = qris_content;
    }
    
    public String getQris_content(){
        return qris_content;
    }
    
    public void setQris_request_date(LocalDateTime qris_request_date){
        this.qris_request_date = qris_request_date;
    }
    
    public LocalDateTime getQris_request_date(){
        return qris_request_date;
    }
    
    public void setQris_invoiceid(String qris_invoiceid){
        this.qris_invoiceid = qris_invoiceid;
    }
    
    public String getQris_invoiceid(){
        return qris_invoiceid;
    }
    
    public void setQris_nmid(String qris_nmid){
        this.qris_nmid = qris_nmid;
    }
    
    public String getQris_nmid(){
        return qris_nmid;
    }
    
    // Contoh implementasi toString() untuk memudahkan penggunaan Gson
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
