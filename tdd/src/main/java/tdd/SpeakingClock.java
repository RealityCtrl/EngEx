package tdd;

import java.time.LocalTime;

public class SpeakingClock {
	
	private final static String MIDNIGHT = "Midnight";
	private final static String NOON = "Noon";
	private static LocalTime internalTime;
	public SpeakingClock(){
		
	}
	
	public SpeakingClock(LocalTime aTime){
		internalTime = aTime;
	}
	
	private static String convertLocalTimeToString(LocalTime aTime){
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

	public static String getTimeAsString(LocalTime aTime) {
		return convertLocalTimeToString(aTime);
	}
	
	public String getTimeAsString() {
		return convertLocalTimeToString(internalTime);
	}

}
