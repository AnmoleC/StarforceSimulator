package app;

import util.Equipment;
import util.Probability;

public class Main {

	public static void main(String[] args) {
//		System.out.printf("%.7f",testProbability(0.99999));
		testUpgradeCost(10, 1, 20);

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
	
	private static void testEquip(Equipment equip, int goal){
		Probability.upgrade(equip, goal);
	}
	
	@SuppressWarnings("unused")
	private static void testUpgradeCost(int lvl, int star, int goal){
		//Setup Equip
		Equipment equip = new Equipment();
		equip.setLvl(lvl);
		equip.setStar(star);
		
		System.out.println("Before");
		System.out.println(equip);
		
		//Simulate upgrade
		testEquip(equip, goal);
		
//		System.out.println("After");
//		System.out.println(equip);
	}
	
}
