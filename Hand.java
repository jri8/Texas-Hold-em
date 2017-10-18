package texas;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;

	public Hand() {
		this.cards = new ArrayList<Card>();
	}
	
	public Hand(ArrayList<Card> cards) {
		this.cards = new ArrayList<Card>();
		for(int i = 0; i < cards.size(); i++)
			this.addCard(cards.get(i));
	}

	public void addCard(Card card) {
		//adds cards to hand in order
		int i = 0;
		while (i < cards.size() && card.rank > cards.get(i).rank)
		{
			i++;
		}
		cards.add(i, card);
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void setCards(ArrayList<Card> cards) {
		for(int i = 0; i < cards.size(); i++)
			this.addCard(cards.get(i));
	}
	
	public String toString()
	{
		String output = "";
		for(int i = 0; i < cards.size(); i++)
			output+= cards.get(i).toString() + " ";
		
		return output;
	}
	

	public int isPair() {
		
		int rankOfPair = 0;
		int rankOfBase = 0;
		int rankOfOther = 0;
		for(int i = 0; i < cards.size(); i++)
			for(int j = 0; j < cards.size(); j++)
			{
				rankOfBase = cards.get(i).getRank();
				rankOfOther = cards.get(j).getRank();
				
				if(i != j && rankOfBase == rankOfOther)
				{
					if(rankOfPair <= rankOfOther)
						rankOfPair = rankOfOther;
				}
				
			}
		
		return rankOfPair;
	} //checks if there is a pair.  card rank of pair 
	
	public int isTwoPairs() {
		
		int rankOfBase = 0;
		int rankOfOther = 0;
		ArrayList<Integer> pairs = new ArrayList<Integer>();
		for(int i = 0; i < cards.size(); i++)
			for(int j = 0; j < cards.size(); j++)
			{
				rankOfBase = cards.get(i).getRank();
				rankOfOther = cards.get(j).getRank();
				
				if(i != j && rankOfBase == rankOfOther)
				{
					if(!pairs.contains(rankOfBase))
						pairs.add(rankOfBase);
				}
				
			}
	
		if(pairs.size() == 2 )
			return Integer.max(pairs.get(0), pairs.get(1));
		else
			return 0;
	} //checks if two pairs.  returns higher of both pairs
	
	public int isThreeofKind() {
		
		int[] counts = new int[15];
		int rank = 0;
		for(int i = 0; i < cards.size(); i++)
		{
			rank = cards.get(i).rank;
			counts[rank] = counts[rank] + 1;
		}
		
		int j = 14;
		while (j >= 0 && counts[j] != 3)
		{
			j--;
		}
		
		if(j > 0)
			return j;
		else
			return 0;
		
	} //checks if three of a kind returns rank of the 3 of kind

	public int isStraight() {
		
		int cardCount = 0;
		int increment = 0;
		int cardRank = 0;
		boolean nextCard = false;
		
		//cardRank = cards.get(increment).rank;
		while(cardCount != 4 && increment < cards.size())
		{
			if(cardCount == 0)
				cardRank = cards.get(increment).rank;
			nextCard = false;
			for(int i = 0; i < cards.size(); i++)
			{
				if(cardRank-1 == cards.get(i).rank)
					nextCard = true;
			}
			
			if(nextCard == true)
			{
				cardRank--;
				cardCount++;
			}
			else
			{
				increment++;
				cardCount = 0;
			}
		}
		
		if(cardCount == 4)
			return cardRank + 4;
		else
			return 0;
	}  //checks if straight and returns highest card of straight

	public int isFullHouse() 
	{
		int[] counts = new int[15];
		int rank = 0;
		for(int i = 0; i < cards.size(); i++)
		{
			rank = cards.get(i).rank;
			counts[rank] = counts[rank] + 1;
		}
		
		int j = 14;
		while (j >= 0 && counts[j] != 3)
		{
			j--;
		}
		
		int k = 14;
		while (k >= 0 && counts[k] != 2)
		{
			k--;
		}
		
		
		if(j > 0 && k > 0)
			return j;
		else
			return 0;	
		
	} //checks if full house and returns card rank of 3 of kind

	public int isFourofKind() {
		int[] counts = new int[15];
		int rank = 0;
		for(int i = 0; i < cards.size(); i++)
		{
			rank = cards.get(i).rank;
			counts[rank] = counts[rank] + 1;
		}
		
		int j = 14;
		while (j >= 0 && counts[j] != 4)
		{
			j--;
		}
		
		if(j > 0)
			return j;
		else
			return 0;	
	} //checks if 4 of kind and returns card rank
	
	public int getMaxCard()
	{
		int maxCard = 0;
		for(int i = 0; i < this.cards.size(); i++)
		{
			if(this.cards.get(i).rank > maxCard)
				maxCard = this.cards.get(i).rank;
		}		
		return maxCard;
	} //returns the max card of the hand
	
	private int getTieBreaker(Hand hand)
	{
		int result = 0;
		
		for(int i = 0; i < hand.cards.size() && result == 0; i++)
		{
			if(this.cards.get(i).rank > hand.cards.get(i).rank)
				result = 1;
			else if (this.cards.get(i).rank < hand.cards.get(i).rank)
				result = -1;
			else
				result = 0;
		} //loops through two hands and compares cards at each index
		//works becaues the cards are sorted
	
		return result;
	}
	
	
	
	
	
	public int compareTo(Hand hand) 
	{
		
		int winner = 0;
		
		if(this.isFourofKind() != 0 || hand.isFourofKind() != 0)
		{
			if(this.isFourofKind() > hand.isFourofKind())
				winner = 1;
			else if(this.isFourofKind() < hand.isFourofKind())
				winner = -1;
			else
				winner = this.getTieBreaker(hand);
		}
		
		else if(this.isFullHouse() != 0 || hand.isFullHouse() != 0)
		{
			if(this.isFullHouse() > hand.isFullHouse())
				winner = 1;
			else if(this.isFullHouse() < hand.isFullHouse())
				winner = -1;
			else
				winner = this.getTieBreaker(hand);
		}
		
		else if(this.isStraight() != 0 || hand.isStraight() != 0)
		{
			if(this.isStraight() > hand.isStraight())
				winner = 1;
			else if(this.isStraight() < hand.isStraight())
				winner = -1;
			else
				winner = this.getTieBreaker(hand);
		}
		
		else if(this.isThreeofKind() != 0 || hand.isThreeofKind() != 0)
		{
			if(this.isThreeofKind() > hand.isThreeofKind())
				winner = 1;
			else if(this.isThreeofKind() < hand.isThreeofKind())
				winner = -1;
			else
				winner = this.getTieBreaker(hand);
		}
		
		
		else if(this.isTwoPairs() != 0 || hand.isTwoPairs() != 0)
		{
			if(this.isTwoPairs() > hand.isTwoPairs())
				winner = 1;
			else if(this.isTwoPairs() < hand.isTwoPairs())
				winner = -1;
			else
				winner = this.getTieBreaker(hand);
		}
		
		
		else if(this.isPair() != 0 || hand.isPair() != 0)
		{
			if(this.isPair() > hand.isPair())
				winner = 1;
			else if(this.isPair() < hand.isPair())
				winner = -1;
			else
				winner = this.getTieBreaker(hand);
		}
		
		
		else
		{
			if(this.getMaxCard() > hand.getMaxCard())
				winner = 1;
			else if(this.getMaxCard() < hand.getMaxCard())
				winner = -1;
			else
				winner = this.getTieBreaker(hand);
		}
		
		return winner;
	} //compares cards in an if else manner
	//also checks for tie breakers to make sure if there is a tie. 
}
