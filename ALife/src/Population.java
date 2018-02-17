import java.util.Map;
import java.util.ArrayList;

public class Population {

	public Map<String, Integer> counts;
	public ArrayList<Organism> coopElements;
	public ArrayList<Organism> defectElements;
	public ArrayList<Organism> partialElements;
	
	public Population (Map<String, Integer> counts) {
		this.counts = counts;
		this.coopElements = new ArrayList<Organism>();
		this.defectElements = new ArrayList<Organism>();
		this.partialElements = new ArrayList<Organism>();
		
		for(int i = 0; i < counts.get("Cooperator"); i++) {
			Organism org = new Organism();
			coopElements.add(org);
			org.coopProb = 1;
		}
		for(int i = 0; i < counts.get("Defector"); i++) {
			Organism org = new Organism();
			defectElements.add(org);
		}
		for(int i = 0; i < counts.get("PartialCooperator"); i++) {
			Organism org = new Organism();
			partialElements.add(org);
			org.coopProb = .5;
		}
	}
	
	
	
	public void update () {
		for (int i = 0; i < counts.get("Cooperator"); i++) {
			org.update();//do on specific organism
			org.decrementEnergy();
			//inc energy of 8 other orgs
			
		}
	}
	
}
