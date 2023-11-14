package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.MusicDao;
import org.sleepy.hmmusicbox.mapper.MusicMapper;
import org.sleepy.hmmusicbox.mapper.MusicMapperImpl;
import org.sleepy.hmmusicbox.pojo.entity.MusicEntity;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.MusicService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //用于自动生成带有所有非 final 和非 @NonNull 注解的成员变量的构造函数
public class MusicServiceImpl implements MusicService {
    private final MusicDao musicDao;

    @Override
    public void addMusic(String name, String album, String singer) {
        MusicEntity entity = MusicEntity.builder().name(name).album(album).singer(singer).build();
        musicDao.save(entity);
    }

    @Override
    public MusicVO getTestMusic() {
        List<MusicEntity> entity = musicDao.findAll();
        return MusicMapper.INSTANCE.toMusicVO(entity.get(0));
    }

    @Override
    public List<MusicVO> searchMusic(String name) {
        MusicMapper mapper = new MusicMapperImpl();
        List<MusicVO> list = new ArrayList<>();
        for(MusicEntity entity : musicDao.findAll()) {
            list.add(mapper.toMusicVO(entity));
        }
        // TODO:search
        return list;
    }
}
