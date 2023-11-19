package com.hy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.hy.Vo.PostVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yixin
 * @since 2023-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "userId")
    private Integer userId;

    /**
     * 房屋标题
     */
    @TableField("postTitle")
    private String postTitle;

    /**
     * 房屋描述
     */
    @TableField("postContent")
    private String postContent;

    /**
     * 房屋摘要
     */
    @TableField("postSummary")
    private String postSummary;

    /**
     * 略缩图
     */
    @TableField("postThumbnail")
    private String postThumbnail;

    /**
     * 房屋状态
     */
    @TableField("postStatus")
    private Integer postStatus;

    /**
     * 月付价格
     */
    private Integer price;

    /**
     * 房屋编号
     */
    private String number;

    /**
     * 分类id
     */
    @TableField("cateId")
    private Integer cateId;

    /**
     * 城市id
     */
    @TableField("cityId")
    private Integer cityId;

    /**
     * 图片url
     */
    @TableField("imgUrl")
    private String imgUrl;

    private Integer postid;
    /**
     * 富文本
     */
    @TableField("postEditor")
    private String postEditor;
    private String type;
    /**
     * 卧室数量
     */
    @TableField("roomCount")
    private Integer roomCount;

    /**
     * 洗手间数量
     */
    @TableField("toiletCount")
    private Integer toiletCount;

    /**
     * 面积
     */
    private Double area;

    private Integer useId;

}
