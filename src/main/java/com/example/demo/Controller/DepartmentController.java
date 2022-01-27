package com.example.demo.Controller;

import com.example.demo.Model.Department;
import com.example.demo.Service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/department")
public class DepartmentController {
	private static final Logger LOG = LogManager.getLogger(DepartmentController.class);
	DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @return
	 */
	@GetMapping("/allDepartments")

	public ResponseEntity<Object> departmentList() {

		return departmentService.listAllUser();

	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param department
	 * @return
	 */

	@PostMapping("/addDepartment")

	public ResponseEntity<Object> addDepartment(@RequestBody Department department) {

		return departmentService.saveDepartment(department);
	}

	/**
	 * @author RaisAhmad
	 * @date 29/10/2021
	 * @param department
	 * @return
	 */
	@PutMapping("/updateDepartment")
	public ResponseEntity<Object> updateDepartment(@RequestBody Department department) {

		return departmentService.updateDepartment(department);

	}

}
