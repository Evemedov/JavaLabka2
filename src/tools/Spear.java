package tools;

/**
 * Клас спису
 */
public class Spear {
	/**
	 * Ім'я списа
	 */
	private String name;
	/**
	 * ID списа
	 */
	private int ID;
	/**
	 * Пронікний урон від списа
	 */
	private int prickingDamage;
	/**
	 * Ріжучий урон від списа
	 */
	private int cuttingDamage;
	/**
	 * Ігнорування броні при атаці 
	 */
	private double armorIgnoring;
	
	/**
	 * Конструктор класу
	 * @param name Ім'я зброї
	 * @param ID ID зброї
	 * @param prickingDamage урон зброї 
	 * @param cuttingDamage Ріжучий урон зброї 
	 * @param armorIgnoring Ігнорування броні 
	 */
	public Spear(String name, int ID, int prickingDamage, int cuttingDamage, double armorIgnoring) {
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
		
		ret += "Мій спис:\n";
		ret += "" + this.name + "\n";
		ret += "Проникний урон: " + this.prickingDamage + "\n";
		ret += "Ріжучий урон: " + this.cuttingDamage + "\n";
		ret += "Ігнорування броні: " + this.armorIgnoring + "\n";
		
		return ret;
	}
	/**
	 * Повертає пронікний урон від списа
	 * @return Повертає {@link tools.Spear#prickingDamage}
	 */
	public int GetPrickingDamage() {
		return this.prickingDamage;
	}
	/**
	 * Повертає ріжучий урон від списа
	 * @return Повертає {@link tools.Spear#cuttingDamage}
	 */
	public int GetCuttingDamage() {
		return this.cuttingDamage;
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
	 * Повертає ігнорування броні при атаці 
	 * @return Повертає {@link tools.Spear#armorIgnoring}
	 */
	public double GetArmorIgnoring() {
		return this.armorIgnoring;
	}
	/**
	 * Повертає ID списа
	 * @return Повертає {@link tools.Spear#ID}
	 */
	public int GetID() {
		return this.ID;
	}
}
