package com.hw1.covidmetrics.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.hw1.covidmetrics.model.Cache;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CovidMetricsCacheTest {
    
    private Cache cache;

    @BeforeEach
    void setUp() {
        this.cache = new Cache(5); // ttl = 5 secs
    }

    @AfterEach
    void tearDown() {
        this.cache.clean();
    }

    @Test
    void addEntryTest() {
        this.cache.addEntry("Portugal", 10000000);
        
        assertEquals(10000000, this.cache.getEntry("Portugal"));
        assertEquals(1, this.cache.size());
    }

    @Test
    void clearEntryTest() {
        this.cache.addEntry("Portugal", 10000000);
        this.cache.addEntry("Romania", 8000000);
        assertEquals(2, this.cache.size());

        this.cache.clearEntry("Romania");
        assertEquals(1, this.cache.size());
        assertFalse(this.cache.clearEntry("Romania"));

        this.cache.clearEntry("Portugal");
        assertEquals(0, this.cache.size());
    }

    @Test
    void getEntryTest() {
        this.cache.addEntry("Portugal", 10000000);
        // First request
        this.cache.getEntry("Portugal");
        assertEquals(1, this.cache.getRequests()); // 1 request
        assertEquals(1, this.cache.getHits()); // 1 hit
        assertEquals(0, this.cache.getMisses()); // 0 misses
        
        // Second request
        assertEquals(null, this.cache.getEntry("Romania"));
        assertEquals(2, this.cache.getRequests()); // 2 requests
        assertEquals(1, this.cache.getHits()); // 1 hit
        assertEquals(1, this.cache.getMisses()); // 1 miss
    }

    @Test
    void ttlTest() throws InterruptedException {
        this.cache.addEntry("Portugal", 10000000);
        this.cache.addEntry("Romania", 8000000);
        assertEquals(2, cache.size());

        try {
            Thread.sleep(6000); // remember cache has ttl = 5 secs so, giving a sleep of 6 secs will delete all entries in the next access
            assertEquals(null, this.cache.getEntry("Portugal"));
            assertEquals(null, this.cache.getEntry("Romania"));
            assertEquals(0, cache.size());
        } catch (InterruptedException e) {
            System.out.println("Interruption detected");
        }
        
    }
}
