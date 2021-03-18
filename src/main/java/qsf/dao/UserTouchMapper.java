package qsf.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qsf.entity.UserTouch;

import java.util.List;

@Repository
public interface UserTouchMapper {

    int insert(UserTouch record);

    int insertSelective(UserTouch record);

    long countUserTouchByUid(@Param("userId") String userId);

    List<UserTouch> selectUid(@Param("userId") String userId, @Param("maxNum") int maxNum);

    List<UserTouch> getOtherUserTouchs(@Param("userId")String userId, @Param("dataNum")int dataNum);
}