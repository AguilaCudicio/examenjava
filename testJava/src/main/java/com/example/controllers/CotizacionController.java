package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ResponseBody
public class CotizacionController {

    @RequestMapping("/cotizacion")
    public  ResponseEntity<?> cotizacion(@RequestParam(value="name", defaultValue="dolar") String name) {
    	CotizacionStrategy cur;
    	if ( name.equals("dolar") ) {
	        cur= new Dolar();
    	}
    	else {
    		cur = new OtherCurrency();
    	}
    	
    	return cur.show();
    }
}