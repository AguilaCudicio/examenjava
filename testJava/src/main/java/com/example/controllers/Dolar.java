package com.example.controllers;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.models.Currency;

public class Dolar implements CotizacionStrategy {

	public ResponseEntity<?> show(){
		
		String content = "";
		try {
			   InputStream in = new URL( "https://www.bancoprovincia.com.ar/Principal/Dolar" ).openStream();
			   content = IOUtils.toString(in, "UTF-8");
			   IOUtils.closeQuietly(in);
		} catch (IOException e) {
			   e.printStackTrace();
			   return new ResponseEntity<String>("404 - Not found",HttpStatus.NOT_FOUND);
		}
		content = content.replace("[", "");
		content = content.replace("]", "");
		content = content.replace("\"", "");
		String[] ary = content.split(",");
		
		Currency cu = new Currency(Float.parseFloat(ary[0]),Float.parseFloat(ary[1]),ary[2]);
		return new ResponseEntity<Currency>(cu, HttpStatus.OK);
	}
}
