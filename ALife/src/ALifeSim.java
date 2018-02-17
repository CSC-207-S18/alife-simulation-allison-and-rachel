import java.util.HashMap;
import java.util.Map;

public class ALifeSim {
	
public static void main (String[] args) {
	int iterations = Integer.parseInt(args[0]);
	int coops = Integer.parseInt(args[1]);
	int defs = Integer.parseInt(args[2]);
	int partcoops = Integer.parseInt(args[3]);
	Map <String, Integer> PopCounts = new HashMap <String, Integer>();
	PopCounts.put("Cooperator", coops);
	PopCounts.put("Defector", defs);
	PopCounts.put("PartialCooperator", partcoops);
	
	Population simPop = new Population(PopCounts);
	for (int i = 0; i < iterations; i++) {
		simPop.update();
	}
	System.out.println("After " + iterations + " ticks:");
	Map <String, Integer> map = simPop.getPopulationCounts();
	Integer numCoops = map.get("Cooperator");
	System.out.println("Cooperators = " + numCoops);
	Integer numDefs = map.get("Defector");
	System.out.println("Defectors = " + numDefs);
	Integer numPartCoops = map.get("PartialCooperator");
	System.out.println("Partial Cooperators = " + numPartCoops);
	
	double meanCoopProb = simPop.calculateCooperationMean();
	System.out.println("Mean Cooperation Probability = " + meanCoopProb);
}

}
