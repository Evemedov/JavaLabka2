package characters;

import java.util.ArrayList;
import java.util.List;

import MainPkg.MainClass;
import tools.Tools;

/**
 * Клас який керує всіма ворогами
 */
public class Enemies {
	/**
	 * Масив з екземплярами ворогів
	 */
	private List<Enemy> enemies;
	
	/**
	 * Ініціалізує масив {@link characters.Enemies#enemies}
	 */
	public Enemies() {
		this.enemies = new ArrayList<>();
	}
	
	/**
	 * Повертає кількість ворогів у масиві
	 * @return Повертає {@link characters.Enemies#enemies enemies.size()}
	 */
	public int getNumOfEnemies() {
		return this.enemies.size();
	}
	/**
	 * Повертає ворога за індексом
	 * @param index Індекс противника якого потрібно отримати
	 * @return Повертає противника за індексом
	 */
	public Enemy get(int index) {
		return enemies.get(index);
	}
	
	/**
	 * Створює противників та додає їх у {@link characters.Enemies#enemies}
	 * @param count Кількість противників
	 * @param tools Екземпляр класу {@link tools.Tools}
	 * @param player Екземпляр класу {@link characters.Player}
	 */
	public void SpawnEnemy(int count, Tools tools, Player player) {
		enemies.clear();
		for(int i = 0; i < count; i++) {
			enemies.add(new Enemy(player.getLvl() ));
		}
	}
	
	/**
	 * Віднімає від гравця зроров'я від кожного ворога
	 * @param player Екземпляр класу {@link characters.Player}
	 * @return Повертає чи вбили атаки ботів гравця
	 */
	public boolean enemyAttack(Player player) {
		for(int i = 0; i < enemies.size(); i++) {
			if(!enemies.get(i).getIsAlive()) 
				continue;
			
			int damage = enemies.get(i).getWeapon().GetDamage();
			player.damage(damage, enemies.get(i).getWeapon().GetArmorIgnoring());
			System.out.print("Вам нанесли " + damage + " урону ");
			
			if(!player.getIsAlive()) {
				System.out.println("та на жаль вбили вас");
				while(true) {
					System.out.println("Бажаете спробувати ще раз?(y, yes, n, no)");
					String input;
					try {
						input = MainClass.scanner.next();
					}
					catch(Exception ex) {
						continue;
					}
					
					if(input.equals("y") || input.equals("yes")) {
						return true;
					}
					else if(input.equals("n") || input.equals("no")){
						System.exit(0);
						return true;
					}
				}
			}
				
			System.out.print("\n");
			
		}
		return false;
	}
	/**
	 * Питає користувача якого ворога атакувати та має "захист від дурнів"
	 * @return Повертає індекс ворога якого обрав користувач
	 */
	public int getEnemyIndexToAttack() {
		while(true) {
			System.out.println("Якого ворога атакувати?");
			int res = MainClass.scanner.nextInt();
			if(res < 0 || res > enemies.size()) {
				System.out.println("Введіть номер противника (всього їх " + enemies.size() +")");
				continue;
			}
			else 
				return res;
		}
	}
	/**
	 * Повертає чи живий ворог за індексом
	 * @param index Індекс ворога
	 * @return Повертає чи живий ворог
	 */
	public boolean checkEnemyIfDead(int index) {
		boolean res = false;
		if(!enemies.get(index).getIsAlive()) {
			res = true;
			enemies.remove(index);
		}
		
		return res;
	}
	
	public void printEnemies() {
		for(int i = 0; i < enemies.size(); i++)
			if(enemies.get(i).getIsAlive()) {
				System.out.println((i + 1) + ". " + enemies.get(i).ToString());
			}
	}
}
