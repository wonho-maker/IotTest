package ssu.media.iot.service;

import java.util.Date;


public interface DataFieldService {
	
	boolean storeDataToDeviceField(String apiKey, Integer value, int fieldNumber);
	
	boolean storeDataToDeviceField(String apiKey, Integer value, int fieldNumber, Date date);
	
}
