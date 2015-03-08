package ssu.media.iot.api;

import java.util.Random;



public class APIKeyGenerator {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();
	

	/*public static String getNewApiKey()
	{	
		
		while(true)
		{
			String apiKeyTemp = randomString(16);
		
			try
			{
				if(apiKeysRepo.findByApiKey(apiKeyTemp) == null)
					return apiKeyTemp;
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			
		}
	}*/
	
	public static String randomString( int len ) 
	{
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}

	
}
