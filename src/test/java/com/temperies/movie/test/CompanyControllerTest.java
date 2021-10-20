package com.temperies.movie.test;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.temperies.movie.dto.CompanyDTO;
import com.temperies.movie.error.handling.EntityNotFoundException;
import com.temperies.movie.service.ICompanyService;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	ICompanyService companyService;

	List<CompanyDTO> allCompanies;

	@BeforeEach
	void setUp() {
		this.allCompanies = new ArrayList<>();
		CompanyDTO company1 = new CompanyDTO(1, "Warner Bros", "3400 Warner Blvd, Burbank, CA", 5000000.0);
		CompanyDTO company2 = new CompanyDTO(2, "Paramount Pictures", "5555 Melrose Avenue, Hollywood, California'", 8000000.0);
		CompanyDTO company3 = new CompanyDTO(3, "Fox Pictures", "10201 W. Pico Blvd., Bldg. 78 , Los Angeles, CA", 3500000.0);
		CompanyDTO company4 = new CompanyDTO(4, "Jersey Films", "10351 Santa Monica Blvd, Los Angeles, CA", 2000000.0);
		allCompanies.add(company1);
		allCompanies.add(company2);
		allCompanies.add(company3);
		allCompanies.add(company4);
	}

	@Test
	public void testFindAllCompanies() throws Exception {
		given(companyService.findAll()).willReturn(this.allCompanies);

		this.mvc.perform(get("/companies"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(this.allCompanies.size())));
	}

	@Test
	public void testFindCompanyById() throws Exception {
		final Integer id = 1;
		given(companyService.findById(id)).willReturn(this.allCompanies.get(0));

		this.mvc.perform(get("/companies/{id}", id))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(this.allCompanies.get(0).getName())));
	}
	
	@Test
	public void testGet404WhenCompanyDoesntExist() throws Exception {
		final Integer id = 7;
		given(companyService.findById(id)).willThrow(new EntityNotFoundException("Company ID: " + id + "doesn't exists"));

		this.mvc.perform(get("/companies/{id}", id)).andExpect(status().isNotFound());
	}

}