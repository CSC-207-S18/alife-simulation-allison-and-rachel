
public class Defector extends Organism {
	private double coopProb;

	/**
	 * Constructor for the Defector subclass of Organism
	 */
	public Defector() {
		this.coopProb = 0;
	}
	
	/**
	 * Returns the type of the Organism, Defector
	 * 
 	 * @return "Defector", a String
	 */
	public String getType() {
		return "Defector";
	}

	/**
	 * Makes and return a new Organism of type Defector
	 * 
	 * @return the new Defector Organism
	 */
	public Organism reproduce() {
		Defector newOrg = new Defector();
		for (int i = 0; i < 10; i++) {
			this.decrementEnergy();
		}
		return newOrg;
	}

	/**
	 * returns the probability that the Defector will cooperate, 0.0
	 * 
	 * @return the cooperation probability of the Defector
	 */	
	public double getCooperationProbability() {
		return this.coopProb;
	}

	/**
	 * Returns if the Defector will cooperate
	 * 
	 * @return false
	 */	
	public boolean cooperates() {
		return false;
	}

}

