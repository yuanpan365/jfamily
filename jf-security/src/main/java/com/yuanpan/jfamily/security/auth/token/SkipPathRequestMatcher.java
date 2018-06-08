package com.yuanpan.jfamily.security.auth.token;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.auth.token
 * @Description:  跳过请求匹配路径
 * @date 2018/6/7 13:28
 */
public class SkipPathRequestMatcher implements RequestMatcher {
    private OrRequestMatcher matcher;
    private List<RequestMatcher> processingMatchers;

    /**
     * @param paths 拦截的路径
     */
    public SkipPathRequestMatcher(List<String> paths) {
        matcher = new OrRequestMatcher(paths.stream().map(AntPathRequestMatcher::new).collect(Collectors.toList()));
    }

    /**
     * 暂不支持
     *
     * @param pathsToSkip 不拦截路径
     * @param paths       拦截路径
     */
    @Deprecated
    public SkipPathRequestMatcher(List<String> pathsToSkip, List<String> paths) {
        List<RequestMatcher> m = pathsToSkip.stream().map(AntPathRequestMatcher::new).collect(Collectors.toList());
        matcher = new OrRequestMatcher(m);
        processingMatchers = new ArrayList<>();
        paths.forEach(req -> processingMatchers.add(new AntPathRequestMatcher(req)));

    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return matcher.matches(request);
    }
}
