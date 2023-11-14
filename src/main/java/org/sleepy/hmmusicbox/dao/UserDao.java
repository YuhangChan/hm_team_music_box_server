package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
