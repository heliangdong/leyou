package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.SpuBo;

public interface GoodsService {
     PageResult<SpuBo> querySpuByPageAndSort(Integer page, Integer rows, Boolean saleable, String key);
}
