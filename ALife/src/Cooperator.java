
public class Cooperator extends Organism {

	public double coopProb;

	public Cooperator() {
		super();
		this.coopProb = 1;
	}

	public String getType() {
		return "Cooperator";
	}

	public Organism reproduce() {
		Cooperator newOrg = new Cooperator();
		for (int i = 0; i < 10; i++) {
			this.decrementEnergy();
		}
		return newOrg;
	}

	public double getCooperationProbability() {
		return 1;
	}

	public boolean cooperates() {
		return true;
	}
}
