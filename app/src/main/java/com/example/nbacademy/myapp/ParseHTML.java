package com.example.nbacademy.myapp;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package parsehtml;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
//import org.json.simple.JSONObject;
/**
 *
 * @author NB24030
 */
public class ParseHTML {

    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    private String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String requestNumbeoAPI (String city){
        String replace = city.replace(' ', '-');
        String url = "https://www.numbeo.com/cost-of-living/in/" + replace + "?displayCurrency=EUR";
        String response="";
        Double cost=0.0;
        try{
            response = sendGet(url);
        }catch(Exception ex){
            System.out.println("ERROR");
        }
        return response;
    }

    //Price for meal
    public double getMealCost(String response){
        Double cost=0.0;
        String search = "Meal for 2 People, Mid-range Restaurant, Three-course";
        String value;
        int init_index;
        int end_index;
        init_index=response.indexOf(search)+125;
        value = response.substring(init_index, init_index+10);
        String y =(value.replaceAll("[A-Za-z]+", ""));
        cost = Double.parseDouble(y.replaceAll("&", ""));
        return cost;
    }

    public String getCountryName(String response) {
        String value;
        int init_index;
        int end_index;
        String search = "country=";
        init_index=response.indexOf(search)+8; //index after "country="
        value = response.substring(init_index);
        end_index= value.indexOf("\"");
        String country = value.substring(0, end_index);
        country = country.replace('+', ' ');
        return country;
    }

    private String getCurrencyName (String country){

        String url = "https://restcountries.eu/rest/v2/name/"+country;
        String response;
        String value="";

        try{
            response = sendGet(url);
            String search = "\"code\"";
            int init_index;
            init_index=response.indexOf(search);
            value = response.substring(init_index+8, init_index+11);
        }catch(Exception ex){
            System.out.println("ERROR");
        }
        return value;
    }


    private Double getCurrencyTax(String CurrencyCode){
        String app_id = "caa9568e5b644a7cbab40512f9c092d3";
        String url = "http://openexchangerates.org/api/latest.json?app_id="+app_id;
        String response;
        String value="";
        Double result=0.0;
        double currency_value;
        int init_index;
        int end_index;
        try{
            response = sendGet(url);
            String search = "\""+CurrencyCode.toUpperCase()+"\"";
            String dolar = "\"USD\"";
            if (!search.equals(dolar)) {

                init_index=response.indexOf(search);
                value = response.substring(init_index);
                end_index=value.indexOf(",");
                value = value.substring(7,end_index);
                currency_value = Double.parseDouble(value);
            }else{
                currency_value=1;
            }

            search = "\"EUR\"";
            init_index=response.indexOf(search);
            value = response.substring(init_index);
            end_index=value.indexOf(",");
            value = value.substring(7,end_index);
            double eur = Double.parseDouble(value);

            result = (1/currency_value)*eur;

        }catch(Exception ex){
            System.out.println("ERROR");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        String city = "Porto";
        ParseHTML http = new ParseHTML();

        System.out.println("Sending Http GET request");
        String response = http.requestNumbeoAPI(city);
        Double meal_cost = http.getMealCost(response);
        String country = http.getCountryName(response);
        String currency_code=http.getCurrencyName(country);
        Double currency_toEur=http.getCurrencyTax(currency_code);
        System.out.println("*************************");
        System.out.println("Country = " +country);
        System.out.println("*************************");
        System.out.println("Avg meal cost = " +meal_cost+ " EUR");
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("Local Currency = " +currency_code);
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("Currency to Eur = " +currency_toEur);
        System.out.println("*************************");

    }

}