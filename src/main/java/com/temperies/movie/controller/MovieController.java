package com.temperies.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temperies.movie.dto.MovieDTO;
import com.temperies.movie.dto.ScreenWriterDTO;
import com.temperies.movie.dto.ScriptDTO;
import com.temperies.movie.repository.MovieRepository;
import com.temperies.movie.service.IMovieService;

@RestController
@RequestMapping("movies")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	IMovieService movieService;

	@GetMapping
	public ResponseEntity<List<MovieDTO>> getMovies() {
		return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getMovieById(@PathVariable Integer id) {
		return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/{id}/screenwriters")
	public ResponseEntity<List<ScreenWriterDTO>> getScreenWritersByMovie(@PathVariable Integer id, 
			@RequestParam(required = false) Integer genderId) {
		return new ResponseEntity<>(movieService.findScreenWritersByMovie(id, genderId), HttpStatus.OK);
	
	}

	@PostMapping
	public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieDTO movie) {
		return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
	}

	@GetMapping("/{id}/script")
	public ResponseEntity<ScriptDTO> getScriptByMovieId(@PathVariable Integer id) {
		return new ResponseEntity<>(movieService.findScriptByMovieId(id), HttpStatus.OK);
	}

}
