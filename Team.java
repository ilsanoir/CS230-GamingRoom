package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	long id;
	String name;
	
	// List of current players
	private List <Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	// Method that allows to add a player if it is unique
		public Player addPlayer(String name) {
			Player player = null;
			
			//Look through the players to check if the name is available
			//If unavailable returning existing player
			for(int i = 0; i < players.size()-1; i++) {
				if (players.get(i).getName()== name) {
					player = players.get(i);
				}
			}
			
			//Otherwise, if available add unique team to list of teams
			if(player == null) {
				GameService service = GameService.getInstance();
				player = new Player(service.getNextPlayerId(), name);
				players.add(player);
			}
			
			return player;
		}

	// Removed redundant code post-inheritance
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
