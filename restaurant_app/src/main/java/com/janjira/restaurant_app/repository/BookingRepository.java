package com.janjira.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janjira.restaurant_app.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
