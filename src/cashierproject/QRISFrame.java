/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cashierproject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class QRISFrame extends javax.swing.JFrame {
    private float totalHarga;
    private LocalDateTime waktuPembayaran, request_date;
    private int flag = 0;
    private String noMeteran, token, detail, metode_pembayaran, invoice, nmid, IDPembayaran;
    /**
     * Creates new form QRISFrame
     */
    
    
    public QRISFrame() {
        initComponents();
        
        PembayaranQris qrisData = new PembayaranQris();
        qrisData.setQris_content("https://qris.id/api-doc/create-invoice.php");
        qrisData.setQris_request_date(LocalDateTime.now());
        
        // Implementasi algoritma pembangunan invoiceid
        int length = 9; // Panjang urutan acak yang diinginkan
        String characters = "1234567890"; // Karakter yang digunakan
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        // Membuat urutan acak sebanyak panjang yang diinginkan
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        invoice = sb.toString();
        
        qrisData.setQris_invoiceid(invoice);
        qrisData.setQris_nmid("ID1020021181745");
        qrisData.setTotalHarga(totalHarga);
        qrisData.setWaktuPembayaran(waktuPembayaran);
        
        request_date = qrisData.getQris_request_date();
        invoice = qrisData.getQris_invoiceid();
        nmid = qrisData.getQris_nmid();
    
        String qrisContent = "QRIS: konten (String), requestDate (LocalDateTime), invoiceID (String). " +
                "Untuk informasi lebih lanjut tentang transaksi QRIS, silahkan akses tautan berikut: " +
                "https://qris.id/api-doc/create-invoice.php";
        int width = 300;
        int height = 300;

        BufferedImage qrisImage = createQRISCode(qrisContent, width, height);
        jLabelQRCode.setIcon(new javax.swing.ImageIcon(qrisImage));
        jTextArea2.setText(qrisData.getQris_content() + "\n" + 
                           qrisData.getQris_request_date() + "\n" + 
                           qrisData.getQris_invoiceid() + "\n" + 
                           qrisData.getQris_nmid());
        
        
    }
    
    private BufferedImage createQRISCode(String content, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            BufferedImage qrisImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = (Graphics2D) qrisImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (bitMatrix.get(x, y)) {
                        graphics.fillRect(x, y, 1, 1);
                    }
                }
            }

            return qrisImage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void terimaPembayaran(Pembayaran pembayaran) {
        totalHarga = pembayaran.getTotalHarga();
        String totalHargastr = Float.toString(totalHarga);
        waktuPembayaran = pembayaran.getWaktuPembayaran();
        IDPembayaran = pembayaran.getIDPembayaran();
        detail = pembayaran.getDetail();
        metode_pembayaran = "QRIS";

        jTextField1.setText("" + totalHarga);
        // Detail transaksi
        if (flag == 1){
            jTextArea1.setText( "Waktu Pembayaran \t: " + waktuPembayaran + "\n"  + 
                                "ID Pembayaran    \t: " + IDPembayaran + "\n"  +
                                "Total          \t\t: " + totalHarga + "\n\n" +
                                "Nomor Meteran    \t: " + noMeteran + "\n"  + 
                                "Token          \t\t: " + token + "\n\n" +
                                "Detail Pembayaran\t: " + "\n" + 
                                "Metode Pembayaran\t: " + metode_pembayaran + "\n" +
                                "Request Date     \t: " + request_date + "\n" + 
                                "Invoice        \t\t: " + invoice + "\n" + 
                                "NMID           \t\t: " + nmid);
            detail = noMeteran + " | " + token;
            TransaksiQris transaksiqris = new TransaksiQris(IDPembayaran, detail, metode_pembayaran, totalHargastr, invoice, nmid, request_date);
        } else {
            jTextArea1.setText( "Waktu Pembayaran \t: " + waktuPembayaran + "\n"  + 
                                "ID Pembayaran    \t: " + IDPembayaran + "\n" +
                                "Total          \t\t: " + totalHarga + "\n\n" +
                                "Detail         \t\t: " + detail+ "\n\n" +
                                "Detail Pembayaran\t: " + "\n" + 
                                "Metode Pembayaran\t: " + metode_pembayaran + "\n" +
                                "Request Date     \t: " + request_date + "\n" + 
                                "Invoice        \t\t: " + invoice + "\n" + 
                                "NMID           \t\t: " + nmid);
            TransaksiQris transaksiqris = new TransaksiQris(IDPembayaran, detail, metode_pembayaran, totalHargastr, invoice, nmid, request_date);
        }
        System.out.println(waktuPembayaran);
        System.out.println(IDPembayaran);
    }
    
    public void terimaDetail(Detail detail) {
        noMeteran = detail.getDaftarBelanja();
        token = detail.getToken();
        flag = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelQRCode = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(290, 130));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(708, 570));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cashierproject/QRIS_logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Total Harga : ");

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabelQRCode.setText("jLabel3");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Selesai");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabelQRCode))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(jButton1)))))))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQRCode))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(131, 131, 131))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Pembayaran dengan QRIS berhasil sebanyak Rp. " + totalHarga); 
        setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QRISFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QRISFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QRISFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QRISFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QRISFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelQRCode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
