package com.choaib.Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {

	public static ArrayList<TOperator> parse(String filePath) {
	    ArrayList<TOperator> tl=new ArrayList<TOperator>();
	    BufferedReader br = null;
		try   {
			br = new BufferedReader(new FileReader(filePath));
		    String line;
		    int i=-1;
		    while ((line = br.readLine()) != null) {
		    		if(line.split(" ")[0].equals("Operator")){
		    		 tl.add(new TOperator(line.split(" ")[1].split(":")[0]));
		    		 i++;
		    		}
		    		else if(i>-1){
		    			tl.get(i).addPrice(line.split(" ")[0],Double.parseDouble(line.split(" ")[1]));
		    		}
		    }
		}catch(IOException e){
			System.out.println("unable to read input file");
			
		}
		try {
			if(br!=null)
			br.close();
		} catch (IOException e) {
			System.out.println("unable to close input file");

		}
		
		return tl;
	}
}
