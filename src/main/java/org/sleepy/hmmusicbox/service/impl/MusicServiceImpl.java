package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.MusicDao;
import org.sleepy.hmmusicbox.dao.MusicDetailDao;
import org.sleepy.hmmusicbox.mapper.MusicDetailMapper;
import org.sleepy.hmmusicbox.mapper.MusicDetailMapperImpl;
import org.sleepy.hmmusicbox.mapper.MusicMapper;
import org.sleepy.hmmusicbox.mapper.MusicMapperImpl;
import org.sleepy.hmmusicbox.pojo.entity.MusicDetailEntity;
import org.sleepy.hmmusicbox.pojo.entity.MusicEntity;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicDetailVO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.MusicService;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //用于自动生成带有所有非 final 和非 @NonNull 注解的成员变量的构造函数
public class MusicServiceImpl implements MusicService {
    private final MusicDao musicDao;
    private final MusicDetailDao musicDetailDao;

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
            if(entity.getName().contains(name) || entity.getAlbum().contains(name) || entity.getSinger().contains(name)) {
                list.add(mapper.toMusicVO(entity));
            }
        }
        // TODO:search
        return list;
    }

    @Override
    public MusicDetailVO getMusicDetail(Long id) {
        MusicDetailMapper mapper = new MusicDetailMapperImpl();
        return mapper.toMusicDetailVO(musicDetailDao.findById(id).get());
//        return null;
    }

    @Override
    public void addMusicDetail(Long id, String detail, URL imageUrl) {
        MusicDetailEntity entity = MusicDetailEntity.builder().id(id).detail(detail).imageUrl(imageUrl).build();
        musicDetailDao.save(entity);
    }

}
