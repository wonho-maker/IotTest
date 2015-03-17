package ssu.media.iot.service;


import java.util.Map;

import ssu.media.iot.domain.Devices;


public interface DeviceService {
	
	Devices findDeviceByApiKey(String apiKey);
	
	Devices findByDeviceId(Long deviceId, String apiKey, Boolean allData);
	
	Devices findByDeviceIdAndLastFieldsData(Long deviceId, String apiKey);
	
	Devices getDeviceAndDataOneField(Long deviceId, Integer fieldNumber, String apiKey, Boolean allData);
	
	Devices getDeviceAndLastDataOneField(Long deviceId, Integer fieldNumber, String apiKey);
	
	String isPublicField(Devices device, String apiKey);
	
	Map<Integer, String> dataNameMap(Devices device);
}
