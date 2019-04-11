/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainRSA.java
 *
 * Created on 21/09/2010, 12:33:38 م
 */
package rsa;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.swing.UIManager;

/**
 *
 * @author eng
 */
public class MainRSA extends javax.swing.JFrame {

    /*PrivateKey privateKey2;
    RSAPrivateKey rsaprivateKey2;
    PublicKey publicKey2;
    RSAPublicKey rsapublicKey2;
    PrivateKey prvKey;
    PublicKey pubKey;*/
    RSAPrivateKey rsaPrvkey;
    RSAPublicKey rsaPubkey;
    KPG kpg;
    RSAEncDec rsaEncryption = new RSAEncDec();

    /** Creates new form MainRSA */
    public MainRSA() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        encryptB = new javax.swing.JButton();
        decryptB = new javax.swing.JButton();
        pF = new javax.swing.JTextField();
        qF = new javax.swing.JTextField();
        moduleF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageF = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        decryptedMessageF = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        genKeysB = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pubkeyF = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        prvkeyF = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("p");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 10, 20, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("q");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 10, 20, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("module");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 10, 50, 20);

        encryptB.setText("Encrypt");
        encryptB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptBActionPerformed(evt);
            }
        });
        getContentPane().add(encryptB);
        encryptB.setBounds(10, 260, 73, 23);

        decryptB.setText("Decrypt");
        decryptB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptBActionPerformed(evt);
            }
        });
        getContentPane().add(decryptB);
        decryptB.setBounds(10, 340, 80, 23);

        pF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(pF);
        pF.setBounds(90, 10, 50, 20);

        qF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(qF);
        qF.setBounds(190, 10, 50, 20);

        moduleF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(moduleF);
        moduleF.setBounds(310, 10, 50, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Plain Message");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 240, 80, 20);

        messageF.setColumns(20);
        messageF.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        messageF.setRows(5);
        jScrollPane1.setViewportView(messageF);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 260, 400, 76);

        decryptedMessageF.setColumns(20);
        decryptedMessageF.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        decryptedMessageF.setRows(5);
        jScrollPane2.setViewportView(decryptedMessageF);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 340, 400, 70);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Encrypted Message");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 320, 120, 20);

        genKeysB.setText("Generate Keys");
        genKeysB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genKeysBActionPerformed(evt);
            }
        });
        getContentPane().add(genKeysB);
        genKeysB.setBounds(90, 40, 120, 23);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Public Key");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 70, 70, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Private Key");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 100, 80, 20);
        getContentPane().add(pubkeyF);
        pubkeyF.setBounds(90, 70, 400, 20);

        prvkeyF.setColumns(20);
        prvkeyF.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        prvkeyF.setRows(5);
        jScrollPane3.setViewportView(prvkeyF);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(90, 100, 400, 140);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-516)/2, (screenSize.height-449)/2, 516, 449);
    }// </editor-fold>//GEN-END:initComponents

    private void encryptBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptBActionPerformed
        // TODO add your handling code here:
        try {
            /*////////////////// preparing public key ////////////////////////////////
            ObjectInputStream publickeyFile=new ObjectInputStream(new FileInputStream("publicKey.Key"));
            publicKey2=(PublicKey)publickeyFile.readObject();
            rsapublicKey2 = (RSAPublicKey)publicKey2;
            publickeyFile.close();
            /////////////////////// end  /////////////////////////////////////////*/

            /*////////////////  preparing  private key ///////////////////////////////
            ObjectInputStream privatekeyFile=new ObjectInputStream(new FileInputStream("privateKey.Key"));
            privateKey2=(PrivateKey)privatekeyFile.readObject();
            rsaprivateKey2 = (RSAPrivateKey)privateKey2;
            privatekeyFile.close();
            /////////////////////end//////////////////////////////////////////////*/
            //RSA rsa = new RSA(100);            
            String utf8SrcString = new String(rsaEncryption.Encrypt(messageF.getText(), kpg.rsaPublic), 0, rsaEncryption.Encrypt(messageF.getText(), kpg.rsaPublic).length, "UTF8");
            decryptedMessageF.setText(utf8SrcString);
            //messageF.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_encryptBActionPerformed

    private void genKeysBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genKeysBActionPerformed
        // TODO add your handling code here:
        try {
            kpg = new KPG();
            pubkeyF.setText(kpg.rsaPublic.toString());
            prvkeyF.setText(kpg.rsaPrivate.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_genKeysBActionPerformed

    private void decryptBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptBActionPerformed
        // TODO add your handling code here:
        try {
            String utf8SrcString = new String(rsaEncryption.Decrypt(decryptedMessageF.getText().getBytes(), kpg.rsaPrivate), 0, rsaEncryption.Decrypt(decryptedMessageF.getText().getBytes(), kpg.rsaPrivate).length, "UTF8");
            //rsaEncryption.Decrypt(decryptedMessageF.getText().getBytes(), kpg.rsaPrivate);
            messageF.setText(utf8SrcString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_decryptBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new MainRSA().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decryptB;
    private javax.swing.JTextArea decryptedMessageF;
    private javax.swing.JButton encryptB;
    private javax.swing.JButton genKeysB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea messageF;
    private javax.swing.JTextField moduleF;
    private javax.swing.JTextField pF;
    private javax.swing.JTextArea prvkeyF;
    private javax.swing.JTextField pubkeyF;
    private javax.swing.JTextField qF;
    // End of variables declaration//GEN-END:variables
}