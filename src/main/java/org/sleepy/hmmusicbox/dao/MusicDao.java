package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.MusicEntity;
import org.sleepy.hmmusicbox.pojo.entity.MusicEntityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicDao extends JpaRepository<MusicEntity, Long> {

    @Query("SELECT new org.sleepy.hmmusicbox.pojo.entity.MusicEntityDTO(e.id, e.name, e.album, e.singer) FROM MusicEntity e WHERE e.name LIKE %:keyword% OR e.album LIKE %:keyword% OR e.singer LIKE %:keyword%")
    List<MusicEntityDTO> findByKeyword(@Param("keyword") String keyword);

    @Query
    MusicEntity findByIdIs(Long id);
}
