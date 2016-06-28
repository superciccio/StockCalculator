package stock.model;

import java.time.LocalTime;

/**
 *  class that model a Trade
 * @author andrea
 *
 */
public class Trade {
	
	private LocalTime localtime;
	
	private ActionTrade trade;
	
	private Stock stock;

	public Trade(LocalTime localtime, ActionTrade trade,Stock stock) {
		this.localtime = localtime;
		this.trade = trade;
		this.stock = stock;
	}

	public LocalTime getLocaltime() {
		return localtime;
	}
	
	public void setLocaltime(LocalTime localtime) {
		this.localtime = localtime;
	}

	public ActionTrade getTrade() {
		return trade;
	}

	public void setTrade(ActionTrade trade) {
		this.trade = trade;
	}

	public Stock getStock() {
		return stock;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return String.format("Trade [localtime=%s, trade=%s, stock=%s]", localtime, trade, stock);
	}
	
	
	
}
