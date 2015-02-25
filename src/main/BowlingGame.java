package main;

import java.util.ArrayList;

public class BowlingGame {
	
	public static final int MAX_PLAYERS = 6;
	
	// current frame (0-9)
	private int frame;
	
	// arraylist for all players
	private ArrayList<Player> players;
	// current Player
	private Player currentPlayer;
	// current players index in arraylist (0-5)
	private int currentPlayerIndex;
	
	// boolean to indicate if the game has ended
	private boolean gameOver;
	
	
	/**
	 * constructor
	 */
	public BowlingGame() {
		players = new ArrayList<Player>();
	}
	
	/**
	 * add a new player to the game
	 * @param name the name of the new player
	 * @throws BowlingException
	 */
	public void addPlayer(String name) throws BowlingException {
		if(players.size() < MAX_PLAYERS) {
			players.add(new Player(name));
		} else {
			throw new BowlingException("Maximum number of players reached!");
		}
	}
	
	/**
	 * start a new game
	 * @throws BowlingException 
	 */
	public void newGame() throws BowlingException {
		if (players.size()==0)
			throw new BowlingException("No players added!");
		frame = 0;
		currentPlayerIndex = 0;
		currentPlayer = players.get(0);
		gameOver = false;
	}
	
	/**
	 * advance to next player
	 */
	private void nextPlayer() {
		if (currentPlayerIndex < players.size()-1) {
			currentPlayer = players.get(++currentPlayerIndex);
		} else { // last player. increase frame
			if (frame < 9) {
				currentPlayerIndex = 0;
				currentPlayer = players.get(0);
				frame++;
			} else {
				gameOver = true;
			}
		}
	}
	
	/**
	 * submit a score for the current player
	 * @param score the number of pins hit in the last shot
	 * @throws BowlingException
	 */
	public void submitScore(int score) throws BowlingException {
		
		if (gameOver)
			throw new BowlingException("Gameover!");
		
		currentPlayer.submitScore(score);
		if (currentPlayer.isFrameFinished(frame)) {
			nextPlayer();
		}
	}
	
	/**
	 * Print the scoreboard
	 */
	public void printScoreboard() {
		System.out.format("%-10s ", " ");
		for (int i=1; i<=10; i++) {
			System.out.format("%-3d ", i);
		}
		System.out.print("\n");
		System.out.print("--------------------------------------------------\n");
		
		
		for (Player p : players) {
			p.printScores();
		}
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
}
