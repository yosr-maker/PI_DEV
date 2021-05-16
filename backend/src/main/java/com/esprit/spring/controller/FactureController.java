package com.esprit.spring.controller;

//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Facture;
import com.esprit.spring.services.BasketService;
import com.esprit.spring.services.FactureService;
//import com.itextpdf.text.pdf.codec.Base64.InputStream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;



@RestController
@RequestMapping("/api")
public class FactureController {

	
	@Autowired
    private FactureService factureService;
	@Autowired
	private BasketService basketService;
	
	@Autowired
	ServletContext context;
	
/*	@GetMapping(value = "/pdfreportFacture/{basketId}")
    public String FactureReport(@PathVariable("basketId") int basketId) {
		Basket p  = basketService.findBasket(basketId);
         Facture f = factureService.findFactureByPanier(p);
         ByteArrayInputStream bis = GeneratePdfReport.FactureReport(f);
         HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=FactureReport.pdf");
         int size = bis.available();
        char[] theChars = new char[size];
        byte[] bytes = new byte[size];
        bis.read(bytes, 0, size);
        for (int i = 0; i < size;)
          theChars[i] = (char) (bytes[i++] & 0xff);
   
        File convertFile = new File("./uploads\\FactureReport.pdf");
		try {
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(bytes);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return new String(theChars);
       
    }
	
	*/
	@GetMapping("/findMyBills/{id}")
	@ResponseBody
	public List<Facture> findMyBills(@PathVariable("id")Client id){
		return factureService.findMyBills(id);
	}
	
}
