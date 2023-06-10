/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cashierproject;

import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public interface Pembayaran {
    float getTotalHarga();
    void setTotalHarga(float totalHarga);
    LocalDateTime getWaktuPembayaran();
    void setWaktuPembayaran(LocalDateTime waktuPembayaran);
    String getIDPembayaran();
    void setIDPembayaran(String IDPembayaran);
    String getDetail();
    void setDetail(String detail);
}
