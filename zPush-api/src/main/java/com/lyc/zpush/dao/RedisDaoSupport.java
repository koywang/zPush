/**
 * RedisDao.java    2014年10月15日下午4:27:58
 */
package com.lyc.zpush.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.alibaba.fastjson.JSON;


/**
 * @author yuancen.li
 * @since 2014年10月15日  下午4:27:58
 */
@Component
public class RedisDaoSupport<T> {
	
	private static Logger logger = LoggerFactory.getLogger(RedisDaoSupport.class);
	
	/*
	 * usage: store increment id
	 * datastruct: hash
	 * spec: key:counter,field:appId,value:$counter
	 */
	public static final String KEY_COUNTER = "counter";
	public static final String FIELD_APPID = "appId";
	
	/*
	 * usage: store app
	 * datastruct: hash
	 * spec: key:app,field:$appid,value:$appBean
	 */
	public static final String KEY_APP = "app";
	
	/**
	 * usage : store message
	 * datastruct: hash
	 * spec : key:msg,field:$uuid,value:$messageBean
	 */
	public static final String KEY_MESSAGE = "msg";


	@Autowired
	private ShardedJedisPool shardedJedisPool;
	
	public String serialize(T t){
		if(t == null){
			return "";
		}
		return JSON.toJSONString(t);
	}
	
	public T deserialize(String str, Class<T> clazz){
		if(StringUtils.isBlank(str)){
			return null;
		}
		return JSON.parseObject(str,clazz);
	}
	
	public void set(String key,String value){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			shardedJedis.set(key, value);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
	}
	
	public String get(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.get(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return "";
	}
	
	public long del(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.del(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public boolean exists(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.exists(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return false;
	}
	
	public long expireAt(String key, long unixTime){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.expireAt(key, unixTime);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public long ttl(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.ttl(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public long incr(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.incr(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public long lpush(String key, String... value){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.lpush(key, value);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public long rpush(String key, String... value){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.rpush(key, value);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public String lpop(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.lpop(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return "";
	}
	
	public String rpop(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.rpop(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return "";
	}
	
	public String lset(String key, long index, String value){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.lset(key, index, value);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return "";
	}
	
	public String lindex(String key, long index){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.lindex(key, index);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return "";
	}
	
	public long llen(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.llen(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public long hset(String key, String field, String value){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hset(key, field, value);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	
	public boolean hexists(String key, String field){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hexists(key, field);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return false;
	}
	
	public String hget(String key, String field){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hget(key, field);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return "";
	}
	
	public long hdel(String key, String field){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hdel(key, field);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public Set<String> hkeys(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hkeys(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return Collections.emptySet();
	}
	
	public List<String> hvals(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hvals(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return Collections.emptyList();
	}
	
	public Map<String, String> hgetAll(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hgetAll(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return Collections.emptyMap();
	}
	
	public long hincrBy(String key, String field, long value){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hincrBy(key, field, value);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public long hsetnx(String key, String field, String value){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.hsetnx(key, field, value);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public long sadd(String key, String... member){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.sadd(key, member);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public long srem(String key, String... member){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.srem(key, member);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public Set<String> smembers(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.smembers(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return Collections.emptySet();
	}
	
	public boolean sismember(String key, String member){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.sismember(key, member);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return false;
	}
	
	public long scard(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.scard(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return 0l;
	}
	
	public String spop(String key){
		ShardedJedis shardedJedis = null;
		try{			
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.spop(key);
		} 
		catch(Exception e){
			shardedJedisPool.returnBrokenResource(shardedJedis);
			logger.error(e.getMessage());
		}
		finally{
			shardedJedisPool.returnResource(shardedJedis);
		}
		return "";
	}
}
