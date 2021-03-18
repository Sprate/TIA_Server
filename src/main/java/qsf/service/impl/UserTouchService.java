package qsf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qsf.dao.UserTouchMapper;
import qsf.entity.UserTouch;
import qsf.service.IUserTouchService;

import java.util.List;


@Service
@Transactional
    public class UserTouchService implements IUserTouchService {

    @Autowired
    private UserTouchMapper userTouchMapper;

    @Override
    public int insert(UserTouch record) {
        return userTouchMapper.insert(record);
    }

    @Override
    public int insertSelective(UserTouch record) {
        return userTouchMapper.insertSelective(record);
    }

    @Override
        public long countUserTouchByUid(String userId) {
            return userTouchMapper.countUserTouchByUid(userId);
        }

    @Override
    public List<UserTouch> selectUid(String userId, int maxNum) {
        return userTouchMapper.selectUid(userId, maxNum);
    }

    @Override
    public List<UserTouch> getOtherUserTouchs(String userId, int dataNum) {
        return userTouchMapper.getOtherUserTouchs(userId, dataNum);
    }


}
