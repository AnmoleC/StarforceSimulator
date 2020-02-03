package util;

public class Probability {
	private static double[] success = { 0.95, 0.90, 0.85, 0.85, 0.80, 
										0.75, 0.70, 0.65, 0.60, 0.55, 
										0.50, 0.45, 0.4 , 0.35, 0.30,
										0.30, 0.30, 0.30, 0.30, 0.30, 
										0.30, 0.30, 0.03, 0.02, 0.01};

	private static double[] fail = {	0.05, 0.10, 0.15, 0.15, 0.20,
										0.25, 0.30, 0.35, 0.40, 0.45, 
										0.50, 0.55, 0.60, 0.65, 0.70,
										0.70, 0.70, 0.70, 0.70, 0.70,
										0.70, 0.70, 0.97, 0.98, 0.99};

	private static double[] boom = {	0, 0, 0, 0, 0,
										0, 0, 0, 0, 0,
										0, 0, 0.01, 0.02, 0.02,
										0.03, 0.03, 0.03, 0.04, 0.04,
										0.10, 0.10, 0.20, 0.30, 0.40};

	private static boolean eventDiscount = false;
	private static boolean payRemoveBoom = false;
		
	public static boolean roll (double probability){
		if (probability == 0.0) return false;
		if (probability == 1.0) return true;
		
		return Math.random() < probability;
	}
	
	public static void upgrade(Equipment equip, int goal){
		boolean result;
		while(equip.getStar() < goal && equip.getStar() < 25){
			equip.addTotalUpgradeCost(equip.upgradeCost());
			result = roll(success[equip.getStar()]);
			if(result){
				//Success
				equip.addStar(1);
			}else{
				result = roll(boom[equip.getStar()]);
				if(result){
					//Boom
					System.out.println("Boomed");
					equip.addTotalUpgradeCost(equip.getBoomCost());
					equip.setStar(12);
				}
				//Fail (Keep)
			}
			System.out.println(equip);
		}
	}
	
	public static void event51015(){
		success[5] = 1.0;
		success[10] = 1.0;
		success[15] = 1.0;
	}
	
	public static void noEvent(){
		success[5] = 0.75;
		success[10] = 0.50;
		success[15] = 0.3;
	}

	public static boolean isEventDiscount() {
		return eventDiscount;
	}

	public static void setEventDiscount(boolean eventDiscount) {
		Probability.eventDiscount = eventDiscount;
	}

	public static boolean isPayRemoveBoom() {
		return payRemoveBoom;
	}

	public static void setPayRemoveBoom(boolean payRemoveBoom) {
		Probability.payRemoveBoom = payRemoveBoom;
	}

	public static double[] getSuccess() {
		return success;
	}

	public static double[] getFail() {
		return fail;
	}

	public static double[] getBoom() {
		return boom;
	}
	
}
