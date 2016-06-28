package stock;

import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.List;

import stock.mock.MockDataForTesting;
import stock.model.ActionTrade;
import stock.model.Stock;
import stock.model.Trade;
import stock.share.Calculator;
import stock.util.RegistryTrade;
import stock.util.TradeKey;

public class Main {

	public static void main(String[] args) {
		
		Stock value = MockDataForTesting.mockStock.get(0);
		TradeKey tradeKey = new TradeKey();
		tradeKey.setActionTrade(ActionTrade.BUY);
		tradeKey.setTime(tradeKey.getTime().minusMinutes(5));
		RegistryTrade.registry.put(tradeKey, value);
		
		Stock value1 = MockDataForTesting.mockStock.get(1);
		TradeKey tradeKey1 = new TradeKey();
		tradeKey1.setActionTrade(ActionTrade.SELL);
		tradeKey1.setTime(tradeKey1.getTime().minusMinutes(5));
		RegistryTrade.registry.put(tradeKey1, value1);
		
		Stock value2 = MockDataForTesting.mockStock.get(2);
		TradeKey tradeKey2 = new TradeKey();
		tradeKey2.setActionTrade(ActionTrade.BUY);
		tradeKey2.getTime().minusMinutes(5);
		RegistryTrade.registry.put(tradeKey2, value2);
		
		Stock value3 = MockDataForTesting.mockStock.get(3);
		TradeKey tradeKey3 = new TradeKey();
		tradeKey3.setActionTrade(ActionTrade.BUY);
		RegistryTrade.registry.put(tradeKey3, value3);
		
		List<Stock> onlyLastFiveMinutes = Calculator.onlyLastFiveMinutes(RegistryTrade.registry);
		
		Calculator.calculateDividendYield(value);
		
		Calculator.calculatePERatio(value2);
		
		Calculator.volumeWeightedStockPrice(onlyLastFiveMinutes);
		
		Calculator.volumeWeightedStockPrice((List<Stock>) RegistryTrade.registry.values());
	}
}
