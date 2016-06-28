package stock.calculator.test;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Test;

import stock.share.Calculator;
import stock.mock.MockDataForTesting;
import stock.model.Stock;
import stock.model.StockSymbol;
import stock.model.StockType;

public class CalculatorTest {

	private final Logger log = Logger.getLogger(Calculator.class.getName());

	@Test
	public void calculateDividendYieldForCommon() {
		log.info("calculateDividendYieldForCommon method");

		Stock stock = MockDataForTesting.mockStock.get(2);
		StockType type = stock.getType();
		assertEquals(type, StockType.Common);

		log.info("calculateDividendYieldForCommon result \n: "
				+ Calculator.calculateDividendYield(stock).toPlainString());
	}

	@Test
	public void calculateDividendYieldForPreferred() {
		log.info("calculateDividendYieldForPreferred method");

		Stock stock = MockDataForTesting.mockStock.get(3);
		StockType type = stock.getType();
		assertEquals(type, StockType.Preferred);

		log.info("calculateDividendYieldForPreferred result \n: "
				+ Calculator.calculateDividendYield(stock).toPlainString());
	}

	@Test
	public void calculatePERatio() {
		log.info("calculatePERatio method");

		Stock stock = MockDataForTesting.mockStock.get(3);
		StockType type = stock.getType();
		assertEquals(type, StockType.Preferred);

		log.info("PeRatio result \n: " + Calculator.calculatePERatio(stock).toPlainString());
	}

	@Test
	public void testingSqrt() {
		log.info("testingSqrt method");
		
		System.out.println(Calculator.geometricMean(MockDataForTesting.mockStock));
		
		log.info("testingSqrt result \n: " + Calculator.geometricMean(MockDataForTesting.mockStock));
	}

	@Test
	public void volumeWeighted() {
		log.info("volumeWeighted method");
		
		log.info("volumeWeighted result \n: " + Calculator.volumeWeightedStockPrice(MockDataForTesting.mockStock, StockSymbol.ALE));
	}

}
