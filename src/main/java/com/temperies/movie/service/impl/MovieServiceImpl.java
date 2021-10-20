package com.temperies.movie.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temperies.movie.dto.MovieDTO;
import com.temperies.movie.dto.ScriptDTO;
import com.temperies.movie.error.handling.EntityNotFoundException;
import com.temperies.movie.error.handling.SQLErrorException;
import com.temperies.movie.jpa.Movie;
import com.temperies.movie.repository.MovieRepository;
import com.temperies.movie.service.IMovieService;

@Service
public class MovieServiceImpl implements IMovieService {
    
	@Autowired
	MovieRepository movieRepository;
	
    @Autowired
    ModelMapper modelMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Override
	public List<MovieDTO> findAll() {
		return movieRepository.findAll()
				.stream()
				.map(movie -> modelMapper.map(movie, MovieDTO.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public MovieDTO findById(Integer id) {
		Optional<Movie> movie = movieRepository.findById(id);	
		if(movie.isPresent()) {
			return modelMapper.map(movie.get(), MovieDTO.class);
		} else {
			LOGGER.error("Movie ID: {} doesn't found", id);
			throw new EntityNotFoundException("Movie ID: " + id + " doesn't found");  
		}
	}

	@Override
	public MovieDTO save(MovieDTO movieDTO) {
		Movie newMovie = modelMapper.map(movieDTO, Movie.class);
		try { 
			movieRepository.save(newMovie);
		} catch (Exception e) {
			LOGGER.error("Error saving new movie. MovieDTO: {}", movieDTO);
			throw new SQLErrorException("Error saving new movie", e);
		}
		return modelMapper.map(newMovie, MovieDTO.class);
	}

	@Override
	public ScriptDTO findScriptByMovieId(Integer id) {
		Optional<Movie> movie = movieRepository.findById(id);
		if (movie.isPresent()) {
			return modelMapper.map(movie.get().getScript(), ScriptDTO.class);
		} else {
			LOGGER.error("Movie ID: {} doesn't found", id);
			throw new EntityNotFoundException("Movie ID: " + id + " doesn't found");
		}
	}
}
