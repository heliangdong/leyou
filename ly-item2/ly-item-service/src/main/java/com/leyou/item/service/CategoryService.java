package com.leyou.item.service;


import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService  {
     List<Category> queryCategoryListByParentId(Long pid);

    List<String> queryNameByIds(List<Long> ids);
}
