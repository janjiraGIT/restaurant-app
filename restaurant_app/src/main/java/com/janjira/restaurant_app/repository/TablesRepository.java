package com.janjira.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janjira.restaurant_app.model.Guess;
import com.janjira.restaurant_app.model.Tables;


@Repository
public interface TablesRepository extends JpaRepository<Tables, Long> {

}
