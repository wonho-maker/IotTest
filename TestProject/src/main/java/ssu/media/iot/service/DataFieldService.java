package ssu.media.iot.service;

import java.util.Date;


public interface DataFieldService {
	
	boolean storeDataToDeviceField(String apiKey, String value, int fieldNumber);
	
	boolean storeDataToDeviceField(String apiKey, String value, int fieldNumber, Date date);
	
}
