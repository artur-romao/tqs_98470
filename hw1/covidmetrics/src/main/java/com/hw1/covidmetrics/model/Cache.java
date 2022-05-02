package com.hw1.covidmetrics.model;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    private Map <String, Object> cache = new HashMap<>();

    private int requests = 0;
    private int hits = 0;
    private int misses = 0;

    private Map <String, Long> timeToLive = new HashMap<>();
    private long maxTTL;

    public Cache() {
        this.maxTTL = 60 * 1000; // 60 seconds of max cache time seemed reasonable
    }

    public Cache(long maxTTL) {
        this.maxTTL = maxTTL * 1000; // cache with defined max ttl
    }

    public void addEntry(String key, Object content) {
        this.cache.put(key, content);
        this.timeToLive.put(key, System.currentTimeMillis() + maxTTL);
    }

    public boolean clearEntry(String key) { // boolean method so we can log if entry was successfully removed or not
        if (cache.keySet().contains(key)) {
            this.cache.remove(key);
            this.timeToLive.remove(key);
            return true;
        }
        return false;
    }

    public Object getEntry(String key) {
        this.requests++;

        if (cache.keySet().contains(key) && timeToLive.get(key) > System.currentTimeMillis()) { // if ttl is still valid
            this.hits++;
            return cache.get(key);
        }
        else if (cache.keySet().contains(key) && timeToLive.get(key) <= System.currentTimeMillis()) { // if ttl expired
            this.clearEntry(key);
        }
        this.misses++;
        return null;
    }

    public void clean() {
        this.cache.clear();
        this.timeToLive.clear();
    }

    public int size() {
        return this.cache.size();
    }

    public Map<String,Object> getCache() {
        return this.cache;
    }

    public void setCache(Map<String,Object> cache) {
        this.cache = cache;
    }

    public int getRequests() {
        return this.requests;
    }

    public void setRequests(int requests) {
        this.requests = requests;
    }

    public int getHits() {
        return this.hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getMisses() {
        return this.misses;
    }

    public void setMisses(int misses) {
        this.misses = misses;
    }

    public Map<String,Long> getTimeToLive() {
        return this.timeToLive;
    }

    public void setTimeToLive(Map<String,Long> timeToLive) {
        this.timeToLive = timeToLive;
    }

    public long getMaxTTL() {
        return this.maxTTL;
    }

    public void setMaxTTL(long maxTTL) {
        this.maxTTL = maxTTL;
    }


    @Override
    public String toString() {
        return "{" +
            " cache='" + getCache() + "'" +
            ", requests='" + getRequests() + "'" +
            ", hits='" + getHits() + "'" +
            ", misses='" + getMisses() + "'" +
            ", timeToLive='" + getTimeToLive() + "'" +
            ", maxTTL='" + getMaxTTL() + "'" +
            "}";
    }

}
