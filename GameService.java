package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton
	
	// First, create an object that will be the only instance of GameService
	// Making it null allows it to be tested as empty or with content that can be altered
	

	// Holds next team identifier
	private static long nextTeamId = 1;
	
	// Holds next player identifier
	private static long nextPlayerId = 1;
	
	
	private static GameService service =  null;
	
	// Then make a private, empty constructor 
	
	private GameService() {}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public static GameService getInstance() {
		if(service == null) {
			service = new GameService();
		}
		
		return service;
	}
	
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		if(getGame(name) != null) {
			game = getGame(name);
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		
		// Using a for/if loop and methods within the class, the games list
		// can be iterated through to check for existing games with the id
		for(int i = 0; i < getGameCount(); i++) {
			if (games.get(i).getId()==id) {
				game = games.get(i);
			}
		}
		

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		
		// Using a for/if loop and methods within the class, the games list
		// can be iterated through to check for existing games with the name
		for(int i = 0; i < getGameCount(); i++) {
			if (games.get(i).getName()== name) {
				game = games.get(i);
			}
		}
				
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	
	// Returns next team's identifier and then increments by 1
	public long getNextTeamId() {
		return nextTeamId++;
	}
		
	// Returns next player's identifier and then increments by 1
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	
}
