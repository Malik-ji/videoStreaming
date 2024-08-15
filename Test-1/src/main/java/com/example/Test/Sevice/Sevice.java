package com.example.Test.Sevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.Test.model.EmployeeDetails;

@Service
public interface Sevice extends JpaRepository<EmployeeDetails,Integer>{

}
