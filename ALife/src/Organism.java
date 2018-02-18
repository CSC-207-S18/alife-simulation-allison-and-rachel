
public abstract class Organism {
	private int energy;

	public Organism() {
		this.energy = 0;
	}

	public void update() {
		this.energy += 1;

	}

	public int getEnergy() {
		return this.energy;
	}

	public void setEnergy(int newEnergy) {
		if (newEnergy >= 0) {
			this.energy = newEnergy;
		}
	}

	public void incrementEnergy() {
		this.energy += 1;
	}

	public void decrementEnergy() {
		if (this.energy > 0)
			this.energy -= 1;
	}

	public abstract String getType();

	public abstract Organism reproduce();

	public abstract double getCooperationProbability();

	public abstract boolean cooperates();

}
