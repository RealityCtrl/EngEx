package tdd;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalTime;

public class TestSpeakingClock {

	@Test
	public void  testMidnight(){
		//Given
		LocalTime midnight = LocalTime.MIDNIGHT;
		SpeakingClock myClock = new SpeakingClock();
		//When
		String result = myClock.getTimeAsString(midnight);
		//Then
		assertEquals("Midnight", result);
	}
}
