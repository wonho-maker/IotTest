package ssu.media.iot.service;

import java.util.ArrayList;
import java.util.Date;
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
		
		Devices device = apiKeyD.getApiOwnner();
		
		//Devices device = deviceRepo.findByApiKey(apiKeyD);
		
		
		return device;
	}
	
	@Override
	public Devices findByDeviceId(Long deviceId, String apiKey, Boolean allData) {
		
		Devices device = deviceRepo.findOne(deviceId);
		
		String checkString = isPublicField(device, apiKey);
		
		if(checkString.equals("OK"))
		{
			if(allData) {
				return device;
			}
			else {
				Date start = new Date();
				start.setTime(start.getTime() - 6 * 60 * 60 * 1000);
				Date end = new Date();
				List<SensorDataField> dataField =  sDataFieldRepo.findByDeviceIdOneDay(device, start, end);
				
				device.setDataFields(dataField);
				
				return device;
			}
			
		}
		else
		{
			return new Devices(checkString);
		}
		
	}
	
	@Override
	public Devices findByDeviceIdAndLastFieldsData(Long deviceId, String apiKey) {
		Devices device = deviceRepo.findOne(deviceId);
		
		String checkString = isPublicField(device, apiKey);
		
		if(checkString.equals("OK"))
		{
			int lastIndex = device.getDataFields().size() -1;
			
			List<SensorDataField> lastFields = new ArrayList<SensorDataField>();
			
			Map<Integer, String> dataName = dataNameMap(device);
			
			System.out.println(dataName.isEmpty());
			
			while(!dataName.isEmpty()) {
				
				if(lastIndex < 0)
					break;
				
				SensorDataField lastField = device.getDataFields().get(lastIndex);
				
				Integer fieldNumberKey = lastField.getFieldNumber();
				//System.out.println(dataName);
				if(dataName.containsKey(fieldNumberKey)) {
					//System.out.println(lastField);
					lastFields.add(lastField);
					dataName.remove(lastField.getFieldNumber());
				}
				
				lastIndex--;
			}
			
			device.setDataFields(lastFields);
			
			List<SensorDataField> dataField = device.getDataFields();
				
			device.setDataFields(dataField);
				
			return device;
			
		}
		else
		{
			return new Devices(checkString);
		}
	}
	
	@Override
	public Devices getDeviceAndDataOneField(Long deviceId,
			Integer fieldNumber, String apiKey, Boolean allData) {
		
		Devices device = deviceRepo.findOne(deviceId);
		
		String checkString = isPublicField(device, apiKey);
		
		if(checkString.equals("OK"))
		{
			if(allData) {
				List<SensorDataField> dataField =  sDataFieldRepo.findByDeviceIdAndFieldNumber(device, fieldNumber);
				
				device.setDataFields(dataField);
				
				setFieldNameForAPI(device, fieldNumber);
				
				return device;
			}
			else
			{
				Date start = new Date();
				start.setTime(start.getTime() - 6 * 60 * 60 * 1000);
				
				Date end = new Date();
				
				
				List<SensorDataField> dataField =  sDataFieldRepo.findByDeviceIdAndFieldNumberOneDay(device, fieldNumber, start, end);
				
				device.setDataFields(dataField);
				
				setFieldNameForAPI(device, fieldNumber);
				
				return device;
			}
		}
		else
		{
			return new Devices(checkString);
		}
	}
	
	@Override
	public Devices getDeviceAndLastDataOneField(Long deviceId, Integer fieldNumber, String apiKey)
	{
		Devices device = deviceRepo.findOne(deviceId);
		
		
		String checkString = isPublicField(device, apiKey);
		
		if(checkString.equals("OK"))
		{
			int lastIndex = device.getDataFields().size() -1;
			
			SensorDataField lastField = null;
			
			while(lastIndex > 0){
			
			    lastField = device.getDataFields().get(lastIndex);
				
				if(lastField.getFieldNumber() == fieldNumber) {
					break;
				}
				else
				{
					lastIndex--;
				}
			
			}
			
			if(lastIndex < 0){
				lastField = new SensorDataField();
			}
			
			device.getDataFields().clear();
			
			device.getDataFields().add(lastField);
			
			List<SensorDataField> dataField = device.getDataFields();
				
			device.setDataFields(dataField);
			
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
