package com.springweb.security.service.pais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.security.entity.Pais;
import com.springweb.security.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService {
	
	@Autowired
	private PaisRepository paisRepository;

	@Override
	public List<Pais> findAll() {
		return (List<Pais>) paisRepository.findAll();
	}

	@Override
	public Pais findById(Long id) {
		return paisRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		paisRepository.deleteById(id);		
	}

	@Override
	public void delete(Pais pais) {
		paisRepository.delete(pais);
	}

	@Override
	public Pais save(Pais pais) {
		return paisRepository.save(pais);
	}

}
