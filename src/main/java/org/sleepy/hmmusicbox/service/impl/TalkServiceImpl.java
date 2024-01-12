package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.service.TalkService;
import org.springframework.stereotype.Service;
import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.MessageManager;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;

@Service
@RequiredArgsConstructor
public class TalkServiceImpl implements TalkService {
    @Override
    public String callWithMessage(String input)
            throws NoApiKeyException, ApiException, InputRequiredException {
        String prompt = "下面几首是我喜欢的歌，请据此给我推荐更多歌曲：";
        input = prompt + input;
        Generation gen = new Generation();
        MessageManager msgManager = new MessageManager(10);
        Message systemMsg =
                Message.builder().role(Role.SYSTEM.getValue()).content("You are a helpful assistant.").build();
        Message userMsg = Message.builder().role(Role.USER.getValue()).content(input).build();
        msgManager.add(systemMsg);
        msgManager.add(userMsg);
        QwenParam param =
                QwenParam.builder().model(Generation.Models.QWEN_MAX).messages(msgManager.get())
                        .resultFormat(QwenParam.ResultFormat.MESSAGE)
                        .topP(0.8)
                        .enableSearch(true)
                        .build();
        GenerationResult result = gen.call(param);
        String s = result.getOutput().getChoices().get(0).getMessage().getContent();
        return s;
    }
}
