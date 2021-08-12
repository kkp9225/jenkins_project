package io.zensar.starter.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.zensar.starter.model.User;
import io.zensar.starter.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public void saveUser(User user) {
		this.userRepository.save(user);
	}

	public void updateUser(Long id, String name, String mobile, String description) {
		this.userRepository.updateUser(id, name, mobile, description);
	}

	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return this.userRepository.findOne(id);
	}

	public void deleteUser(Long id) {
		this.userRepository.delete(id);
	}
}
