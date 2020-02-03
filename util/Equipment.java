package util;

public class Equipment {
	private int lvl;
	private int star;
	private int boomCost;
	private long totalUpgradeCost;

	public int upgradeCost(){
		int result = -1;;
		if(			star>=0 && star<=9){
			result = 1000 + (((int)Math.round(Math.pow(lvl, 3)))*(star+1)/25);

		}else if( 	star>=10 && star<=14){
			result = 1000 + ((int)Math.round(Math.pow(lvl, 3)))*((int)Math.round(Math.pow(star + 1, 2.7)/400));
		
		}else if( 	star>=15 && star<=17){
			result = 1000 + ((int)Math.round(Math.pow(lvl, 3)))*((int)Math.round(Math.pow(star + 1, 2.7)/120));
		}else if( 	star>=18 && star<=19){
		
			result = 1000 + ((int)Math.round(Math.pow(lvl, 3)))*((int)Math.round(Math.pow(star + 1, 2.7)/110));
		
		}else if( 	star>=20 && star<=24){
			result = 1000 + ((int)Math.round(Math.pow(lvl, 3)))*((int)Math.round(Math.pow(star + 1, 2.7)/100));
		}
//		System.out.println("UPGRADE:"+result);
		return result;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = Math.floorDiv(lvl, 10)*10;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		if(star < 0)
			this.star = 0;
		else if (star > 25)
			star = 25;
		else
			this.star = star;
	}
	
	public void addStar(int diff){
		setStar(star + diff);
	}

	public int getBoomCost() {
		return boomCost;
	}

	public void setBoomCost(int boomCost) {
		this.boomCost = boomCost;
	}
	
	public long getTotalUpgradeCost(){
		return totalUpgradeCost;
	}
	
	public void setTotalUpgradeCost(long mesoCost){
		totalUpgradeCost = mesoCost;
	}
	
	public void addTotalUpgradeCost(long mesoCost){
		totalUpgradeCost += mesoCost;
	}

	@Override
	public String toString() {
		return "Equipment [lvl=" + lvl + ", star=" + star + ", totalUpgradeCost=" + totalUpgradeCost + "]";
	}
}
