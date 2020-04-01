package com.westee.accounting.manager;

import com.westee.accounting.converter.persistenceToManager.UserInfoP2CConverter;
import com.westee.accounting.dao.UserInfoDAO;
import com.westee.accounting.model.common.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoManagerImpl implements UserInfoManager {
    private final UserInfoDAO userInfoDAO;
    private final UserInfoP2CConverter userInfoP2CConverter;

    @Autowired
    public UserInfoManagerImpl(UserInfoDAO userInfoDAO, UserInfoP2CConverter userInfoP2CConverter) {
        this.userInfoDAO = userInfoDAO;
        this.userInfoP2CConverter = userInfoP2CConverter;
    }


    @Override
    public UserInfo getUserInfoByUserId(Long userId) {
        com.westee.accounting.model.persistence.UserInfo userInfo = userInfoDAO.getUserInfoById(userId);
        return userInfoP2CConverter.convert(userInfo);
    }


}
