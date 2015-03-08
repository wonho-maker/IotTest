package ssu.media.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ssu.media.iot.domain.APIKeys;

import java.lang.String;
import java.util.List;


public interface APIKeysRepository extends JpaRepository<APIKeys, Long>  {
	
	
	APIKeys findByApiKey(String apikey);
}
