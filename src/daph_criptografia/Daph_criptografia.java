/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daph_criptografia;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.digest.DigestUtils;
/**0
 *
 * @author DELL
 */
public class Daph_criptografia {
    /**
     * @param args the command line arguments
     */
    
    daph_enumTypes enumTypes;

    public String encryptText(daph_enumTypes type, String textoEncriptar){
        if(type.equals(enumTypes.MD5)){
            return DigestUtils.md5Hex(textoEncriptar);
        }
        if(type.equals(enumTypes.SHA)){
            return DigestUtils.sha1Hex(textoEncriptar);
        }   
        if(type.equals(enumTypes.SHA256)){
            return DigestUtils.sha256Hex(textoEncriptar);
        }
        if(type.equals(enumTypes.SHA512)){
            return DigestUtils.sha512Hex(textoEncriptar);
        }
        return "";

}
        public String decryptText(String textoEncriptar){
            try{
                MessageDigest decripted = DigestUtils.getDigest(textoEncriptar);
                return Arrays.toString(DigestUtils.digest(decripted, decripted.digest()));
            }
            catch(Exception e){
                return "";
            }
            
      
}
    
}
