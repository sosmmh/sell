package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Auther: Lixh
 * @Date: 2018/4/2 17:07
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        System.out.println(categoryService.findOne(1));
    }

    @Test
    public void findAll() {
        System.out.println(categoryService.findAll());
    }

    @Test
    public void findByCategoryTypeIn() {
        System.out.println(categoryService.findByCategoryTypeIn(Arrays.asList(1, 2)));
    }

    @Test
    public void save() {
        System.out.println(categoryService.save(new ProductCategory("冻品2", 4)));
    }
}