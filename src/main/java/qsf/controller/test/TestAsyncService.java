package qsf.controller.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Qian Shaofeng
 * created on 2018/1/25.
 */
@Service
public class TestAsyncService {
    @Async
    public Future<String> sayHello1() throws InterruptedException {
        int thinking = 5;
        Thread.sleep(thinking * 1000);//网络连接中 。。。消息发送中。。。
        System.out.println("B... 异步执行!");
        return new AsyncResult<String>("B...发送消息用了"+thinking+"秒");
    }
}
