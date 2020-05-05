package com.thankfulness.thankfulness.Config;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class Logging {

    private String uri = "http://127.0.0.1:9200/my-logs/_doc/";
    public Logging(){

    }
    public void get() throws IOException {
        URL url = new URL("http://127.0.0.1:9200");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
    }
    private void save() throws IOException {
        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }

}
