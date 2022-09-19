package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entities.Userpurchased;

@Repository
public interface UserPurchasedRepository extends JpaRepository<Userpurchased, Integer> {


}
