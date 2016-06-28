package stock.share;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import stock.model.Stock;
import stock.model.StockSymbol;
import stock.model.StockType;
import stock.util.TradeKey;

/**
 * the class that will perform the actual calculations
 * @author andrea
 *
 */
public class Calculator {
	
	private final static MathContext mathDecimal = new MathContext(3);
	
	
	public static BigDecimal calculateDividendYield(Stock stock){
		if(stock.getType() == StockType.Common){
			return calculateResultCommon(stock.getPrice(), stock.getLastDividend());
		}
		else{
			return calculateResultPreferred(stock.getPrice(), stock.getFixedDividend(), stock.getValue());
		}
	}
	
	public static BigDecimal geometricMean(List<Stock> list){
		double size = list.size();
		BigDecimal result = BigDecimal.ONE;
		for(Stock s:list){
			result = result.multiply(s.getPrice(), mathDecimal);
		}
		return new BigDecimal(Math.pow(result.doubleValue(), 1/size), mathDecimal);
	}
	
	public static BigDecimal calculatePERatio(Stock stock){
		return stock.getPrice().divide(calculateDividendYield(stock), mathDecimal);
	}
	
	private static BigDecimal calculateResultCommon(BigDecimal price, BigDecimal lastDividend){
		return lastDividend.divide(price, mathDecimal);
	}
	
	private static BigDecimal calculateResultPreferred(BigDecimal price, BigDecimal fixedDividend, BigDecimal parValue){
		BigDecimal valueFixedDividend = fixedDividend.divide(new BigDecimal(100), mathDecimal);
		return valueFixedDividend.multiply(parValue, mathDecimal).divide(price, mathDecimal);
	}

	public static BigDecimal volumeWeightedStockPrice(List<Stock> list, StockSymbol symbol) {
		BigDecimal resultPrice = BigDecimal.ONE;
		Integer resultQuantity = 0;
		for(Stock s:list){
			if(s.getSymbol() == symbol){
				resultPrice = resultPrice.add(s.getPrice(), mathDecimal);
				resultQuantity += s.getQuantity();
			}
		}
		resultPrice = resultPrice.multiply(new BigDecimal(resultQuantity), mathDecimal);
		
		return resultPrice.divide(new BigDecimal(resultQuantity, mathDecimal));
	}
	
	public static List<Stock> onlyLastFiveMinutes(Map<TradeKey, Stock> source){
		List<Stock> result = new ArrayList<>();
		
		source.forEach(new BiConsumer<TradeKey, Stock>() {

			@Override
			public void accept(TradeKey t, Stock u) {
				Duration duration = Duration.between(t.getTime(), LocalTime.now());
				if(duration.toMinutes()==5){
					result.add(u);
				}
			}
		});
		return result;
	}
	
	public static BigDecimal volumeWeightedStockPrice(List<Stock> list) {
		BigDecimal resultPrice = BigDecimal.ONE;
		Integer resultQuantity = 0;
		for(Stock s:list){
				resultPrice = resultPrice.add(s.getPrice(), mathDecimal);
				resultQuantity += s.getQuantity();
		}
		resultPrice = resultPrice.multiply(new BigDecimal(resultQuantity), mathDecimal);
		
		return resultPrice.divide(new BigDecimal(resultQuantity, mathDecimal));
	}

}
