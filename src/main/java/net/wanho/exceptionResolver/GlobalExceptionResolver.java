package net.wanho.exceptionResolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/12/13.
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param request
     * @param response
     * @param handler 当前的处理器
     * @param ex 发生的异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg",ex.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
