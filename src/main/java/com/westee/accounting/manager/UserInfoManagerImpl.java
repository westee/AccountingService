package com.westee.accounting.manager;

import com.westee.accounting.converter.persistenceToManager.UserInfoConverter;
import com.westee.accounting.dao.UserInfoDAO;
import com.westee.accounting.model.common.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoManagerImpl implements UserInfoManager {
    private final UserInfoDAO userInfoDAO;
    private final UserInfoConverter userInfoConverter;

    @Autowired
    public UserInfoManagerImpl(UserInfoDAO userInfoDAO, UserInfoConverter userInfoConverter) {
        this.userInfoDAO = userInfoDAO;
        this.userInfoConverter = userInfoConverter;
    }

    public UserInfoManagerImpl(UserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }

    @Override
    public UserInfo getUserInfoByUserId(Long userId) {
        com.westee.accounting.model.persistence.UserInfo userInfo = userInfoDAO.getUserInfoById(userId);
        return userInfoConverter.convert(userInfo);
    }


}
