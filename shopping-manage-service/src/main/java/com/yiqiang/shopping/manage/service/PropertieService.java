package com.yiqiang.shopping.manage.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/25 0025 15:23
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Service
public class PropertieService {

    @Value("${REPOSITORY_PATH}")
    public String REPOSITORY_PATH;

    @Value("${IMAGE_BASE_URL}")
    public String IMAGE_BASE_URL;
}
