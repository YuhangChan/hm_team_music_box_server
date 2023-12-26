package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostDao extends JpaRepository<PostEntity, Long> {
    @Query
    PostEntity findByIdIs(Long id);
}
