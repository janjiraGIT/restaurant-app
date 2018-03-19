package com.janjira.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janjira.restaurant_app.model.Guest;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

}
