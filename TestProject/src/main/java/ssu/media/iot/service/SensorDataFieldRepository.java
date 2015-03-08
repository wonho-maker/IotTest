package ssu.media.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ssu.media.iot.domain.SensorDataField;
import ssu.media.iot.domain.Devices;
import java.util.List;

public interface SensorDataFieldRepository extends JpaRepository<SensorDataField, Long> {
	
	List<SensorDataField> findByMappedDevice(Devices mappeddevice);
}
