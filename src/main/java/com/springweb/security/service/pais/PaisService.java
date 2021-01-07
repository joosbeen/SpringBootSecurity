package com.springweb.security.service.pais;

import java.util.List;

import com.springweb.security.entity.Pais;

public interface PaisService {
	
	
	public List<Pais> findAll();


	public Pais findById(Long id);

	public void deleteById(Long id);
	
	public void delete(Pais pais);

	public Pais save(Pais pais);

}
