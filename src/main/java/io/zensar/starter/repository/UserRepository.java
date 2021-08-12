package io.zensar.starter.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import io.zensar.starter.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Modifying
	@Transactional
	@Query("UPDATE User u SET name=?2, mobile=?3, description=?4 WHERE id=?1")
	void updateUser(Long id, String name, String mobile, String description);
	
	
//	@Query("SELECT u.id, a.address FROM USER u, Address a WHERE LIKE u.id=?1 and a.uid=u.uid")
//	User getuserById(Long id);
	
}
