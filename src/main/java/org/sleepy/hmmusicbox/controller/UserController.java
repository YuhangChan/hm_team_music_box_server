package org.sleepy.hmmusicbox.controller;


import cn.dev33.satoken.stp.StpUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.exception.BizException;
import org.sleepy.hmmusicbox.exception.CommonErrorType;
import org.sleepy.hmmusicbox.exception.CommonResponse;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.pojo.vo.user.EditUserInfoRequest;
import org.sleepy.hmmusicbox.pojo.vo.user.LoginRequest;
import org.sleepy.hmmusicbox.pojo.vo.user.RegisterRequest;
import org.sleepy.hmmusicbox.pojo.vo.user.UserVO;
import org.sleepy.hmmusicbox.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
//@RequestMapping("/v1") //我也不是太清楚加这个有什么用
public class UserController {
    private final UserService userService;

    @PostMapping("session")
    public CommonResponse<?> login(@Valid @RequestBody LoginRequest request) {
        // Throws BizException if auth failed.
        userService.loginByUserName(request.getUsername(), request.getPassword());

        StpUtil.login(request.getUsername());
        return CommonResponse.success();
    }


    @PostMapping("user")
    public CommonResponse<?> register(@Valid @RequestBody RegisterRequest request) {
        // Throws BizException if register failed.
        userService.register(request.getUsername(), request.getPhone(), request.getPassword());
        return CommonResponse.success();
    }

    @DeleteMapping("session")
    public CommonResponse<?> logout() {
        StpUtil.checkLogin();
        return CommonResponse.success(200);
    }

    @GetMapping("user")
    public CommonResponse<UserVO> userInfo() {
        StpUtil.checkLogin();
        return CommonResponse.success(userService.findByUserName(String.valueOf(StpUtil.getLoginId())));
    }

    @PutMapping("user")
    public CommonResponse<?> editInfo(@Valid @RequestBody EditUserInfoRequest request) {
        StpUtil.checkLogin();
        userService.editInfo(StpUtil.getLoginIdAsString(), request.getUsername(), request.getPhone(), request.getProfile(), request.getAvatar());
        return CommonResponse.success();
    }

    @PostMapping("/like/{id}")
    public CommonResponse<?> likeMusic(@PathVariable("id") Long musicId) {
        StpUtil.checkLogin();
        if (userService.like(String.valueOf(StpUtil.getLoginId()), musicId))
            return CommonResponse.success();
        else
            throw new BizException(CommonErrorType.NOT_FOUND, "Music not found.");
    }

    @PostMapping("/unlike/{id}")
    public CommonResponse<?> unlikeMusic(@PathVariable("id") Long musicId) {
        StpUtil.checkLogin();
        if (userService.unlike(String.valueOf(StpUtil.getLoginId()), musicId))
            return CommonResponse.success();
        else
            throw new BizException(CommonErrorType.NOT_FOUND, "Can't find music in likes.");
    }

    @GetMapping("/likes")
    public CommonResponse<Set<MusicVO>> getLikes() {
        StpUtil.checkLogin();
        return CommonResponse.success(userService.getLikes(String.valueOf(StpUtil.getLoginId())));
    }

}
