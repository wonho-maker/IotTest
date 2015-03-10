package ssu.media.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ssu.media.iot.service.DevicesRepository;
import ssu.media.iot.service.SensorDataFieldRepository;

@Controller
@RequestMapping(value = "/chart")
public class ChartController {
	
	@Autowired
	public DevicesRepository deviceRepository;
	
	@Autowired
	public SensorDataFieldRepository sensorDataFieldRepo;
	
	@RequestMapping(value = "/devices/{deviceId}", method = RequestMethod.GET)
	public String showDeviceChart(@PathVariable Long deviceId, Model model,
									@RequestParam(value = "key", required = false) String apiKey)						
	{
		//System.out.println("deviceID : " + deviceId);
		if(apiKey != null)
		{
			model.addAttribute("apiKey", apiKey);
		}
		//model.addAttribute("device", deviceRepository.findOne(deviceId));
		//model.addAttribute("dataField", sensorDataFieldRepo.findByMappedDevice(deviceRepository.findOne(deviceId)));
		
		return "chart";
	}
	
	@RequestMapping(value = "/channels/{channelId}", method = RequestMethod.GET)
	public String showChannelChart(@PathVariable Long channelId)
	{
		
		return "channel";
	}
}
