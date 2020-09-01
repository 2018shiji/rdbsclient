package com.module.dataaccesser.postgresql.trace;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;


public class KafkaLogAppender<E> extends AppenderBase<E> {
    //此处，logback.xml中的logger的name属性，输出到本地
    private static final Logger log = LoggerFactory.getLogger("local");
    private Producer<String, String> producer;
    protected Layout<E> layout;

    @Override
    public void start() {
        Assert.notNull(layout, "you don't set the layout of KafkaAppender");
        super.start();
//        this.producer = KafkaConfigUtils.createProducer();
    }

    @Override
    public void stop() {
        super.stop();
        producer.close();
        System.out.println("[Stopping KafkaAppender !!!");
    }

    @Override
    protected void append(E e) {
        String msg = layout.doLayout(e);
        //拼接消息内容
//        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>();
    }
}
