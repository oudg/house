package com.hy.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.Vo.PostVo;
import com.hy.Vo.ResponseVo;
import com.hy.mapper.PostMapper;
import com.hy.pojo.Post;
import com.hy.service.PostService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yixin
 * @since 2023-10-23
 */
@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;
@GetMapping("/postupate")
public Integer postupdate(
        @RequestParam Integer postid,
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

   return postService.updatePost1(postid, postTitle, price, cateId, roomCount, toiletCount, area, number, type, postContent);


}
@GetMapping("/getpostId")
public Integer getpostId(@RequestParam String postTitle,@RequestParam String number){

    return postService.getId(postTitle,number);

}
@GetMapping("postUseId")
public Integer saveuseId(@RequestParam String postTitle,@RequestParam String number,@RequestParam Integer useId){

    return postService.useId(postTitle, number, useId);

}
@GetMapping("/postedit")
public Integer postedit(@RequestParam String postTitle,@RequestParam String number,@RequestParam String edit ){

    return postService.saveEdit(postTitle, number, edit);

}
@GetMapping("/selectlow")
public ResponseVo<IPage<PostVo>> recommend1(
        @RequestParam(required = false,defaultValue = "1") Integer pageNum,
        @RequestParam(required = false,defaultValue = "15") Integer pageSize,
        @RequestParam(required = false,defaultValue = "0") Integer category
){
    return  postService.productslowprice(pageNum, pageSize, category);
}
@GetMapping("post_useId")
public ResponseVo<IPage<Post>> getuseIdpost(@RequestParam Integer useId){
    return postService.byuseId(useId);
}
    @GetMapping("/postList")
    public ResponseVo<IPage<PostVo>> recommend(
            @RequestParam(required = false,defaultValue = "0") Integer pageNum,
            @RequestParam(required = false,defaultValue = "100") Integer pageSize,
            @RequestParam(required = false,defaultValue = "0") Integer category
    ){
        return  postService.products(pageNum,pageSize,category);
    }

@GetMapping("/select_byname")
    public ResponseVo<IPage<Post>> getpost_byname(@RequestParam String name,@RequestParam Integer cateId){
       return postService.byName_post(name,cateId);
}

@GetMapping("/select_bytype")
public ResponseVo<IPage<Post>> getpost_bytype(@RequestParam String houseType,@RequestParam Integer cateId){
    return postService.byType_post(houseType, cateId);
}

@GetMapping("/select_byprice")
public ResponseVo<IPage<Post>> getpost_byprice(@RequestParam Integer start,@RequestParam Integer end,@RequestParam Integer cateId){
    return postService.byprcie_post(start,end,cateId);
}

@GetMapping("/select_bytypeAndprice")
    public ResponseVo<IPage<Post>> getposts(@RequestParam String leixing,@RequestParam Integer start,@RequestParam Integer end,@RequestParam Integer cateId){
        return postService.bytypeandprice_post(leixing,start,end,cateId);
}
}

