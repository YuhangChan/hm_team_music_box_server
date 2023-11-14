package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;

import java.util.List;

public interface MusicService {
    public void addMusic(String name, String album, String singer);

    public MusicVO getTestMusic();

    public List<MusicVO> searchMusic(String name);
}
