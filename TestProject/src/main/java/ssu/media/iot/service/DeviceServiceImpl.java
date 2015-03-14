package ssu.media.iot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssu.media.iot.domain.APIKeys;
import ssu.media.iot.domain.Devices;
import ssu.media.iot.domain.SensorDataField;

@Component("deviceService")
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
	public Devices findByDeviceId(Long deviceId, String apiKey) {
		
		Devices device = deviceRepo.findOne(deviceId);
		
		
		String checkString = isPublicField(device, apiKey);
		
		if(checkString.equals("OK"))
		{
			return device;
		}
		else
		{
			return new Devices(checkString);
		}
		
	}
	
	@Override
	public Devices getDeviceAndDataField(Long DeviceId,
			Integer fieldNumber, String apiKey) {
		
		Devices device = deviceRepo.findOne(DeviceId);
		
		String checkString = isPublicField(device, apiKey);
		
		if(checkString.equals("OK"))
		{
			List<SensorDataField> dataField =  sDataFieldRepo.findByDeviceIdAndFieldNumber(device, fieldNumber);
			
			device.setDataFields(dataField);
			
			setFieldNameForAPI(device, fieldNumber);
			
			return device;
		}
		else
		{
			return new Devices(checkString);
		}
	}
	
	@Override
	public String isPublicField(Devices device, String apiKey) {
	
		if(device.isPublic())
		{
			return "OK";
		}
		else
		{
			if(apiKey == null)
			{
				
				return "This device is private";
			}
			else
			{
				if(device.getApiKey().getApiKey().equals(apiKey))
				{
					
					return "OK";
				}
				
				return "wrong api key";
			}
		}
	}
	
	public void setFieldNameForAPI(Devices device, int fieldNumber) {
		if(fieldNumber == 1) {
			device.setDataName2(null);device.setDataName3(null);device.setDataName4(null);device.setDataName5(null);
		}
		if(fieldNumber == 2) {
			device.setDataName1(null);device.setDataName3(null);device.setDataName4(null);device.setDataName5(null);
		}
		if(fieldNumber == 3) {
			device.setDataName1(null);device.setDataName2(null);device.setDataName4(null);device.setDataName5(null);
		}
		if(fieldNumber == 4) {
			device.setDataName1(null);device.setDataName2(null);device.setDataName3(null);device.setDataName5(null);
		}
		if(fieldNumber == 5) {
			device.setDataName1(null);device.setDataName2(null);device.setDataName3(null);device.setDataName4(null);
		}
	}
	
	@Override
	public Map<Integer, String> dataNameMap(Devices device) {
		
		Map<Integer, String> nameMap = new HashMap<Integer, String>();
		
		if(device.getDataName1() != null) {
			nameMap.put(1, device.getDataName1());
		}
		if(device.getDataName2() != null) {
			nameMap.put(2, device.getDataName2());
		}
		if(device.getDataName3() != null) {
			nameMap.put(3, device.getDataName3());
		}
		if(device.getDataName4() != null) {
			nameMap.put(4, device.getDataName4());
		}
		if(device.getDataName5() != null) {
			nameMap.put(5, device.getDataName5());
		}
		
		
		return nameMap;
	}
}
