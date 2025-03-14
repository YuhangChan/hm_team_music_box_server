package org.sleepy.hmmusicbox.controller;

import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.exception.BizException;
import org.sleepy.hmmusicbox.exception.CommonErrorType;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;
import org.sleepy.hmmusicbox.pojo.vo.reply.ReplyVO;
import org.sleepy.hmmusicbox.service.PostService;
import org.sleepy.hmmusicbox.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final ReplyService replyService;
    @GetMapping("/replies/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ReplyVO> showReply(@PathVariable("id") Long id) {
        return postService.showReply(id);
    }

    @PostMapping (value = "/reply/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReply(@PathVariable("id") Long id, @RequestBody ReplyVO reply) {
        if(StpUtil.isLogin()) {
            postService.addReply(id, StpUtil.getLoginId().toString(), reply.getContent());
        } else {
            throw new BizException(CommonErrorType.UNAUTHORIZED, "Can't reply while not logged in.");
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public PostVO getPost(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }
    @DeleteMapping("/deleteReply/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteReply(@PathVariable("id") Long id) {
        replyService.deleteReply(id);
    }

}
