package util;

import java.text.NumberFormat;
import java.util.ArrayList;

public class TrackingCollection {
	ArrayList<Tracking> list = new ArrayList<>();
	int minBoom = Integer.MAX_VALUE;
	int maxBoom = 0;
	long totalBoom = 0;
	
	long minCost = Integer.MAX_VALUE;
	long maxCost = 0;
	long totalCost = 0;
	
	int minAttempt = Integer.MAX_VALUE;
	int maxAttempt = 0;
	long totalAttempt = 0;
	
	public void addAttempt(Tracking t){
		list.add(t);
		if (t.getBoom() < minBoom) minBoom = t.getBoom();
		if (t.getBoom() > maxBoom) maxBoom = t.getBoom();
		totalBoom += t.getBoom();
		
		if (t.getTotalCost() < minCost) minCost = t.getTotalCost();
		if (t.getTotalCost() > maxCost) maxCost = t.getTotalCost();
		totalCost += t.getTotalCost();
		
		if (t.getAttempts() < minAttempt) minAttempt = t.getAttempts();
		if (t.getAttempts() > maxAttempt) maxAttempt = t.getAttempts();
		totalAttempt += t.getAttempts();
	}

	public ArrayList<Tracking> getList() {
		return new ArrayList<Tracking>(list);
	}
	public int getMinBoom() {
		return minBoom;
	}
	public int getMaxBoom() {
		return maxBoom;
	}
	public double getAvgBoom(){
		return ((double)totalBoom)/list.size();
	}
	public long getMinCost() {
		return minCost;
	}
	public long getMaxCost() {
		return maxCost;
	}
	public double getAvgCost(){
		return ((double)totalCost)/list.size();
	}
	public int getMinAttempt() {
		return minAttempt;
	}
	public int getMaxAttempt() {
		return maxAttempt;
	}
	public double getAvgAttempt(){
		return ((double)totalAttempt)/list.size();
	}
	public int getTrials(){
		return list.size();
	}
}
