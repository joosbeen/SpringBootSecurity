package com.springweb.security.service.autor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.security.entity.Autor;
import com.springweb.security.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public List<Autor> findAll() {
		return (List<Autor>) autorRepository.findAll();
	}

	@Override
	public Autor save(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public Optional<Autor> findById(Long id) {
		return autorRepository.findById(id);
	}

}
