package com.web.old; /**
 * @author Long-666
 * @create 2022-09-16 14:52
 */

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.service.BrandService;
import com.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用brandService的方法，查询所有的数据
        List<Brand> brands = brandService.selectAll();
        //将集转化为JSON的类型
        String jsonString = JSON.toJSONString(brands);
        //设置编码格式
        response.setContentType("text/json;charset=utf-8");
        //响应数据
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
