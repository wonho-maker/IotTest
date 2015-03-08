package ssu.media.iot.controller;


import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ssu.media.iot.api.APIKeyGenerator;
import ssu.media.iot.domain.APIKeys;
import ssu.media.iot.domain.Devices;
import ssu.media.iot.domain.TestUser;
import ssu.media.iot.service.APIKeysRepository;
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
		
		//devicesRepository.save(new Devices("test device", "test description", "temp", "507", "v1", "v2", "v3", false, loginUser));
		
		Collection<Devices> loginUserDeivices = devicesRepository.findByOwnner(loginUser);
		
		for (Devices devices : loginUserDeivices) {
			if(devices.getApiKey() != null)
				System.out.println(devices.getApiKey().getApiKey());
		}
		//Collection<Devices> devices3 = devicesRepository.findOne(loginUser.getId());
		
		model.addAttribute("myDevices", loginUserDeivices);
		
		
		return "devices/myDevices";
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
	public String addNewMyDevice(Authentication authentication, Devices device, @RequestParam(value="filedsNumber") int filedNumber)
	{
		try
		{
			//System.out.println("filedNumber = "+filedNumber);
			TestUser loginUser = getLoginUser(authentication.getName());
			
			device.setOwnner(loginUser);
			filedNameGenerator(device, filedNumber);
			
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
	
	public Devices filedNameGenerator(Devices device, int filedNumber)
	{
		if(1 <= filedNumber)
			device.setDataName1("filed 1");
		
		if(2 <= filedNumber)
			device.setDataName2("filed 2");
		
		if(3 <= filedNumber)
			device.setDataName3("filed 3");
		
		if(4 <= filedNumber)
			device.setDataName4("filed 4");
		
		if(5 <= filedNumber)
			device.setDataName5("filed 5");
		
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
