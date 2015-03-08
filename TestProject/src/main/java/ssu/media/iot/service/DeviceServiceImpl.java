package ssu.media.iot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssu.media.iot.domain.APIKeys;
import ssu.media.iot.domain.Devices;

@Component("deviceService")
@Transactional
public class DeviceServiceImpl implements DeviceService{

	
	public APIKeysRepository apiKeyRepo;
	
	public DevicesRepository deviceRepo;
	
	@Autowired
	public DeviceServiceImpl(APIKeysRepository apiKeyRepo,
			DevicesRepository deviceRepo) {
		super();
		this.apiKeyRepo = apiKeyRepo;
		this.deviceRepo = deviceRepo;
	}

	@Override
	public Devices findDeviceByApiKey(String apiKey) {
		
		APIKeys apiKeyD = apiKeyRepo.findByApiKey(apiKey);
		
		System.out.println(apiKeyD.getApiKey());
		
		Devices device = apiKeyD.getApiOwnner();
		
		//Devices device = deviceRepo.findByApiKey(apiKeyD);
		
		if(device != null)
		System.out.println(device.getDeviceName());
		
		return device;
	}

}
