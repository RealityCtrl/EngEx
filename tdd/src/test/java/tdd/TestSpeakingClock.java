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
		//myClock = new SpeakingClock();
	}

	@Test
	public void  testStaticMidnight(){
		//Given
		testTime = LocalTime.MIDNIGHT;
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testStaticMidnightNumeric(){
		//Given
		testTime = LocalTime.of(0, 0);
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testStaticNoon(){
		//Given
		testTime = LocalTime.NOON;
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  testStaticNoonNumeric(){
		//Given
		testTime = LocalTime.of(12, 0);
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  testStatic2PM(){
		//Given
		testTime = LocalTime.of(14, 0);
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("14:00", result);
	}
	
	@Test
	public void  testStaticElevenFiftyNineAM(){
		//Given
		testTime = LocalTime.of(11, 59);
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("11:59", result);
	}
	
	@Test
	public void  testStaticOneMinutePastTwelvePM(){
		//Given
		testTime = LocalTime.of(12, 01);
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("12:01", result);
	}
	
	@Test
	public void  testStaticElevenFiftyNinePM(){
		//Given
		testTime = LocalTime.of(23, 59);
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("23:59", result);
	}
	
	@Test
	public void  testStaticOneMinutePastTwelveAM(){
		//Given
		testTime = LocalTime.of(00, 01);
		//When
		String result = SpeakingClock.getTimeAsString(testTime);
		//Then
		assertEquals("00:01", result);
	}
	
	@Test
	public void  testMidnight(){
		//Given
		testTime = LocalTime.MIDNIGHT;
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testMidnightNumeric(){
		//Given
		testTime = LocalTime.of(0, 0);
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testNoon(){
		//Given
		testTime = LocalTime.NOON;
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  testNoonNumeric(){
		//Given
		testTime = LocalTime.of(12, 0);
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  test2PM(){
		//Given
		testTime = LocalTime.of(14, 0);
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("14:00", result);
	}
	
	@Test
	public void  testElevenFiftyNineAM(){
		//Given
		testTime = LocalTime.of(11, 59);
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("11:59", result);
	}
	
	@Test
	public void  testOneMinutePastTwelvePM(){
		//Given
		testTime = LocalTime.of(12, 01);
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("12:01", result);
	}
	
	@Test
	public void  testElevenFiftyNinePM(){
		//Given
		testTime = LocalTime.of(23, 59);
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("23:59", result);
	}
	
	@Test
	public void  testOneMinutePastTwelveAM(){
		//Given
		testTime = LocalTime.of(00, 01);
		myClock = new SpeakingClock(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("00:01", result);
	}
	
}
