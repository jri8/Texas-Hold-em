package texas;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Card> cards;
	
	
	public Player(String name, ArrayList<Card> cards) {
		this.name = name;
		this.cards = new ArrayList<Card>(cards);
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public String toString()
	{
		String output = "";
		output += this.name + " ";
		for(int i = 0; i < cards.size(); i++)
			output+= cards.get(i).toString() + " ";
		
		return output;
	}
	
	
}
