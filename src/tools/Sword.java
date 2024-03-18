package tools;

/**
 * Клас меча
 */
public class Sword {
	/**
	 * Ім'я меча
	 */
	private String name;
	/**
	 * ID меча
	 */
	private int ID;
	/**
	 * Пронікний урон від меча
	 */
	private int prickingDamage;
	/**
	 * Ріжучий урон від меча
	 */
	private int cuttingDamage;
	/**
	 * Ігнорування броні при атаці 
	 */
	private double armorIgnoring;
	
	/**
	 * 
	 * @param name Ім'я зброї
	 * @param ID ID зброї
	 * @param prickingDamage урон зброї 
	 * @param cuttingDamage Ріжучий урон зброї 
	 * @param armorIgnoring Ігнорування броні 
	 */
	public Sword(String name, int ID, int prickingDamage, int cuttingDamage, double armorIgnoring) {
		this.name = name;
		this.ID = ID;
		this.prickingDamage = prickingDamage;
		this.cuttingDamage = cuttingDamage;
		this.armorIgnoring = armorIgnoring;
	}
	/**
	 * Виводить основні параметри зброї у консоль
	 */
	public String toString() {
		String ret = "";
		
		ret += "Мій меч:\n";
		ret += "" + this.name + "\n";
		ret += "Проникний урон: " + this.prickingDamage + "\n";
		ret += "Ріжучий урон: " + this.cuttingDamage + "\n";
		ret += "Ігнорування броні: " + this.armorIgnoring + "\n";
		
		return ret;
	}
	
	/**
	 * Повертає рандомно або ріжучий або пронікний урон
	 * @return Урон зброї
	 */
	public int GetRandomDamage() {
		int rand = (int)Math.round(Math.random());
		if(rand == 1)
			return this.prickingDamage;
		else
			return this.cuttingDamage;
	}
	/**
	 * Повертає пронікний урон від меча
	 * @return Повертає {@link tools.Sword#prickingDamage}
	 */
	public int GetPrickingDamage() {
		return this.prickingDamage;
	}
	/**
	 * Повертає ріжучий урон від меча
	 * @return Повертає {@link tools.Sword#cuttingDamage}
	 */
	public int GetCuttingDamage() {
		return this.cuttingDamage;
	}
	/**
	 * Повертає ігнорування броні при атаці 
	 * @return Повертає {@link tools.Sword#armorIgnoring}
	 */
	public double GetArmorIgnoring() {
		return this.armorIgnoring;
	}
	/**
	 * Повертає ID меча
	 * @return Повертає {@link tools.Sword#ID}
	 */
	public int GetID() {
		return this.ID;
	}
	
}

