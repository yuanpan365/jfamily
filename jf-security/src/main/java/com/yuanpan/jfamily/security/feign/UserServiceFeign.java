package com.yuanpan.jfamily.security.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.feign
 * @Description: 远程调用用户服务
 * @date 2018/6/7 14:43
 */
@FeignClient(value = "jf-system")
public interface UserServiceFeign {


}
