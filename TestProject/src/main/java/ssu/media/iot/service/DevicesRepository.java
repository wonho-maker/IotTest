package ssu.media.iot.service;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ssu.media.iot.domain.Devices;
import ssu.media.iot.domain.TestUser;
import ssu.media.iot.domain.APIKeys;
import java.util.List;

public interface DevicesRepository extends JpaRepository<Devices, Long>{
	
	Collection<Devices> findByOwnner(TestUser ownner);
	
	Devices findByApiKey(APIKeys apikey); 

	
	
}
