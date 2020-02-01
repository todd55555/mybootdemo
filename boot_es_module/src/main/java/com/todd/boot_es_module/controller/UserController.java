package com.todd.boot_es_module.controller;

import com.alibaba.fastjson.JSON;
import com.todd.boot_es_module.entity.User;
import com.todd.boot_es_module.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ClassName UserController
 * @Description
 * @Author todd
 * @Date 2020/2/1 3:46 下午
 * @Version v.1.0
 **/

@RestController
@RequestMapping(value = "/com/todd/user/es/")
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "save")
    public void saveUser(@RequestBody User user){
        userRepository.save(user);
        log.info("保存完成");
    }

    @RequestMapping(value = "getUserById/{userId}")
    public String getUser(@PathVariable Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            return JSON.toJSONString(userOptional.get());
        }
        return "no data";
    }

    @RequestMapping(value = "update")
    public void updateUser(@RequestBody User user){
        if(user.getId() == null){
            log.error("用户ID不能为空");
            return;
        }
        userRepository.save(user);
        log.info("更新完成");
    }

}
