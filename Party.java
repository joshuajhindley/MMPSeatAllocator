import java.util.ArrayList;
import java.util.List;

public class Party {

	private final String name;
	private final double partyVotePercentage;
	private List<Double> nextSeatCost = new ArrayList<>();
	private int electorateSeats;
	private int totalSeatsDeserved = 0;
	
	public Party(String name, double partyVotePercentage, int electorateSeats) {
		this.name = name;
		this.partyVotePercentage = partyVotePercentage;
		this.electorateSeats = electorateSeats;
		calculateSeatCosts();
	}
	
	private void calculateSeatCosts() {
		for (int quotient = 1; quotient <= 199; quotient += 2) {
			this.nextSeatCost.add(this.partyVotePercentage / quotient);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPartyVotePercentage() {
		return this.partyVotePercentage;
	}
	
	public double getNextSeatCost() {
		return this.nextSeatCost.get(0);
	}
	
	public void addSeat() {
		this.totalSeatsDeserved++;
		this.nextSeatCost.remove(0);
	}
	
	public int getElectorateSeats() {
		return this.electorateSeats;
	}
	
	public int getListSeats() {
		return Math.max(this.totalSeatsDeserved - this.electorateSeats, 0);
	}
	
	public int getTotalSeats() {
		return this.getElectorateSeats() + this.getListSeats();
	}
	
	/**
	 * 
	 * @return
	 * WARNING: this number may not be the same as the total seats the party gets
	 * as the party may win additional electorate seats, creating overhang seats.
	 */
	public int getSeatsDeserved() {
		return this.totalSeatsDeserved;
	}
	
}
