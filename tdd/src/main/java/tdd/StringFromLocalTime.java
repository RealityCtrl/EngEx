package tdd;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringFromLocalTime implements StringFromTime {

	private final static String MIDNIGHT = "Midnight";
	private final static String NOON = "Noon";
	private final static String OClOCK = "o'clock";
	private final static List<Integer> MINUTES_ON_HOUR = (List<Integer>) Arrays.asList(0,60);
	private static LocalTime internalTime;

	private static Map<Integer, String> MINUTES_MAP = new HashMap<>();
	static{
		MINUTES_MAP.put(0, "");
		MINUTES_MAP.put(5, "five past");
		MINUTES_MAP.put(10, "ten past");
		MINUTES_MAP.put(15, "a quarter past");
		MINUTES_MAP.put(20, "twenty past");
		MINUTES_MAP.put(25, "twenty five past");
		MINUTES_MAP.put(30, "half past");
		MINUTES_MAP.put(35, "twenty five to");
		MINUTES_MAP.put(40, "twenty to");
		MINUTES_MAP.put(45, "a quarter to");
		MINUTES_MAP.put(50, "ten to");
		MINUTES_MAP.put(55, "five to");
		MINUTES_MAP.put(60, "");
	}
	public StringFromLocalTime(){

	}

	public StringFromLocalTime(LocalTime aTime){
		internalTime = aTime;
	}

	private static String hourToString(int aHour){
		String formattedHour = null;
		switch(aHour){
		case 1: case 13:
			formattedHour = "one";
			break;
		case 2: case 14:
			formattedHour = "two";
			break;
		case 3: case 15:
			formattedHour = "three";
			break;
		case 4: case 16:
			formattedHour = "four";
			break;
		case 5: case 17:
			formattedHour = "five";
			break;
		case 6: case 18:
			formattedHour = "six";
			break;
		case 7: case 19:
			formattedHour = "seven";
			break;
		case 8: case 20:
			formattedHour = "eight";
			break;
		case 9: case 21:
			formattedHour = "nine";
			break;
		case 10: case 22:
			formattedHour = "ten";
			break;
		case 11: case 23:
			formattedHour = "eleven";
			break;
		default:
			formattedHour = "twelve";
			break;
		}
		return formattedHour;
	}

	private static String convertLocalTimeToString(LocalTime aTime){
		StringBuilder myTimeString =  new StringBuilder();
		if(LocalTime.MIDNIGHT.equals(aTime)){
			myTimeString.append(MIDNIGHT);
		}else if(LocalTime.NOON.equals(aTime)){
			myTimeString.append(NOON);
		}
		else {
			int hour = aTime.getHour();
			int minutes = aTime.getMinute();
			if(minutes == 0 ){
				generateHourString(myTimeString, hour);
			}else{
				minutes = adjustMinutesForLookUp(myTimeString, minutes);
				myTimeString.append(generateMinutesText(hour, minutes));
			}
		}
		return myTimeString.toString();
	}

	private static void generateHourString(StringBuilder myTimeString, int hour) {
		myTimeString.append(hourToString(hour));
		myTimeString.append(" ");
		myTimeString.append(OClOCK);
	}

	private static StringBuilder generateMinutesText( int hour, int minutes) {
		StringBuilder myTimeString = new StringBuilder();
		if(!MINUTES_ON_HOUR.contains(minutes)){
			myTimeString.append(MINUTES_MAP.get(minutes));
			myTimeString.append(" ");
		}
		if(minutes>30){
			myTimeString.append(hourToString(++hour));
		}else{
			myTimeString.append(hourToString(hour));
		}
		if(MINUTES_ON_HOUR.contains(minutes)){
			myTimeString.append(" ");
			myTimeString.append(OClOCK);
		}
		return myTimeString;
	}

	private static int adjustMinutesForLookUp(StringBuilder myTimeString, int minutes) {
		if(minutes%5 > 2){
			myTimeString.append("almost ");
			minutes++;
			if(minutes%5 != 0){
				minutes++;
			}
		}else if(minutes%5 <= 2 && minutes%5 != 0){
			myTimeString.append("just gone ");
			minutes--;
			if(minutes%5 != 0){
				minutes--;
			}
		}
		return minutes;
	}

	public static String getTimeAsString(LocalTime aTime) {
		return convertLocalTimeToString(aTime);
	}

	/* (non-Javadoc)
	 * @see tdd.StringFromTime#getTimeAsString()
	 */
	@Override
	public String getTimeAsString() {
		return convertLocalTimeToString(internalTime);
	}

}
