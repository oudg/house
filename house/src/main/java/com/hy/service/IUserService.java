package com.hy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.Vo.ResponseVo;
import com.hy.pojo.Post;
import com.hy.pojo.User;
import org.springframework.web.multipart.MultipartFile;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-10-25
 */
public interface IUserService extends IService<User> {
User loginService(String name, String password);
User registService(User user);
    ResponseVo<IPage<Post>> getUser_post(Integer pageNum, Integer pageSize , Integer userId);
  Integer getUserId(String username);
  Integer saveUser(String userName, String userPass,Integer phone,Integer user_status);
  Integer savePost(Integer userId, String postTitle, Integer price, Integer cateId, Integer roomCount, Integer toiletCount, Double area, String number, String type, String postContent);
Integer savepic(String img,String postTitle,String number);
Integer updateUser(Integer userId,String userName,String userPass,Integer phone);
Integer getPhone(Integer id);

boolean deleteuser(String userName, String userPass);
    ResponseVo<IPage<User>>  getAlluser();
Integer getUserStatus(Integer id);

    ResponseVo<IPage<Post>> getManger_post(Integer pageNum, Integer pageSize);

}
