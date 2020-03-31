package com.westee.accounting.dao;

import com.westee.accounting.model.persistence.UserInfo;

public interface UserInfoDAO {
    UserInfo getUserInfoById(Long id);

    void createNewUser(String username, String password);
}
