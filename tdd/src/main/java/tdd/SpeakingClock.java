package tdd;

import java.time.LocalTime;

public class SpeakingClock {
	
	private final static String MIDNIGHT = "Midnight";
	private final static String NOON = "Noon";

	public String getTimeAsString(LocalTime aTime) {
		String timeToString = null;
		if(LocalTime.MIDNIGHT.equals(aTime)){
			timeToString = MIDNIGHT;
		}else if(LocalTime.NOON.equals(aTime)){
			timeToString = NOON;
		}
		else{
			timeToString = aTime.toString();
		}
		return timeToString;
	}

}
