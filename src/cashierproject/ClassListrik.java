/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashierproject;

import java.util.Random;

/**
 *
 * @author ASUS
 */
public class ClassListrik extends Barang{
    private String noMeteran;
    private float nominal;
    private String token;

    public ClassListrik(String kode, String nama, float harga, String noMeteran, float nominal) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.noMeteran = noMeteran;
        this.nominal = nominal;
        this.token = generateToken();
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

    public String getNoMeteran() {
        return noMeteran;
    }

    public float getNominal() {
        return nominal;
    }

    public String getToken() {
        return token;
    }

    private String generateToken() {
        // Implementasi algoritma pembangunan token PLN sesuai standar token PLN
        int length = 20; // Panjang urutan acak yang diinginkan
        String characters = "1234567890"; // Karakter yang digunakan
        
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        
        // Membuat urutan acak sebanyak panjang yang diinginkan
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        
        String token = sb.toString();
        
        return token;
    }
}
