package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.MusicDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicDetailDao extends JpaRepository<MusicDetailEntity, Long> {
}
