package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		
		BowlingGame game = new BowlingGame();
		
		try {
			game.addPlayer("John");
			game.addPlayer("Smith");
		} catch (BowlingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		game.newGame();
		
		for (int i=0; i<24; i++) {
			try {
				game.submitScore(10);
			} catch (BowlingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		game.printScoreboard();
		
	}
	
}
