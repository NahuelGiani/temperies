package com.temperies.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temperies.movie.jpa.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
