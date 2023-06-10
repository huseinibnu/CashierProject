/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashierproject;

import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class PembayaranCash implements Pembayaran{
    private float totalHarga;
    private LocalDateTime waktuPembayaran;
    private String IDPembayaran;
    private String detail;

    @Override
    public float getTotalHarga() {
        return totalHarga;
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
    
}
