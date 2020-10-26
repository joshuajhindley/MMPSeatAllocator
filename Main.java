import java.util.ArrayList;
import java.util.List;

public class Main {

	
	// TODO: get parties names, vote %, and electorate seat no.
	private List<Party> parties = new ArrayList<>();
	private int seatsAllocated = 0;
	private List<String> seatOrder = new ArrayList<>();
	
	
	
	public Main() {
		this.parties.add(new Party("Labour", 49.15, 43));
		this.parties.add(new Party("National", 26.79, 26));
		this.parties.add(new Party("Greens", 7.57, 1));
		this.parties.add(new Party("ACT", 7.98, 1));
		this.parties.add(new Party("Maori", 1, 1));
		
		while (this.seatsAllocated < 120) {
			Party nextSeatParty = null;
			double quotient = 0;
			for (Party p : this.parties) {
				if (p.getNextSeatCost() > quotient) {
					nextSeatParty = p;
					quotient = p.getNextSeatCost();
				}
			}
			nextSeatParty.addSeat();
			seatOrder.add(nextSeatParty.getName() + nextSeatParty.getSeatsDeserved());
			this.seatsAllocated++;
			//System.out.println(nextSeatParty.getName() + " gets seat number " + this.seatsAllocated);
		}
		
		for (Party p : this.parties) {
			System.out.println("Party:\t\t" + p.getName());
			System.out.println("Electorates:\t" + p.getElectorateSeats());
			System.out.println("List Seats:\t" + p.getListSeats());
			System.out.println("Total Seats:\t" + p.getTotalSeats() + "\n");
		}
		
	}
	
	
	public static void main(String[] args) {
		new Main();
	}
	
	
}
