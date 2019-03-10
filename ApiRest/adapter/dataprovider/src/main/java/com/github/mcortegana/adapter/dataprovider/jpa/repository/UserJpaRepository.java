package com.github.mcortegana.adapter.dataprovider.jpa.repository;

import com.github.mcortegana.adapter.dataprovider.jpa.entity.UserEntity;
import com.github.mcortegana.core.entity.User;
import com.github.mcortegana.core.port.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);

}
