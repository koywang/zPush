/**
 * PushFacade.java    2014年10月15日下午2:04:44
 */
package com.lyc.zpush.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.zpush.common.ResultDto;
import com.lyc.zpush.error.Error;
import com.lyc.zpush.service.PushService;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午2:04:44
 */
@Service
@Path("/server/push")
public class PushFacade {

	@Autowired
	private PushService pushService;
	
	@POST
	@Path("/pushToSingle")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto pushToSingle(@FormParam("appId") String appId,
								  @FormParam("appKey") String appKey,
								  @FormParam("clientId") String clientId,
								  @FormParam("content") String content,
								  @FormParam("params") JSONObject params,
								  @FormParam("timeout") long timeout){
		if(StringUtils.isBlank(appId)){
			return new ResultDto(false, Error.APP_ID_INVALIED);
		}
		if(StringUtils.isBlank(appKey)){
			return new ResultDto(false, Error.APP_KEY_INVALIED);
		}
		if(StringUtils.isBlank(clientId)){
			return new ResultDto(false, Error.CLIENT_ID_INVALIED);
		}
		if(StringUtils.isBlank(content)){
			return new ResultDto(false, Error.CONTENT_NULL);
		}
		return pushService.pushToSingle(appId, appKey, clientId, content, params, timeout);
	}
	
	@POST
	@Path("/pushToApp")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto pushToApp(@FormParam("appId") String appId,
							   @FormParam("appKey") String appKey,
							   @FormParam("content") String content,
							   @FormParam("timeout") long timeout,
							   @FormParam("params") JSONObject params){
		if(StringUtils.isBlank(appId)){
			return new ResultDto(false, Error.APP_ID_INVALIED);
		}
		if(StringUtils.isBlank(appKey)){
			return new ResultDto(false, Error.APP_KEY_INVALIED);
		}
		if(StringUtils.isBlank(content)){
			return new ResultDto(false, Error.CONTENT_NULL);
		}
		return pushService.pushToApp(appId, appKey, content, params, timeout);
	}
	
	@POST
	@Path("/pushToTag")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto pushToTag(@FormParam("appId") String appId,
							   @FormParam("appKey") String appKey,
							   @FormParam("tag") String tag,
							   @FormParam("content") String content,
							   @FormParam("timeout") long timeout,
							   @FormParam("params") JSONObject params){
		if(StringUtils.isBlank(appId)){
			return new ResultDto(false, Error.APP_ID_INVALIED);
		}
		if(StringUtils.isBlank(appKey)){
			return new ResultDto(false, Error.APP_KEY_INVALIED);
		}
		if(StringUtils.isBlank(tag)){
			return new ResultDto(false, Error.TAG_NAME_INVALID);
		}
		if(StringUtils.isBlank(content)){
			return new ResultDto(false, Error.CONTENT_NULL);
		}
		return pushService.pushToTag(appId, appKey, tag, content, params, timeout);
	}
	
	
}
