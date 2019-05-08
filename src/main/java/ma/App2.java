package ma;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String text = null;
		  FileInputStream fstream = new FileInputStream("I:\\automation\\changeLogStatus.txt");
		  DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

      /*  while((text = br.readLine())!= null){
      	  
      	  mail.append(text);
      	  mail.append(System.getProperty("line.separator"));
      	  
        }
        
        System.out.println(mail.toString());
        */
		
		//List<String> headersList = Arrays.asList("NAME", "GENDER", "MARRIED", "AGE", "SALARY($)");
        
        List<String> headersList = new ArrayList<String>();
        List<String> headersLis1t = new ArrayList<String>(new ArrayList<String>());
        headersLis1t.add(1,"hi");
        headersList.add("hi");
        headersList.add("hi");

        headersList.add("hi");
        headersList.add("hi");
        headersList.add("hi");
        

		List<List<String>> rowsList = Arrays.asList(
		        Arrays.asList("Eddy", "Male", "No", "23", "1200.27"),
		        Arrays.asList("Libby", "Male", "No", "17", "800.50"),
		        Arrays.asList("Rea", "Female", "No", "30", "10000.00"),
		        Arrays.asList("Deandre", "Female", "No", "19", "18000.50"),
		        Arrays.asList("Alice", "Male", "Yes", "29", "580.40"),
		        Arrays.asList("Alyse", "Female", "No", "26", "7000.89"),
		        Arrays.asList("Venessa", "Female", "No", "22", "100700.50")
		);
		//bookmark 1
		Board board = new Board(50);
		String tableString = board.setInitialBlock(new Table(board, 50, headersList, rowsList).tableToBlocks()).build().getPreview();
		System.out.println(tableString);
	}

}
