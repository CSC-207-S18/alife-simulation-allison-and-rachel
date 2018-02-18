import java.util.Map;
import java.util.ArrayList;
import java.util.Random; 

public class Population {

	int tick; //Tracks the number of updates
	public Map<String, Integer> counts; //Stores the number of organisms of each subtype in the population
	public ArrayList<Organism> Pop; //Stores the organisms in the population
	public int populationSize; //The number of organisms in the population

	/**
	Constructor for the Population class
	@param Map<String, Integer> counts, a map which associates names of subtypes of organisms (that's the String key) 
		with the number of organisms of that particular subtype (that's the Integer value)
	@throws IllegalArgumentException 
	*/
	public Population(Map<String, Integer> counts) throws IllegalArgumentException {
		//Initializing fields
		this.counts = counts;
		this.Pop = new ArrayList<Organism>();
		this.tick = 0;
		//Adding the appropriate number of organisms of each type to the ArrayList Pop
		for (int i = 0; i < counts.get("Cooperator"); i++) {
			Cooperator org = new Cooperator();
			Pop.add(org);
		}//for
		for (int i = 0; i < counts.get("Defector"); i++) {
			Defector org = new Defector();
			Pop.add(org);
		}//for
		for (int i = 0; i < counts.get("PartialCooperator"); i++) {
			PartialCooperator org = new PartialCooperator();
			Pop.add(org);
		}//for
		this.populationSize = counts.get("PartialCooperator") + counts.get("Defector") + counts.get("Cooperator");
	}//Population

	/**
	Handles reproduction and cooperation for each organism in Pop
	*/
	public void update() {
		for (int i = 0; i < populationSize; i++) {
			Organism temp = Pop.get(i);
			temp.update();
			if (temp.cooperates()) {
				temp.decrementEnergy();
				// Incrementing the energy of 8 other organisms 
				for (int j = i; j < (i + 8); j++) {
					Pop.get(j % populationSize).incrementEnergy();
				}//for j
			}//if
			//If there's enough energy, reproducing
			if (temp.getEnergy() >= 10) {
				//Determining which organism to replace
				Random numGenerator = new Random();
				int rand = Math.abs(numGenerator.nextInt());
				int indexRemove = rand % populationSize;
				
				//Decreasing the number of organisms stored in the removed organism's subtype in the map
				String indexRemoveType = Pop.get(indexRemove).getType();
				int numRemove = counts.get(indexRemoveType);
				counts.put(indexRemoveType, numRemove - 1);
				Pop.remove(indexRemove);
				
				//Adding new organism 
				Organism addOrg = Pop.get(i).reproduce();
				int numAdd = counts.get(addOrg.getType());
				Pop.add(addOrg);
				counts.put(addOrg.getType(), numAdd + 1);
			}//if
		}//for i
	}
	
	/**
	Calculates the average cooperation probability for all organisms in Pop
	@return average, a double
	*/
	public double calculateCooperationMean() {
		double sum = 0;
		for (int i = 0; i < populationSize; i++) {
			sum += Pop.get(i).getCooperationProbability();
		}//for
		return (sum / populationSize);
	}

	/**
	Getter for the counts field
	@return Map, a Map<String, Integer>
	*/
	public Map<String, Integer> getPopulationCounts(){
		return this.counts;
	}
	
	/**
	Getter for the Pop field
	@return Pop, an ArrayList
	*/
	public ArrayList<Organism> getPop() {
		return Pop;
	}
}

