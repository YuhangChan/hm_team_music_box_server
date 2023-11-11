# hm_team_music_box_server

Hm music box后端代码

## push说明

由于现在使用的是本地数据库，不要将`src/main/resources/application.yaml`一并push

## 配置说明

- Java版本17
- Spring Boot版本3.1.5
- 数据库使用Postgres

## 连接数据库

在`src/main/resources/application.yaml`中配置本地数据库密码，然后运行代码，访问http://localhost:8080/test，如果有返回值则说明正常配置。

## 添加依赖

在pom.xml文件中添加依赖可以查询[Maven Central (sonatype.com)](https://central.sonatype.com/)，搜索包名并直接复制代码片段。

## 包说明

将项目分为以下几个包：

- pojo
- mapper
- dao
- service
- controller
- exception

### pojo

POJO（Plain Old Java Object）包含项目中所有简单的、普通的 Java 对象。

包含3个子包

- entity
- enum_
- vo

#### entity

用于描述数据库中的表。每一个entity类对应数据库的一张表。由JPA自动建表。

#### enum_

所有需要用到的枚举类。

#### vo

VO（Value Object）包含所有业务代码中可能用到的存储特定值的对象。

VO下有若干子包，每一个子包与一个entity类一一对应，这个子包中会包含和该entity有关的所有vo

例如，对于TrainEntity，vo下有train子包，该子包下有TrainVO、AddTrainRequest（用于描述特定请求）等。

其中，TrainVO和TrainEntity的区别是：TrainEntity专门用于描述数据库中的表，而TrainVO专门用于业务代码中。

因此，需要实现从entity到vo的转化，即mapper

### mapper

实现从entity到vo的转化。

使用mapstruct自动实现，只需写好mapper接口，mapstruct会自动实现其Impl

##### mapstruct配置过程

（这里不用看，写下来防止下次再踩坑）

1. 按照官网指南添加依赖

   ```xml
   ...
   <properties>
       <org.mapstruct.version>1.5.5.Final</org.mapstruct.version>
   </properties>
   ...
   <dependencies>
       <dependency>
           <groupId>org.mapstruct</groupId>
           <artifactId>mapstruct</artifactId>
           <version>${org.mapstruct.version}</version>
       </dependency>
   </dependencies>
   ...
   <build>
       <plugins>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-compiler-plugin</artifactId>
               <version>3.8.1</version>
               <configuration>
                   <source>1.8</source> <!-- depending on your project -->
                   <target>1.8</target> <!-- depending on your project -->
                   <annotationProcessorPaths>
                       <path>
                           <groupId>org.mapstruct</groupId>
                           <artifactId>mapstruct-processor</artifactId>
                           <version>${org.mapstruct.version}</version>
                       </path>
                       <!-- other annotation processors -->
                   </annotationProcessorPaths>
               </configuration>
           </plugin>
       </plugins>
   </build>
   ```

   发现mvn install报奇怪的错。搜索后发现是lombok和mapstruct冲突。

2. 参考[解决 MapStruct 和 Lombok 冲突问题 - 简书 (jianshu.com)](https://www.jianshu.com/p/f7f59f4347bc)，使用lombok-mapstruct-binding包解决冲突。

### dao

用于实现业务代码中对数据库的操作。如`findById`

由JPA自动实现

### service

Controller中会用到的业务代码

### controller

### exception

专门用于存放自定义的exception
