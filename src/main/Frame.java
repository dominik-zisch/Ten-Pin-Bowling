package main;

public class Frame {

	private int[] pins;
	private int score;
	private int attempts;
	private boolean isStrike;
	private boolean isSpare;
	private boolean finished;
	private int bonusesWaiting;
	
	/**
	 * Constructor
	 */
	public Frame() {
		pins = new int[2];
		score = 0;
		attempts = 0;
		isStrike = false;
		isSpare = false;
		finished = false;
		bonusesWaiting = 0;
	}
	
	/**
	 * Submit a score for this frame
	 * @param s number of pins knocked over
	 * @throws BowlingException
	 */
	public void shot(int s) throws BowlingException {
		
		if (score+s > 10 || s < 0)
			throw new BowlingException("Illegal number of pins!");
		
		pins[attempts] = s;
		attempts++;
		score += s;
		if (attempts==1 && s==10) { // strike
			isStrike = true;
			bonusesWaiting = 2;
		}
		if (attempts==2 && pins[0]+pins[1]==10) { //spare
			isSpare = true;
			bonusesWaiting = 1;
		}
		if (attempts==2 || isStrike || isSpare) // frame is finished
			finished = true;
	}
	
	// add bonus to this frame
	public void addBonus(int b) {
		score += b;
		bonusesWaiting--;
		if (bonusesWaiting == 0)
			finished = true;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public int getAttempts() {
		return attempts;
	}
	
	public boolean isFinished() {
		return finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean isStrike() {
		return isStrike;
	}

	public boolean isSpare() {
		return isSpare;
	}
	
	public int getBonusesWaiting() {
		return bonusesWaiting;
	}

	public String getPins() {
		if (isStrike)
			return "X";
		else if (isSpare)
			return pins[0] + " /";
		else
			return pins[0] + " " + pins[1];
	}
	
}
