package stock.model;

public enum StockSymbol {
	
	TEA(StockType.Common), POP(StockType.Common), ALE(StockType.Common), GIN(StockType.Preferred), JOE(StockType.Common);
	
	private StockType type;

	private StockSymbol(StockType type){
		this.type = type;
	}

	public static StockType getType(StockSymbol symbol){
		return valueOf(symbol.name()).type;
	}
}
