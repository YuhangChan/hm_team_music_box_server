package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<UserEntity, Long> {

    //命名规则：https://springdoc.cn/spring-data-jpa-findby-vs-findoneby/
    UserEntity findByUsername(String username);


}
