package test;

import static org.junit.Assert.*;

import main.BowlingException;
import main.BowlingGame;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void testAddPlayer() throws Exception {
		BowlingGame game = new BowlingGame();
		game.addPlayer("John");
		assertEquals(1, game.getPlayers().size());
	}

	@Test
	public void testAddPlayers() throws Exception {
		BowlingGame game = new BowlingGame();
		game.addPlayer("John");
		game.addPlayer("Smith");
		assertEquals(2, game.getPlayers().size());
	}

	@Test (expected = BowlingException.class)
	public void testAddTooManyPlayers() throws Exception {
		BowlingGame game = new BowlingGame();
		for (int i=0; i<7; i++)
			game.addPlayer("John");
		fail("Exception expected");
	}

	@Test (expected = BowlingException.class)
	public void testNewGameWithNoPlayers() throws Exception {
		BowlingGame game = new BowlingGame();
		game.newGame();
		fail("Exception expected");
	}
	
	
	
	

}
