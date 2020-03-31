package com.westee.accounting.controller;

import com.westee.accounting.converter.commonToService.UserInfoConverter;
import com.westee.accounting.manager.UserInfoManager;
import com.westee.accounting.model.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserInfoManager userInfoManager;
    private final UserInfoConverter userInfoConverter;

    @Autowired
    public UserController(UserInfoManager userInfoManager, UserInfoConverter userInfoConverter) {
        this.userInfoManager = userInfoManager;
        this.userInfoConverter = userInfoConverter;
    }

    @GetMapping("/{id}")
    public UserInfo getUserInfoByUserId(@PathVariable("id") Long userId){
        com.westee.accounting.model.common.UserInfo userInfo = userInfoManager.getUserInfoByUserId(userId);
        return userInfoConverter.convert(userInfo);
    }
}
