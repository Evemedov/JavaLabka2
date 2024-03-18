package characters;

import MainPkg.MainClass;
import tools.*;

/**
 * Клас гравця яким гравець буде керувати впродовж гри
 */
public class Player {
	/**
	 * Ім'я гравця
	 */
	private String name;
	/**
	 * Левел гравця
	 */
	private int lvl;
	/**
	 * Здоров'я гравця
	 */
	private int healthPoint;
	/**
	 * Максимальне здоров'я гравця
	 */
	private int maxHP;
	/**
	 * Броня гравця
	 */
	private int armor;
	/**
	 * У якому підземеллі зараз гравець
	 */
	private int nowDungeon;
	/**
	 * Кількість зілля
	 */
	private int numOfPotion;
	/**
	 * Меч гравця
	 */
	private Sword sword;
	/**
	 * Спис гравця
	 */
	private Spear spear;
	/**
	 * Флаг чи живий зараз гравець
	 */
	private boolean IsAlive;
	
	/**
	 * Конструктор класу
	 * @param name Ім'я гравця
	 * @param sword Екземпляр меча який буде виданий гравцю
	 * @param spear Екземпляр списа який буде виданий гравцю
	 */
	public Player(String name, Sword sword, Spear spear) {
		this.name = name;
		this.healthPoint = 100;
		this.maxHP = 100;
		this.lvl = 1;
		this.nowDungeon = 1;
		this.armor = 10;
		this.numOfPotion = 0;
		this.IsAlive = true;
		
		this.sword = sword;
		this.spear = spear;
	}
	
	/**
	 * Виводить основні параметри гравця у консоль
	 * @return Строка с основними параметрами
	 */
	public String toString() {
		String ret = "";
		
		ret += "Ім'я гравця: " + this.name + "\n";
		ret += "Левел: " + this.lvl + "\n";
		ret += "Здоров'я: " + this.healthPoint + "\n";
		ret += "Максимальне здоров'я: " + this.maxHP + "\n";
		ret += "Броня: " + this.armor + "\n";
		ret += "Кількість зілля: " + this.numOfPotion + "\n";
		
		return ret;
	}
	/**
	 * Виводить основні параметри зброї у консоль
	 * @return Строка с основними параметрами
	 */
	public String weaponToString() {
		String ret = "";
		
		ret += this.sword.toString() + "\n";
		ret += this.spear.toString() + "\n";
		
		return ret;
	}
	/**
	 * Додає левел та здоров'я, броню, зілля та замінює зброю на кращі аналоги
	 */
	public void lvlUp() {
		this.healthPoint += 20;
		this.maxHP += 20;
		this.armor += 2;
		this.lvl += 1;
		this.numOfPotion += 1;
		
		int res = MainClass.userFunctions.getUsersInput("Що хочете вдосконалити? Меч(1) чи спис(2)?", 2);
		switch(res) {
		case 1:
			this.sword = MainClass.tools.getImprovedSword(sword);
			return;
		case 2:
			this.spear = MainClass.tools.getImprovedSpear(spear);
			return;
		}
	}
	
	/**
	 * Повертає ім'я гравця
	 * @return Повертає {@link characters.Player#name}
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Повертає здоров'я гравця
	 * @return Повертає {@link characters.Player#healthPoint}
	 */
	public int getHP() {
		return this.healthPoint;
	}
	/**
	 * Додає здоров'я та перевіряє чи не перевищує здоров'я {@link characters.Player#maxHP}
	 * @param hp Rількіть хп яке потрібно додати
	 */
	public void addHP(int hp) {
		hp = Math.abs(hp);
		if(this.healthPoint + hp > this.maxHP) {
			this.healthPoint = this.maxHP;
			return;
		}
		this.healthPoint += hp;
	}
	/**
	 * Віднімає здоров'я враховуючи броню та ігнорування броні. Також перевіряє чи не вмер гравець після нанесеного урону
	 * @param damage Кількість хп яку треба відняти
	 * @param armorIgnoring Ігнорування броні зброї
	 */
	public void damage(int damage, double armorIgnoring) {
		this.healthPoint -= damage - ((double)this.armor * armorIgnoring);
		if(this.healthPoint <= 0)
			this.IsAlive = false;
	}
	/**
	 * Додає до {@link characters.Player#nowDungeon} одиницю та додає лвл через кожні 3 підземелля
	 */
	public void dungeonUp() {
		this.nowDungeon++;
		if(this.nowDungeon % 3 == 0)
			this.lvlUp();
	}
	/**
	 * Перевіряє чи не дорівнює {@link characters.Player#numOfPotion} нулю та додає 50 здоров'я
	 */
	public void drinkPotion() {
		if(this.numOfPotion == 0)
			System.out.println("Нема зілля");
		else {
			addHP(50);
			this.numOfPotion--;
		}
	}
	/**
	 * Повертає левел гравця
	 * @return Повертає {@link characters.Player#lvl}
	 */
	public int getLvl() {
		return this.lvl;
	}
	/**
	 * Повертає чи живий гравець
	 * @return Повертає {@link characters.Player#IsAlive}
	 */
	public boolean getIsAlive() {
		return this.IsAlive;
	}
	/**
	 * Повертає екземпляр меча гравця
	 * @return Повертає {@link characters.Player#sword}
	 */
	public Sword getSword() {
		return this.sword;
	}
	/**
	 * Повертає екземпляр списа гравця
	 * @return Повертає {@link characters.Player#spear}
	 */
	public Spear getSpear() {
		return this.spear;
	}
	/**
	 * Повертає у якому підземеллі зараз гравець
	 * @return Повертає {@link characters.Player#nowDungeon}
	 */
	public int getDungeon() {
		return this.nowDungeon;
	}
	
}
