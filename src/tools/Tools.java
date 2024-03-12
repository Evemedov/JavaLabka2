package tools;

import MainPkg.MainClass; 

/**
 * Клас Tools представляє збірку зброї
 */
public class Tools {
	/**
	 * Масив об'єктів {@link tools.Sword}
	 */
	private Sword[] swords;
	/**
	 * Кількість мечів
	 */
	private int numOfSwords;
	
	/**
	 * Масив об'єктів {@link tools.Spear}
	 */
	private Spear[] spears;
	/**
	 * Кількість списів
	 */
	private int numOfSpears;
	
	/**
     * Конструктор класу {@link tools.Tools}, ініціалізує колекцію мечів та копій
     */
	public Tools() {
		this.numOfSwords = 6;
		swords = new Sword[this.numOfSwords];
		this.swords[0] = new Sword("Дерев'яний меч", 0, 4, 6, 0);
		this.swords[1] = new Sword("Залізний меч", 1, 6, 8, 0);
		this.swords[2] = new Sword("Зачарований меч", 2, 7, 8, 0);
		this.swords[3] = new Sword("Золотий меч", 3, 9, 10, 0);
		this.swords[4] = new Sword("Кобальтовий меч", 4, 11, 13, 0);
		this.swords[5] = new Sword("Катана", 5, 6, 16, 0);
		
		this.numOfSpears = 3;
		this.spears = new Spear[this.numOfSpears];
		this.spears[0] = new Spear("Мідний спис", 0, 7, 1, 0.5);
		this.spears[1] = new Spear("Залізний спис", 1, 10, 2, 0.7);
		this.spears[2] = new Spear("Міфріловий спис", 2, 14, 4, 0.8);
	}
	/**
     * Повертає випадковий меч
     *
     * @return Випадковий об'єкт {@link tools.Sword}
     */
	public Sword getRandomSword() {
		int randID = (int)Math.round(Math.random() * (this.numOfSwords - 1));
		return this.swords[randID];
	}
	/**
     * Повертає випадковий вибраний меч у визначеному діапазоні
     * @param fromIndex Початковий індекс
     * @param toIndex Кінцевий індекс
     * @return Випадковий об'єкт {@link tools.Sword} у визначеному діапазоні
     */
	public Sword getRandomSword(int fromIndex, int toIndex) {
		if(fromIndex > toIndex || fromIndex > (this.numOfSwords - 1)) {
			fromIndex = 0;
			MainClass.debugLog("Warning: uncorrecr value fromIndex in tools.GetRandomSword(int fromIndex, int toIndex)");
		}
			
		int randID = (int)Math.round(Math.random() * Math.min((this.numOfSwords - 1), toIndex) + fromIndex);
		return this.swords[randID];
	}
	/**
     * Повертає випадковий спис
     * @return Випадковий об'єкт {@link tools.Spear}
     */
	public Spear getRandomSpear() {
		int randID = (int)Math.round(Math.random() * (this.numOfSpears - 1));
		return this.spears[randID];
	}
	/**
     * Повертає випадковий вибраний спис у визначеному діапазоні
     * @param fromIndex Початковий індекс
     * @param toIndex Кінцевий індекс
     * @return Випадковий об'єкт {@link tools.Spear} у визначеному діапазоні
     */
	public Spear getRandomSpear(int fromIndex, int toIndex) {
		if(fromIndex > toIndex || fromIndex > (this.numOfSpears - 1)) {
			fromIndex = 0;
			MainClass.debugLog("Warning: uncorrecr value fromIndex in tools.getRandomSpear(int fromIndex, int toIndex)");
		}
			
		int randID = (int)Math.round(Math.random() * Math.min((this.numOfSpears - 1), toIndex) + fromIndex);
		return this.spears[randID];
	}
	/**
     * Повертає покращену версію меча
     * @param sword Вхідний меч
     * @return Покращена версія вхідного меча
     */
	public Sword getImprovedSword(Sword sword) {
		if(sword.GetID() >= this.numOfSwords - 1) {
			MainClass.debugLog("Warning: Not found improved sword");
			return sword;
		}
		
		return this.swords[sword.GetID() + 1];
	}
	/**
     * Повертає покращену версію списа
     * @param spear Вхідний спис
     * @return Покращена версія вхідного списа
     */
	public Spear getImprovedSpear(Spear spear) {
		if(spear.GetID() >= this.numOfSwords - 1) {
			MainClass.debugLog("Warning: Not found improved spear");
			return spear;
		}
		
		return this.spears[spear.GetID() + 1];
	}
}
