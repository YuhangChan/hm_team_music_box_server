package org.sleepy.hmmusicbox.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.exception.BizException;
import org.sleepy.hmmusicbox.exception.CommonErrorType;
import org.sleepy.hmmusicbox.exception.CommonResponse;
import org.sleepy.hmmusicbox.pojo.vo.reply.ReplyVO;
import org.sleepy.hmmusicbox.pojo.vo.talk.TalkVO;
import org.sleepy.hmmusicbox.service.PostService;
import org.sleepy.hmmusicbox.service.TalkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/talk")
public class TalkController {
    private final TalkService talkService;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String talk(@RequestBody TalkVO talkVO) throws NoApiKeyException, InputRequiredException {
        return talkService.callWithMessage(talkVO.getText());
    }
}
