package com.hy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.Vo.PostVo;
import com.hy.Vo.ResponseVo;
import com.hy.pojo.Post;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yixin
 * @since 2023-10-23
 */
public interface PostService extends IService<Post> {
    ResponseVo<IPage<PostVo>> products(Integer pageNum, Integer pageSize , Integer category);
    Integer updatePost1(Integer postid, String postTitle,Integer price,Integer cateId,Integer roomCount,Integer toiletCount,Double area,String number,String type,String postContent);
Integer useId(String postTitle,String number,Integer useId);
    boolean delete(String postTitle,String number);
    ResponseVo<IPage<PostVo>> productslowprice(Integer pageNum, Integer pageSize , Integer category);
    ResponseVo<IPage<Post>> byuseId(Integer useId);
    Integer getId(String postTitle,String number);
    boolean deletes(String postTitle,String number);
    ResponseVo<IPage<Post>> byType_post(String type,Integer cateId);
    ResponseVo<IPage<Post>> byName_post(String name,Integer cateId);
    ResponseVo<IPage<Post>> byprcie_post(Integer x, Integer y,Integer cateId);
    ResponseVo<IPage<Post>> bytypeandprice_post(String leixing,Integer x, Integer y,Integer cateId);

    Integer saveEdit(String postTitle,String number,String edit);

}
