package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Frame;

public class FrameTest {
	
	@Test
	public void testStrike() throws Exception {
		Frame f = new Frame();
		f.shot(10);
		assertEquals(10, f.getScore());
		assertEquals(true, f.isStrike());
		assertEquals(true, f.isFinished());
	}
	
	@Test
	public void testSpare() throws Exception {
		Frame f = new Frame();
		f.shot(5);
		f.shot(5);
		assertEquals(10, f.getScore());
		assertEquals(true, f.isSpare());
		assertEquals(true, f.isFinished());
	}

	@Test
	public void testNormal() throws Exception {
		Frame f = new Frame();
		f.shot(4);
		f.shot(5);
		assertEquals(9, f.getScore());
		assertEquals(false, f.isStrike());
		assertEquals(false, f.isSpare());
		assertEquals(true, f.isFinished());
	}

	@Test
	public void testNotFinished() throws Exception {
		Frame f = new Frame();
		f.shot(4);
		assertEquals(4, f.getScore());
		assertEquals(false, f.isFinished());
	}
	
	
	
	
}
