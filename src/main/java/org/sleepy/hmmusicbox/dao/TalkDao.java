package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.sleepy.hmmusicbox.pojo.entity.TalkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalkDao  extends JpaRepository<TalkEntity, Long> {
}
