package com.temperies.movie.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temperies.movie.dto.CompanyDTO;
import com.temperies.movie.dto.MovieDTO;
import com.temperies.movie.error.handling.EntityNotFoundException;
import com.temperies.movie.jpa.Company;
import com.temperies.movie.jpa.Movie;
import com.temperies.movie.repository.CompanyRepository;
import com.temperies.movie.repository.MovieRepository;
import com.temperies.movie.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	ModelMapper modelMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Override
	public List<CompanyDTO> findAll() {
		return companyRepository.findAll().stream().map(company -> modelMapper.map(company, CompanyDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CompanyDTO findById(Integer id) {
		return modelMapper.map(checkIfCompanyExists(id), CompanyDTO.class);
	}

	@Override
	public List<MovieDTO> findMoviesByCompanyId(Integer id) {
		Company company = checkIfCompanyExists(id);
		return movieRepository.findAllByCompany(company)
				.stream()
				.map(movie -> modelMapper.map(movie, MovieDTO.class))
				.collect(Collectors.toList());
	}
	
	private Company checkIfCompanyExists(Integer id) {
		Optional<Company> company = companyRepository.findById(id);
		if (company.isPresent()) {
			LOGGER.debug("Company founded: {}", company.get());
			return company.get();
		} else {
			LOGGER.error("Company ID: {} doesn't found", id);
			throw new EntityNotFoundException("Company ID: " + id + " doesn't found");
		}
	}

}
