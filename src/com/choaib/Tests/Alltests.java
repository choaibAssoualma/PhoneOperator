package com.choaib.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import com.choaib.Main.BestTOperator;
import com.choaib.Main.FileParser;
import com.choaib.Main.TOperator;

public class Alltests {
	ArrayList<TOperator> tps;
	  @Before
	    public void setUp() {
	        tps=FileParser.parse("PricesList.txt");
	    }
	  
	   @Test
	    public void shouldReturnNull() {
		   TOperator tp1=new TOperator("TestOp1");
		   TOperator tp2=new TOperator("TestOp2");
		   String dial="4566789";
		   tp1.addPrice("44", 2.0);
		   tp2.addPrice("434", 1.0);
		   tps.add(tp1);
		   tps.add(tp2);
		   assertNull(BestTOperator.calculateBest(tps,dial));
	    }
	   
	@Test
	    public void shouldCalculateBestPriceForAnOperator() {
		   TOperator tp=new TOperator("TestOp");
		   String dial="4566789";
		   tp.addPrice("456", 2.1);
		   tp.addPrice("45667", 2.0);

		   tps.add(tp);
		   assertEquals(2,(int)BestTOperator.calculateBest(tps,dial).getPrice(dial));
	    }
	
	@Test
    public void shouldFindBestOperator() {
	   TOperator tp1=new TOperator("TestOp1");
	   TOperator tp2=new TOperator("TestOp2");
	   String dial="4566789";
	   tp1.addPrice("45667", 2.0);
	   tp2.addPrice("4566", 1.0);
	   tps.add(tp1);
	   tps.add(tp2);

	   assertEquals(tp2,BestTOperator.calculateBest(tps,dial));
    }
	
	

}
