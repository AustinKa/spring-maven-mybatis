package net.wanho.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2019/12/13.
 */
public class RedisTest {
    @Test
    public void jedis(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("sttttt","12");
        System.out.println(jedis.get("sttttt"));
        jedis.close();
    }
    @Test
    public void jediss(){
        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("aaaaaa","12");
        System.out.println(jedis.get("aaaaaa"));
        jedis.close();
        jedisPool.close();
    }
}
