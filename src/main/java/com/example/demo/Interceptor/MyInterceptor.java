package com.example.demo.Interceptor;

import com.alibaba.fastjson2.JSON;
import com.example.demo.Entity.Result;
import com.example.demo.Utils.JwtUtils;
import com.example.demo.Filter.MyFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 自定义拦截器
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    // 在请求处理之前进行调用（Controller方法调用之前）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求url
        String url = request.getRequestURL().toString();
        log.info("我是interceptor，拦截器请求 URL: {}", url);

        // 判断是否是登陆请求
        MyFilter filterChain;
        if (url.contains("login")) {
            log.info("登陆操作，放行");
            // 如果是登录请求，则直接放行
            return true;
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
                return false;
            }
        }
        //token校验通过，放行
        log.info("token校验通过");
        return true;
    }

    //目标资源方法执行之后调用，请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Controller方法已经执行，我是interceptor");

    }

    // 在整个请求结束之后被调用，也就是在DispatcherServlet渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        log.info("我是interceptor,请求已经结束");

    }

}
