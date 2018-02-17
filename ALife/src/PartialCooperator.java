import java.util.Random; 

public class PartialCooperator extends Organism {
	// private int energy;
	public double coopProb;

	public PartialCooperator() {
		this.coopProb = .5;
	}

	public String getType() {
		return "PartialCooperator";
	}

	public Organism reproduce() {
		PartialCooperator newOrg = new PartialCooperator();
		for (int i = 0; i < 10; i++) {
			this.decrementEnergy();
		}
		return newOrg;
	}

	public double getCooperationProbability() {
		return .5;
	}

	public boolean cooperates() {
		Random numGenerator = new Random();
		int rand = numGenerator.nextInt();
		return (rand%2 == 0);
	}

}
