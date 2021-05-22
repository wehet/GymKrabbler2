package com.example.GymKrabbler2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.GymKrabbler2.model.Gym;

@Repository
public interface GymRepository extends CrudRepository<Gym, Long> {}
