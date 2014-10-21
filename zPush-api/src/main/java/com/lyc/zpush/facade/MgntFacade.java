/**
 * MgntFacade.java    2014年10月21日下午4:41:31
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
import com.lyc.zpush.service.MgntService;

/**
 * @author yuancen.li
 * @since 2014年10月21日  下午4:41:31
 */
@Service
@Path("/mgnt")
public class MgntFacade {
	
	@Autowired
	private MgntService mgntService;

	@POST
	@Path("/sdk/addSdk")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto addSdk(@FormParam("version") String version,
			                @FormParam("params") JSONObject params){
		if(StringUtils.isBlank(version)){
			return new ResultDto(false, Error.SDK_VERSIONE_INVALID);
		}
		return mgntService.addSdk(version, params);
	}
	
	@POST
	@Path("/sdk/updateParams")
	@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
	public ResultDto updateParams(@FormParam("sdkId") String sdkId,
								  @FormParam("params") JSONObject params){
		if(StringUtils.isBlank(sdkId)){
			return new ResultDto(false, Error.SDK_ID_INVALID);
		}
		if(params == null){
			return new ResultDto(false, Error.SDK_VERSIONE_INVALID);
		}
		return mgntService.updateParams(sdkId, params);
	}
}
