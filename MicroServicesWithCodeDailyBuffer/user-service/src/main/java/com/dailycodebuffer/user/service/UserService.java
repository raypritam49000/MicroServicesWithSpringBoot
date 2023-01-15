package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.vo.ResponseTemplateVO;

public interface UserService {
    public User saveUser(User user);
    public ResponseTemplateVO getUserWithDepartment(Long userId);
}
