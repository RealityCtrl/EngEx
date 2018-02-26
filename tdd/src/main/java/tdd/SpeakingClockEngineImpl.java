package tdd;

public class SpeakingClockEngineImpl implements ISpeakingClockEngine {

	String[] integers = {
			"",
			"one",
			"two",
			"three",
			"four",
			"five",
			"six",
			"seven",
			"eight",
			"nine",
			"ten",
			"eleven",
	};
	/* (non-Javadoc)
	 * @see com.mycompany.speakingclock.SpeakingClockEngine#translate(com.mycompany.speakingclock.Time)
	 */
	public String translate(Time time) {
		if (time.getMinute() == 0) {
			int hour = time.getHour();
			switch(hour) {
			case 12:
				if (time.isAm()) {
					return "midnight";
				} else {
					return "noon";
				}
			default:
				String hourStr = integers[hour];
				String morningAfternoonStr = 
					time.isAm()?"morning":time.getHour()<6?"afternoon":"evening";
				return hourStr + " o'clock in the " + morningAfternoonStr;
			}
		}
		return "cannot translate that time yet";
	}

}
