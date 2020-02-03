package app;

import java.text.NumberFormat;

import util.Equipment;
import util.Probability;
import util.Tracking;
import util.TrackingCollection;

public class Main {

	public static void main(String[] args) {
//		System.out.printf("%.7f",testProbability(0.99999, 1000000));
		
//		Tracking summary = testUpgradeCost(160, 20, 22);
//		System.out.println(summary);
		TrackingCollection set = trials(160, 10, 20, 100);
//		NumberFormat.getIntegerInstance().format()
		System.out.println("Min Attempts:" + set.getMinAttempt());
		System.out.println("Min Boom:" + set.getMinBoom());
		System.out.println("Min Cost:" + set.getMinCost());

		System.out.println("Max Attempts:" + set.getMaxAttempt());
		System.out.println("Max Boom:" + set.getMaxBoom());
		System.out.println("Max Cost:" + set.getMaxCost());
		
		System.out.println("AVG Attempts:" + set.getAvgAttempt());
		System.out.println("AVG Boom:" + set.getAvgBoom());
		System.out.println("AVG Cost:" + set.getAvgCost());
	}
	
	@SuppressWarnings("unused")
	private static double testProbability(double probability, int trials){
		int total = 0;
		for (int i = 0; i < trials; i++) {
			total += Probability.roll(probability)? 1:0;
		}
		
		return ((double)total)/trials;
	}
	
	private static Tracking testEquip(Equipment equip, int goal){
		System.out.println(equip);
		return Probability.upgrade(equip, goal);
	}
	
//	@SuppressWarnings("unused")
	private static Tracking testUpgradeCost(int lvl, int star, int goal){
		Equipment equip = new Equipment();
		equip.setLvl(lvl);
		equip.setStar(star);
		
		//Simulate upgrade
		return testEquip(equip, goal);
	}
	
	private static TrackingCollection trials(int lvl, int star, int goal, int trials){
		TrackingCollection set = new TrackingCollection();
		for (int i = 0; i < trials; i++) {
			Tracking t = testUpgradeCost(lvl, star, goal);
			set.addAttempt(t);
//			System.out.println("Attempt" + i);
		}

		return set;
	}
	
}
