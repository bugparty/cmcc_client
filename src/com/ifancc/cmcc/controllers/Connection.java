package com.ifancc.cmcc.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



public class Connection {
	
	
	public static void start() throws IOException{
		URL url;
		URLConnection conn;
		url = new URL("http://www.baidu.com");
		conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "G3WLAN");
		
		
		conn.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		StringBuilder sb = new StringBuilder();
		String line;
		while( (line = reader.readLine()) != null){
			sb.append(line);
		}
		//System.out.println(sb);
		Document doc = Jsoup.parse(sb.toString());
		Element form = doc.select("#loginform").first();
		//System.out.println(form.html());
		
		
		
	}
}
