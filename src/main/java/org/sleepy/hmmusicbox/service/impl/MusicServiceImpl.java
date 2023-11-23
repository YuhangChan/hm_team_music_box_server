package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.MusicDao;
import org.sleepy.hmmusicbox.mapper.MusicDTOMapper;
import org.sleepy.hmmusicbox.mapper.MusicDTOMapperImpl;
import org.sleepy.hmmusicbox.mapper.MusicMapper;
import org.sleepy.hmmusicbox.mapper.MusicMapperImpl;
import org.sleepy.hmmusicbox.pojo.entity.MusicEntity;
import org.sleepy.hmmusicbox.pojo.entity.MusicEntityDTO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicDTOVO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.MusicService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //用于自动生成带有所有非 final 和非 @NonNull 注解的成员变量的构造函数
public class MusicServiceImpl implements MusicService {
    private final MusicDao musicDao;

    // TODO: combine two tables together
    @Override
    public void addMusic(String name, String album, String singer, String detail, String imageUrl) {
        MusicEntity entity = MusicEntity.builder().name(name).album(album).singer(singer).detail(detail).imageUrl(imageUrl).build();
        musicDao.save(entity);
    }

    @Override
    public MusicVO getTestMusic() {
        List<MusicEntity> entity = musicDao.findAll();
        return MusicMapper.INSTANCE.toMusicVO(entity.get(entity.size() - 1));
    }

    @Override
    public List<MusicDTOVO> searchMusic(String name) {
        MusicDTOMapper mapper = MusicDTOMapper.INSTANCE;
        List<MusicEntityDTO> searchResult = musicDao.findByKeyword(name);
        List<MusicDTOVO> list = new ArrayList<>();
        for (MusicEntityDTO result : searchResult) {
            list.add(mapper.musicDTOVO(result));
        }
        return list;
//        return null;
    }

    @Override
    public MusicVO getMusicDetail(Long id) {
        MusicMapper mapper = MusicMapper.INSTANCE;
        return mapper.toMusicVO(musicDao.findByIdIs(id));
    }

    @Override
    public void deleteAll() {
        musicDao.deleteAll();
    }

}
