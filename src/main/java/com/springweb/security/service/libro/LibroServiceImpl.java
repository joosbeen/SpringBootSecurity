package com.springweb.security.service.libro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.security.entity.Libro;
import com.springweb.security.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	private LibroRepository libroRepository; 

	@Override
	public Libro save(Libro libro) {
		return this.libroRepository.save(libro);
	}

	@Override
	public Optional<Libro> findById(Long id) {
		return this.libroRepository.findById(id);
	}

	@Override
	public List<Libro> findAll() {
		return (List<Libro>) this.libroRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.libroRepository.deleteById(id);		
	}

}
