package com.second.secondbatchVeer.relative;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelativesRepository extends CrudRepository<Relatives,Integer> {
    List<Relatives>getByName(String name);
}
