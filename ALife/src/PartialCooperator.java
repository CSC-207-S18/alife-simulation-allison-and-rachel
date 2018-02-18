import java.util.Random; 

public class PartialCooperator extends Organism {

	private double coopProb;

	/**
	 * Constructor for the PartialCooperator subclass of Organism
	 */
	public PartialCooperator() {
		this.coopProb = .5;
	}

	/**
 	* Returns the type of the Organism, PartialCooperator
	* 
	* @return "PartialCooperator", a String
	*/
	public String getType() {
		return "PartialCooperator";
	}
	
	/**
	 * Makes and return a new Organism of type PartialCooperator
	 * 
	 * @return the new PartialCooperator Organism
	 */
	public Organism reproduce() {
		PartialCooperator newOrg = new PartialCooperator();
		for (int i = 0; i < 10; i++) {
			this.decrementEnergy();
		}
		return newOrg;
	}

	/**
	 * returns the probability that the PartialCooperator will cooperate, 0.5
	 * 
	 * @return the cooperation probability of the PartialCooperator
	 */
	public double getCooperationProbability() {
		return this.coopProb;
	}

	/**
	 * Returns if the PartialCooperator will cooperate using a random number generator
	 * 
	 * @return a boolean
	 */
	public boolean cooperates() {
		Random numGenerator = new Random();
		int rand = numGenerator.nextInt();
		return (rand%2 == 0);
	}
}
