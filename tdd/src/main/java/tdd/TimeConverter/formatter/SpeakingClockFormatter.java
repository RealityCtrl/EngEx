package tdd.TimeConverter.formatter;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SpeakingClockFormatter implements StringTimeFormatter {
	
	private final static String MIDNIGHT = "Midnight";
	private final static String NOON = "Noon";
	private final static String OClOCK = "o'clock";
	private final static List<Integer> MINUTES_ON_HOUR = (List<Integer>) Arrays.asList(0,60);

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
	
	private enum HoursText{
		
		ZERO(0,"twelve"),ONE(1, "one"),TWO(2, "two"), THREE(3,"three"),FOUR(4, "four"),FIVE(5,"five"),
		SIX(6,"six"),SEVEN(7,"seven"),EIGHT(8,"eight"),NINE(9,"nine"),TEN(10,"ten"),ELEVEN(11,"eleven"),
		TWELVE(12,"twelve"),THIRTEEN(13, "one"),FOURTEEN(14, "two"), FIFTEEN(15,"three"),SIXTEEN(16, "four"),
		SEVENTEEN(17,"five"),EIGHTEEN(18,"six"),NINETEEN(19,"seven"),TWENTY(20,"eight"),TWENTy_ONE(21,"nine"),
		TWENTy_TWO(22,"ten"),TWENTy_THREE(23,"eleven"),TWENTy_FOUR(24,"twelve");
		
		int aHour;
		String aStringTime;
		HoursText(int hour, String stringTime){
			aHour = hour;
			aStringTime = stringTime;
		}
		
		public static Map<Integer, HoursText> hourIntegerMap;
		static{
			List<HoursText> myValues = Arrays.asList(values());
			hourIntegerMap = myValues.stream().collect(Collectors.toMap(HoursText::getHour, e->e));
		}
		private int getHour(){
			return aHour;
		}
		
		public static String stringFromInt(int aInt){
			return hourIntegerMap.get(aInt).toString();
		}
		
		public String toString(){
			return aStringTime;
		}
	}
	
	public String formatLocalTime(LocalTime aTime){
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
		appendOClock(myTimeString);
	}
	
	private static String hourToString(int aHour){
		return HoursText.stringFromInt(aHour);
	}

	private static void appendOClock(StringBuilder myTimeString) {
		myTimeString.append(" ");
		myTimeString.append(OClOCK);
	}

	private static StringBuilder generateMinutesText( int hour, int minutes) {
		StringBuilder myTimeString = new StringBuilder();
		if(!isExactlyAnHour(minutes)){
			myTimeString.append(MINUTES_MAP.get(minutes));
			myTimeString.append(" ");
		}
		if(minutes>30){
			myTimeString.append(hourToString(++hour));
		}else{
			myTimeString.append(hourToString(hour));
		}
		if(isExactlyAnHour(minutes)){
			appendOClock(myTimeString);
		}
		return myTimeString;
	}

	private static boolean isExactlyAnHour(int minutes) {
		return MINUTES_ON_HOUR.contains(minutes);
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
}
