package test;

import static org.junit.Assert.*;

import main.BowlingException;
import main.Player;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testGutterGame() throws Exception {
		Player p = new Player("John");
		for (int i=0; i<20; i++) {
			p.submitScore(0);
		}
		assertEquals(0, p.getTotalScore(9));
	}

	@Test
	public void testPerfectGame() throws Exception {
		Player p = new Player("John");
		for (int i=0; i<12; i++) {
			p.submitScore(10);
		}
		assertEquals(300, p.getTotalScore(9));
	}

	@Test
	public void testAllSpares() throws Exception {
		Player p = new Player("John");
		for (int i=0; i<21; i++) {
			p.submitScore(5);
		}
		assertEquals(150, p.getTotalScore(9));
	}

	@Test
	public void testAllTwos() throws Exception {
		Player p = new Player("John");
		for (int i=0; i<20; i++) {
			p.submitScore(2);
		}
		assertEquals(40, p.getTotalScore(9));
	}

	@Test
	public void testOneSpare() throws Exception {
		Player p = new Player("John");

		p.submitScore(5);
		p.submitScore(5);

		p.submitScore(3);
		p.submitScore(3);
		
		assertEquals(19, p.getTotalScore(2));
	}

	@Test
	public void testOneStrike() throws Exception {
		Player p = new Player("John");

		p.submitScore(10);

		p.submitScore(3);
		p.submitScore(3);
		
		assertEquals(22, p.getTotalScore(2));
	}
	
	

}
