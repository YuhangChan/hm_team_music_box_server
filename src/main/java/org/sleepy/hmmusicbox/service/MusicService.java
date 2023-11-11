package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;

public interface MusicService {
    public void addMusic(String name, String album, String singer);

    public MusicVO getTestMusic();
}
