package com.web.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;
import com.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Long-666
 * @create 2022-09-16 16:56
 */
@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    /**
     * 查询数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用brandService的方法，查询所有的数据
        List<Brand> brands = brandService.selectAll();
        //将集转化为JSON的类型
        String jsonString = JSON.toJSONString(brands);
        //设置编码格式
        resp.setContentType("text/json;charset=utf-8");
        //响应数据
        resp.getWriter().write(jsonString);
    }

    /**
     * 添加数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String line = reader.readLine();
        Brand brand = JSON.parseObject(line, Brand.class);

        brandService.add(brand);
        resp.getWriter().write("ok");
    }

    /**
     * 批量删除数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String line = reader.readLine();
        int[] ids = JSON.parseObject(line, int[].class);
        brandService.deleteByIds(ids);
        resp.getWriter().write("ok");
    }

    /**
     * 根据Id删除数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        brandService.deleteById(Integer.parseInt(id));
        resp.getWriter().write("ok");
    }

    /**
     * 分页查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);


        //将集转化为JSON的类型
        String jsonString = JSON.toJSONString(brandPageBean);
        //设置编码格式
        resp.setContentType("text/json;charset=utf-8");
        //响应数据
        resp.getWriter().write(jsonString);
    }

    /**
     * 分页条件查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String line = reader.readLine();
        Brand brand = JSON.parseObject(line, Brand.class);
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);


        //将集转化为JSON的类型
        String jsonString = JSON.toJSONString(brandPageBean);
        //设置编码格式
        resp.setContentType("text/json;charset=utf-8");
        //响应数据
        resp.getWriter().write(jsonString);
    }
}
