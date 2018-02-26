package tdd.speakingclock;

import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.Matcher;

import tdd.speakingclock.IClock.ClockException;

public class SpeakingClock {

	private IClock clock;
	private ISpeakingClockEngine engine;
	private ISpeechSynthesizer synthesizer; 

	/**
	 * For test purposes, so we can provide our own collaborators
	 * 
	 * @param clock
	 * @param engine
	 * @param synth
	 */
	public SpeakingClock(IClock clock, ISpeakingClockEngine engine, ISpeechSynthesizer synth) {
		setClock(clock);
		setEngine(engine);
		setSynthesizer(synth);
	}
	
	public void init() {
		ensureDependenciesInjected();
		// any other initialization
	}
	
	public void tellTheTime() {
		ensureDependenciesInjected();
		String translatedTime = null;
		try {
			Time time = clock.getTime();
			translatedTime = engine.translate(time);
			synthesizer.speak(translatedTime);
		} catch(ClockException ex) {
			throw new RuntimeException(ex);
		}
	}
	
//	public void tellTheTime() {
//		ensureDependenciesInjected();
//		String translatedTime = null;
//		try {
//			Time time = clock.getTime();
//			translatedTime = engine.translate(time);
//		} catch(ClockException ex) {
//			translatedTime = "Sorry, time server down";
//		}
//		synthesizer.speak(translatedTime);
//	}
	
	

	private void ensureDependenciesInjected() {
		ensureDependencyInjected(clock, engine, synthesizer);
	}

	private void ensureDependencyInjected(Object... objects) {
		for (Object object: objects) {
			ensureThat(object, is(not(nullValue())));
		}
	}
	
	private static void ensureThat(Object o, Matcher m) {
		if (!m.matches(o)) {
			throw new IllegalStateException();
		}
	}

	
	public void setClock(IClock clock) {
		this.clock = clock;
	}
	public void setEngine(ISpeakingClockEngine engine) {
		this.engine = engine;
	}
	public void setSynthesizer(ISpeechSynthesizer synthesizer) {
		this.synthesizer = synthesizer;
	}
	
}
