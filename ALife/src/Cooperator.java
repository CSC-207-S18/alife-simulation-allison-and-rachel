
public class Cooperator extends Organism{

	private int energy;
	public double coopProb;
	
	public Cooperator() {
		
	}
	
	public String getType() {
		return "Cooperator";
	}
	
	public Organism reproduce() {
		
	}
	
	public double getCooperationProbability() {
		return 1;
	}
	
	public boolean cooperates() {
		return true;
	}
}
