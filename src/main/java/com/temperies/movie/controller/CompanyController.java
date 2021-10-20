package com.temperies.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temperies.movie.dto.CompanyDTO;
import com.temperies.movie.dto.MovieDTO;
import com.temperies.movie.repository.CompanyRepository;
import com.temperies.movie.service.ICompanyService;

@RestController
@RequestMapping("companies")
public class CompanyController {
    
	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	ICompanyService companyService;
	
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getCompanies() {
        return new ResponseEntity<>( companyService.findAll(), HttpStatus.OK);
    }	
    
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Integer id) {
        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }
    
    @GetMapping("/{id}/movies")
    public ResponseEntity<List<MovieDTO>> getMoviesByCompanyId(@PathVariable Integer id) {
        return new ResponseEntity<>(companyService.findMoviesByCompanyId(id), HttpStatus.OK);
    }
    
}
