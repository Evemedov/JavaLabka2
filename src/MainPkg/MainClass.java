package MainPkg;

import java.util.Scanner;

import characters.*;
import tools.*;
/**
 * Головний клас гри.
 */
public class MainClass {
	/**
	 * Флаг який показує чи працює ще гра
	 */
	private static boolean GameRun;
	/**
	 * Флаг який визначає чи потрібно виводити додаткові строки для розробника
	 */
	private static boolean isDebug;
	
	/**
	 * Публічний екземпляр сканера для вводу даних з консолі
	 */
	public static Scanner scanner;
	/**
	 * Екземпляр гравця 
	 */
	private static Player player;
	/**
	 * Екземпляр всьої зброї
	 */
	public static Tools tools;
	/**
	 * Екземпляр класу який має масив всіх поточних ворогів
	 */
	private static Enemies enemies;
	
	/**
	 * Головний метод гри, точка входу
	 * @param args Аргументи. Наразі гра може прийняти тільки аргумент "debug" 
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		tools = new Tools();
		enemies = new Enemies();
		
		isDebug = false;
		if(args.length != 0 && args[0].equals("debug"))
			isDebug = true;
		
		GameInit();
		
		String inputStr;
		int input = 0;
		while(GameRun) {
			System.out.println("Перед вами стоять " + enemies.getNumOfEnemies() + " противників:");
			
			for(int i = 0; i < enemies.getNumOfEnemies(); i++)
				if(enemies.get(i).getIsAlive()) {
					System.out.println((i + 1) + ". " + enemies.get(i).ToString());
				}
					
			System.out.println("Що будемо робити?\n"
					+ "1. Подивитися в дзеркальце\n"
					+ "2. Подивитися на зброю\n"
					+ "3. Атакувати мечом\n"
					+ "4. Атакувати списом\n"
					+ "5. Випити зілля регенерації (+50HP)\n"
					+ "6. Здатися (вийти з гри)");
			try {
				inputStr = "";
				inputStr = scanner.nextLine();
				
				if(inputStr == "")
					inputStr = scanner.nextLine();
				input = Integer.parseInt(inputStr);
			}
			catch(Exception ex) {
				System.out.println("Введіть нормальне значення");
				continue;
			}
			
			switch (input) {
			case 1:
				System.out.println(player.toString());
				break;
			case 2:
				System.out.println(player.weaponToString());
				break;
			case 3:
				playerAttack(true);
				break;
			case 4:
				playerAttack(false);
				break;
			case 5:
				player.drinkPotion();
				enemies.enemyAttack(player);
				break;
			case 6:
				debugLog("Debug: Exit");
				System.exit(0);
			default:
				System.out.println("Введіть нормальне значення");
				continue;
			}
		}
	}
	
	/**
	 * Ініціалізація гри, викликається при створенні нової гри або під час першого запуску. Створення екземпляру гравця, спавн ворогів
	 */
	private static void GameInit() {
		GameRun = true;
		
		System.out.println("Як назвати гравця?");
		String namePlayer = scanner.nextLine();
		player = new Player(namePlayer, tools.getRandomSword(), tools.getRandomSpear());
		
		enemies.SpawnEnemy(1, tools, player);
		
		debugLog("Debug: Game Initilizated");
	}
	
	/**
	 * Атака гравця та перевірка чи вмерли боти або гравець
	 * @param isSword true - Атака мечом, false - атака списом
	 */
	private static void playerAttack(boolean isSword) {
		int input = enemies.getEnemyIndexToAttack();
		
		int damage;
		if(isSword) {
			damage = player.getSword().GetRandomDamage();
			enemies.get(input - 1).damage(damage, player.getSword().GetArmorIgnoring());
		}
		else {
			damage = player.getSpear().GetRandomDamage();
			enemies.get(input - 1).damage(damage, player.getSpear().GetArmorIgnoring());
		}
		
		System.out.print("Ви нанесли " + damage + " урона ");
		
		if(enemies.checkEnemyIfDead(input - 1)) 
			System.out.print("та вбили ворога");
		System.out.print("\n");
		
		if(enemies.enemyAttack(player))
			GameInit();
		
		if(enemies.getNumOfEnemies() == 0) {
			System.out.println("Ви пройшли " + player.getDungeon() + " підземелля");
			player.dungeonUp();
			enemies.SpawnEnemy(player.getDungeon() / 2 + 1, tools, player);
		}
	}
	
	/**
	 * Публічний метод який від залежності від флага {@link MainPkg.MainClass#isDebug} буде виводити строку str
	 * @param str строка яку потрібно вивести
	 */
	public static void debugLog(String str) {
		if(isDebug)
			System.out.println(str);
	}
}
