package com.hy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.Vo.ResponseVo;
import com.hy.pojo.Post;
import com.hy.pojo.User;
import com.hy.service.IUserService;
import com.hy.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unit.Result;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    PostService postService;

    @Autowired
    IUserService userService;
    @GetMapping("/login")

public User getLogin(@RequestParam String userName, @RequestParam String userPass){



    return userService.loginService(userName,userPass);



}
@GetMapping("/deleteuser")
public Boolean deleteuser(@RequestParam String userName,@RequestParam String userPass){

        return userService.deleteuser(userName, userPass);

}
@GetMapping("/getAlluser")
public ResponseVo<IPage<User>> getuserAll(){
        return userService.getAlluser();
}
@GetMapping("/getphone")
public Integer phone(@RequestParam Integer id){
        return userService.getPhone(id);
}
@GetMapping("/getuser_post")
public ResponseVo<IPage<Post>> getpost(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer userId){

        return userService.getUser_post(pageNum,pageSize,userId);

}

@GetMapping("/getuser_id")
    public Integer test(@RequestParam String username){
        return userService.getUserId(username);
}

@GetMapping("/delete1")
    public boolean delete1_post(@RequestParam String postTitle,@RequestParam String number){

        return postService.deletes(postTitle,number);

    }
    @GetMapping("/delete")
    public boolean delete_post(@RequestParam String postTitle,@RequestParam String number){

        return postService.delete(postTitle,number);

    }
    @GetMapping("/regite")
    public Integer adduser(@RequestParam String userName,@RequestParam String userPass,@RequestParam Integer phone,@RequestParam Integer user_status){

        return userService.saveUser(userName,userPass,phone,user_status);
    }
@GetMapping("/addPost")
    public Integer addpost(
            @RequestParam Integer userId,
            @RequestParam String postTitle,
            @RequestParam Integer price,
            @RequestParam Integer cateId,
            @RequestParam Integer roomCount,
            @RequestParam Integer toiletCount,
            @RequestParam Double area,
            @RequestParam String number,
            @RequestParam String type,
            @RequestParam String postContent

){

      return   userService.savePost(userId,postTitle,price,cateId,roomCount,toiletCount,area,number,type,postContent);

}

@GetMapping("/userUpdate")
public Integer userupdate(@RequestParam Integer userId, @RequestParam String userName,@RequestParam String userPass, @RequestParam Integer phone){

     return userService.updateUser(userId, userName, userPass, phone);

}
@GetMapping("/getuserStatus")
    public Integer getStatus(@RequestParam Integer id){

        return userService.getUserStatus(id);
}
@GetMapping("/getAllpost")
    public ResponseVo<IPage<Post>> getAll(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        return userService.getManger_post(pageNum,pageSize);
}
}

