package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Command_line;


@Repository
public interface ICommandLineRepository extends CrudRepository<Command_line, Integer> {

}
