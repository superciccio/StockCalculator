package stock.mock;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import stock.model.Stock;
import stock.model.StockSymbol;

public class MockDataForTesting {
	
	public static List<Stock> mockStock = new ArrayList<>();
	
	static{
		MathContext mathContext = new MathContext(3);
		mockStock.add(new Stock(StockSymbol.TEA, new BigDecimal(0.0, mathContext), new BigDecimal(100), new BigDecimal(120.5, mathContext), 5));
		mockStock.add(new Stock(StockSymbol.POP, new BigDecimal(0.8, mathContext), new BigDecimal(100), new BigDecimal(14.48, mathContext), 1));
		mockStock.add(new Stock(StockSymbol.ALE, new BigDecimal(0.23, mathContext), new BigDecimal(60), new BigDecimal(55.9, mathContext), 20));
		mockStock.add(new Stock(StockSymbol.GIN, new BigDecimal(0.8, mathContext), new BigDecimal(100), new BigDecimal(25.3), new BigDecimal(0.22, mathContext), 14));
		mockStock.add(new Stock(StockSymbol.JOE, new BigDecimal(0.13, mathContext), new BigDecimal(250), new BigDecimal(14.5, mathContext), 14));
	}

}
