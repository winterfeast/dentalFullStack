package kz.saparov.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.app.entity.UserEntity;
import kz.saparov.app.exception.ResourceNotFoundException;
import kz.saparov.app.model.User;
import kz.saparov.app.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() {
		return userRepository.findAll().stream()
									   .map(a->User.UserListModel(a))
									   .collect(Collectors.toList());
	}
	
	public User findById(Long id) {
		UserEntity user = userRepository.findById(id)
				          .orElseThrow(()-> new ResourceNotFoundException("Пациент с id:" + id + " не найден"));
		return User.toModel(user);
	}
	
	public User saveUser(UserEntity user) {
		return User.toModel(userRepository.save(user));
	}
	
	public User updateUser(Long id, UserEntity userDetails) {
		UserEntity user = userRepository.findById(id)
				          .orElseThrow(()-> new ResourceNotFoundException("Пациент с id:" + id + " не найден"));
		user.setLastName(userDetails.getLastName());
		user.setName(userDetails.getName());
		user.setTeeth(userDetails.getTeeth());
		user.setPhone(userDetails.getPhone());
		user.setTeeth(userDetails.getTeeth());
		return User.toModel(userRepository.save(user));
	}
	
	public Map<String, Boolean> deleteUser(Long id) {
		UserEntity user = userRepository.findById(id)
				          .orElseThrow(()-> new ResourceNotFoundException("Пациент с id:" + id + " не найден"));
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}	
}





