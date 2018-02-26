package tdd;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalTime;

public class TestTimeAsString {
	
	StringFromTime myClock;
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
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testStaticMidnightNumeric(){
		//Given
		testTime = LocalTime.of(0, 0);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testStaticNoon(){
		//Given
		testTime = LocalTime.NOON;
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  testStaticNoonNumeric(){
		//Given
		testTime = LocalTime.of(12, 0);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  testStatic1PM(){
		//Given
		testTime = LocalTime.of(13, 0);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("one o'clock", result);
	}
	
	@Test
	public void  testStatic1AM(){
		//Given
		testTime = LocalTime.of(1, 0);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("one o'clock", result);
	}
	
	@Test
	public void  testStaticFivePast1PM(){
		//Given
		testTime = LocalTime.of(13, 05);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("five past one", result);
	}
	
	@Test
	public void  testStaticTenFortyFiveAM(){
		//Given
		testTime = LocalTime.of(10, 45);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("a quarter to eleven", result);
	}
	
	@Test
	public void  testStaticTenFifteenAM(){
		//Given
		testTime = LocalTime.of(10, 15);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("a quarter past ten", result);
	}
	
	@Test
	public void  testStaticTenThirty(){
		//Given
		testTime = LocalTime.of(10, 30);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("half past ten", result);
	}
	
	@Test
	public void  testStaticElevenTwentySeven(){
		//Given
		testTime = LocalTime.of(11, 27);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("just gone twenty five past eleven", result);
	}
	
	@Test
	public void  testStaticOneMinutePastTwelvePM(){
		//Given
		testTime = LocalTime.of(12, 01);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("just gone twelve o'clock", result);
	}
	
	@Test
	public void  testStaticElevenFiftyNinePM(){
		//Given
		testTime = LocalTime.of(23, 59);
		//When
		String result = StringFromLocalTime.getTimeAsString(testTime);
		//Then
		assertEquals("almost twelve o'clock", result);
	}
	
	@Test
	public void  testMidnight(){
		//Given
		testTime = LocalTime.MIDNIGHT;
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testMidnightNumeric(){
		//Given
		testTime = LocalTime.of(0, 0);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testNoon(){
		//Given
		testTime = LocalTime.NOON;
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  testNoonNumeric(){
		//Given
		testTime = LocalTime.of(12, 0);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("Noon", result);
	}
	
	@Test
	public void  test1PM(){
		//Given
		testTime = LocalTime.of(13, 0);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("one o'clock", result);
	}
	
	@Test
	public void  test1AM(){
		//Given
		testTime = LocalTime.of(1, 0);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("one o'clock", result);
	}
	
	@Test
	public void  testFivePast1PM(){
		//Given
		testTime = LocalTime.of(13, 05);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("five past one", result);
	}
	
	@Test
	public void  testTenFortyFiveAM(){
		//Given
		testTime = LocalTime.of(10, 45);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("a quarter to eleven", result);
	}
	
	@Test
	public void  testTenFifteenAM(){
		//Given
		testTime = LocalTime.of(10, 15);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("a quarter past ten", result);
	}
	
	@Test
	public void  testTenThirty(){
		//Given
		testTime = LocalTime.of(10, 30);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("half past ten", result);
	}
	
	@Test
	public void  testElevenTwentySeven(){
		//Given
		testTime = LocalTime.of(11, 27);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("just gone twenty five past eleven", result);
	}
	
	@Test
	public void  testOneMinutePastTwelvePM(){
		//Given
		testTime = LocalTime.of(12, 01);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("just gone twelve o'clock", result);
	}
	
	@Test
	public void  testElevenFiftyNinePM(){
		//Given
		testTime = LocalTime.of(23, 59);
		myClock = new StringFromLocalTime(testTime);
		//When
		String result = myClock.getTimeAsString();
		//Then
		assertEquals("almost twelve o'clock", result);
	}
	
}
