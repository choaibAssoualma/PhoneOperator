package com.choaib.Main;

import java.io.IOException;
import java.util.*;

public class MainClass {

	public static void main(String[] args) throws IOException {
		ArrayList<TOperator> m=FileParser.parse("PricesList.txt"); //input
		String dial="44"; //dialed number

		
		if(m.size()>0){
		TOperator tp=null;
		if((tp=BestTOperator.calculateBest(m,dial))==null ){
			System.out.println("Sorry we can't dial this number with any operator");
		}
		else{
			System.out.println("**dialed number : "+dial+"  Cheapest Operator : "+tp.getName()+" price :"+tp.getPrice(dial)+"**");

			
		}
		}
		
    
	}

}
