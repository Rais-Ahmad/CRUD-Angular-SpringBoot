package com.example.demo.Controller;

import com.example.demo.Model.Exam;
import com.example.demo.Service.ExamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {
	private static final Logger LOG = LogManager.getLogger(ExamController.class);
	@Autowired
	ExamService examService;

	public ExamController(ExamService examService) {
		this.examService = examService;
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @return
	 */
	@GetMapping("/allExam")

	public ResponseEntity<Object> examList() {

		return examService.listAllExam();

		
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param exam
	 * @return
	 */
	@PostMapping("/addExam")

	public ResponseEntity<Object> addExam(@RequestBody Exam exam) {

		return examService.saveExam(exam);

	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param exam
	 * @return
	 */

	@PutMapping("/updateExam")
	public ResponseEntity<Object> updateExam(@RequestBody Exam exam) {

		return	examService.updateExam(exam);
			

	}	

}
