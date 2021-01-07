package com.springweb.security.service.autor;

import java.util.List;
import java.util.Optional;

import com.springweb.security.entity.Autor;

public interface AutorService {

	public List<Autor> findAll();
	
	public Autor save(Autor autor);
	
	public Optional<Autor> findById(Long id);
	
}
