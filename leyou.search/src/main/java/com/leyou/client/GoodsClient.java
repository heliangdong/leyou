package com.leyou.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("item-service")
public class GoodsClient extends BrandApi  {
}
