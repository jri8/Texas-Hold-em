package texas;

public class Card {
	protected int rank; // {A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2}
	
	public Card(int rank) {
		this.rank = rank;
	}
	
	public Card(String cardNum) {
		if(cardNum.equals("A"))
		{
			this.rank = 14;
		}
		else if (cardNum.equals("K"))
		{
			this.rank = 13;
		}
		else if (cardNum.equals("Q"))
		{
			this.rank = 12;
		}
		else if(cardNum.equals("J"))
		{
			this.rank = 11;
		}
		else
		{
			this.rank = Integer.parseInt(cardNum);
		}
	}
	
	
	

	public int getRank() {
		return rank; 
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String toString() {
		String result = "";
		switch (rank) {
			case 14: result += "A"; break;
			case 13: result += "K"; break;
			case 12: result += "Q"; break;
			case 11: result += "J"; break;
			default: result += rank;
		}
		
		return result;
	}
}
