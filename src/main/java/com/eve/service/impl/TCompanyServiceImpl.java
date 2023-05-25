package com.eve.service.impl;

import com.eve.entity.TCompany;
import com.eve.mapper.TCompanyMapper;
import com.eve.service.ITCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TCompanyServiceImpl extends ServiceImpl<TCompanyMapper, TCompany> implements ITCompanyService {

}
