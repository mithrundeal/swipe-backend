package com.mithrundeal.swipebackend.repository;

import com.mithrundeal.swipebackend.dto.SwipeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SwipeUser, Long> {
}
