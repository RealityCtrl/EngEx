package tdd;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalTime;

public class TestSpeakingClock {
	
	SpeakingClock myClock;
	LocalTime testTime;
	
	@Before
	public void setup(){
		myClock = new SpeakingClock();
	}

	@Test
	public void  testMidnight(){
		//Given
		testTime = LocalTime.MIDNIGHT;
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testMidnightNumeric(){
		//Given
		testTime = LocalTime.of(0, 0);
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testNoon(){
		//Given
		testTime = LocalTime.NOON;
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  testNoonNumeric(){
		//Given
		testTime = LocalTime.of(12, 0);
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  test2PM(){
		//Given
		testTime = LocalTime.of(14, 0);
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("14:00", result);
	}
	
	@Test
	public void  testElevenFiftyNineAM(){
		//Given
		testTime = LocalTime.of(11, 59);
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("11:59", result);
	}
	
	@Test
	public void  testOneMinutePastTwelvePM(){
		//Given
		testTime = LocalTime.of(12, 01);
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("12:01", result);
	}
	
	@Test
	public void  testElevenFiftyNinePM(){
		//Given
		testTime = LocalTime.of(23, 59);
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("23:59", result);
	}
	
	@Test
	public void  testOneMinutePastTwelveAM(){
		//Given
		testTime = LocalTime.of(00, 01);
		//When
		String result = myClock.getTimeAsString(testTime);
		//Then
		assertEquals("00:01", result);
	}
	
	
}
