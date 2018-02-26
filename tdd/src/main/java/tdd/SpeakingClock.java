package tdd;

import java.time.LocalTime;

public class SpeakingClock {

	public String getTimeAsString(LocalTime aTime) {
		String timeToString = null;
		if(LocalTime.MIDNIGHT.equals(aTime)){
			timeToString = "Midnight";
		}
		return timeToString;
	}

}
