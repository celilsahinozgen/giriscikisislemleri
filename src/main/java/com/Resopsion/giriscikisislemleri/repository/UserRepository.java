package com.Resopsion.giriscikisislemleri.repository;


import com.Resopsion.giriscikisislemleri.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

  Optional<User> findByOdaNumarasi(Integer OdaNumarasi);



}
