package stock.model;

import java.math.BigDecimal;

/***
 *  class that model a stock
 * @author andrea
 *
 */
public class Stock {
	
	private StockSymbol symbol;
	
	private StockType type;
	
	private BigDecimal lastDividend;
	
	private BigDecimal fixedDividend;
	
	private BigDecimal value;
	
	private BigDecimal price;
	
	private Integer quantity;
	
	public Stock(StockSymbol symbol, BigDecimal lastDividend, BigDecimal value, BigDecimal fixedDividend, BigDecimal price, Integer quantity){
		setSymbol(symbol);
		setLastDividend(lastDividend);
		setValue(value);
		setFixedDividend(fixedDividend);
		setPrice(price);
		setQuantity(quantity);
	}
	
	public Stock(StockSymbol symbol, BigDecimal lastDividend, BigDecimal value, BigDecimal price, Integer quantity){
		this(symbol, lastDividend, value, BigDecimal.ONE, price, quantity);
	}

	public StockSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(StockSymbol symbol) {
		this.symbol = symbol;
	}

	public StockType getType() {
		return StockSymbol.getType(getSymbol());
	}

	public BigDecimal getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(BigDecimal lastDividend) {
		this.lastDividend = lastDividend;
	}

	public BigDecimal getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(BigDecimal fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (symbol != other.symbol)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Stock [symbol=%s, type=%s, lastDividend=%s, fixedDividend=%s, value=%s, price=%s, quantity=%s]",
				symbol, type, lastDividend, fixedDividend, value, price, quantity);
	}

	

}
