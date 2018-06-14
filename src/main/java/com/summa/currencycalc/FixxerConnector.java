/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summa.currencycalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Druid
 */
public class FixxerConnector {
    private String targetURL;
    private URL url;
    private URLConnection connection;
    
    public FixxerConnector() throws MalformedURLException {
        targetURL = "http://api.nbp.pl/api/exchangerates/rates/c/usd/today/?format=json";
        connection = null;
        
    }
    
    public void retrieveExchange() throws MalformedURLException, IOException{
        url = new URL(targetURL);
        connection = url.openConnection();
               
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        String inputLine = in.readLine(); 
        System.out.println(inputLine);
        
        in.close();
    
    }
    public void changeCurrency(String currency){
        targetURL = "http://api.nbp.pl/api/exchangerates/rates/c/"+currency+"/today/?format=json"; 
    }
    
    
}
