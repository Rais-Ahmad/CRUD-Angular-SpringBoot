package com.example.demo.Controller;

import com.example.demo.Model.Result;
import com.example.demo.Service.ResultService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.NoSuchElementException;

@EnableSwagger2
@RestController
@RequestMapping("/result")
public class ResultController {
	private static final Logger LOG = LogManager.getLogger(ResultController.class);
	@Autowired
	ResultService resultService;

	public ResultController(ResultService resultService) {
		this.resultService = resultService;
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @return
	 */
	@GetMapping("/allResults")

	public ResponseEntity<Object> allResults() {

		return (ResponseEntity<Object>) resultService.listAllResults();

	}
	
	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @return
	 */
	@PostMapping("/addResult")

	public ResponseEntity<Object> addResult(@RequestBody Result result) {

		return resultService.saveResult(result);

	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param result
	 * @return
	 */

	@PutMapping("/updateResult")
	public ResponseEntity<Object> updateResult(@RequestBody Result result) {

		try {
			resultService.updateStudentMarks(result);
			LOG.info("Result updated successfully:  " + result);
			return new ResponseEntity<>("Result updated successfully ", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			LOG.error(e.getMessage(), e);
			return new ResponseEntity<>("Result not found incorrect id ", HttpStatus.NOT_FOUND);
		}

	}	


}
