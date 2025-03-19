package com.tw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.entity.AutherDetails;

public interface AutherRepo extends JpaRepository<AutherDetails, Integer> {

}
