package app;

import util.Equipment;
import util.Probability;
import util.Tracking;

public class Main {

	public static void main(String[] args) {
//		System.out.printf("%.7f",testProbability(0.99999));
		
		Tracking summary = testUpgradeCost(160, 20, 22);
		System.out.println(summary);
		
	}
	
	@SuppressWarnings("unused")
	private static double testProbability(double probability){
		int trials = 1000000;
		int total = 0;
		for (int i = 0; i < trials; i++) {
			total += Probability.roll(probability)? 1:0;
		}
		
		return ((double)total)/trials;
	}
	
	private static Tracking testEquip(Equipment equip, int goal){
		return Probability.upgrade(equip, goal);
	}
	
//	@SuppressWarnings("unused")
	private static Tracking testUpgradeCost(int lvl, int star, int goal){
		//Setup Equip
		Equipment equip = new Equipment();
		equip.setLvl(lvl);
		equip.setStar(star);
		
		System.out.println("Before");
		System.out.println(equip);
		
		//Simulate upgrade
		return testEquip(equip, goal);
		
//		System.out.println("After");
//		System.out.println(equip);
	}
	
}
