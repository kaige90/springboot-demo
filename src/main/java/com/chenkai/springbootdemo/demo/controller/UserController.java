package com.chenkai.springbootdemo.demo.controller;

import com.chenkai.springbootdemo.demo.exception.CommonException;
import com.chenkai.springbootdemo.demo.service.UserService;
import com.chenkai.springbootdemo.demo.util.Result;
import com.chenkai.springbootdemo.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关接口
 * Author: chenkai
 * Date: 2019-03-21
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 查找用户信息
     * @param name 姓名
     * @param mobile 手机号
     * @return
     */
    @GetMapping("/api/users")
    public Result find(String name, String mobile){
        UserVO vo = new UserVO();
        vo.setName(name);
        vo.setMobile(mobile);
        return Result.successResult(vo);
    }

    /**
     * 用户登陆
     * @param vo
     * @return
     * @throws CommonException
     */
    @PostMapping("/api/users/login")
    public Result login(@RequestBody UserVO vo) throws CommonException {
        UserVO resultVO = userService.login(vo);
        return Result.successResult(resultVO);
    }


}
