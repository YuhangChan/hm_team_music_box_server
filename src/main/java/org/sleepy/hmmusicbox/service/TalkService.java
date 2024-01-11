package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.entity.TalkEntity;
import org.sleepy.hmmusicbox.pojo.vo.talk.TalkVO;

import java.io.IOException;
import java.util.List;

public interface TalkService {
    public String talk(String input) throws IOException;


}
