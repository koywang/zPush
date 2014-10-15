/**
 * PushFacade.java    2014年10月15日下午2:04:44
 */
package com.lyc.zpush.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.zpush.common.ResultDto;
import com.lyc.zpush.service.PushService;

/**
 * @author yuancen.li
 * @since 2014年10月15日  下午2:04:44
 */
@Service
@Path("/api/push")
public class PushFacade {

	@Autowired
	private PushService pushService;
	
	@POST
	@Path("/pushToSingle")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto pushToSingle(@FormParam("appId") String appId,
								  @FormParam("appKey") String appKey,
								  @FormParam("clientId") String clientId,
								  @FormParam("content") String content){
		
		return null;
	}
	
	@POST
	@Path("/pushToApp")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto pushToApp(@FormParam("appId") String appId,
							   @FormParam("appKey") String appKey,
							   @FormParam("content") String content){
		
		return null;
	}
	
	@POST
	@Path("/pushToTag")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto pushToTag(@FormParam("appId") String appId,
							   @FormParam("appKey") String appKey,
							   @FormParam("tag") String tag,
							   @FormParam("content") String content){
		
		return null;
	}
	
	
}
