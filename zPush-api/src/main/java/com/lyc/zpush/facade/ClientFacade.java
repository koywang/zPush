/**
 * ClientFacade.java    2014年10月20日上午10:17:13
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
import com.lyc.zpush.service.ClientService;

/**
 * @author yuancen.li
 * @since 2014年10月20日  上午10:17:13
 */
@Service
@Path("/api/client")
public class ClientFacade {
	
	@Autowired
	private ClientService clientService;

	@POST
	@Path("/bindClient")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto bindClient(@FormParam("appId") String appId,
								@FormParam("devId") String devId){
		if(StringUtils.isBlank(appId)){
			return new ResultDto(false, Error.APP_ID_INVALIED);
		}
		if(StringUtils.isBlank(devId)){
			return new ResultDto(false, Error.DEV_ID_INVALID);
		}
		return clientService.bindClient(appId, devId);
	}
	
	@POST
	@Path("/setTag")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto setTag(@FormParam("appId") String appId,
							@FormParam("devId") String devId,
							@FormParam("tag") String tag,
							@FormParam("clientId") String clientId){
		if(StringUtils.isBlank(appId)){
			return new ResultDto(false, Error.APP_ID_INVALIED);
		}
		if(StringUtils.isBlank(devId)){
			return new ResultDto(false, Error.DEV_ID_INVALID);
		}
		if(StringUtils.isBlank(tag)){
			return new ResultDto(false, Error.TAG_NAME_INVALID);
		}
		if(StringUtils.isBlank(clientId)){
			return new ResultDto(false, Error.CLIENT_ID_INVALIED);
		}
		return clientService.setTag(appId, devId, tag, clientId);
	}
	
	@POST
	@Path("/getClientId")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto getClientId(@FormParam("appId") String appId,
							@FormParam("devId") String devId){
		if(StringUtils.isBlank(appId)){
			return new ResultDto(false, Error.APP_ID_INVALIED);
		}
		if(StringUtils.isBlank(devId)){
			return new ResultDto(false, Error.DEV_ID_INVALID);
		}
		return clientService.getClientId(appId, devId);
	}
	
	@POST
	@Path("/querySdkParams")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto querySdkParams(@FormParam("sdkId") String sdkId){
		if(StringUtils.isBlank(sdkId)){
			return new ResultDto(false, Error.APP_ID_INVALIED);
		}
		return clientService.querySdkParams(sdkId);
	}
	
}
