package com.fs.bar.service.impl;/**
 * Created by fengsong on 2017/4/11.
 */

import com.fs.bar.dao.DictMapper;
import com.fs.bar.entity.Dict;
import com.fs.bar.exchange.constants.DictType;
import com.fs.bar.service.DictService;
import com.fs.util.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-04-11 17:29
 **/
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public String barTypeOpts() {
        return constructOpts(dictMapper.findByMap(GeneralUtils.generateMap("parentName", DictType.BAR)));
    }

    /**
     * 生成下拉选项字符串
     * @param dicts
     * @return
     */
    private String constructOpts(List<Dict> dicts) {
        StringBuffer sb = new StringBuffer();

        if (GeneralUtils.isNotNullOrEmpty(dicts)) {
            for (Dict dict : dicts) {
                sb.append("<option value=" + dict.getValue() + ">");
                sb.append(dict.getName());
                sb.append("</option>");
            }

        }

        return sb.toString();
    }
}
