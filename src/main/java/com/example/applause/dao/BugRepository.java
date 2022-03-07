package com.example.applause.dao;

import com.example.applause.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Integer> {

        List<Bug> findAll();

        @Query(value = "SELECT * FROM bugs WHERE testerid IN :testerid and deviceid IN :devicesid", nativeQuery = true)
        List<Bug> findBugByDeviceIdAndTesterId(@Param("testerid") List<Integer> testerid, @Param("devicesid") List<Integer> devicesid);
}