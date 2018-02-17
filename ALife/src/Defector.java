
public class Defector extends Organism {
	// private int energy;
	public double coopProb;

	public Defector() {
		this.coopProb = 0;
	}

	public String getType() {
		return "Defector";
	}

	public Organism reproduce() {
		PartialCooperator newOrg = new PartialCooperator();
		for (int i = 0; i < 10; i++) {
			this.decrementEnergy();
		}
		return newOrg;
	}

	public double getCooperationProbability() {
		return 0;
	}

	public boolean cooperates() {
		return false;
	}

}
