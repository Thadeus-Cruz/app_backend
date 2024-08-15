package com.example.autogarage.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.autogarage.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCustomer_Id(Long customerId);
}