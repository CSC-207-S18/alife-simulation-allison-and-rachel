
public abstract class Organism {
	private int energy;
	/** 
	Default constructor for Organism class
	*/
	public Organism() {
		this.energy = 0;
	}
	
	/**
	Update method increments the organism's energy
	*/
	public void update() {
		this.energy += 1;
	}
	
	/**
	Getter for the energy field
	*/
	public int getEnergy() {
		return this.energy;
	}
	
	/**
	Setter for the energy field
	*/
	public void setEnergy(int newEnergy) {
		if (newEnergy >= 0) { //Guarding against improper input
			this.energy = newEnergy;
		}//if
	}

	/**
	Increments energy field, used in update method in Population class
	*/
	public void incrementEnergy() {
		this.energy += 1;
	}
	
	/**
	Decrements energy field, used in update method in Population class
	*/
	public void decrementEnergy() {
		if (this.energy > 0)
			this.energy -= 1;
	}
	
	/**
	Returns the type of the Organism object on which it is called
	@return type, a String
	*/
	public abstract String getType();

	/**
	Creates 1 new organism of the same type as the Organism object on which it is called
	Subtracts 10 from the energy field of the Organism object on which it is called
	@return newOrg, the Organism which was made
	*/
	public abstract Organism reproduce();

	/**
	Getter for an organism's coopProb field, which is defined in each subclass of Organism
	*/
	public abstract double getCooperationProbability();

	/**
	Determines whether or not a particular organism will cooperate
	@return true, if the organism will cooperate
	@return false, if the organism won't cooperate 
	*/
	public abstract boolean cooperates();

}

