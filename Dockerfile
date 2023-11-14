FROM maven:3-openjdk-17 as builder

WORKDIR /music-box

COPY pom.xml /music-box

COPY src /music-box/src

RUN mvn install -DskipTests=true

FROM ictu/sshpass as deploy

COPY --from=0 /music-box/target/hmmusicbox-0.0.1-SNAPSHOT.jar .

RUN sshpass -p "Aa123456" scp -o StrictHostKeyChecking=no ./hmmusicbox-0.0.1-SNAPSHOT.jar root@47.115.224.143:~/hm_team_music_box_server \
    && sshpass -p "Aa123456" ssh -o StrictHostKeyChecking=no root@47.115.224.143 "killall java;screen -d -m java -jar hm_team_music_box_server/hmmusicbox-0.0.1-SNAPSHOT.jar"
