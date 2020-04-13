package com.ddc.projects.aerospike.utils;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class AeroSpikeTest {
    private Logger logger = Logger.getLogger(AeroSpikeTest.class);

    AerospikeClient as = new AerospikeClient("192.168.1.1",3000);

    WritePolicy writePolicy = new WritePolicy();

    Key key = new Key("test","myset","mykey");

    @Before
    public void before(){
        logger.error("this is the before method");
        writePolicy.setTimeout(50);
    }

    @Test
    public void ASWritingValue(){
        Bin bin = new Bin("myBin","myValue");
        Bin bin2 = new Bin("myBin2","myValue2");
        as.put(null,key,bin);
        as.put(null,key,bin2);
        logger.info(as.get(null,key));
    }

    @After
    public void after(){
        logger.error("this is the after method");
    }
}
