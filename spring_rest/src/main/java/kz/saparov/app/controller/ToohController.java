package kz.saparov.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.app.entity.ToothEntity;
import kz.saparov.app.model.Tooth;
import kz.saparov.app.service.ToothService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tooth")
public class ToohController {
	
	private ToothService toothService;
	
	@Autowired
	public ToohController(ToothService toothService) {
		this.toothService = toothService;
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Tooth> describeTooth(@RequestBody ToothEntity tooth,
							                   @PathVariable("id") Long id ) {
		
		Tooth savedTooth= toothService.createUpdateTooth(tooth, id);
		return ResponseEntity.ok(savedTooth);
	}
}
