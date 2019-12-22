package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.Comment;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {

    @Insert("insert into comment(userID,username,postID,comment,time)" +
            "value(#{comment.userID},#{comment.username},#{comment.postID},#{comment.comment},#{comment.time})")
    void addComment(@Param("comment") Comment comment);

    @Select("select username,comment from comment where postID=#{postID}")
    Post getComment(@Param("postID") int postID);

    @Delete("delete from comment where commentID=#{commentID}")
    void deleteComment(@Param("commentID") int commentID);

    @Select("select * from comment where postID = #{postID}")
    List<Comment> getComments(@Param("postID") int postID);

    @Update("update comment set answer=1")
    void updateAnswer();
}
