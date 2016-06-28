package stock.util;

import java.time.LocalTime;

import stock.model.ActionTrade;

public class TradeKey {
	
	private LocalTime time;
	
	private ActionTrade actionTrade;
	
	public TradeKey() {
		setTime(LocalTime.now());
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public ActionTrade getActionTrade() {
		return actionTrade;
	}

	public void setActionTrade(ActionTrade actionTrade) {
		this.actionTrade = actionTrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionTrade == null) ? 0 : actionTrade.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		TradeKey other = (TradeKey) obj;
		if (actionTrade != other.actionTrade)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	
	
}
