package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.music.MusicDTOVO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;

import java.util.List;

public interface MusicService {
    public void addMusic(String name, String album, String singer, String detail, String imageUrl);

    public MusicVO getTestMusic();

    public List<MusicDTOVO> searchMusic(String name);

    public MusicVO getMusicDetail(Long id);


}
