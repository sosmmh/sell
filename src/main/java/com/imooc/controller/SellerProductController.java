package com.imooc.controller;

import com.imooc.Exception.SellException;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Lixh
 * @Date: 2018/4/9 11:40
 * @Description: 卖家端商品
 */
@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {

        PageRequest pageRequest = new PageRequest(page - Integer.valueOf(1), size);

        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);

        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("product/list", map);
    }

    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/onSale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {

        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.PRODUCT_ON_SALE_SUCCESS.getMessage());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success");

    }

    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/offSale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {

        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.PRODUCT_OFF_SALE_SUCCESS.getMessage());
        map.put("url", "/sell/seller/product/list");

        return new ModelAndView("common/success");
    }

    /**
     * 商品修改
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {

        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        //查询所有的类目
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("categoryList", productCategoryList);

        return new ModelAndView("product/index", map);
    }
}
