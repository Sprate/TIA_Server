package qsf.service;

import qsf.entity.UserTouch;

import java.util.List;


public interface IUserTouchService {
    int insert(UserTouch record);

    int insertSelective(UserTouch record);

    long countUserTouchByUid(String userId);

    List<UserTouch> selectUid(String userId, int maxNum);

    List<UserTouch> getOtherUserTouchs(String userId, int dataNum);

}
