package org.hw.sml.status.client;

import org.hw.sml.context.SmlContextUtils;
import org.hw.sml.status.rs.StatusResource;
import org.hw.sml.support.LoggerHelper;
import org.hw.sml.support.ioc.BeanHelper;
import org.hw.sml.support.ioc.annotation.Bean;
import org.hw.sml.support.ioc.annotation.Init;
import org.hw.sml.support.ioc.annotation.Inject;

import com.alibaba.fastjson.JSON;
@Bean("manageClientResource")
public class ClientResource {
	
	private String severUrl;
	
	@Inject("manage-status-resource")
	private StatusResource statusResource;
	
	@Init
	public void init(){
		severUrl=BeanHelper.getValue("server.master.url");
	}
	
	public void task(){
		try {
			if(severUrl==null){
				return;
			}
			String result=SmlContextUtils.queryFromUrl(severUrl+"/regist",JSON.toJSONString(statusResource.status()));
			LoggerHelper.debug(getClass(),"status sended! recieved->"+result);
		} catch (Exception e) {
			LoggerHelper.error(getClass(),"status send error["+e.toString()+"]");
		}
	}
	
}
