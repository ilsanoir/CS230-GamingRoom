package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// FIXME: obtain reference to the singleton instance
		GameService service = GameService.getInstance(); // replace null with ???
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game One");
		Team team1 = game1.addTeam("NerdGamers");
		Player player1 = team1.addPlayer("ilsanoir");
		Player player2 = team1.addPlayer("theomegarose");
		System.out.println(game1);
		System.out.println(team1);
		System.out.println(player1);
		System.out.println(player2);
		Game game2 = service.addGame("Game Two");
		Team team2 = game2.addTeam("TheBoys");
		Player player3 = team2.addPlayer("ATGravy");
		Player player4 = team2.addPlayer("Ravenir");
		System.out.println(game2);
		System.out.println(team2);
		System.out.println(player3);
		System.out.println(player4);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
