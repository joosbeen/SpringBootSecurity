package com.springweb.security.service.libro;

import java.util.List;
import java.util.Optional;

import com.springweb.security.entity.Libro;

public interface LibroService {
	
	public Libro save(Libro libro);

	public Optional<Libro> findById(Long id);

	public List<Libro> findAll();

	public void deleteById(Long id);

}
