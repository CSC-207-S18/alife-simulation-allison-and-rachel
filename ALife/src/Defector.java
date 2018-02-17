
public class Defector extends Organism {
	private double coopProb;

	public Defector() {
		this.coopProb = 0;
	}

	public String getType() {
		return "Defector";
	}

	public Organism reproduce() {
		Defector newOrg = new Defector();
		for (int i = 0; i < 10; i++) {
			this.decrementEnergy();
		}
		return newOrg;
	}

	public double getCooperationProbability() {
		return this.coopProb;
	}

	public boolean cooperates() {
		return false;
	}

}
