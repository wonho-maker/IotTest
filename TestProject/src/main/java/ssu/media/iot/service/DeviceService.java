package ssu.media.iot.service;


import java.util.Map;

import ssu.media.iot.domain.Devices;


public interface DeviceService {
	
	Devices findDeviceByApiKey(String apiKey);
	
	Devices findByDeviceId(Long deviceId, String apiKey, Boolean allData);
	
	Devices findByDeviceIdAndLastFieldsData(Long deviceId, String apiKey);
	
	Devices getDeviceAndDataField(Long DeviceId, Integer fieldNumber, String apiKey, Boolean allData);
	
	String isPublicField(Devices device, String apiKey);
	
	Map<Integer, String> dataNameMap(Devices device);
}
