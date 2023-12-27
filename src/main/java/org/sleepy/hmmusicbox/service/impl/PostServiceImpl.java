package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.PostDao;
import org.sleepy.hmmusicbox.dao.ReplyDao;
import org.sleepy.hmmusicbox.mapper.PostMapper;
import org.sleepy.hmmusicbox.mapper.ReplyMapper;
import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.sleepy.hmmusicbox.pojo.entity.ReplyEntity;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;
import org.sleepy.hmmusicbox.pojo.vo.reply.ReplyVO;
import org.sleepy.hmmusicbox.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDao postDao;
    private final ReplyDao replyDao;

    @Override
    public void addTestPost() {
        PostEntity postEntity = PostEntity.builder().title("Test").content("Test Content.").posterID(1L).build();
        postDao.save(postEntity);
    }

    @Override
    public void addTestPostReply() {
        PostEntity postEntity = postDao.findById(1L).get();
        ReplyEntity replyEntity = ReplyEntity.builder().content("Test Content.").replierID(1L).build();

        postEntity.getReplies().add(replyEntity);
        postDao.save(postEntity);
    }
    @Override
    public void addReply(Long postID, Long replierID, String content) {
        PostEntity post = postDao.findByIdIs(postID);
        ReplyEntity replyEntity = ReplyEntity.builder().replierID(replierID).content(content).build();
        post.getReplies().add(replyEntity);
        replyEntity.setPost(post);
        postDao.save(post);
    }

    @Override
    public List<ReplyVO> showReply(Long id){
        ReplyMapper mapper = ReplyMapper.INSTANCE;
        PostEntity post = postDao.findById(id).get();

        List<ReplyEntity> replyEntities = post.getReplies();
        List<ReplyVO> replyVOS = new ArrayList<>();
        for(ReplyEntity replyEntity: replyEntities) {
            replyVOS.add(mapper.toReplyVO(replyEntity));
        }
        return replyVOS;
    }
    @Override
    public void deletePost(Long id) {
        postDao.deleteById(id);
    }

    @Override
    public PostVO getPost(Long id) {
        PostMapper postMapper = PostMapper.INSTANCE;
        return postMapper.toPostVO(postDao.findByIdIs(id));
    }
}
