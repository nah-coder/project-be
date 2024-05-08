package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaytinhRepository extends JpaRepository<Category,Integer> {
    @Query(value = "select s from Category s where s.name like concat('%',:name,'%') ")
    List<Category> findbyname(@Param("name") String name);

    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
    List<Category> searchCategory(String keyword);
}
