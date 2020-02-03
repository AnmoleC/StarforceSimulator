package util;

import java.text.NumberFormat;

public class Tracking {
	private int boom = 0;
	private int attempts = 0;
	private long totalCost = 0;
	
	public int getBoom() {
		return boom;
	}
	public void setBoom(int boom) {
		this.boom = boom;
	}
	public void addBoom(){
		boom++;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public void addAttempts(){
		 attempts++;
	}
	public long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}
	public void addTotalCost(long totalCost){
		this.totalCost += totalCost;
	}
	
	@Override
	public String toString() {
		return "Tracking ["
					+ "boom=" + boom 
					+ ", attempts=" + attempts 
					+ ", totalCost=" + NumberFormat.getIntegerInstance().format(totalCost) 
					+ "]";
	}
	
}
