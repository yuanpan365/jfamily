package com.yuanpan.jfamily.common.page;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuanpan.jfamily.common.utils.Underline2Camel;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.common.page
 * @Description: 分页查询参数
 * @date 2018/6/6 16:45
 */
public class Query<T extends PageModel> extends LinkedHashMap<String, Object> {

    @Getter
    @Setter
    private Page<?> page;

    @Getter
    @Setter
    private EntityWrapper<T> entityWrapper = new EntityWrapper<T>();


    public Query() {

    }

    /**
     * 该查询方法默认string类型的查询字段处理为  'like' not '='
     * 根据泛型反射获取查询条件进行查询 默认分页
     *
     * @param t
     */
    public Query(T t) {
        try {
            EntityWrapper<T> wrapper = new EntityWrapper<T>();
            int offset = t.getOffset();
            int limit = t.getLimit();
            buildParam(wrapper, t);
            this.entityWrapper = wrapper;
            this.page = PageHelper.startPage(offset / limit + 1, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 该查询方法默认string类型的查询字段处理为 '=' not 'like'
     *
     * @param t
     * @param f true 是进行分页处理，false 不分页处理
     */
    public Query(T t, boolean f) {
        EntityWrapper<T> wrapper = new EntityWrapper<T>(t);
        String order = t.getOrder();
        String sort = t.getSort();
        if (StringUtils.isNotEmpty(order) && StringUtils.isNotEmpty(sort)) {
            String orderArr[] = order.split(",");
            String sortArr[] = sort.split(",");
            if (orderArr.length == sortArr.length) {
                int i = 0;
                for (String orderName : orderArr) {
                    wrapper.orderBy(orderName, "asc".equals(sortArr[i]));
                    i++;
                }
            }
        }
        this.entityWrapper = wrapper;
        if (f) {
            int offset = t.getOffset();
            int limit = t.getLimit();
            this.page = PageHelper.startPage(offset / limit + 1, limit);
        }
    }

    private void buildParam(EntityWrapper<T> wrapper, T t) {
        Field[] files = t.getClass().getDeclaredFields();
        for (Field file : files) {
            try {
                file.setAccessible(true);
                if (file.get(t) != null) {
                    TableField tableFile = file.getAnnotation(TableField.class);
                    if (tableFile != null && tableFile.exist() == false) {
                        continue;
                    }
                    if (file.getType() == String.class) {
                        wrapper.like(Underline2Camel.camel2Underline(file.getName()), (String) file.get(t));
                    }
                    if (file.getType() == Integer.class || file.getType() == Long.class) {
                        wrapper.eq(Underline2Camel.camel2Underline(file.getName()), file.get(t));
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        String order = t.getOrder();
        String sort = t.getSort();
        if (StringUtils.isNotEmpty(order) && StringUtils.isNotEmpty(sort)) {
            String orderArr[] = order.split(",");
            String sortArr[] = sort.split(",");
            if (orderArr.length == sortArr.length) {
                int i = 0;
                for (String orderName : orderArr) {
                    wrapper.orderBy(orderName, "asc".equals(sortArr[i]));
                    i++;
                }
            }
        }
    }
}

