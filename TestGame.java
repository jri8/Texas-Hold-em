package texas;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;



public class TestGame {



	@Test
	public void compareToTest1() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(2), new Card(3), new Card(4), new Card(5), new Card(6)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(3), new Card(4), new Card(5), new Card(6), new Card(7)));
		hand2 = new Hand(cards);
		
		assertEquals(-1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //compares straights
	
	
	
	
	@Test
	public void compareToTest2() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(13), new Card(13), new Card(4), new Card(4)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(13), new Card(13), new Card(13), new Card(6), new Card(6)));
		hand2 = new Hand(cards);
		
		assertEquals(-1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //compares full houses

	@Test
	public void compareToTest3() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(12), new Card(11), new Card(10), new Card(9)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(9), new Card(10), new Card(11), new Card(12), new Card(13)));
		hand2 = new Hand(cards);
		
		assertEquals(0, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //compares tie when cards are reversed
	 
	@Test
	public void compareToTest4() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(2), new Card(2), new Card(2), new Card(2), new Card(14)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(2), new Card(2), new Card(2), new Card(2), new Card(13)));
		hand2 = new Hand(cards);
		
		assertEquals(1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //compares 4 of a kind tie with high card
	
	@Test
	public void compareToTest5() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(2), new Card(2), new Card(6), new Card(6), new Card(4)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(2), new Card(2), new Card(8), new Card(9), new Card(10)));
		hand2 = new Hand(cards);
		
		assertEquals(1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //compares two pair
	
	@Test
	public void compareToTest6() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(3), new Card(3), new Card(10), new Card(6), new Card(4)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(2), new Card(2), new Card(8), new Card(9), new Card(10)));
		hand2 = new Hand(cards);
		
		assertEquals(1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //compares pair
	
	@Test
	public void compareToTest7() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(2), new Card(2), new Card(2), new Card(6), new Card(4)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(3), new Card(3), new Card(3), new Card(9), new Card(10)));
		hand2 = new Hand(cards);
		
		assertEquals(-1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //compares three of a kind
	
	@Test
	public void compareToTest8() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(2), new Card(2), new Card(2), new Card(2), new Card(4)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(14), new Card(14), new Card(14), new Card(6), new Card(10)));
		hand2 = new Hand(cards);
		
		assertEquals(1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //lower 4 of a kind to three of a kind
	
	@Test
	public void compareToTest9() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(2), new Card(2), new Card(8), new Card(3), new Card(4)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(13), new Card(6), new Card(4), new Card(2), new Card(10)));
		hand2 = new Hand(cards);
		
		assertEquals(1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //compare pair to high card
	
	@Test
	public void compareToTest10() {
		Hand hand1;
		Hand hand2;
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(9), new Card(2), new Card(6), new Card(4)));
		hand1 = new Hand(cards);
		cards = new ArrayList<>
		
		(Arrays.asList(new Card(14), new Card(4), new Card(3), new Card(9), new Card(6)));
		hand2 = new Hand(cards);
		
		assertEquals(-1, hand1.compareTo(hand2));

		//fail("Not yet implemented");
	} //comparing high cards
	
	
	
	
	@Test
	public void readSettings1() {
		Game game = new Game();
		
		try{
		    PrintWriter writer = new PrintWriter("file-name.txt", "UTF-8");
		    writer.println("4 13 4 8 7");
		    writer.println("3");
		    writer.println("Bob 14 4");
		    writer.println("Carol 14 9");
		    writer.println("Ted 13 13");
		    writer.close();
		    
		    game.readSettings("file-name.txt");
		    
		    assertEquals(3 , game.getPlayers().size());
		    
		    
		    
		} catch (IOException e) 
		{
			System.err.println(("Error:" + e.getMessage()));
			System.exit(1);
		}

		//fail("Not yet implemented");
	} //checks to see if all the players are loaded

	@Test
	public void readSettings2() {
		Game game = new Game();
		
		try{
		    PrintWriter writer = new PrintWriter("file-name.txt", "UTF-8");
		    writer.println("4 13 4 8 7");
		    writer.println("3");
		    writer.println("Bob 14 4");
		    writer.println("Carol 14 9");
		    writer.println("Ted 13 13");
		    writer.close();
		    
		    game.readSettings("file-name.txt");
		    
		    assertEquals(9 , game.getPlayers().get(1).getCards().get(1).getRank());
		    
		    
		    
		} catch (IOException e) 
		{
			System.err.println(("Error:" + e.getMessage()));
			System.exit(1);
		}

		//fail("Not yet implemented");
	} //checks to see if the cards are loaded correctly
	
	
	@Test
	public void readSettings3() {
		Game game = new Game();
		
		try{
		    PrintWriter writer = new PrintWriter("file-name.txt", "UTF-8");
		    writer.println("4 13 4 8 7");
		    writer.println("3");
		    writer.println("Bob 14 4");
		    writer.println("Carol 14 9");
		    writer.println("Ted 13 13");
		    writer.close();
		    
		    game.readSettings("file-name.txt");
		    
		    assertEquals("Carol" , game.getPlayers().get(1).getName());
		    
		    
		    
		} catch (IOException e) 
		{
			System.err.println(("Error:" + e.getMessage()));
			System.exit(1);
		}

		//fail("Not yet implemented");
	} //checks if name is loaded correctly
	
	@Test
	public void readSettings4() {
		Game game = new Game();
		
		try{
		    PrintWriter writer = new PrintWriter("file-name.txt", "UTF-8");
		    writer.println("4 13 4 8 7");
		    writer.println("3");
		    writer.println("Bob 14 4");
		    writer.println("Carol 14 9");
		    writer.println("Ted 13 13");
		    writer.close();
		    
		    game.readSettings("file-name.txt");
		    
		    assertEquals(2 , game.getPlayers().get(1).getCards().size());
		    
		    
		    
		} catch (IOException e) 
		{
			System.err.println(("Error:" + e.getMessage()));
			System.exit(1);
		}

		//fail("Not yet implemented");
	} //checks to see if there are two cards loaded
	
	

	@Test
	public void announceWinner1() {
		Game game = new Game();
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(4), new Card(13), new Card(4), new Card(8), new Card(7)));
		game.setBoard(cards);
		cards = new ArrayList<>
		(Arrays.asList(new Card(14), new Card(4)));	
		Player player = new Player("Bob", cards );
		game.addPlayer(player);
		
		cards = new ArrayList<>
		(Arrays.asList(new Card(14), new Card(9)));	
		player = new Player("Carol", cards );
		game.addPlayer(player);
		
		cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(13)));	
		player = new Player("Ted", cards );
		game.addPlayer(player);
		
		assertEquals("Ted wins", game.announceWinner());
		
	} //checks for outright winner

	@Test
	public void announceWinner2() {
		Game game = new Game();
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(4), new Card(13), new Card(4), new Card(8), new Card(7)));
		game.setBoard(cards);
		cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(4)));	
		Player player = new Player("Bob", cards );
		game.addPlayer(player);
		
		cards = new ArrayList<>
		(Arrays.asList(new Card(14), new Card(9)));	
		player = new Player("Carol", cards );
		game.addPlayer(player);
		
		cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(4)));	
		player = new Player("Ted", cards );
		game.addPlayer(player);
		
		assertEquals("Bob Ted tie", game.announceWinner());
	} //checks for tie between two people
	
	@Test
	public void announceWinner3() {
		Game game = new Game();
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(4), new Card(13), new Card(4), new Card(8), new Card(7)));
		game.setBoard(cards);
		cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(4)));	
		Player player = new Player("Bob", cards );
		game.addPlayer(player);
		
		cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(4)));	
		player = new Player("Carol", cards );
		game.addPlayer(player);
		
		cards = new ArrayList<>
		(Arrays.asList(new Card(13), new Card(4)));	
		player = new Player("Ted", cards );
		game.addPlayer(player);
		
		assertEquals("Bob Carol Ted tie", game.announceWinner());
	} //checks for tie between more than two people
	
	
	
	@Test
	public void generateCandidates() {
		Game game = new Game();
		Hand compare;
		ArrayList<Hand> candidates;
		
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(4), new Card(4), new Card(7), new Card(13), new Card(13)));
		compare = new Hand(cards);
		
		ArrayList<Card> board = new ArrayList<Card>
		(Arrays.asList(new Card(4), new Card(13), new Card(4), new Card(8), new Card(7)));
		
		
		ArrayList<Card> pocket = new ArrayList<Card>
		(Arrays.asList(new Card(4), new Card(13)));
		
		Player player =  new Player("Tom", pocket);
		
		candidates = new ArrayList<Hand>(game.generateCandidates(board, player));
		
		
		assertEquals(21, candidates.size());

		//fail("Not yet implemented");
	} //checks that 21 possible hands are constructed
	
	@Test
	public void generateCandidates2() {
		Game game = new Game();
		Hand compare;
		ArrayList<Hand> candidates;
		
		
		ArrayList<Card> cards = new ArrayList<>
		(Arrays.asList(new Card(4), new Card(4), new Card(7), new Card(13), new Card(13)));
		compare = new Hand(cards);
		
		ArrayList<Card> board = new ArrayList<Card>
		(Arrays.asList(new Card(4), new Card(13), new Card(4), new Card(8), new Card(7)));
		
		
		ArrayList<Card> pocket = new ArrayList<Card>
		(Arrays.asList(new Card(4), new Card(13)));
		
		Player player =  new Player("Tom", pocket);
		
		candidates = new ArrayList<Hand>(game.generateCandidates(board, player));
		
		
		assertEquals(5, candidates.get(0).getCards().size());

		//fail("Not yet implemented");
	} //checks that there are 5 cards in each hand



}


