package com.dg.deukgeun.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dg.deukgeun.entity.Membership;
import com.dg.deukgeun.entity.User;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {
    Optional<Membership> findByUser(User user);

    List<Membership> findAllByGym_GymId(Integer gymId);

    List<Membership> findByExpDate(String expirationDate);

    void deleteByExpDate(String expirationDate);

    Optional<Membership> findByUser_UserId(Integer userId);
}