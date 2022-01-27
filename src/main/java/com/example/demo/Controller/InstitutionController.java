package com.example.demo.Controller;

import com.example.demo.Model.Institution;
import com.example.demo.Service.InstitutionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@CrossOrigin
@RequestMapping("/institution")
public class InstitutionController {
	private static final Logger LOG = LogManager.getLogger(InstitutionController.class);
	@Autowired
	InstitutionService institutionService;

	public InstitutionController(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @return
	 */
	@GetMapping("/allInstitutions")

	public ResponseEntity<Object> institutionList() {

		return institutionService.listAllInstitutions();

	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param institution
	 * @return
	 */
	@PostMapping("/addInstitution")

	public ResponseEntity<Object> addInstitution(@RequestBody Institution institution) {

		return institutionService.saveInstitution(institution);

	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param institution
	 * @return
	 */

	@PutMapping("/updateInstitute")
	public ResponseEntity<Object> updateInstitution(@RequestBody Institution institution) {

		
			return institutionService.updateInstitution(institution);
			

	}

}
