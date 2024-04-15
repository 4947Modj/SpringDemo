package com.example.demo.Filter;

import com.alibaba.fastjson2.JSON;
import com.example.demo.Entity.Result;
import com.example.demo.Utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*") // 拦截所有请求
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 在这里添加过滤器的逻辑
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取请求url
        String url = request.getRequestURL().toString();
        log.info("我是filter，请求 URL: {}", url);

        // 判断是否是登陆请求
        if (url.contains("login")) {
            log.info("登陆操作，放行");
            // 如果是登录请求，则直接放行
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 获取请求头中的token
        // 这里需要根据实际情况获取token，例如从请求头中获取，或者从请求参数中获取
        String token = request.getHeader("token");
        if (StringUtils.hasLength(token)){
            //有token，进行校验
            log.info("校验token");
            // 这里可以调用JWT工具类的方法来验证token的有效性
            try{
                JwtUtils.parseJwtToken(token);
            }catch (Exception e){
                //token校验失败
                log.info("token校验失败");
                e.printStackTrace();
                Result error = Result.error("NOT_LOGIN");
                String notLogin = JSON.toJSONString(error);
                response.getWriter().write(notLogin);
                return;
            }
        }
        //token校验通过，放行
        log.info("token校验通过");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("我是filter，销毁了");
    }
}
