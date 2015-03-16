package ssu.media.iot.controller;


import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ssu.media.iot.api.APIKeyGenerator;
import ssu.media.iot.domain.APIKeys;
import ssu.media.iot.domain.Devices;
import ssu.media.iot.domain.TestUser;
import ssu.media.iot.service.APIKeysRepository;
import ssu.media.iot.service.DeviceService;
import ssu.media.iot.service.DevicesRepository;
import ssu.media.iot.service.UserRepository;



@Controller
@RequestMapping(value = "/devices")
public class MyDevicesController {
	
	@Autowired
	private DevicesRepository devicesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private APIKeysRepository apiKeyRepository;
	
	@Autowired
	private DeviceService deviceService;
	
	/**
	 * Show user's device list
	 * 
	 * @param authentication - spring sec
	 * @param model - add device info.
	 * @return devices/myDevices - page
	 */
	
	@RequestMapping(value="/myDevices", method=RequestMethod.GET)
	public String viewMyDevices(Authentication authentication, Model model)
	{
		
		TestUser loginUser = getLoginUser(authentication.getName());
		
		Collection<Devices> loginUserDeivices = devicesRepository.findByOwnner(loginUser);
		
		model.addAttribute("myDevices", loginUserDeivices);
		
		return "devices/myDevices";
	}
	
	/**
	 * 
	 * @param authentication
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/viewMyDevice/{deviceId}", method=RequestMethod.GET)
	public String viewMyDeviceDetail(Authentication authentication, Model model,
									@PathVariable Long deviceId)
	{
		//System.out.println("in");
		Devices device = devicesRepository.findOne(deviceId);
		
		model.addAttribute("device", device);
		
	   // System.out.println(model.asMap().get("device"));
		
		Map<Integer, String> dataNameMap = deviceService.dataNameMap(device);
		
		if(dataNameMap != null){
		
		model.addAttribute("dataNameMap", dataNameMap);}
		
		return "devices/viewMyDevice";
	}
	
	@RequestMapping(value="/viewMyDevice/{deviceId}", method=RequestMethod.POST)
	public String updateMyDeviceSetting(Authentication authentication, @PathVariable Long deviceId, Devices device)
	{
		//Devices oDevice = devicesRepository.findOne(deviceId);
		
		System.out.println(device);
		
		//oDevice = device;
		
		device.setId(deviceId);
		
		TestUser loginUser = getLoginUser(authentication.getName());
		device.setOwnner(loginUser);
		
		devicesRepository.save(device);
		
		return "redirect:/devices/viewMyDevice/"+deviceId;
	}
	
	/**
	 * Add new user's device
	 * @return
	 */
	@RequestMapping(value = "/newMyDevice", method = RequestMethod.GET)
	public String newMyDevice(Devices device)
	{
		
		return "devices/newMyDevice";
	}
	
	@RequestMapping(value = "/newMyDevice", method = RequestMethod.POST)
	public String addNewMyDevice(Authentication authentication, Devices device, @RequestParam(value="fieldsNumber") int fieldNumber)
	{
		try
		{
			//System.out.println("filedNumber = "+filedNumber);
			TestUser loginUser = getLoginUser(authentication.getName());
			
			device.setOwnner(loginUser);
			fieldNameGenerator(device, fieldNumber);
			
			APIKeys newApiKey = new APIKeys(getNewApiKey(), new Date());
			newApiKey.setApiOwnner(device);
			
			//apiKeyRepository.save(newApiKey);
			
			device.setApiKey(newApiKey);
			
			System.out.println("apikey : "+newApiKey.getApiKey());
			
			devicesRepository.save(device);
			
			
			return "redirect:/devices/myDevices";
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
			return "redirect:/devices/newMyDevice?error";
		}
		
		
	}
	
	public TestUser getLoginUser(String userName)
	{
		//System.out.println(authentication.getName());
		
		return userRepository.findOneByUserName(userName);
		
	}
	
	public Devices fieldNameGenerator(Devices device, int fieldNumber)
	{
		if(1 <= fieldNumber)
			device.setDataName1("field 1");
		
		if(2 <= fieldNumber)
			device.setDataName2("field 2");
		
		if(3 <= fieldNumber)
			device.setDataName3("field 3");
		
		if(4 <= fieldNumber)
			device.setDataName4("field 4");
		
		if(5 <= fieldNumber)
			device.setDataName5("field 5");
		
		return device;
	
	}
	
	/**
	 * check a duplicate api key
	 * 
	 * @return String - new api key
	 */
	public String getNewApiKey()
	{	
		
		while(true)
		{
			String apiKeyTemp = APIKeyGenerator.randomString(16);
			try{
				if(apiKeyRepository.findByApiKey(apiKeyTemp) == null)
					return apiKeyTemp;
				}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}
	}
}
