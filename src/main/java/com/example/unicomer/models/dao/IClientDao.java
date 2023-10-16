package com.example.unicomer.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.unicomer.models.entities.Client;

public interface IClientDao extends CrudRepository<Client, Long>{

}
