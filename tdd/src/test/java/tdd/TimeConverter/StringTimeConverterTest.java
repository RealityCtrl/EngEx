package tdd.TimeConverter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import tdd.TimeConverter.formatter.StringTimeFormatter;

public class StringTimeConverterTest {
	
	StringTimeFormatter mockFormatterMidnight;
	StringTimeFormatter mockFormatterTwelve;
	StringTimeConverter myConverter;
	
	@Before
	public void setup(){
		mockFormatterMidnight = mock(StringTimeFormatter.class);
		mockFormatterTwelve  = mock(StringTimeFormatter.class);
		myConverter = new StringTimeConverter(LocalTime.MIDNIGHT, mockFormatterMidnight);
	}
	
	@Test
	public void  testMidnight(){
		when(mockFormatterMidnight.formatLocalTime(LocalTime.MIDNIGHT)).thenReturn("Midnight");
		//When
		String result = myConverter.convertTime();
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testSecondIvocationReturnCachedValue(){
		when(mockFormatterMidnight.formatLocalTime(LocalTime.MIDNIGHT)).thenReturn("Midnight").thenReturn("Second");
		//When
		String result = myConverter.convertTime();
		assertEquals("Midnight", result);
		result = myConverter.convertTime();
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testChangeformatter(){
		when(mockFormatterMidnight.formatLocalTime(LocalTime.MIDNIGHT)).thenReturn("Midnight");
		when(mockFormatterTwelve.formatLocalTime(LocalTime.MIDNIGHT)).thenReturn("Twelve");
		//When
		myConverter.convertTime();
		String result = myConverter.convertTime();
		//Then
		assertEquals("Midnight", result);
		myConverter.setFormatter(mockFormatterTwelve);
		result = myConverter.convertTime();
		assertEquals("Twelve", result);
	}
	
	@Test
	public void  testChangeTime(){
		
		myConverter.setFormatter(new SimplemTimeFomatter());
		//When
		String result = myConverter.convertTime();
		//Then
		assertEquals("00:00", result);
		myConverter.setLocalTime(LocalTime.NOON);
		result = myConverter.convertTime();
		assertEquals("12:00", result);
	}
	

	@Test
	public void  testMidnightToString(){
		when(mockFormatterMidnight.formatLocalTime(LocalTime.MIDNIGHT)).thenReturn("Midnight");
		//When
		String result = myConverter.toString();
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testSecondIvocationReturnCachedValueToString(){
		when(mockFormatterMidnight.formatLocalTime(LocalTime.MIDNIGHT)).thenReturn("Midnight").thenReturn("Second");
		//When
		String result = myConverter.toString();
		assertEquals("Midnight", result);
		result = myConverter.toString();
		//Then
		assertEquals("Midnight", result);
	}
	
	@Test
	public void  testChangeformatterToString(){
		when(mockFormatterMidnight.formatLocalTime(LocalTime.MIDNIGHT)).thenReturn("Midnight");
		when(mockFormatterTwelve.formatLocalTime(LocalTime.MIDNIGHT)).thenReturn("Twelve");
		//When
		myConverter.convertTime();
		String result = myConverter.toString();
		//Then
		assertEquals("Midnight", result);
		myConverter.setFormatter(mockFormatterTwelve);
		result = myConverter.toString();
		assertEquals("Twelve", result);
	}
	
	@Test
	public void  testChangeTimeToString(){
		
		myConverter.setFormatter(new SimplemTimeFomatter());
		//When
		String result = myConverter.toString();
		//Then
		assertEquals("00:00", result);
		myConverter.setLocalTime(LocalTime.NOON);
		result = myConverter.toString();
		assertEquals("12:00", result);
	}
	class SimplemTimeFomatter implements StringTimeFormatter{
		
	}
}
