/**
 * RandomUtil.java    2014年10月20日上午10:05:57
 */
package com.lyc.zpush.common;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author yuancen.li
 * @since 2014年10月20日  上午10:05:57
 */
public class RandomUtil {

	public static String getRandom(){
		byte[] bytes = new byte[128];
		ThreadLocalRandom.current().nextBytes(bytes);
		return DigestUtils.md5Hex(Base64.encodeBase64String(bytes));
	}
}
