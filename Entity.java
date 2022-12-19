package com.gamingroom;

// The Entity class holds all common attributes
// And behaviors of the children classes (Game, Team and Player)

public class Entity {
	// Private attributes that will be passes to all children ID and Name
	private long id;
	private String name;
	
	// Protected default constructor for visibility and protection
	protected Entity() {}
	
	// Public constructor that assigns ID and Name
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// Method to call ID of Entity
	public long getId() {
		return id;
	}
	
	// Method to call Name of Entity
	public String getName() {
		return name;
	}
	
	public String toString() {
		
		return "Entity [id =" + id + ", name =" + name + "]";
	}
}
