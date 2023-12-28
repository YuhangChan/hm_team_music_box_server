package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.UserEntity;
import org.sleepy.hmmusicbox.pojo.entity.UserEntityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity, Long> {

    //命名规则：https://springdoc.cn/spring-data-jpa-findby-vs-findoneby/
    UserEntity findByUsername(String username);

    @Query("SELECT new org.sleepy.hmmusicbox.pojo.entity.UserEntityDTO(e.id, e.username, e.avatarURL, e.profile) from UserEntity e where e.id = :id")
    UserEntityDTO findUserDetail(@Param("id") Long id);
}
