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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public CommonResponse<?> login(@Valid @RequestBody LoginRequest request) {
        // Throws BizException if auth failed.
        userService.loginByUserName(request.getUsername(), request.getPassword());

        StpUtil.login(request.getUsername());
        return CommonResponse.success();
    }


    @PostMapping("/regist")
    public CommonResponse<?> register(@Valid @RequestBody RegisterRequest request) {
        // Throws BizException if register failed.
        userService.register(request.getUsername(), request.getPhone(), request.getPassword());
        return CommonResponse.success();
    }

    @DeleteMapping("/logout")
    public CommonResponse<?> logout() {
        StpUtil.checkLogin();
        return CommonResponse.success(200);
    }

    @GetMapping("/info")
    public CommonResponse<UserVO> userInfo() {
        StpUtil.checkLogin();
        return CommonResponse.success(userService.findByUserName(String.valueOf(StpUtil.getLoginId())));
    }

    @GetMapping("/userInfo/{userId}")
    public CommonResponse<UserVO> getUserInfo(@PathVariable("userId") Long userId) {
        UserVO userVO = userService.findByUserId(userId);
        if (userVO != null) {
            return CommonResponse.success(userVO);
        } else {
            throw new BizException(CommonErrorType.NOT_FOUND, "Can't find user in database(just a tip,maybe other bug).");
        }
    }

    @PutMapping("/updateinfo")
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

    @DeleteMapping("/history/{id}")
    public CommonResponse<?> deleteHistory(@PathVariable("id") Long musicId) {
        StpUtil.checkLogin();
        if (userService.removeFromHistory(String.valueOf(StpUtil.getLoginId()), musicId))
            return CommonResponse.success();
        else
            throw new BizException(CommonErrorType.NOT_FOUND, "Can't find music in history.");
    }

    @GetMapping("/history")
    public CommonResponse<List<MusicVO>> getHistory() {
        StpUtil.checkLogin();
        return CommonResponse.success(userService.getHistory(String.valueOf(StpUtil.getLoginId())));
    }

}
