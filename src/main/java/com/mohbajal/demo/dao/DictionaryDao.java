package com.mohbajal.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DictionaryDao {

    private static final String ALL_UNIQUE_WORDS = "all-unique-words";

    @Autowired
    private StringRedisTemplate redisTemplate;


    public void addWordWithItsMeaningToDictionary(String word, String meaning) {
        //Long index = redisTemplate.opsForList().rightPush(word, meaning);
        redisTemplate.boundHashOps(ALL_UNIQUE_WORDS).put(word, meaning);
    }

    public Map<Object, Object> getAllTheMeaningsForAWord(String word) {
        Map<Object, Object> entries = redisTemplate.boundHashOps(ALL_UNIQUE_WORDS).entries();
        return entries;
    }
}