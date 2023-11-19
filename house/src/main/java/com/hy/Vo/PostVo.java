package com.hy.Vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class PostVo {

    private Integer userId;

    /**
     * 房屋标题
     */

    private String postTitle;

    /**
     * 房屋描述
     */

    private String postContent;


    /**
     * 房屋状态
     */

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

    private Integer cateId;

    /**
     * 城市id
     */

    private Integer cityId;

    /**
     * 图片url
     */

    private String imgUrl;


    /**
     * 卧室数量
     */

    private Integer roomCount;

    /**
     * 洗手间数量
     */

    private Integer toiletCount;

    /**
     * 面积
     */
    private Double area;
private String postThumbnail;

private String postSummary;

private  String type;

}
