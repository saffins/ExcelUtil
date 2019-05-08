package ExcelReaderUtility;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromTxt {

	static StringBuffer mail = new StringBuffer("");
	
	public static void main(String... args) throws IOException {
		// TODO Auto-generated method stub

		String text = null;
		  FileInputStream fstream = new FileInputStream("I:\\automation\\changeLogStatus.txt");
		  DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));

          while((text = br.readLine())!= null){
        	  
        	  mail.append(text);
        	  mail.append(System.getProperty("line.separator"));
        	  System.out.println(text);
        	  
          }
          
       //   return mail.toString();
          
		
	}

}
