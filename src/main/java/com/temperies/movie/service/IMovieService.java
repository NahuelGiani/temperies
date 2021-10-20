package com.temperies.movie.service;

import java.util.List;

import com.temperies.movie.dto.MovieDTO;
import com.temperies.movie.dto.ScriptDTO;

public interface IMovieService {

	public List<MovieDTO> findAll();
	
	public MovieDTO findById(Integer id);
	
	public MovieDTO save(MovieDTO movieDTO);

	public ScriptDTO findScriptByMovieId(Integer id);

}
