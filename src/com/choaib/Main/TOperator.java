package com.choaib.Main;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 * telephone operators class
 * 
 * @param name
 *            : Operator name
 * @param prices
 *            :  the list of prices (keys=phone number prefixes , values=prices)
 * @param sortedPrices
 *            : list of number prefixes   sorted  by length
 
 */
public class TOperator {
	private String name;
	private Map<String,Double> prices=new TreeMap<String,Double>();
	private SortedSet<String> sortedPrices;
	
//Constructors
	public TOperator() {
	}
	public TOperator(String name) {
		this.name = name;
	}
	
	/**
	 
	 * @return : list of number prefixes   sorted  by length ( to select the longest one)
	 * 
	 */	public SortedSet<String> getSortedPrices() {
		Comparator<String> comparator = new Comparator<String>() {
			  public int compare(String s1, String s2) {
			    return -((Integer)s1.length()).compareTo((Integer)s2.length());
			  }
			};
			sortedPrices = new TreeSet<String>(comparator);
			sortedPrices.addAll(prices.keySet());
		return sortedPrices;
	}
	 
	 /**
		 * add a price to the list
		 * @param number
		 *            : a number prefixe
		 * @param price
		 *            :  the prefixe price
		 * 
		 * 
		 */
	 public void addPrice(String number,Double price) {
			prices.put(number, price);
		}
	 
	 /**
		 * get the operator price for the dialed number
		 * @param dial
		 *            : dialed number
		 * @return 
		 *            :  the dialed number price
		 * 
		 * 
		 */
		public double getPrice(String dial){
			
		 	for(String o : this.getSortedPrices()){
		 		if(dial.startsWith(o))
		 			return prices.get(o);

	     	}
		 	return -1.0;
			
		}
	 
	//getters & setters 	
	public void setPrices(Map<String, Double> prices) {
		this.prices = prices;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Double> getPrices() {
		return prices;
	}


}
