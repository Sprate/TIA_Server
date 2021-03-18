package qsf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import qsf.entity.UserTouch;
import qsf.service.IUserClassifierService;
import qsf.service.IUserTouchService;
import qsf.service.impl.UserClassifierService;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@RestController
@RequestMapping("/usertouch")
public class UserTouchController {

    @Autowired
    private IUserTouchService userTouchService;

    @Autowired
    private IUserClassifierService userClassifierService;

    private ConcurrentLinkedDeque<DeferredResult<String>> deferredResults =
            new ConcurrentLinkedDeque<DeferredResult<String>>();


    private IUserClassifierService classifierService = new UserClassifierService();

    @PostMapping(value = "/insert")
    @ResponseBody
    public DeferredResult<String> scoreUserTouchs(@RequestBody List<UserTouch> userTouchs){

        System.out.println("running ...");
        DeferredResult<String> stringDeferredResult = new DeferredResult<String>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());

                int userScore = userClassifierService.computeUserTouchsScore(userTouchs);

                String result = userScore==-1? "untraining": userScore==0?"fail": "success";
//                for (UserTouch userTouch: userTouchs)
//                    userTouchService.insert(userTouch);
                stringDeferredResult.setResult(result);

            }
        });

        //setResult完毕之后，调用该方法
        stringDeferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步调用完成");
                //响应完毕之后，将请求从队列中去除掉
                deferredResults.remove(stringDeferredResult);
            }
        });

        stringDeferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                System.out.println("业务处理超时");
                stringDeferredResult.setResult("error:timeOut");
            }
        });


        return stringDeferredResult;
    }


    @PostMapping(value = "/test")
    @ResponseBody
    @Async
    public Future<String> test(@RequestBody List<UserTouch> userTouchs){
        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());
        int userScore = userClassifierService.computeUserTouchsScore(userTouchs);

        String result = userScore==-1? "untraining": userScore==0?"fail": "success";
//        for (UserTouch userTouch: userTouchs)
//            userTouchService.insert(userTouch);
        System.out.println("result: "+result);
//        try {
//            Thread.sleep(1*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return new AsyncResult<>(result);
    }

    @PostMapping(value = "/common")
    @ResponseBody
    public String test2(@RequestBody List<UserTouch> userTouchs){
        //for (UserTouch userTouch: userTouchs)
           // userTouchService.insert(userTouch);

        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());

        int userScore = userClassifierService.computeUserTouchsScore(userTouchs);

        String result = userScore==-1? "untraining": userScore==0?"fail": "success";

        System.out.println("result: "+result);


        return result;
    }
    @PostMapping(value = "/insertdata")
    @ResponseBody
    public String test3(@RequestBody List<UserTouch> userTouchs)
    {
        for (UserTouch userTouch: userTouchs)
        userTouchService.insert(userTouch);
        String result="insert sucess!";
        return result;
    }



}
