package com.hkjava.demo.demofinnhub.infra;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.ResourceAccessException;

import com.hkjava.demo.demofinnhub.exception.FinnhubException;

public class RedisHelper<T> {

  // key value pair, keymust be unqiue, most likely String

  private RedisTemplate<String, T> redisTemplate;

  public RedisHelper(RedisTemplate<String, T> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public boolean set(String key, T value) {
    try {
      redisTemplate.opsForValue().set(key, value);
      return true;
    } catch (Exception e) {
      throw new ResourceAccessException("Redis unavailable.");
    }
  }

  public boolean set(String key, T value, long time) {
    try {
      redisTemplate.opsForValue().set(key, value, time);
      return true;
    } catch (Exception e) {
      throw new ResourceAccessException("Redis unavailable.");
    }
  }

  public Object get(String key) {
    try {
      if (key != null) {
        return redisTemplate.opsForValue().get(key);
      }
      return null;
    } catch (Exception e) {
      throw new ResourceAccessException("Redis unavailable");
    }
  }

  public boolean expire(String key, long time) {
    try {
      if (time > 0) {
        redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
        return true;
      }
    } catch (Exception e) {
      throw new ResourceAccessException("Redis unavailable");
    }
    return false;
  }
}
