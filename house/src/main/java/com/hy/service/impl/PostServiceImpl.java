package com.hy.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.Vo.PostVo;
import com.hy.Vo.ResponseVo;
import com.hy.mapper.UserMapper;
import com.hy.pojo.Post;
import com.hy.mapper.PostMapper;
import com.hy.pojo.User;
import com.hy.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yixin
 * @since 2023-10-23
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper,Post> implements  PostService{

    @Autowired
    private PostService postService;

@Autowired
private UserMapper userMapper;
    @Autowired
    private PostMapper postMapper;
    @Override
    public ResponseVo<IPage<PostVo>> products(Integer pageNum, Integer pageSize , Integer category) {
    LambdaQueryWrapper<Post> postQuery=Wrappers.lambdaQuery();
    postQuery.eq(Post::getCateId,category);
    Page<Post> page=new Page(pageNum,pageSize);
    IPage<Post> postIPage=postMapper.selectPage(page,postQuery);

    IPage<PostVo> postVoIPage=new Page<>();
    BeanUtils.copyProperties(postIPage,postVoIPage);
    List<PostVo> postVoList=postIPage.getRecords().stream().
            map(e->postVo2(e)).collect(Collectors.toList());
postVoIPage.setRecords(postVoList);
return ResponseVo.success(postVoIPage);
    }

    @Override
    public Integer updatePost1(Integer postid, String postTitle, Integer price, Integer cateId, Integer roomCount, Integer toiletCount, Double area, String number, String type, String postContent) {
       QueryWrapper<Post> wrapper=new QueryWrapper<>();
       wrapper.eq("postid",postid);
        Post post=new Post();
        post.setPostTitle(postTitle);
        post.setPrice(price);
        post.setCateId(cateId);
        post.setPostContent(postContent);
        post.setRoomCount(roomCount);
        post.setToiletCount(toiletCount);
        post.setArea(area);
        post.setNumber(number);
        post.setType(type);





        return postMapper.update(post,wrapper);
    }

    @Override
    public Integer useId(String postTitle, String number,Integer useId) {
        QueryWrapper<Post> wrapper=new QueryWrapper<>();
        wrapper.eq("postTitle",postTitle).eq("number",number);
        Post post=new Post();
        post.setUseId(useId);
        return postMapper.update(post,wrapper);
    }

    @Override
    public boolean delete(String postTitle, String number) {
        QueryWrapper<Post> wrapper=new QueryWrapper<>();
        wrapper.eq("postTitle",postTitle).eq("number",number);
        return  postService.remove(wrapper);
    }

    @Override
    public ResponseVo<IPage<PostVo>> productslowprice(Integer pageNum, Integer pageSize, Integer category) {

        LambdaQueryWrapper<Post> postQuery=Wrappers.lambdaQuery();
        postQuery.eq(Post::getCateId,category).lt(Post::getPrice,1000);
        Page<Post> page=new Page(pageNum,pageSize);
        IPage<Post> postIPage=postMapper.selectPage(page,postQuery);

        IPage<PostVo> postVoIPage=new Page<>();
        BeanUtils.copyProperties(postIPage,postVoIPage);
        List<PostVo> postVoList=postIPage.getRecords().stream().
                map(e->postVo2(e)).collect(Collectors.toList());
        postVoIPage.setRecords(postVoList);
        return ResponseVo.success(postVoIPage);
    }

    @Override
    public ResponseVo<IPage<Post>> byuseId(Integer useId) {
        QueryWrapper<Post> wrapper=new QueryWrapper();
        wrapper.eq("useId",useId);
        Page<Post> page=new Page<>(1,100);
        IPage<Post> postIPage=postMapper.selectPage(page,wrapper);
        return ResponseVo.success(postIPage);
    }


    @Override
    public Integer getId(String postTitle, String number) {
        QueryWrapper<Post> wrapper=new QueryWrapper<>();
        wrapper.eq("postTitle",postTitle).eq("number",number);

        return postMapper.selectOne(wrapper).getPostid();
    }

    @Override
    public boolean deletes(String postTitle, String number) {
        QueryWrapper<Post> wrapper=new QueryWrapper<>();
        wrapper.eq("postTitle",postTitle).eq("number",number);
Post post=new Post();
post.setUseId(0);
        return  postService.update(post,wrapper);
    }

    @Override
    public ResponseVo<IPage<Post>> byType_post(String type, Integer cateId) {
        LambdaQueryWrapper<Post> wrapper=Wrappers.lambdaQuery();
        wrapper.eq(Post::getType,type).eq(Post::getCateId,cateId);
        Page<Post> page=new Page<>(1,100);
        IPage<Post> postIPage=postMapper.selectPage(page,wrapper);
        return ResponseVo.success(postIPage);

    }

    @Override
    public ResponseVo<IPage<Post>> byName_post(String name,Integer cateId) {
        LambdaQueryWrapper<Post> wrapper=Wrappers.lambdaQuery();
        wrapper.like(Post::getPostTitle,name).eq(Post::getCateId,cateId);

        Page<Post> page=new Page<>(1,100);
        IPage<Post> postIPage=postMapper.selectPage(page,wrapper);
        return ResponseVo.success(postIPage);
    }

    @Override
    public ResponseVo<IPage<Post>> byprcie_post(Integer x, Integer y, Integer cateId) {
        LambdaQueryWrapper<Post> wrapper=Wrappers.lambdaQuery();
        wrapper.ge(Post::getPrice,x).lt(Post::getPrice,y);
        Page<Post> page=new Page<>(1,100);
        IPage<Post> postIPage=postMapper.selectPage(page,wrapper);
        return ResponseVo.success(postIPage);
    }

    @Override
    public ResponseVo<IPage<Post>> bytypeandprice_post(String leixing, Integer x, Integer y, Integer cateId) {
        LambdaQueryWrapper<Post> wrapper=Wrappers.lambdaQuery();
        wrapper.ge(Post::getPrice,x).lt(Post::getPrice,y).eq(Post::getType,leixing);
        Page<Post> page=new Page<>(1,100);
        IPage<Post> postIPage=postMapper.selectPage(page,wrapper);
        return ResponseVo.success(postIPage);
    }

    @Override
    public Integer saveEdit(String postTitle, String number, String edit) {
        QueryWrapper<Post> wrapper=new QueryWrapper<>();
        wrapper.eq("postTitle",postTitle).eq("number",number);
        Post post=new Post();
        post.setPostEditor(edit);
        return postMapper.update(post,wrapper);
    }


    private PostVo postVo2(Post post){
        PostVo postVo=new PostVo();
        BeanUtils.copyProperties(post,postVo);
        return postVo;
    }



}
