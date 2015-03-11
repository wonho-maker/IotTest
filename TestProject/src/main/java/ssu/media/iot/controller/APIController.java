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
import ssu.media.iot.service.DataFieldService;
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
	
	@Autowired
	public DataFieldService dataFieldService;
	
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
		
	}
	
	@RequestMapping(value = "/devices/{deviceId}/fields/{fieldId}", method = RequestMethod.GET)
	public Devices getFieldData(@PathVariable Long deviceId, @PathVariable Integer fieldId)
	{
		Devices device = deviceService.getDeviceAndDataField(deviceId, fieldId);
		
		//List<SensorDataField> dataField = sensorDataFieldRepo.findByDeviceFieldOne(device);
		
		//System.out.println(dataField);
		
		return device;
	
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
		
		Date uDate = new Date();
		
		if(value1 != null) {
			dataFieldService.storeDataToDeviceField(apiKey, value1, 1, uDate);
		}
		if(value2 != null) {
			dataFieldService.storeDataToDeviceField(apiKey, value2, 2, uDate);
		}
		if(value3 != null) {
			dataFieldService.storeDataToDeviceField(apiKey, value3, 3, uDate);
		}
		if(value4 != null) {
			dataFieldService.storeDataToDeviceField(apiKey, value4, 4, uDate);
		}
		if(value5 != null) {
			dataFieldService.storeDataToDeviceField(apiKey, value5, 5, uDate);
		}
		
		//newData.setUpdateTime(new Timestamp(new Date().getTime()));
		
		//TimeZone timeZone = TimeZone.getTimeZone("Asia/Seoul"); 
		//Calendar updateTime = Calendar.getInstance(timeZone);
		
	
		return "sucess";
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
			return "fail";
		}
		
	}
}
