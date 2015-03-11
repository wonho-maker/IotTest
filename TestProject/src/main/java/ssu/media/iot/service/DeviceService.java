package ssu.media.iot.service;


import ssu.media.iot.domain.Devices;


public interface DeviceService {
	
	Devices findDeviceByApiKey(String apiKey);
	
	Devices getDeviceAndDataField(Long DeviceId, Integer fieldNumber);
}
