package com.choaib.Main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class BestTOperator {
	
	/**
	 * 
	 * 
	 * @param ll
	 *            : list of operators
	 * @param dial
	 *            :  dialed number
	 * @return 
	 *            : the best operator or null if  we can't dial this number with any operator
	 
	 */
	public static TOperator calculateBest(ArrayList<TOperator> ll,String dial){
		int index=-1;
		Double price=Double.MAX_VALUE;
		   for(int i=0;i<ll.size();i++){
			 Double  tmpPrice=ll.get(i).getPrice(dial);
			  if(tmpPrice>-1.0 && tmpPrice<=price){
				  price=tmpPrice;
				  index=i;
				  
			  }
		   }
		   if(index>-1)
			   return ll.get(index);
		   else
			   return null;
		
	}

}
