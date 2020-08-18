package com.ky.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RM
 * @version V1.0.0
 * @date 2020-01-08 12:33
 */
public class Test {
    public static void main(String[] args) throws IOException, UnrecoverableKeyException, CertificateException, KeyStoreException, KeyManagementException {
        SSLConnectionSocketFactory socketFactory = getSocketFactory();

        // 创建 CloseableHttpClient 对象
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();

        // 指定请求的 URL 并创建 HttpPost 对象
        HttpPost httppost = new HttpPost("https://xingzhengquhua.51240.com/");

        // 设置请求通过的代理
        httppost.setConfig(RequestConfig.custom().setProxy(new HttpHost("host", 8080)).build());
        HttpEntity entity;

        // 设置请求的 ContentType 为 application/x-www-form-urlencoded
//        httppost.addHeader(HttpHeaders.CONTENT_TYPE, Consts.HTTP_REQUEST_CONTENTTYPE_FORM);

        // 构建 POST 的内容
        List<BasicNameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("amount", "1.00"));
        entity = new UrlEncodedFormEntity(nvps, "UTF-8");
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            // 发送请求
            response = httpclient.execute(httppost);

            // 获取响应内容
            HttpEntity entity1 = response.getEntity();
            System.out.println(EntityUtils.toString(entity1));
        } finally {
            if (null != response) {
                response.close();
            }
            if (null != httpclient) {
                httpclient.close();
            }
        }
    }

    // 忽略服务器端证书链的认证
    private static TrustManager getTrustManagers() {
        return new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        };
    }

    private static SSLConnectionSocketFactory getSocketFactory() throws IOException, KeyStoreException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        SSLContext sslContext;
        try {
            // keyStore 用来存放客户端证书
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream instream = new FileInputStream(new File("d:\\test.p12"));
            try {
                keyStore.load(instream, "passwd".toCharArray());
            } finally {
                instream.close();
            }

            // 加载客户端证书，并设置HTTPS的安全协议为 TLSv1.2
            sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, "passwd".toCharArray()).useProtocol("TLSv1.2").build();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        try {
            sslContext.init(null, new TrustManager[]{getTrustManagers()}, new SecureRandom());
        } catch (KeyManagementException e) {
            return null;
        }
        return new SSLConnectionSocketFactory(sslContext);
    }
}
