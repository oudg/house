package com.hy.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.pojo.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yixin
 * @since 2023-10-23
 */
public interface PostMapper extends BaseMapper<Post> {

        /**
         * <p>
         * 查询 : 根据state状态查询用户列表，分页显示
         * </p>
         *
         * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
         * @param state 状态
         * @return 分页对象
         */
        IPage<Post> selectPageVo(Page<?> page, Integer state);


}
