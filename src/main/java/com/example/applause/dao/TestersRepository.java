package com.example.applause.dao;

import com.example.applause.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestersRepository extends JpaRepository<Tester, Integer> {

    @Query(value = "SELECT * FROM testers WHERE COUNTRY IN :country", nativeQuery = true)
    List<Tester> findTestersByCountry(@Param("country") List<String> country);

    List<Tester> findAll();

}
