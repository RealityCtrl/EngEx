package tdd.TimeConverter;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import tdd.TimeConverter.formatter.StringTimeFormatter;

public class StringTimeConverter implements TimeConveter {

	private LocalTime internalTime;
	private StringTimeFormatter aStringTimeFormatter;
	private String formattedString;
	
	public StringTimeConverter(LocalTime aTime, StringTimeFormatter aFormatter){
		Objects.requireNonNull(aTime);	
		Objects.requireNonNull(aFormatter);	
		internalTime = aTime;
		aStringTimeFormatter = aFormatter;
	}

	private String convertLocalTimeToString(){
		formattedString = aStringTimeFormatter.formatLocalTime(internalTime);
		return formattedString;
	}
	
	public void setFormatter(StringTimeFormatter aFormatter){
		Objects.requireNonNull(aFormatter);	
		formattedString =null; //clear cached String as formatting changed
		aStringTimeFormatter = aFormatter;
	}
	
	public void setLocalTime(LocalTime aTime){
		formattedString =null; //clear cached String as time changed
		internalTime = aTime;
	}

	/* (non-Javadoc)
	 * @see tdd.TimeConveter#getTimeAsString()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String convertTime() {
		if(formattedString != null){
			return formattedString;
		}
		else{
			return convertLocalTimeToString();
		}
	}
	
	@Override
	public String toString(){
		return convertTime();
	}

}
