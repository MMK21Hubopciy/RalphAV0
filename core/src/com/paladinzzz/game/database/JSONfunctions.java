package com.paladinzzz.game.database;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Selim on 27/6/2017.
 */

public class JSONfunctions{

    public static final String MY_JSON ="MY_JSON";

    private static final String api_url = "http://www.wemoney.nl/connect.php";

    public String doInBackground() {

        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(api_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String json;
            while((json = bufferedReader.readLine())!= null){
                sb.append(json+"\n");
            }

            return sb.toString().trim();

        }catch(Exception e){
            return null;
        }

    }
}
