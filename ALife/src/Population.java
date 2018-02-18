import java.util.Map;
import java.util.ArrayList;
import java.util.Random; 

public class Population {

	int tick;
	public Map<String, Integer> counts;
	public ArrayList<Organism> Pop;
	public int populationSize;

	public Population(Map<String, Integer> counts) throws IllegalArgumentException {
		this.counts = counts;
		this.Pop = new ArrayList<Organism>();
		this.tick = 0;
		for (int i = 0; i < counts.get("Cooperator"); i++) {
			Cooperator org = new Cooperator();
			Pop.add(org);
		}
		for (int i = 0; i < counts.get("Defector"); i++) {
			Defector org = new Defector();
			Pop.add(org);
		}
		for (int i = 0; i < counts.get("PartialCooperator"); i++) {
			PartialCooperator org = new PartialCooperator();
			Pop.add(org);
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
			if (temp.getEnergy() >= 10) {
				Random numGenerator = new Random();
				int rand = Math.abs(numGenerator.nextInt());
				int indexRemove = rand % populationSize;
				String indexRemoveType = Pop.get(indexRemove).getType();
				int numRemove = counts.get(indexRemoveType);
				counts.put(indexRemoveType, numRemove - 1);
				Pop.remove(indexRemove);
				Organism addOrg = Pop.get(i).reproduce();
				int numAdd = counts.get(addOrg.getType());
				Pop.add(addOrg);
				counts.put(addOrg.getType(), numAdd + 1);
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
	
	public ArrayList<Organism> getPop() {
		return Pop;
	}
}

