/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashierproject;

/**
 *
 * @author ASUS
 */
public class ClassPulsa extends Barang{
    private String operator;
    private String noTelp;
    private float nominal;

    public ClassPulsa(String kode, String nama, float harga, String operator, String noTelp, float nominal) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.operator = operator;
        this.noTelp = noTelp;
        this.nominal = nominal;
    }
    
    public String getKode() {
        return kode;
    }
    
    public String getNama() {
        return nama;
    }
    
    public float getHarga() {
        return harga;
    }

    public String getOperator() {
        return operator;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public float getNominal() {
        return nominal;
    }
}
