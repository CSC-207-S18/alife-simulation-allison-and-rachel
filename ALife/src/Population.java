import java.util.Map;
import java.util.ArrayList;
import java.util.Random; 

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
		System.out.println(counts.get("Cooperator"));
		System.out.println(counts.get("Defector"));
		for (int i = 0; i < counts.get("Cooperator"); i++) {
			Cooperator org = new Cooperator();
			// maybe declare it as type Organism
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
		for (int i = 0; i < populationSize; i++) {
			System.out.println(Pop.get(i).getType());
		}
	}

	public void update() {
		//System.out.println(this.getPopulationCounts().get("Cooperator"));
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
				//System.out.println(rand%populationSize);
				Pop.remove(rand%populationSize);
				System.out.printf("\n" + temp.reproduce().getType() + "\n");
				Pop.add(temp.reproduce());
				String orgType = new String(temp.reproduce().getType());
				System.out.println("orgtype = " + orgType);
				int orgNum = counts.get(temp.getType());
				counts.put(orgType,orgNum++);
				System.out.println("orgnum = " + orgNum);
			}
		}
		//System.out.println(populationSize);
	}
	
	public double calculateCooperationMean() {
		double sum = 0;
		for (int i = 0; i < populationSize; i++) {
			System.out.println(Pop.get(i).getType());
		}
		for (int i = 0; i < populationSize; i++) {
			sum += Pop.get(i).getCooperationProbability();
			System.out.println(Pop.get(i).getType());
			System.out.println(Pop.get(i).getCooperationProbability());
			System.out.println(sum);
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

