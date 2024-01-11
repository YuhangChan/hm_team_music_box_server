package org.sleepy.hmmusicbox.service;

import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;

public interface TalkService {
    public String callWithMessage(String input)
            throws NoApiKeyException, ApiException, InputRequiredException;


}
