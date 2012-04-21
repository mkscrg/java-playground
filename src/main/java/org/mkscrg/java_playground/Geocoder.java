package org.mkscrg.java_playground;

import java.net.URLEncoder;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Geocoder {
    public static void main(String[] args) throws java.io.IOException {
        System.out.println("Address: (one line)");

        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            System.out.println("No input. Bye.");
            return;
        }
        String input = scanner.nextLine();

        String url = String.format(
            "http://maps.googleapis.com/maps/api/"
                .concat("geocode/json?address=%s&sensor=false"),
            URLEncoder.encode(input, "UTF-8")
        );

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);

        HttpEntity ety = client.execute(get).getEntity();
        if (ety != null) {
            System.out.println(EntityUtils.toString(ety));
        } else {
            System.out.println("Null entity returned.");
        }
    }
}
