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

import java.util.Date;


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

    @NotNull
    private String name;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
