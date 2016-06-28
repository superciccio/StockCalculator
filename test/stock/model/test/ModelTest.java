/**
 * 
 */
package stock.model.test;

import org.junit.Before;
import org.junit.Test;

import stock.mock.MockDataForTesting;
import stock.model.Stock;
import stock.model.StockSymbol;

/**
 * @author andrea
 *
 */
public class ModelTest {
	
	Stock stock;
	
	@Before
	public void init(){
		stock = MockDataForTesting.mockStock.get(0);
	}
	
	
	@Test
	public void testStockSymbolEnum() {
		System.out.println(StockSymbol.getType(StockSymbol.ALE));
	}
	
	@Test
	public void testToString(){
		System.out.println(stock.toString());
	}

}
