package ssu.media.iot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssu.media.iot.domain.APIKeys;
import ssu.media.iot.domain.Devices;
import ssu.media.iot.domain.SensorDataField;

@Component("deviceService")
@Transactional
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	public APIKeysRepository apiKeyRepo;
	
	@Autowired
	public DevicesRepository deviceRepo;
	
	@Autowired
	public SensorDataFieldRepository sDataFieldRepo;
	

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
	
	@Override
	public Devices getDeviceAndDataField(Long DeviceId,
			Integer fieldNumber) {
		
		Devices device = deviceRepo.findOne(DeviceId);
		
		List<SensorDataField> dataField =  sDataFieldRepo.findByDeviceIdAndFieldNumber(DeviceId, fieldNumber);
		
		device.setDataField(dataField);
		
		//device.getDataField()
		
		return device;
	}
}
