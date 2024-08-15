package com.example.Test.Controller;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test.Sevice.Sevice;
import com.example.Test.model.EmployeeDetails;

@RestController
public class TestControler {

	@Autowired
	Sevice serviceRepo;

	@GetMapping("/api/v1/name")
	public String getName() {
		return "Affan";
	}

	@PostMapping("/api/v1/saveUser")
	public ResponseEntity<EmployeeDetails> saveUsers(@RequestBody EmployeeDetails s) {

		try {
//			System.out.println("aaaaaaaaaaaa" + s.getName());
			EmployeeDetails save = serviceRepo.save(s);
			return new ResponseEntity(s, HttpStatusCode.valueOf(200));
		} catch (Exception e) {
			return new ResponseEntity(e, HttpStatusCode.valueOf(500));
		}

//		return 
	}

	@GetMapping("/api/v1/getAllDetails")
	public ResponseEntity< List<EmployeeDetails>> getDetails() {
		try {
			List<EmployeeDetails> findAll = serviceRepo.findAll();
			if(!findAll.isEmpty())
			{
				return new ResponseEntity(findAll,HttpStatusCode.valueOf(200));
			}
			else
			{
				return new ResponseEntity("No Such Element Found",HttpStatusCode.valueOf(200));
			}
		} catch (Exception e) {
			return new ResponseEntity("No Such Element Found",HttpStatusCode.valueOf(500));
		}
		
	}

	@PutMapping("/api/v1/updateUser/{id}")
	public ResponseEntity<?> updateRecords(@PathVariable int id, @RequestParam(name="name",required= false) String name,
			@RequestParam(name="firstname",required= false) String firstname,@RequestParam(name="doDate",required= false) String doDate) {
		try {
		 EmployeeDetails employeeDetails = serviceRepo.findById(id).get();
			
			System.out.println(employeeDetails);
			
			if (employeeDetails !=null) {
				if(firstname!=null)
				{
//				employeeDetails.setFirstname(firstname);
				employeeDetails.setName(name);
				}
				employeeDetails.setDoDate(doDate);
				serviceRepo.save(employeeDetails);
			
			}
			return new ResponseEntity(employeeDetails, HttpStatusCode.valueOf(200));
		} catch (Exception e) {
			return new ResponseEntity("No Record Found with ID : "+id, HttpStatusCode.valueOf(500));
			// TODO: handle exception
		}

	}
	@SuppressWarnings("deprecation")
	@DeleteMapping("api/v1/deleteById/{id}")
	public ResponseEntity<?> deleteResource(@PathVariable int id)
	{
		System.out.println(id);
			try {
				int id2 = serviceRepo.findById(id).get().getId();
				System.out.println(id2+"FFFFFFFFF");
				if(id2!=0)
				{
					serviceRepo.deleteById(id);
					return new ResponseEntity(HttpStatusCode.valueOf(200),HttpStatusCode.valueOf(200));
				}
				else
				{
					return new ResponseEntity("No Such Element Found",HttpStatusCode.valueOf(500));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(HttpStatusCode.valueOf(404),HttpStatusCode.valueOf(500));
				// TODO: handle exception
			}
		
		
	}
}
