package com.westee.accounting.converter.persistenceToManager;

import com.google.common.base.Converter;
import com.westee.accounting.model.persistence.UserInfo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserInfoP2CConverter extends Converter<UserInfo, com.westee.accounting.model.common.UserInfo> {
    @Override
    protected com.westee.accounting.model.common.UserInfo doForward(UserInfo userInfo) {
        return com.westee.accounting.model.common.UserInfo.builder().build();
    }

    @Override
    protected UserInfo doBackward(com.westee.accounting.model.common.UserInfo userInfo) {
        return UserInfo.builder().build();
    }
}
