package com.xxw.smlzxx.repository;

import com.xxw.smlzxx.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {

    @Query(value = "select * from addr where level = :level",nativeQuery = true)
    @Modifying
    public List<Region> findByLevel(@Param("level") Integer level);

    List<Region> findByType(String type);

    @Query(value = "select * from addr where id=:id",nativeQuery = true)
    @Modifying
    public Region findOne(@Param("id") Integer id);

    @Query(value = "delete * from addr where id=:id",nativeQuery = true)
    @Modifying
    public void deleteById(@Param("id") Integer id);
}