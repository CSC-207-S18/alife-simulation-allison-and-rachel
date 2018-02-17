
public class Defector extends Organism{
	private int energy;
	public double coopProb;
	
	public Defector() {
		
	}
	
	public String getType() {
		return "Defector";
	}
	
	public Organism reproduce() {
		
	}
	
	public double getCooperationProbability() {
		return 0;
	}
	
	public boolean cooperates() {
		return false;
	}

}
