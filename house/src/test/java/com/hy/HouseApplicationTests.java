package com.hy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.Vo.ResponseVo;
import com.hy.mapper.PostMapper;
import com.hy.mapper.UserMapper;
import com.hy.pojo.Category;
import com.hy.pojo.Post;
import com.hy.pojo.User;
import com.hy.service.ICategoryService;
import com.hy.service.IUserService;
import com.hy.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HouseApplicationTests {
@Autowired
private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;

    @Autowired
    private PostService postService;



    @Test
    void contextLoads() {
        for (int i=50 ;i<100 ;i++){
            Post post=new Post();
            post.setUserId(i);
            post.setPostTitle("玉树小区");
            post.setPostSummary("摘要");
            post.setPostThumbnail("sdasd");
            post.setPostStatus(0);
            post.setPrice(1300);
            post.setNumber("22栋2单元111室");
            post.setCateId(1);
            post.setImgUrl("src\\pic\\1001");
            post.setPostEditor("33333");
            post.setRoomCount(4);
            post.setToiletCount(2);
            post.setArea(130.0);
            postService.save(post);
        }

    }
@Test
    void eee() {

    QueryWrapper<User> wrapper=new QueryWrapper<>();
    wrapper.select("max(phone) as phone");

System.out.println(userMapper.selectOne(wrapper).getPhone());

}
}
