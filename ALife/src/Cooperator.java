

public class Cooperator extends Organism {

	private double coopProb;

	/**
	 * Constructor for the Cooperator subclass of Organism
	 */
	public Cooperator() {
		super();
		this.coopProb = 1;
		
	}

	/**
 	* Returns the type of the Organism, Cooperator
 	* 
	* @return "Cooperator", a String
 	*/
	public String getType() {
		return "Cooperator";
	}

	/**
	 * Makes and return a new Organism of type Cooperator
	 * 
	 * @return the new Cooperator Organism
	 */
	public Organism reproduce() {
		Cooperator newOrg = new Cooperator();
		for (int i = 0; i < 10; i++) {
			this.decrementEnergy();
		}
		return newOrg;
	}

	/**
	 * returns the probability that the Cooperator will cooperate, 1.0
	 * 
	 * @return the cooperation probability of the Cooperator
	 */
	public double getCooperationProbability() {
		return this.coopProb;
	}

	/**
	 * Returns if the Cooperator will cooperate
	 * 
	 * @return true
	 */
	public boolean cooperates() {
		return true;
	}
}

