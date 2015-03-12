package ssu.media.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ssu.media.iot.domain.SensorDataField;
import ssu.media.iot.domain.Devices;

import java.util.List;


public interface SensorDataFieldRepository extends JpaRepository<SensorDataField, Long> {
	
	@Query("SELECT d FROM SensorDataField d WHERE d.mappedField = ?1 AND d.fieldNumber = ?2")
	List<SensorDataField> findByDeviceIdAndFieldNumber(Devices device, Integer fieldNumber);
	
	//@PersistenceContext
	//private EntityManager em;
	
	//List<SensorDataField> findByMappedDevice(Devices mappedField);
	
	/*@Query("select new ssu.media.iot.domain.SensorDataField(f.dataValue1, f.update_time)"
			+ "from SensorDataField f where f.mappedDevice = :mdevice")
	List<SensorDataField> findByDeviceFieldOne(@Param("mdevice")Devices mappedDevice);
	
	 /*
	 * select new sample.data.jpa.domain.RatingCount(r.rating, count(r)) "
			+ "from Review r where r.hotel = ?1 group by r.rating order by r.rating DESC"
	 */
//	/@Query("select new ssu.media.iot.domain.SensorDataField(dataValue+"fieldNumber+"r.update_time)")
}
