package ssu.media.iot.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ssu.media.iot.domain.Devices;
import ssu.media.iot.domain.SensorDataField;
import ssu.media.iot.service.DeviceService;
import ssu.media.iot.service.DevicesRepository;
import ssu.media.iot.service.SensorDataFieldRepository;


@RestController
@RequestMapping(value = "/api")
public class APIController {
	
	@Autowired
	public DevicesRepository deviceRepository;
	
	@Autowired
	public SensorDataFieldRepository sensorDataFieldRepo;
	
	@Autowired
	public DeviceService deviceService;
	
	@RequestMapping(value = "/devices/{deviceId}", method = RequestMethod.GET)
	public List<Devices> getDeviceData(@PathVariable Long deviceId,
									@RequestParam(value="key", required=false) String apiKey)
	{
		Devices device = deviceRepository.findOne(deviceId);
		
		System.out.println(device.getApiKey().getApiKey());
		
		List<Devices> deviceList = new ArrayList<Devices>();
		
		if(device.isPublic())
		{
			
			deviceList.add(device);
			
			return deviceList;
			
		}
		else
		{
			if(apiKey == null)
			{
				
				deviceList.add(new Devices("This device is private"));
				
				return deviceList;
			}
			else
			{
				if(device.getApiKey().getApiKey().equals(apiKey))
				{
					deviceList.add(device);
					
					return deviceList;
				}
				
				deviceList.add(new Devices("wrong api key"));
				
				return deviceList;
			}
			
		}
		
		
		/*Devices device = deviceRepository.findOne(deviceId);
		
		System.out.println(device.getApiKey().getApiKey());
		
		return device;*/
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateDeviceData(@RequestParam(value="key") String apiKey,
								@RequestParam(value="field1", required=false) Integer value1,
								@RequestParam(value="field2", required=false) Integer value2,
								@RequestParam(value="field3", required=false) Integer value3,
								@RequestParam(value="field4", required=false) Integer value4,
								@RequestParam(value="field5", required=false) Integer value5)
								
	{
		
		try{
		Devices device = deviceService.findDeviceByApiKey(apiKey);
		
		SensorDataField newData = new SensorDataField();
		
		if(device.getDataName1() != null && value1 != null)
			newData.setDataValue1(value1);
		if(device.getDataName2() != null && value2 != null)
			newData.setDataValue2(value1);
		if(device.getDataName3() != null && value3 != null)
			newData.setDataValue3(value1);
		if(device.getDataName4() != null && value4 != null)
			newData.setDataValue4(value1);
		if(device.getDataName5() != null && value5 != null)
			newData.setDataValue5(value1);
		
		//newData.setUpdateTime(new Timestamp(new Date().getTime()));
		
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Seoul"); 
		Calendar updateTime = Calendar.getInstance(timeZone);
		updateTime.setTime(new Date());
		
		System.out.println(updateTime.getTime());
		
		newData.setUpdateTime(updateTime.getTime());
		
		newData.setMappedDevice(device);
		
		sensorDataFieldRepo.save(newData);
		
		return "sucess";
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
			return "fail";
		}
		
	}
}
