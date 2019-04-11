package rsa;

/*
 * KeyPairGenerator.java
 *
 * Created on 15 �����, 2007, 08:26 �
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */   
import java.io.IOException;
import java.security.*;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import javax.crypto.IllegalBlockSizeException;
import java.security.interfaces.RSAPublicKey ;
import java.security.interfaces.RSAPrivateKey ;
/**
 *
 * @author Dell
 */
public  class KPG {
    PrivateKey privateKey , testPK ;
    PublicKey publicKey ;
    Key key ;
    RSAPublicKey rsaPublic;
    RSAPrivateKey rsaPrivate;
    /** Creates a new instance of KeyPairGenerator
     * @throws javax.crypto.IllegalBlockSizeException
     * @throws java.security.InvalidKeyException
     * @throws java.io.IOException
     * @throws java.security.NoSuchProviderException
     */
    public KPG() throws IllegalBlockSizeException, InvalidKeyException, IOException, NoSuchProviderException  {
        SecureRandom random = null;
        try {
            // Generate a 1024-bit Digital Signature Algorithm (DSA || RSA || DH) key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            //random = SecureRandom.getInstance("SHA512", "SUN");
            //keyGen.initialize(4096,random);
            keyGen.initialize(1024,random);
            KeyPair keypair = keyGen.genKeyPair();
            privateKey = keypair.getPrivate();
            publicKey = keypair.getPublic();
            
            rsaPublic = (RSAPublicKey)publicKey;
            rsaPrivate = (RSAPrivateKey)privateKey;
            
            
            /*////////// write pair key to file ///////////
            File myfileprivate = new File("privateKey.txt");
            ObjectOutputStream outstrprivate = new ObjectOutputStream( new FileOutputStream(myfileprivate));
            outstrprivate.writeObject("private key is : "+rsaprivate.getPrivateExponent());
            //outstrprivate.writeObject("private key is : "+rsaprivate.toString());
            outstrprivate.flush();
            outstrprivate.close();
             
            File myfilepublic = new File("publicKey.txt");
            ObjectOutputStream outstrpublic = new ObjectOutputStream( new FileOutputStream(myfilepublic));
            outstrpublic.writeObject("\npublic key is :"+rsapublic.getPublicExponent());
            //outstrpublic.writeObject("\npublic key is :"+rsapublic.toString());
            outstrpublic.flush();
            outstrpublic.close();
             */
            
            //key  = KeyGenerator.getInstance("AES").generateKey();
            
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param buf
     * @return
     */
    public String asHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;
        
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)
                strbuf.append("0");
            
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }
}