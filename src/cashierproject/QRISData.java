/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashierproject;

import com.google.gson.Gson;

/**
 *
 * @author ASUS
 */
public class QRISData {
    private String qris_content;
    private String qris_request_date;
    private String qris_invoiceid;
    private String qris_nmid;

    // Buatlah konstruktor, getter, dan setter jika diperlukan
    // ...qrisData.
    
    public void setQris_content(String qris_content){
        this.qris_content = qris_content;
    }
    
    public String getQris_content(){
        return qris_content;
    }
    
    public void setQris_request_date(String qris_request_date){
        this.qris_request_date = qris_request_date;
    }
    
    public String getQris_request_date(){
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
