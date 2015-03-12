package ssu.media.iot.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssu.media.iot.domain.Devices;
import ssu.media.iot.domain.SensorDataField;


@Component("dataFieldService")
public class DataFieldServiceImpl implements DataFieldService{
	
	
	@Autowired
	SensorDataFieldRepository sDataFieldRepo;
	
	@Autowired
	DeviceService deviceService;
	
	@Override
	public boolean storeDataToDeviceField(String apiKey, Integer value, int fieldNumber) 
	{
		Devices device = deviceService.findDeviceByApiKey(apiKey);
		
		if((device.getDataName1() == null && fieldNumber == 1) ||
			(device.getDataName2() == null && fieldNumber == 2) ||
			(device.getDataName3() == null && fieldNumber == 3) ||
			(device.getDataName4() == null && fieldNumber == 4) ||
			(device.getDataName5() == null && fieldNumber == 5) ){
				return false; }
			
		
		SensorDataField newData = new SensorDataField();
		newData.setDataValue(value);
		newData.setUpdateTime(new Date());
		newData.setFieldNumber(fieldNumber);
		newData.setMappedField(device);
		
		sDataFieldRepo.save(newData);
		
		return true;
	}
	
	@Override
	public boolean storeDataToDeviceField(String apiKey, Integer value,
			int fieldNumber, Date date) {
		
		Devices device = deviceService.findDeviceByApiKey(apiKey);
		
		if((device.getDataName1() == null && fieldNumber == 1) ||
			(device.getDataName2() == null && fieldNumber == 2) ||
			(device.getDataName3() == null && fieldNumber == 3) ||
			(device.getDataName4() == null && fieldNumber == 4) ||
			(device.getDataName5() == null && fieldNumber == 5) ){
				return false; }
			
		
		SensorDataField newData = new SensorDataField();
		newData.setDataValue(value);
		newData.setUpdateTime(date);
		newData.setFieldNumber(fieldNumber);
		newData.setMappedField(device);
		
		sDataFieldRepo.save(newData);
		
		return true;
	}
	
	
}
