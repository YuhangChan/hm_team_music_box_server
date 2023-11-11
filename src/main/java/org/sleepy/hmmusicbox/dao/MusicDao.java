package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicDao extends JpaRepository<MusicEntity, Long> {
}
