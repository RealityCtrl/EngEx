package tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpeakingClockTest {
	IClock mockClock;
	ISpeakingClockEngine mockEngine;
	ISpeechSynthesizer mockSynth;
	SpeakingClock aSpeakingClock;
	
	Time aTime;

	@Before
	public void setup(){
		mockClock = mock(IClock.class);
		mockEngine = mock(ISpeakingClockEngine.class);
		mockSynth = mock(ISpeechSynthesizer.class);
		aSpeakingClock = new SpeakingClock(mockClock,mockEngine,mockSynth);
	}
	
	@Test
	public void tellTheTimeHappyCase() throws Exception{
		aTime = new Time(0,0, Time.AM);
		when(mockClock.getTime()).thenReturn(aTime);
		when(mockEngine.translate(aTime)).thenReturn("midnight");
		
		aSpeakingClock.tellTheTime();
		
		verify(mockEngine).translate(aTime);
		verify(mockClock, times(1)).getTime();
		verify(mockSynth).speak("midnight");
	}
	
	@After
	public void tearDown(){
		mockClock = null;
		mockEngine = null;
		mockSynth = null;
	}
}
