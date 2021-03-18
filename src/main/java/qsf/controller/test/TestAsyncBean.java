package qsf.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Qian Shaofeng
 * created on 2018/1/25.
 */
@RestController
@RequestMapping("test")
public class TestAsyncBean {

    @Autowired
    private TestAsyncService testAsyncService;

    @GetMapping(value = "/a")
    public void test() {
        Future<String> future = null;
        System.out.println("A 。。。");
        try {
            future = testAsyncService.sayHello1();

            System.out.println("又是A。。。");
//          Thread.sleep(3 * 1000);// 不让主进程过早结束
            System.out.println(future.get(10000, TimeUnit.MILLISECONDS));
        }
         catch (TimeoutException e) {
             System.out.println("A。。。获取时间超时");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("finish!");
    }
}
