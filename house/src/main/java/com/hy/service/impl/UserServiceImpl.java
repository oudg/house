package com.hy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hy.Vo.ResponseVo;
import com.hy.mapper.PostMapper;
import com.hy.mapper.UserMapper;
import com.hy.pojo.Post;
import com.hy.pojo.User;
import com.hy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2023-10-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
@Autowired
private UserMapper userMapper;

@Autowired
private PostMapper postMapper;


@Autowired
IUserService userService;

    @Override
    public User loginService(String name, String password) {
QueryWrapper<User> wrapper=new QueryWrapper();

User user=new User();

user=userService.getOne(wrapper.eq("userName",name).eq("userPass",password));

if (user!=null)
    return user;
else
return null;

    }


    @Override
    public ResponseVo<IPage<Post>> getUser_post(Integer pageNum, Integer pageSize, Integer userId) {
        QueryWrapper<Post> wrapper=new QueryWrapper();
        wrapper.eq("userId",userId);
        Page<Post> page=new Page<>(pageNum,pageSize);
        IPage<Post> postIPage=postMapper.selectPage(page,wrapper);
        return ResponseVo.success(postIPage);
    }

    @Override
    public Integer getUserId(String username) {
        LambdaQueryWrapper<User> wrapper=Wrappers.lambdaQuery();
        wrapper.eq(User::getUserName,username);
        User user=userMapper.selectOne(wrapper);

        return user.getId();
    }

    @Override
    public Integer saveUser(String userName, String userPass,Integer phone,Integer user_status) {
        User user=new User();
        user.setUserName(userName);
        user.setUserPass(userPass);
        user.setPhone(phone);
        user.setStatus(user_status);
        return userMapper.insert(user);
    }

    @Override
    public Integer savePost(Integer userId, String postTitle, Integer price, Integer cateId, Integer roomCount, Integer toiletCount, Double area, String number, String type, String postContent) {

        Post post=new Post();
       post.setPostTitle(postTitle);
       post.setUserId(userId);
       post.setPrice(price);
       post.setCateId(cateId);
       post.setPostContent(postContent);
       post.setRoomCount(roomCount);
       post.setToiletCount(toiletCount);
       post.setArea(area);
       post.setNumber(number);
       post.setType(type);
        Integer a= postMapper.insert(post);
        return a;
    }

    @Override
    public Integer savepic(String img,String postTitle,String number) {

        return null;
    }

    @Override
    public Integer updateUser(Integer userId, String userName, String userPass, Integer phone) {

        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("id",userId);
        User user=new User();
        user.setUserName(userName);
        user.setUserPass(userPass);
        user.setPhone(phone);
        return userMapper.update(user,wrapper);
    }

    @Override
    public Integer getPhone(Integer id) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("id",id);
        return userService.getOne(wrapper).getPhone();
    }

    @Override
    public boolean deleteuser(String userName, String userPass) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userName",userName).eq("userPass",userPass);

        return userService.remove(wrapper);
    }

    @Override
    public ResponseVo<IPage<User>> getAlluser() {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        Page<User> page=new Page<>(1,10);
        IPage<User> postIPage=userMapper.selectPage(page,wrapper);
        return ResponseVo.success(postIPage);
    }

    @Override
    public Integer getUserStatus(Integer id) {
        QueryWrapper<User> wrapper=new QueryWrapper();
        wrapper.eq("id",id);

        return userService.getOne(wrapper).getStatus();
    }

    @Override
    public ResponseVo<IPage<Post>> getManger_post(Integer pageNum, Integer pageSize) {
        QueryWrapper<Post> wrapper=new QueryWrapper();
        wrapper.eq("manger",0);
        Page<Post> page=new Page<>(pageNum,pageSize);
        IPage<Post> postIPage=postMapper.selectPage(page,wrapper);
        return ResponseVo.success(postIPage);
    }


    @Override
    public User registService(User user) {
        return null;
    }

}
