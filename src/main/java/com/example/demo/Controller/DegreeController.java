package com.example.demo.Controller;

import com.example.demo.Model.Degree;
import com.example.demo.Service.DegreeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/degree")
public class DegreeController {
	private static final Logger LOG = LogManager.getLogger(DegreeController.class);
	@Autowired
	DegreeService degreeService;

	public DegreeController(DegreeService degreeService) {
		this.degreeService = degreeService;
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @return
	 */
	@GetMapping("/allDegree")

	public ResponseEntity<Object> degreeList() {

		return degreeService.listAllDegree();
	}

	@GetMapping("/{id}")

	public ResponseEntity<Object> degreeById(@PathVariable long id) {

		return degreeService.degreeById(id);
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param degree
	 * @return
	 */
	@PostMapping("/addDegree")

	public ResponseEntity<Object> addDegree(@RequestBody Degree degree) {

		return degreeService.saveDegree(degree);

	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param id
	 * @return
	 */

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDegree(@PathVariable long id, @RequestBody String name) {
		  Degree degreeObj = degreeService.findDegreeById(id);
		   return degreeService.updateDegreeAngular(degreeObj, name);
			

	}

	@PutMapping("/updateDegree1")
	public ResponseEntity<Object> updateDegree(@RequestBody Degree degree) {

		return degreeService.updateDegree(degree);

	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		return degreeService.deleteDegree(id);
	}

	}
