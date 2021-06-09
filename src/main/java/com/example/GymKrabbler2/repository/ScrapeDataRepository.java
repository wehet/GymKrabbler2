package com.example.GymKrabbler2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.GymKrabbler2.model.ScrapeData;

@Repository
public interface ScrapeDataRepository extends CrudRepository<ScrapeData, Long> {}