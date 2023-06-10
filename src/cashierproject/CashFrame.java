/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cashierproject;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class CashFrame extends javax.swing.JFrame {
    float totalHarga;
    int flag = 0;
    LocalDateTime waktuPembayaran;
    String IDPembayaran, noMeteran, token, detail, metode_pembayaran, detail_listrik, kembalianstr;
    
    /**
     * Creates new form CashFrame
     */
    public CashFrame() {    
        initComponents();
    }
    
    public void terimaPembayaran(Pembayaran pembayaran) {
        totalHarga = pembayaran.getTotalHarga();
        waktuPembayaran = pembayaran.getWaktuPembayaran();
        IDPembayaran = pembayaran.getIDPembayaran();
        detail = pembayaran.getDetail();
        metode_pembayaran = "CASH";

        jTextField1.setText("" + totalHarga);
        System.out.println(pembayaran.getWaktuPembayaran());
        System.out.println(pembayaran.getIDPembayaran());
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
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(290, 130));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(706, 570));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Pembayaran Cash");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Total Belanja");

        jTextField1.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Total Bayar");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Kembalian");

        jTextField3.setEditable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel1)
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        String dibayar = jTextField2.getText();
        dibayar = dibayar.replace(",", "");
        
        int totalHargaInt = (int) totalHarga;
        String totalHargastr = Float.toString(totalHarga);
        
        try {
            int dibayarInt = Integer.parseInt(dibayar);
            
            if (dibayarInt < totalHargaInt) {
                throw new Exception("Insufficient payment amount !!!");
            }

            int kembalian = dibayarInt - totalHargaInt;
            kembalianstr = Integer.toString(kembalian);
            jTextField3.setText(String.format("%,d", kembalian));
            if (flag == 1){
                jTextArea1.setText( "Waktu Pembayaran \t: " + waktuPembayaran + "\n"  + 
                                    "ID Pembayaran    \t: " + IDPembayaran + "\n"  +
                                    "Total          \t\t: " + totalHarga + "\n\n" +
                                    "Nomor Meteran    \t: " + noMeteran + "\n"  + 
                                    "Token          \t\t: " + token + "\n\n" +
                                    "Detail Pembayaran\t: " + "\n" +
                                    "Metode Pembayaran\t: " + metode_pembayaran + "\n" +
                                    "Dibayar        \t\t: " + dibayar + "\n" +
                                    "Kembalian        \t: " + kembalian);
                detail = noMeteran + " | " + token;
                // Menyimpan data transaksi ke dalam database
                TransaksiCash transaksicash = new TransaksiCash(IDPembayaran, detail, metode_pembayaran, totalHargastr, dibayar, kembalianstr);
            } else {
                jTextArea1.setText("Waktu Pembayaran \t: " + waktuPembayaran + "\n"  + 
                                   "ID Pembayaran    \t: " + IDPembayaran + "\n" +
                                   "Total          \t\t: " + totalHarga + "\n\n" +
                                   "Detail         \t\t: " + detail + "\n\n" +
                                    "Detail Pembayaran\t: " + "\n" +
                                    "Metode Pembayaran\t: " + metode_pembayaran + "\n" +
                                    "Dibayar        \t\t: " + dibayar + "\n" +
                                    "Kembalian        \t: " + kembalian);
                // Menyimpan data transaksi ke dalam database
                TransaksiCash transaksicash = new TransaksiCash(IDPembayaran, detail, metode_pembayaran, totalHargastr, dibayar, kembalianstr);
            }
            
            
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Input harus berupa angka!!!");
            jTextField2.setText("");
            jTextField2.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        String dibayarString = jTextField2.getText();
        dibayarString = dibayarString.replace(",", "");
        
        int dibayarInput = Integer.valueOf(dibayarString);
        jTextField2.setText(String.format("%,d", dibayarInput));
    }//GEN-LAST:event_jTextField2KeyReleased

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
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
