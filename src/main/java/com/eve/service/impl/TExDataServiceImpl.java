package com.eve.service.impl;

import com.eve.entity.TCompany;
import com.eve.entity.TExData;
import com.eve.mapper.TExDataMapper;
import com.eve.service.ITCompanyService;
import com.eve.service.ITExDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TExDataServiceImpl extends ServiceImpl<TExDataMapper, TExData> implements ITExDataService {


    @Autowired
    private ITCompanyService companyService;


    @Override
    public void saveData(){
        List<TCompany> list = companyService.list();
        for(int i=0;i<=1000;i++){
            List<TExData> rs = new ArrayList<>();
            for(TCompany l:list){
                TExData tExData = new TExData();
                tExData.setName(i+l.getName());
                tExData.setCompanyId(l.getCompanyId());
                tExData.setCompanyName(l.getName());
                rs.add(tExData);
            }

            saveBatch(rs);
        }
    }

}
