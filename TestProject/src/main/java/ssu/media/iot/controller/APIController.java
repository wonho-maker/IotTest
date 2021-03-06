package ssu.media.iot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ssu.media.iot.domain.Devices;
import ssu.media.iot.service.DataFieldService;
import ssu.media.iot.service.DeviceService;


@RestController
@RequestMapping(value = "/api")
public class APIController {
	
	@Autowired
	public DeviceService deviceService;
	
	@Autowired
	public DataFieldService dataFieldService;
	
	@RequestMapping(value = "/devices/{deviceId}/fields", method = RequestMethod.GET)
	public Devices getDeviceFieldsData(@PathVariable Long deviceId,
									@RequestParam(value="key", required=false) String apiKey,
									@RequestParam(value="allData", required=false) Boolean allData)
									
	{
		if(allData != null) {
			return deviceService.findByDeviceId(deviceId, apiKey, allData);
		}
		else {
			return deviceService.findByDeviceId(deviceId, apiKey, false);
		}
	}
	
	@RequestMapping(value = "/devices/{deviceId}/fields/{fieldIdOrOption}", method = RequestMethod.GET)
	public Devices getFieldData(@PathVariable Long deviceId, @PathVariable String fieldIdOrOption,
								@RequestParam(value="key", required=false) String apiKey,
								@RequestParam(value="allData", required=false) Boolean allData)
	{
		Devices device;
		
		try {
			int fieldNumber = Integer.parseInt(fieldIdOrOption);
		
			if(allData != null) {
				device = deviceService.getDeviceAndDataOneField(deviceId, fieldNumber, apiKey, allData);
			}
			else
			{
				device = deviceService.getDeviceAndDataOneField(deviceId, fieldNumber, apiKey, false);
			}
			
			return device;
		}
		catch(Exception e) {
			if(fieldIdOrOption.equals("last")) {
				return deviceService.findByDeviceIdAndLastFieldsData(deviceId, apiKey);
			}
			
			return null;
		}
	
	}
	
	@RequestMapping(value = "/devices/{deviceId}/fields/{fieldId}/{option}", method = RequestMethod.GET)
	public Devices getFieldDataAndOption(@PathVariable Long deviceId, @PathVariable Integer fieldId,
								@PathVariable String option,
								@RequestParam(value="key", required=false) String apiKey,
								@RequestParam(value="allData", required=false) Boolean allData)
	{
		
		
		if(option.equals("last")) {
			return deviceService.getDeviceAndLastDataOneField(deviceId, fieldId, apiKey);
		}
			
		return null;
	
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateDeviceData(@RequestParam(value="key") String apiKey,
								@RequestParam(value="field1", required=false) String value1,
								@RequestParam(value="field2", required=false) String value2,
								@RequestParam(value="field3", required=false) String value3,
								@RequestParam(value="field4", required=false) String value4,
								@RequestParam(value="field5", required=false) String value5)
								
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
