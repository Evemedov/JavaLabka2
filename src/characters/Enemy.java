package characters;

import java.util.Random;

/**
 * Клас ворога який буде атакувати гравця та навпаки
 */
public class Enemy {
	/**
	 * Здоров'я ворога
	 */
	private int healthPoint;
	/**
	 * Броня ворога
	 */
	private int armor;
	/**
	 * Зброя ворога
	 */
	private Weapon weapon;
	/**
	 * Флаг чи живий зараз бот
	 */
	private boolean IsAlive;
	
	/**
	 * Конструктор класу
	 * @param lvlOfPlayer Левел гравця. Чим більший цей параметр тим більше здоров'я та броні буде мати бот
	 */
	public Enemy(int lvlOfPlayer) {
		Random random = new Random();
		float randFloat = random.nextFloat(0.8f, 1.2f);
		
		this.healthPoint = (int)(10 * lvlOfPlayer * randFloat);
		this.armor = (int)((1 + lvlOfPlayer) * randFloat);
		this.IsAlive = true;
		
		weapon = new Weapon( (int)((10 * lvlOfPlayer) * randFloat), 0.05 * lvlOfPlayer );
	}
	
	/**
	 * Виводить основні параметри ворога у консоль
	 * @return Строка с основними параметрами
	 */
	public String ToString() {
		String ret = "Має ";
		
		ret += this.healthPoint + " здоровя та ";
		ret += this.armor + " броні";
		
		return ret;
	}
	/**
	 * Віднімає здоров'я враховуючи броню та ігнорування броні. Також перевіряє чи не вмер бот після нанесеного урону
	 * @param damage Кількість хп яку треба відняти
	 * @param armorIgnoring Ігнорування броні зброї гравця
	 */
	public void damage(int damage, double armorIgnoring) {
		this.healthPoint -= damage - ((double)this.armor * armorIgnoring);
		if(this.healthPoint <= 0)
			this.IsAlive = false;
	}
	/**
	 * Повертає чи живий бот
	 * @return Повертає {@link characters.Enemy#IsAlive}
	 */
	public boolean getIsAlive() {
		return this.IsAlive;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	class Weapon {
		private int damage;
		private double armorIgnoring;
		
		public Weapon(int damage, double armorIgnoring) {
			this.damage = damage;
			this.armorIgnoring = armorIgnoring;
		}
		
		public int GetDamage() {
			return this.damage;
		}
		
		public double GetArmorIgnoring() {
			return this.armorIgnoring;
		}
	}
}
