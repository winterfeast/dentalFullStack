package kz.saparov.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.app.entity.ToothEntity;
import kz.saparov.app.entity.UserEntity;
import kz.saparov.app.exception.ResourceNotFoundException;
import kz.saparov.app.model.Tooth;
import kz.saparov.app.repository.ToothRepository;
import kz.saparov.app.repository.UserRepository;

@Service
public class ToothService {
	private ToothRepository toothRepository;
	private UserRepository userRepository;

	@Autowired
	public ToothService(ToothRepository toothRepository, UserRepository userRepository) {
		this.toothRepository = toothRepository;
		this.userRepository = userRepository;
	}
	
	public Tooth createUpdateTooth(ToothEntity tooth, Long id) {
		UserEntity user = userRepository.findById(id)
		          .orElseThrow(()-> new ResourceNotFoundException("Пациент с id:" + id + " не найден"));
		tooth.setUser(user);
		
		return Tooth.toModel(toothRepository.save(tooth));
	}
}
