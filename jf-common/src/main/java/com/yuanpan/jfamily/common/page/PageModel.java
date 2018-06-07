package com.yuanpan.jfamily.common.page;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.common.page
 * @Description: 分页Model
 * @date 2018/6/6 16:42
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class PageModel extends Model<Model>{
    @Override
    protected Serializable pkVal() {
        return null;
    }


    public PageModel() {

    }
    // 总记录数
    @TableField(exist=false)
    private long total;
    // 列表数据
    @TableField(exist=false)
    private List<?> rows;
    //页面大小
    @TableField(exist=false)
    private int limit;

    //页码
    @TableField(exist=false)
    private int offset;

    //排序字段
    @TableField(exist=false)
    private String order;

    //降序/升序
    @TableField(exist=false)
    private String sort;

    // 获取数据正常
    @TableField(exist=false)
    private int code=0;


    /**
     * 分页
     *
     * @param list
     *            列表数据
     * @param total
     *            总记录数
     */
    public PageModel(List<?> list, long total) {
        this.rows = list;
        this.total = total;
    }
}
