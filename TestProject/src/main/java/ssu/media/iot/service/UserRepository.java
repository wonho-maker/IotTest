package ssu.media.iot.service;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;



import ssu.media.iot.domain.TestUser;

public interface UserRepository extends JpaRepository<TestUser, Long> {
	
	Collection<TestUser> findByUserName(String userName); //userName is userID
	
	TestUser findOneByUserName(String userName);
	
	Collection<TestUser> findByStudentNumber(String studentNumber);
}
