package pro1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {

    private static HttpClient client = HttpClient.newBuilder().build();
    private static String baseUrl = "https://stag-demo.uhk.cz/ws/services/rest2";
    public static String getTeachersByDepartment(String department)
    {
        return getFromUri(baseUrl+"/ucitel/getUciteleKatedry?outputFormat=JSON&katedra="+department);
    }


    public static String getActionsByDepartment(String department, int year)
    {
        return getFromUri(baseUrl+"/rozvrhy/getRozvrhByKatedra?semestr=%25&outputFormat=JSON&katedra="+department+"&rok="+year+"LS");
    }

    private static String getFromUri(String uri)
    {
        try {
            URL obj = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "UTF-8")
            );
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
    }
    public static String getSpecializations(int year) {
        return getFromUri(baseUrl + "/prijimacky/getPrijimaciObory?outputFormat=JSON&rok=" + year);
    }

}

