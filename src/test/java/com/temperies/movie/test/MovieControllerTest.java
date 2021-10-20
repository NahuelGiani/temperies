package com.temperies.movie.test;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.temperies.movie.dto.CompanyDTO;
import com.temperies.movie.dto.MovieDTO;
import com.temperies.movie.dto.ScriptDTO;
import com.temperies.movie.error.handling.EntityNotFoundException;
import com.temperies.movie.service.IMovieService;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	IMovieService movieService;

	List<MovieDTO> allMovies;

	@BeforeEach
	void setUp() {
		this.allMovies = new ArrayList<>();
		MovieDTO movie1 = new MovieDTO("Casablanca", (short) 102, new Date(), 8.4,
				new CompanyDTO(1, "Warner Bros", "3400 Warner Blvd, Burbank, CA", 5000000.0), new ScriptDTO());
		
		MovieDTO movie2 = new MovieDTO("Fight Club", (short) 139, new Date(), 8.8,
				new CompanyDTO(2, "Paramount Pictures","5555 Melrose Avenue, Hollywood, California", 8000000.0), new ScriptDTO());
		
		MovieDTO movie3 = new MovieDTO("Pulp Fiction", (short) 165, new Date(), 8.6,
				new CompanyDTO(2, "Paramount Pictures","5555 Melrose Avenue, Hollywood, California", 8000000.0), new ScriptDTO());
		
		MovieDTO movie4 = new MovieDTO("The Godfather", (short) 175, new Date(), 9.0,
				new CompanyDTO(3, "Fox Pictures","10201 W. Pico Blvd., Bldg. 78 , Los Angeles, CA",3500000.0), new ScriptDTO());
		
		MovieDTO movie5 = new MovieDTO("Forrest Gump", (short) 142, new Date(), 9.0,
				new CompanyDTO(4, "Jersey Films","10351 Santa Monica Blvd, Los Angeles, CA",2000000.0), new ScriptDTO());
		
		MovieDTO movie6 = new MovieDTO("Avatar", (short) 162, new Date(), 7.2,
				new CompanyDTO(1, "Warner Bros", "3400 Warner Blvd, Burbank, CA", 5000000.0), new ScriptDTO());
		allMovies.add(movie1);
		allMovies.add(movie2);
		allMovies.add(movie3);
		allMovies.add(movie4);
		allMovies.add(movie5);
		allMovies.add(movie6);
	}

	@Test
	public void testFindAllMovies() throws Exception {
		given(movieService.findAll()).willReturn(this.allMovies);

		this.mvc.perform(get("/movies")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(this.allMovies.size())));
	}

	@Test
	public void testFindMovieById() throws Exception {
		final Integer id = 1;
		given(movieService.findById(id)).willReturn(this.allMovies.get(0));

		this.mvc.perform(get("/movies/{id}", id)).andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(this.allMovies.get(0).getName())));
	}

	@Test
	public void testGet404WhenMovieDoesntExist() throws Exception {
		final Integer id = 7;
		given(movieService.findById(id))
				.willThrow(new EntityNotFoundException("Movie ID: " + id + "doesn't exists"));

		this.mvc.perform(get("/movies/{id}", id)).andExpect(status().isNotFound());
	}

}