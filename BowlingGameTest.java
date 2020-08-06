import static org.junit.Assert.*;
import org.junit.*;

public class BowlingGameTest {
	private Game g = new Game();

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			g.roll(pins);
	}
	
	@Before
	public void before() {
		g = new Game();
		System.out.println("New Game");
	}
	
	@After 
	public void after() {
		g = null;
		System.out.println("Game Over!");
	}
	
	@Test
	public void testOneSpare() {
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		assertEquals(16, g.score());
	}

	@Test
	public void testOneStrike() {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertEquals(24, g.score());
	}

	@Test
	public void testPerfectGame() {
		rollMany(12, 10);
		assertEquals(300, g.score());
	}

	private void rollStrike() {
		g.roll(10);
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

}
