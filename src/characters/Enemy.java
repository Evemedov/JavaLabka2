package characters;

import tools.Spear;
import tools.Sword;

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
	 * Меч ворога
	 */
	private Sword sword;
	/**
	 * Спис ворога
	 */
	private Spear spear;
	/**
	 * Флаг чи живий зараз бот
	 */
	private boolean IsAlive;
	
	/**
	 * Конструктор класу
	 * @param sword Екземпляр меча який буде виданий гравцю
	 * @param spear Екземпляр списа який буде виданий гравцю
	 * @param lvlOfPlayer Левел гравця. Чим більший цей параметр тим більше здоров'я та броні буде мати бот
	 */
	public Enemy(Sword sword, Spear spear, int lvlOfPlayer) {
		this.healthPoint = 10 * lvlOfPlayer;
		this.armor = 1 + lvlOfPlayer;
		this.IsAlive = true;
		
		this.sword = sword;
		this.spear = spear;
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
	/**
	 * Повертає меч ворога
	 * @return Повертає {@link characters.Enemy#sword}
	 */
	public Sword getSword() {
		return this.sword;
	}
	/**
	 * Повертає спис ворога
	 * @return Повертає {@link characters.Enemy#spear}
	 */
	public Spear getSpear() {
		return this.spear;
	}
}
