package tdd;

public class Time {

	public enum AmPm {
		AM,PM
	}

	private final AmPm amPm;
	private int hour;
	private int minute;

	public Time(int hour, int minute, AmPm amPm) {
		this.hour = hour;
		this.minute = minute;
		this.amPm = amPm;
	}

	public static final AmPm AM = AmPm.AM;
	public static final AmPm PM = AmPm.PM;
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}

	public AmPm getAmPm() {
		return amPm;
	}
	
	public boolean isAm() {
		return amPm == AM;
	}

	public boolean isPm() {
		return amPm == PM;
	}

}
