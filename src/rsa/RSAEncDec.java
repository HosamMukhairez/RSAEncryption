package rsa;

import java.security.*;
import javax.crypto.*;

public class RSAEncDec {

    static int MAX_RSA_INPUT_LENGTH = 1024;
    static int RSA_OUTPUT_LENGTH = 1024;

    public RSAEncDec() {
    }

    public byte[] Decrypt(byte[] cy, PrivateKey pv) {
        byte[] dataDecoded = null;
        try {
            Cipher RSACipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            System.out.println("cy.length:" + cy.length);
            long fileSize = cy.length;
            byte[] data = null;

            RSACipher.init(Cipher.DECRYPT_MODE, pv);

            long iteration = fileSize / RSA_OUTPUT_LENGTH;
            if (iteration == 0) {
                throw new Exception("ENCRYPTED FILE SIZE ERROR");
            }
            data = new byte[RSA_OUTPUT_LENGTH];
            for (int i = 0; i < iteration; i++) {
                for (int j = 0; j < RSA_OUTPUT_LENGTH; j++) {
                    data[j] = cy[j];
                }

                dataDecoded = RSACipher.doFinal(data);
                String xx = new String(dataDecoded).trim();
                System.out.println(xx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDecoded;
    }

    public byte[] Encrypt(String pl, PublicKey pk) {

        byte[] dataEncoded = null;
        try {
            byte[] data = null;

            long fileSize = pl.length();
            Cipher RSACipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            RSACipher.init(Cipher.ENCRYPT_MODE, pk);
            long iteration = fileSize / MAX_RSA_INPUT_LENGTH;
            int residualByte = (int) (fileSize - iteration * MAX_RSA_INPUT_LENGTH);
            long totalIteration;
            if (residualByte == 0) {
                totalIteration = iteration;
            } else {
                totalIteration = iteration + 1;
            }

            if (iteration > 0) {
                data = new byte[MAX_RSA_INPUT_LENGTH];
            }
            for (int i = 0; i < iteration; i++) {
                for (int j = 0; j < MAX_RSA_INPUT_LENGTH; j++) {
                    data[j] = (byte) pl.charAt(j);
                }

                dataEncoded = RSACipher.doFinal(data);

                //fileOutput.write(dataEncoded);
                //  Decode(dataEncoded);

            }

            if (residualByte > 0) {
                data = new byte[residualByte];
                for (int j = 0; j < residualByte; j++) {
                    data[j] = (byte) pl.charAt(j);
                }

                dataEncoded = RSACipher.doFinal(data);

                //  Decode(dataEncoded);
                // fileOutput.write(dataEncoded);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dataEncoded);
        return dataEncoded;
    }

    public byte[] Encrypt(String pl, PrivateKey pr) {

        byte[] dataEncoded = null;
        try {
            byte[] data = null;

            long fileSize = pl.length();
            Cipher RSACipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            RSACipher.init(Cipher.ENCRYPT_MODE, pr);
            long iteration = fileSize / MAX_RSA_INPUT_LENGTH;
            int residualByte = (int) (fileSize - iteration * MAX_RSA_INPUT_LENGTH);
            long totalIteration;
            if (residualByte == 0) {
                totalIteration = iteration;
            } else {
                totalIteration = iteration + 1;
            }

            if (iteration > 0) {
                data = new byte[MAX_RSA_INPUT_LENGTH];
            }
            for (int i = 0; i < iteration; i++) {
                for (int j = 0; j < MAX_RSA_INPUT_LENGTH; j++) {
                    data[j] = (byte) pl.charAt(j);
                }

                dataEncoded = RSACipher.doFinal(data);

                //fileOutput.write(dataEncoded);
                //  Decode(dataEncoded);

            }

            if (residualByte > 0) {
                data = new byte[residualByte];
                for (int j = 0; j < residualByte; j++) {
                    data[j] = (byte) pl.charAt(j);
                }

                dataEncoded = RSACipher.doFinal(data);

                //  Decode(dataEncoded);
                // fileOutput.write(dataEncoded);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dataEncoded);
        return dataEncoded;
    }

    public byte[] Decrypt(byte[] cy, PublicKey pu) {
        byte[] dataDecoded = null;
        try {
            Cipher RSACipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            long fileSize = cy.length;
            byte[] data = null;

            RSACipher.init(Cipher.DECRYPT_MODE, pu);

            long iteration = fileSize / RSA_OUTPUT_LENGTH;
            if (iteration == 0) {
                throw new Exception("ENCRYPTED FILE SIZE ERROR");
            }
            data = new byte[RSA_OUTPUT_LENGTH];
            for (int i = 0; i < iteration; i++) {
                for (int j = 0; j < RSA_OUTPUT_LENGTH; j++) {
                    data[j] = cy[j];
                }

                dataDecoded = RSACipher.doFinal(data);
                String xx = new String(dataDecoded).trim();
                System.out.println(xx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDecoded;
    }
}
