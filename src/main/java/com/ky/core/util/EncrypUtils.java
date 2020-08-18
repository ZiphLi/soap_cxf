package com.ky.core.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * 3DES加解密工具<br><br>
 *
 * 此工具提供 3DES加解密、BASE64编解码、提供MD5加密
 *
 * @author RM
 * @version 1.0
 * @date 2016-04-05
 */
@SuppressWarnings("restriction")
public class EncrypUtils {
    /******************************** 3DES ********************************/
    private static final String  ALGORITHM= "DESede";

    /**
     * 3DES加密
     *
     * @param text 要加密的字串
     * @param key 密钥
     * @return 加密后的字串
     */
    public static String encrypt3Des(String text, String key)
    {
        try
        {
            // 密钥MD5前24位
            byte[] keyByte = getMD5(key).substring(0, 24).getBytes("UTF-8");
            SecretKey deskey = new SecretKeySpec(keyByte, ALGORITHM);

            // 加密
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return encodeBase64(c1.doFinal(text.getBytes("UTF-8")));
        }
        catch (Exception ex)
        {
        }
        return null;
    }

    /**
     * 3DES解密
     *
     * @param text 要解密的字串
     * @param key 密钥
     * @return 解密后的字串
     */
    public static String decrypt3Des(String text, String key)
    {
        try
        {
            // 密钥MD5前24位
            byte[] keyByte = getMD5(key).substring(0, 24).getBytes("UTF-8");
            SecretKey deskey = new SecretKeySpec(keyByte, ALGORITHM);

            // 解密
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return new String(c1.doFinal(decodeBase64(text)), "UTF-8");
        }
        catch (Exception e)
        {
        }
        return null;
    }

    /******************************** BASE64 ********************************/

    /**
     * Base64编码
     *
     * @param byteArray 要编码的字节数组
     * @return 编码后的字串
     */
    public static String encodeBase64(byte[] byteArray)
    {
        try
        {
            // 注: BASE64编码后的字串中，每超过76字节会产生一个换行符，因此需要替换删除掉。
            // RFC2045中规定: The encoded output stream must be represented in lines of
            // no more than 76 characters each.
            return new BASE64Encoder().encode(byteArray).replaceAll("\r|\n", "");
        }
        catch (Exception e)
        {
        }
        return null;
    }

    /**
     * Base64编码
     *
     * @param str 要编码的字串
     * @return 编码后的字串
     */
    public static String encodeBase64(String str)
    {
        try
        {
            return encodeBase64(str.getBytes("UTF-8"));
        }
        catch (Exception e)
        {
        }
        return null;
    }

    /**
     * Base64解码
     *
     * @param str 要解码的字串
     * @return 解码后的字节数组
     */
    public static byte[] decodeBase64(String str)
    {
        try
        {
            return new BASE64Decoder().decodeBuffer(str);
        }
        catch (Exception e)
        {
        }
        return null;
    }

    /**
     * Base64解码
     *
     * @param str 要解码的字串
     * @return 解码后的字串
     */
    public static String decodeBase64ToString(String str)
    {
        try
        {
            return new String(new BASE64Decoder().decodeBuffer(str), "UTF-8");
        }
        catch (Exception e)
        {
        }
        return null;
    }

    /******************************** MD5 ********************************/

    /**
     * 为字串生成MD5值
     * @param str
     * @return
     */
    public static String getMD5(String str)
    {
        try
        {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] b = md5.digest(str.getBytes("UTF-8"));

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < b.length; i++)
            {
                int val = ((int) b[i]) & 0xff;
                if (val < 16){
                    hexString.append("0");
                }
                hexString.append(Integer.toHexString(val));
            }

            return hexString.toString();
        }
        catch (Exception e)
        {
        }

        return null;
    }

    /**
     * 依据明文获取加密文
     * @param str 明文
     * @param key 秘钥
     */
    public static void getEncrpStringTest(String str,String key){
        String resultString = EncrypUtils.encrypt3Des(str,key);
        System.out.println("明文:"+str);
        System.out.println("密文:"+resultString);
    }
    /**
     * 依据密文获取明文
     * @param str 密文
     * @param key 秘钥
     */
    public static void getDecrpStringTest(String str,String key){
        String resultString = EncrypUtils.decrypt3Des(str,key);
        System.out.println("密文:"+str);
        System.out.println("明文:"+resultString);
    }
    /**
     * 加密方法输出
     * @param args
     */
    public static void main (String[] args) {
        System.out.println(EncrypUtils.decrypt3Des("archiveId:41048219360319901*","1"));
        System.out.println("---------------------------加密----------------------------");
        //明文获取密文
        EncrypUtils.getEncrpStringTest("jdbc:mysql://rm-uf64lx5lrp12tme622o.mysql.rds.aliyuncs.com:3306/his_mris?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull","_@WDYL#ACB#123@");
        System.out.println("---------------------------解密----------------------------");
        //密文获取明文
        EncrypUtils.getDecrpStringTest("uvOCCj6vw1VZS6+IaoDbZg+GVW942LA7JVBm/GeYOHSVka1y0SfrmHz9X7cm4B6VojkFfjmoX6nJpB/e/sRTd3eKZ3NeVdaVUJDhyxnxgUvfi6wzWKGp1w4qW4lbMpm89CX5njcT8QaW4wBqqu05fI0tYTSFWI5XEQ5n33Ldsdha6wEaxIe/kEBpjk4rz+DzAKdK3B1F2pI=","inspur1234,");
        System.out.println("---------------------------结束----------------------------");

    }
}
