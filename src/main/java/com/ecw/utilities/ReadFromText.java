package com.ecw.utilities;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromText {
	
static StringBuffer mail = new StringBuffer("");
	
	public static String readData() throws IOException {
		// TODO Auto-generated method stub

		String text = null;
		  FileInputStream fstream = new FileInputStream("I:\\automation\\statuschange.txt");
		  DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));

          while((text = br.readLine())!= null){
        	  
        	  mail.append(text);
        	  mail.append(System.getProperty("line.separator"));
        	  System.out.println(text);
        	  
          }
          
        return mail.toString();
          
		
	}

}
