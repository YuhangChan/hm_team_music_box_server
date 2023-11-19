package org.sleepy.hmmusicbox.pojo.vo.user;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "修改用户信息请求")
public class EditUserInfoRequest {

    @Schema(description = "用户名", required = false)
    @NotNull
    @Size(min = 4, max = 16, message = "用户名长度必须在 4-16 之间")
    @Pattern(regexp = "^[a-z\\d-_]*$", message = "用户名只能包含小写字母,数字,下划线和连字符")
    private String username;

    @Schema(description = "手机号", required = false)
    @NotNull
    @Size(min = 11, max = 11, message = "手机号长度必须为11")
    @Pattern.List({
            @Pattern(regexp = "^\\d{11}$", message = "手机号格式错误"),
    })
    private String phone;

    @Schema(description = "个性签名", required = false)
    @Size(max = 20, message = "个性签名长度不能超过20")
    private String profile;

    @Schema(description = "头像", required = false)
    @Pattern.List({
            @Pattern(regexp = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]", message = "头像地址错误"),
    })
    private String avatar;
}