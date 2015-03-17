package ssu.media.iot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/chart")
public class ChartController {
	
	
	
	@RequestMapping(value = "/devices/{deviceId}/fields", method = RequestMethod.GET)
	public String showDeviceChart(@PathVariable Long deviceId, Model model,
									@RequestParam(value = "key", required = false) String apiKey)						
	{
		//System.out.println("deviceID : " + deviceId);
		if(apiKey != null)
		{
			model.addAttribute("apiKey", apiKey);
		}
		
		return "chart";
	}
	
	@RequestMapping(value = "/devices/{deviceId}/fields/{fieldNumber}", method = RequestMethod.GET)
	public String showDeviceFieldChart(@PathVariable Long deviceId, @PathVariable Long fieldNumber, 
									@RequestParam(value = "key", required = false) String apiKey
									, Model model)						
	{
		if(apiKey != null)
		{
			model.addAttribute("apiKey", apiKey);
		}
		
		//System.out.println("in");
		
		return "chart";
	}
	
	@RequestMapping(value = "/channels/{channelId}", method = RequestMethod.GET)
	public String showChannelChart(@PathVariable Long channelId)
	{
		
		return "channel";
	}
}
