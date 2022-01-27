package com.example.demo.Controller;

import com.example.demo.Model.Curriculum;
import com.example.demo.Service.CurriculumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
	private static final Logger LOG = LogManager.getLogger(DepartmentController.class);
	@Autowired
	CurriculumService curriculumService;

	public CurriculumController(CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @return
	 */

	@GetMapping("/allCurriculum")

	public ResponseEntity<Object> curriculumList() {

		return curriculumService.listAllUser();

	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 */
	@PostMapping("/addCurriculum")

	public ResponseEntity<Object> addCurriculum(@RequestBody Curriculum curriculum) {

		return curriculumService.saveCurriculum(curriculum);
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param curriculum
	 * @return
	 */
	@PutMapping("/updateCurriculum")
	public ResponseEntity<Object> updateCurriculum(@RequestBody Curriculum curriculum) {

		return curriculumService.updateCurriculum(curriculum);

	}

}
