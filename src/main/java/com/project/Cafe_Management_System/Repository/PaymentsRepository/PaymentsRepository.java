package com.project.Cafe_Management_System.Repository.PaymentsRepository;

import com.project.Cafe_Management_System.Entity.PaymentsEntity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments,Integer> {
}
