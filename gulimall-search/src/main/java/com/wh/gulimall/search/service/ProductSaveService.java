package com.wh.gulimall.search.service;

import com.wh.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author wanghu
 * @date 2022/4/11 17:30
 */
public interface ProductSaveService {

    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
