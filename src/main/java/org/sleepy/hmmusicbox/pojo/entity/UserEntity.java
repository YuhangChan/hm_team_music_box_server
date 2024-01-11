package org.sleepy.hmmusicbox.pojo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;


@Entity
@Table(name = "user1")  // table name "user" is a reserved word in H2 --软工二留下的备注，为保证后面使用H2的可能，那就保留这个命名吧
@Data
@Builder //加入此注解后，可以使用 UserEntity.builder().username("example").password("password").build() 的方式创建对象
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //该注解使得可以链式调用一系列setter方法，如user.setUsername("example").setPassword("password").setName("John")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    //TODO:这里的name是否多余？我们不是实名制
    //@NotNull
    private String name;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    //注册手机号
    @NotNull
    private String phoneNumber;

    //用户头像url
    private String avatarURL;

    //个人简介（个性签名）
    private String profile;

    //喜欢的音乐类型
    private List<String> favoriteMusicGenres;

    //关注的人
    private List<String> followedArtists;

    //粉丝
    private List<String> fans;

    //偏好设置（日间/夜间模式、隐私设置）

    //收藏的音乐
    @ManyToMany
    @JoinTable(
            name = "music_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "music_id"))
    private Set<MusicEntity> likes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "music_history",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "music_id"))
    private List<MusicEntity> history = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "talk_history",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "talk_id"))
    private List<TalkEntity> talkHistory = new ArrayList<>();
}
