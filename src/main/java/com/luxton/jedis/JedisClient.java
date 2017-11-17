package com.luxton.jedis;

public interface JedisClient {

	public String get(String key);
	public String set(String key,String value);
	String hget(String hkey,String key);
	Long hset(String hkey,String key,String value);
	long incr(String key);
	Long expire(String key,int second);
	long ttl(String key);
	long del(String key);
	long hdel(String hkey,String key);
}
