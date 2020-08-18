package com.ky.core.security;

import com.ky.core.util.EncrypUtils;
import com.ky.core.util.StringUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * 该类主要用于解密配置文件
 *
 * @author RM
 * @version V1.0.0
 * @date 2019-01-07 14:09
 */
public class PropertyPlaceholderConfigurerDecode extends PropertyPlaceholderConfigurer {
    /**
     * 默认文件不加密
     */
    private boolean secutiry = false;
    /**
     * 默认秘钥
     */
    private String  key = "_@WDYL#ACB#123@";
    /**
     * 是否解密分解字符   字符以";;"结尾的数据都不解密，也说明它没有加密
     */
    private String  sercurityFlag;

    /**
     * 方法一 ： 解密所有的配置文件
     * @param placeholder 参数名
     * @param props   配置文件加载中心
     * @return
     */
     @Override
	protected String resolvePlaceholder(String placeholder, Properties props) {
		String placeholderValue = props.getProperty(placeholder);
		//是否开启加密
		if (this.secutiry) {
			if (!StringUtil.isEmpty(placeholderValue)) {
				if (placeholderValue.endsWith(this.sercurityFlag)) {
					placeholderValue = placeholderValue.split(this.sercurityFlag)[0];
				} else {
					placeholderValue = EncrypUtils.decrypt3Des(placeholderValue,this.key);
				}
			}
		} else {
			if (!StringUtil.isEmpty(placeholderValue)) {
				if (placeholderValue.endsWith(this.sercurityFlag)) {
					placeholderValue = placeholderValue.split(this.sercurityFlag)[0];
				}
			}
		}
		return placeholderValue;
	}

    public boolean isSecutiry() {
        return secutiry;
    }
    public void setSecutiry(boolean secutiry) {
        this.secutiry = secutiry;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getSercurityFlag() {
        return sercurityFlag;
    }
    public void setSercurityFlag(String sercurityFlag) {
        this.sercurityFlag = sercurityFlag;
    }
}
