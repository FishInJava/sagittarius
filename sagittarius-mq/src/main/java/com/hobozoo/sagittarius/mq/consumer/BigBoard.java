package com.hobozoo.sagittarius.mq.consumer;

import com.hobozoo.sagittarius.mq.aop.Retry;

/**
 * @author hbz
 */
public class BigBoard implements Retry, Consumer{

    @Override
    public void onMessage(String topic, String tag, String key, String message) {
        //doSome business
    }

    @Override
    public Integer getRetryTime() {
        return 5;
    }

}
