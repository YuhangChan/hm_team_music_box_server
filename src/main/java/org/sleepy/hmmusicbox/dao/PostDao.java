package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<PostEntity, Long> {
}
