package com.qf.service.impi;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.SysMenuMapper;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.SysMenu;
import com.qf.service.MenuService;
import com.qf.utils1.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public DataGridResult findMenu(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());

       if (queryDTO.getSort()!=null&&!queryDTO.getSort().equals("")){
           queryDTO.setSort("menu_id");

       }

        List<SysMenu> menuByPage=sysMenuMapper.findMenuByPage(queryDTO);
        PageInfo<SysMenu> info=new PageInfo<SysMenu>(menuByPage);
        long total=info.getTotal();
        DataGridResult result=new DataGridResult(total,info.getList());
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public R deleteMenu(List<Long> ids) {
        for (Long id:ids){
            if (id<=50){
                return R.error("系统菜单，不支持删除");
            }

        }
        int i=sysMenuMapper.deleteMenu(ids);
        if (i>0){

            return R.ok();

        }else {

            return R.error(-200,"删除失败");
        }


    }

    @Override
    public R selectMenu() {
        //这个方法对应了dao层的持久层
        List<SysMenu> menu=sysMenuMapper.findMenu();
        //执行完了会返回一个数据
        //对这个数据进行一个过滤
        SysMenu sysMenu=new SysMenu();
        sysMenu.setMenuId(0L);
        sysMenu.setType(0);
        sysMenu.setParentId(-1L);
        sysMenu.setName("一级菜单");
        menu.add(sysMenu);

        return R.ok().put("menuList",menu);
    }

    @Override
    public R saveMenu(SysMenu sysMenu) {
        int i=sysMenuMapper.insertSelective(sysMenu);
        return i>0?R.ok():R.error();

    }

    @Override
    public R findMenuById(Long menuId) {
        SysMenu sysMenu=sysMenuMapper.selectByPrimaryKey(menuId);
        return R.ok().put("menu",sysMenu);
    }

    @Override
    public R updateMenu(SysMenu sysMenu) {
        int i=sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
        return i>0?R.ok():R.error("修改失败");
    }

    @Override
    public List<String> findPermsByUserId(Long userId) {
        List<String> permsByUserId =sysMenuMapper.findPermsByUserId(userId);
        //set的特点各种快 无序
        Set<String> set=new HashSet<String>();
//        将持久层拿到的数据遍历出来
        for(String s:permsByUserId){
            if (s!=null&&!s.equals("")){
    //      split用于,分割
            String[] split=s.split(",");
            //将split中的数据拿出来
                for (String s1:split){
                    //添加到set hashmap中去
                    set.add(s1);

                }
            }
        }
        List<String> perms=new ArrayList<>();
        perms.addAll(set);
        return perms;
    }

    @Override
    public R findUserMenu(Long userId) {
        //查询用户的一级目录
        List<Map<String,Object>> dirMenuByUserId=sysMenuMapper.findDirMenuByUserId(userId);
        //查询对应的子菜单
        for(Map<String,Object> map:dirMenuByUserId){
            //map.get("menuId") menuid是bigint形式
//            Long.parseLong 是干嘛的？  将调用到的menuId转化为long类型
            Long menuId=Long.parseLong(map.get("menuId")+"");

            //将这两个参数传递过去并返回数据 在封装到map里面
            List<Map<String,Object>> subList=sysMenuMapper.findMenuNotButtonByUserId(userId,menuId);
            map.put("list",subList);
        }

        //在R中继承里map方法 上面将map封装到List中 之后又将list封装在map中 类似于这种形式
        /*
                map{
                    list[
                        map{string,object},
                           {string,object}
                        ],
                    list[
                        map{string,object},
                           {string,object}
                        ]
                    }

         */

        List<String> permsByUserId=sysMenuMapper.findPermsByUserId(userId);
        return R.ok().put("menuList",dirMenuByUserId).put("permissions",permsByUserId);
    }

}
