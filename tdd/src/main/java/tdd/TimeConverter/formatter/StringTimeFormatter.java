package tdd.TimeConverter.formatter;

import java.time.LocalTime;

public interface StringTimeFormatter {

	default String formatLocalTime(LocalTime aTime){
		return aTime.toString();
	}
}
