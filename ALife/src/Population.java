import java.util.Map;
import java.util.ArrayList;

public class Population {

	int tick;
	public Map<String, Integer> counts;
	public ArrayList<Organism> Pop;
	public int populationSize;
	// public ArrayList<Organism> defectElements;
	// public ArrayList<Organism> partialElements;

	public Population(Map<String, Integer> counts) throws IllegalArgumentException {
		this.counts = counts;
		this.Pop = new ArrayList<Organism>();
		// this.defectElements = new ArrayList<Organism>();
		// this.partialElements = new ArrayList<Organism>();
		this.tick = 0;

		for (int i = 0; i < counts.get("Cooperator"); i++) {
			Cooperator org = new Cooperator();
			// maybe declare it as type Organism
			Pop.add(org);
			org.coopProb = 1;
		}
		for (int i = 0; i < counts.get("Defector"); i++) {
			Defector org = new Defector();
			Pop.add(org);
		}
		for (int i = 0; i < counts.get("PartialCooperator"); i++) {
			PartialCooperator org = new PartialCooperator();
			Pop.add(org);
			org.coopProb = .5;
		}
		this.populationSize = counts.get("PartialCooperator") + counts.get("Defector") + counts.get("Cooperator");
	}

	public void update() {
		for (int i = 0; i < populationSize; i++) {
			Organism temp = Pop.get(i);
			temp.update();
			if (temp.cooperates()) {
				temp.decrementEnergy();
				/* Incrementing the energy of 8 other organisms */
				for (int j = i; j < (i + 8); j++) {
					Pop.get(j % populationSize).incrementEnergy();
				}

			}
		}
	}
	
	public double calculateCooperationMean() {
		double sum = 0;
		for (int i = 0; i < populationSize; i++) {
			sum += Pop.get(i).getCooperationProbability();
		}
		return (sum / populationSize);
	}

	public Map<String, Integer> getPopulationCounts(){
		return this.counts;
	}
}

