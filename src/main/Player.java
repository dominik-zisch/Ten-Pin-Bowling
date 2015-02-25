package main;

public class Player {

	// player name
	private String name;
	
	private Frame[] frames;
	private Frame currentFrame;
	private int frameCounter;
	
	
	/**
	 * Constructor
	 * creates new frames array and starts a new game for this player
	 * @param name the name of the player
	 */
	public Player(String name) {
		this.name = name;
		frames = new Frame[10];
		newGame();
	}
	
	
	/**
	 * starts a new game
	 * initializes frames, sets framecounter to zero and currentFrame to first frame
	 */
	protected void newGame() {
		initFrames();
		frameCounter = 0;
		currentFrame = frames[frameCounter];
	}
	
	/**
	 * initialize the frames array with 10 frames
	 */
	private void initFrames() {
		for (int i = 0; i < 10; i++) {
			frames[i] = new Frame();
		}
	}
	
	/**
	 * submit a score for a shot
	 * @param score the amount of pins hits in this shot
	 * @throws BowlingException 
	 */
	public void submitScore(int score) throws BowlingException {
		
		// if getBonusesWaiting is 0, it can't be the a bonus shot, so count the score to the current frame
		if (currentFrame.getBonusesWaiting() == 0) {
			currentFrame.shot(score);
		} else { // if it is greater than 0, this is a bonus shot in the last frame, add the score as bonus
			currentFrame.addBonus(score);
		}

		// add the score to lower frames, that are waiting for a bonus
		addBonuses(score);
		
		// if the frame is finished, but it's not the last frame, increment the current frame
		if (currentFrame.isFinished() && frameCounter < 9)
			currentFrame = frames[++frameCounter];
		
		// if its the last frame and there are bonuses waiting, set finished to false
		if (frameCounter == 9 && currentFrame.getBonusesWaiting() > 0) {
			currentFrame.setFinished(false);
		}
	}
	
	/**
	 * add the current score to lower frames that are waiting for a bonus
	 * @param score the score of the current shot
	 */
	private void addBonuses(int score) {
		for (int i=0; i<frameCounter; i++) {
			if (frames[i].getBonusesWaiting() > 0)
				frames[i].addBonus(score);
		}
	}
	
	/**
	 * return the total score up to a given frame
	 * @param f
	 * @return
	 */
	public int getTotalScore(int f) {
		int totalScore = 0;
		for (int i = 0; i<=f; i++) {
			totalScore += frames[i].getScore();
		}
		return totalScore;
	}
	
	public int getFrameCounter() {
		return frameCounter;
	}
	
	public boolean isFrameFinished(int f) {
		return frames[f].isFinished();
	}
	
	public void printScores() {
		System.out.format("%-10s", name);
		for (int i=0; i<=frameCounter; i++) {
			System.out.format("%-3d ", getTotalScore(i));
		}
		System.out.print("\n");
	}
	
}
