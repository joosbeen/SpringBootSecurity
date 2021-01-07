package com.springweb.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.springweb.security.entity.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {

}
