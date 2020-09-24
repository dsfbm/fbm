package com.example.service;

import com.example.dao.DiduiDao;
import com.example.entity.DiGui;
import com.example.entity.DiGuiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiguiServiceImpi {
    @Autowired
    private DiduiDao diduiDao;
    //输入id为1，是它的根节点
    public DiGuiVo findByRootId(Integer id) {
        //根据ID获取根节点对象
        DiGui diGui=diduiDao.getOne(id);

        //哪些节点的父节点是根节点
        List<DiGui> diGuis=diduiDao.findByPId(id);

        //新建一个包装对象
        DiGuiVo diGuiVo=new DiGuiVo();
        //设置ID NAME
        diGuiVo.setId(id);
        diGuiVo.setName(diGui.getName());
        //调用fide1方法
        find1(diGuis,diGuiVo);
        return diGuiVo;
    }

    public void find1(List<DiGui> diGuis,DiGuiVo diGuiVo){
        List<DiGuiVo> diGuiVos=new ArrayList<>();

        //遍历子节点
        for(DiGui diGui:diGuis){
            DiGuiVo diGuiVo1=new DiGuiVo();
        // 遍历数据，把数据给diGuiVo1
            diGuiVo1.setId(diGui.getId());
            diGuiVo1.setName(diGui.getName());
            // 根据id的值去查pid
            List<DiGui> diGuis1=diduiDao.findByPId(diGui.getId());

            find1(diGuis1,diGuiVo1);
            diGuiVos.add(diGuiVo1);
        }

        diGuiVo.setDiGuiVos(diGuiVos);
    }


}
