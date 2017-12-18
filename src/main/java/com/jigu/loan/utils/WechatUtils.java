package com.jigu.loan.utils;

import java.security.MessageDigest;

public class WechatUtils {

    public static boolean verifyRawData(String rawData, String sessionKey, String signature) {
        try{
            String encryptStr = rawData + sessionKey;
            byte[] byteStr = MessageDigest.getInstance("SHA-1").digest(encryptStr.getBytes());
            String result = hexToString(byteStr);
            return result.toLowerCase().equals(signature);
        }
        catch (Exception e){
            return false;
        }
    }

    private static String hexToString(byte[] byteStr){
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        int j = byteStr.length;
        char buf[] = new char[j*2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = byteStr[i];
            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
            buf[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(buf);
    }
}
