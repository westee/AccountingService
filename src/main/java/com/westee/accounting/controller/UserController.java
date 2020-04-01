package com.westee.accounting.controller;

import com.westee.accounting.converter.commonToService.UserInfoC2SConverter;
import com.westee.accounting.manager.UserInfoManager;
import com.westee.accounting.model.service.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@Slf4j
public class UserController {

    private final UserInfoManager userInfoManager;
    private final UserInfoC2SConverter userInfoC2SConverter;

    @Autowired
    public UserController(UserInfoManager userInfoManager, UserInfoC2SConverter userInfoC2SConverter) {
        this.userInfoManager = userInfoManager;
        this.userInfoC2SConverter = userInfoC2SConverter;
    }

    @GetMapping("/{id}")
    public UserInfo getUserInfoByUserId(@PathVariable("id") Long userId){
        com.westee.accounting.model.common.UserInfo userInfo = userInfoManager.getUserInfoByUserId(userId);
        return userInfoC2SConverter.convert(userInfo);
    }
}
