package com.westee.accounting.manager;

import com.westee.accounting.model.common.UserInfo;

public interface UserInfoManager {
    UserInfo getUserInfoByUserId(Long userId);
}
