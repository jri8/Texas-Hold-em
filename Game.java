package texas;

import java.io.*;

import java.util.ArrayList;

public class Game {
	private ArrayList<Card> board; //holds cards on broad
	private ArrayList<Player> players; //holds players in game
	private ArrayList<Hand> hands; //holds best hand for each player
 	
	public Game()
	{
		board = new ArrayList<Card>();
		players = new ArrayList<Player>();
		hands = new ArrayList<Hand>();
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public void setBoard(ArrayList<Card> board) {
		this.board = new ArrayList<Card>(board);
	}
	
	public void addCard(Card card) {
		this.board.add(card);
	}
	
	public ArrayList<Player> getPlayers()
	{
		return this.players;
	}
	
	public ArrayList<Card> getBoard()
	{
		return this.board;
	}
	
	public void readSettings(String filename) {
		try
		{	
			int lineNum = 0; //tracks the line number
			int playerNum = 0; //holds player count
			Card card; //initializing card variable
			File file = new File(filename); //creating file
			BufferedReader reader = new BufferedReader(new FileReader(file)); //creating file reader
		
			String line = null;		//variable to hold line
			while((line = reader.readLine()) != null) //while there is a line to read
			{
				if(lineNum == 0) //if first line
				{
					String[] flop = line.split(" ");
					for(int i = 0; i < flop.length; i++)
					{
						card = new Card(flop[i]);
						this.addCard(card);
					}
						
				}
				else if(lineNum == 1) //if second line
				{
					playerNum = Integer.parseInt(line); //inputing player number
				}
				else //if after second line
				{
					String[] input = line.split(" ");//split input into string array
					ArrayList<Card> twoCards = new ArrayList<Card>();
					twoCards.add(new Card(input[1]));
					twoCards.add(new Card(input[2]));
					Player p = new Player(input[0],twoCards); //creating player
					
					this.addPlayer(p); //adds player to game
				}
				lineNum++;
			}
			reader.close();
		}
		
		catch (IOException e)
		{
			System.err.println(("Error:" + e.getMessage()));
			System.exit(1);
		}
		
		// First line contains five cards
		
		// Second line contains an integer -- the number of players
		
		// Each following line contains two cards
	} //reads file with settings

	
	public ArrayList<Hand> generateCandidates(ArrayList<Card> board, Player player)
	{
		ArrayList<Hand> candidates = new ArrayList<Hand>(); //array for possible candidates
		ArrayList<Card> cards = new ArrayList<Card>(board); //array for the 7 cards
		cards.addAll(player.getCards());
		Hand hand;	
		int[][] combos = new int[21][]; //generating all possible indexes for 7 choose 5
		combos[0] = new int[]{0,1,2,3,4};
		combos[1] = new int[]{0,1,2,3,5};
		combos[2] = new int[]{0,1,2,3,6};
		combos[3] = new int[]{0,1,2,4,5};
		combos[4] = new int[]{0,1,2,4,6};
		combos[5] = new int[]{0,1,2,5,6};
		combos[6] = new int[]{0,1,3,4,5};
		combos[7] = new int[]{0,1,3,4,6};
		combos[8] = new int[]{0,1,3,5,6};
		combos[9] = new int[]{0,1,4,5,6};
		combos[10] = new int[]{0,2,3,4,5};
		combos[11] = new int[]{0,2,3,4,6};
		combos[12] = new int[]{0,2,3,5,6};
		combos[13] = new int[]{0,2,4,5,6};
		combos[14] = new int[]{0,3,4,5,6};
		combos[15] = new int[]{1,2,3,4,5};
		combos[16] = new int[]{1,2,3,4,6};
		combos[17] = new int[]{1,2,3,5,6};
		combos[18] = new int[]{1,2,4,5,6};
		combos[19] = new int[]{1,3,4,5,6};
		combos[20] = new int[]{2,3,4,5,6};

		for(int i = 0; i < 21; i++)
		{
			hand = new Hand();
			for(int j = 0; j < 5; j++)
			{
				hand.addCard(cards.get(combos[i][j]));
			}
			
			candidates.add(hand);
		}
		return candidates;
	} //generates all possible hands of 5 out of the 7 possible cards for each player
	
	
	public Hand getBestHand(Player player) //gets the best hand for 1 player
	{
		Hand hand;
		//generates candidates
		ArrayList<Hand> candidates = new ArrayList<Hand>(this.generateCandidates(board, player));
	
		
		int winnerIndex = 0; //index of winning hand
		int challengeIndex = 1; //index of challenging hand
		
		while(challengeIndex < candidates.size()) //keeps the indexes in bounds
		{			
			
			//System.out.println(candidates.get(winnerIndex) + " vs " + candidates.get(challengeIndex));
			
			
			if(candidates.get(winnerIndex).compareTo(candidates.get(challengeIndex))== 1) //previous winner is better hand
				challengeIndex++; 
			else if(candidates.get(winnerIndex).compareTo(candidates.get(challengeIndex))== -1) //if challenger is better hand
			{
				winnerIndex = challengeIndex;
				challengeIndex++;
			}
			else //if tie
			{
				challengeIndex++;
			}
			
			
			
		}
		hand = candidates.get(winnerIndex); //best hand
		
		//System.out.println(hand);
		
		return hand; //returning best hand
	}
	
	
	
	public String announceWinner() {
		
		for(int i = 0; i < players.size(); i++) //getting each player in the games best hand
		{
			hands.add(this.getBestHand(players.get(i)));
		}
		
		int winnerIndex = 0;
		int challengeIndex = 1;
		int ties = 0;
		String output = "";
		
		while(challengeIndex < hands.size())
		{			
			if(hands.get(winnerIndex).compareTo(hands.get(challengeIndex))== 1) //if previous winner is best hand
				challengeIndex++;
			else if(hands.get(winnerIndex).compareTo(hands.get(challengeIndex))== -1) //if challenger is best hand
			{
				winnerIndex = challengeIndex;
				challengeIndex++;
			}
			else//if tie
			{
				challengeIndex++;
			}
			
		}
		
		for(int i = 0; i < hands.size(); i++) //traversing back through hands to check for ties
		{
			if(hands.get(winnerIndex).compareTo(hands.get(i))== 0)
			{
				output += players.get(i).getName() + " "; //outputting name
				ties++;
			} 
		}
		
		if(ties > 1) //will always be one tie because winning hand will tie with itself
		{
			output += "tie";
		}//if more than 1 winner output tie
		else //only one winner
		{
			output += "wins";
		}
			
		return output;
		
	}	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		
		Game game = new Game();
		game.readSettings("settings.conf");	
		System.out.println(game.announceWinner());
		
		
		
		
	
	}
	
	
}
