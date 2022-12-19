package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	long id;
	String name;
	
	// List of current teams
	private List <Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Method that allows to add a team if it is unique
	public Team addTeam(String name) {
		Team team = null;
		
		//Look through the teams to check if the name is available
		//If unavailable returning existing team
		for(int i = 0; i < teams.size()-1; i++) {
			if (teams.get(i).getName()== name) {
				team = teams.get(i);
			}
		}
		
		//Otherwise, if available add unique team to list of teams
		if(team == null) {
			GameService service = GameService.getInstance();
			team = new Team(service.getNextTeamId(), name);
			teams.add(team);
		}
		
		return team;
	}
	// Removed redundant code post-inheritance
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
