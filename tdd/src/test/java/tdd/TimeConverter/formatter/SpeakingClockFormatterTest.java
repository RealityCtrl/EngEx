package tdd.TimeConverter.formatter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class SpeakingClockFormatterTest {
	StringTimeFormatter myFormatter;
	LocalTime testTime;
	
	@Before
	public void setup(){
		myFormatter = new SpeakingClockFormatter();
	}
	
	@Test
	public void  testMidnight(){
		//Given
		testTime = LocalTime.MIDNIGHT;
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testMidnightNumeric(){
		//Given
		testTime = LocalTime.of(0, 0);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testNoon(){
		//Given
		testTime = LocalTime.NOON;
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  testNoonNumeric(){
		//Given
		testTime = LocalTime.of(12, 0);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  test1PM(){
		//Given
		testTime = LocalTime.of(13, 0);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("one o'clock", result);
	}
	
	@Test
	public void  test1AM(){
		//Given
		testTime = LocalTime.of(1, 0);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("one o'clock", result);
	}
	
	@Test
	public void  testFivePast1PM(){
		//Given
		testTime = LocalTime.of(13, 05);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("five past one", result);
	}
	
	@Test
	public void  testTenFortyFiveAM(){
		//Given
		testTime = LocalTime.of(10, 45);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("a quarter to eleven", result);
	}
	
	@Test
	public void  testTenFifteenAM(){
		//Given
		testTime = LocalTime.of(10, 15);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("a quarter past ten", result);
	}
	
	@Test
	public void  testTenThirty(){
		//Given
		testTime = LocalTime.of(10, 30);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("half past ten", result);
	}
	
	@Test
	public void  testElevenTwentySeven(){
		//Given
		testTime = LocalTime.of(11, 27);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("just gone twenty five past eleven", result);
	}
	
	@Test
	public void  testOneMinutePastTwelvePM(){
		//Given
		testTime = LocalTime.of(12, 01);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("just gone twelve o'clock", result);
	}
	
	@Test
	public void  testElevenFiftyNinePM(){
		//Given
		testTime = LocalTime.of(23, 59);
		//When
		String result = myFormatter.formatLocalTime(testTime);
		//Then
		assertEquals("almost twelve o'clock", result);
	}
	
}
