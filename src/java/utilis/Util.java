/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilis;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author web4e
 */
public class Util {
    
    public static String hashPassword(String pass, String sale){
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(pass + sale); 
    }
    
    public static String printDefault(Object value, String defValue){
        if(value == null){
            return defValue;
        }else{
            return value.toString();
        }
    }
    
}
