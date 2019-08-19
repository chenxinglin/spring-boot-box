package com.xing.httpclient;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTest {

    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpClientTest.get();
        HttpClientTest.post();
        HttpClientTest.uri();
        HttpClientTest.httpget();
    }

    /**
     * get请求获取响应
     * @throws IOException
     */
    public static void get() throws IOException {

        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response = httpClient.execute(httpget);
        HttpEntity httpEntity= response.getEntity();
        String strResult= EntityUtils.toString(httpEntity, "UTF-8");
        System.out.println(strResult);
    }

    /**
     * post请求获取响应
     * @throws IOException
     */
    public static void post() throws IOException {
        HttpPost httpost = new HttpPost("https://www.baidu.com");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("IDToken1", "username"));
        nvps.add(new BasicNameValuePair("IDToken2", "password"));
        httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
    }

    /**
     * HttpClient提供URIBuilder工具类来简化URIs的创建和修改过程。
     * @throws URISyntaxException
     */
    public static void uri() throws URISyntaxException {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.google.com")
                .setPath("/search")
                .setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search")
                .setParameter("aq", "f")
                .setParameter("oq", "")
                .build();
        HttpGet httpget = new HttpGet(uri);
        System.out.println(httpget.getURI());
    }

    /**
     * 模拟浏览器请求
     * @throws IOException
     */
    public static void httpget() throws IOException {
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.baidu.com");

        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0");

        CloseableHttpResponse response = httpClient.execute(httpget);
        HttpEntity httpEntity= response.getEntity();
        String strResult= EntityUtils.toString(httpEntity, "UTF-8");
        System.out.println(strResult);


    }


}
