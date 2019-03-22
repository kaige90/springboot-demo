package com.chenkai.springbootdemo.demo.service;

import com.chenkai.springbootdemo.demo.exception.CommonException;
import com.chenkai.springbootdemo.demo.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 用户服务类
 * Author: chenkai
 * Date: 2019-03-22
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 用户登陆
     * @param vo
     * @throws CommonException
     */
    public UserVO login(UserVO vo) throws CommonException {
        if(StringUtils.isEmpty(vo.getMobile())){
            throw new CommonException("手机号不能为空");
        }
        if(StringUtils.isEmpty(vo.getName())){
            throw new CommonException("用户姓名不能为空");
        }
        if(!vo.getPassword().equals("123456")){
            throw new CommonException("用户名或密码不对");
        }
        String uid = UUID.randomUUID().toString().replace("-","");
        vo.setUid(uid);
        logger.info("用户{}登陆成功", vo.getName());
        return vo;
    }

}
