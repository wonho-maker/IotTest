package ssu.media.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ssu.media.iot.domain.SensorDataField;
import ssu.media.iot.domain.Devices;

import java.util.Date;
import java.util.List;


public interface SensorDataFieldRepository extends JpaRepository<SensorDataField, Long> {
	
	@Query("SELECT d FROM SensorDataField d WHERE d.mappedField = ?1 AND d.fieldNumber = ?2")
	List<SensorDataField> findByDeviceIdAndFieldNumber(Devices device, Integer fieldNumber);
	
	@Query("SELECT d FROM SensorDataField d WHERE d.mappedField = ?1 AND d.fieldNumber = ?2 AND d.updateTime BETWEEN ?3 AND ?4")
	List<SensorDataField> findByDeviceIdAndFieldNumberOneDay(Devices device, Integer fieldNumber, Date start, Date end);
	
	@Query("SELECT d FROM SensorDataField d WHERE d.mappedField = ?1 AND d.updateTime BETWEEN ?2 AND ?3")
	List<SensorDataField> findByDeviceIdOneDay(Devices device, Date start, Date end);
}
