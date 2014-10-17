/**
 * AppFacade.java    2014年10月15日下午2:04:36
 */
package com.lyc.zpush.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.zpush.common.ResultDto;
import com.lyc.zpush.error.Error;
import com.lyc.zpush.service.AppService;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午2:04:36
 */
@Service
@Path("/server/app")
public class AppFacade {
	
	@Autowired
	private AppService appService;

	@POST
	@Path("/regAndroidApp")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto registerAndroidApp(@FormParam("appName") String appName){
		if(StringUtils.isBlank(appName)){
			ResultDto resultDto = new ResultDto(false, Error.APP_NAME_INVALIED);
			return resultDto;
		}
		return appService.registerAndroidApp(appName);
	}
	
	@POST
	@Path("/regIosApp")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto registerIosApp(@FormParam("appName") String appName){
		if(StringUtils.isBlank(appName)){
			ResultDto resultDto = new ResultDto(false, Error.APP_NAME_INVALIED);
			return resultDto;
		}
		return appService.registerIosApp(appName);
	}
}
