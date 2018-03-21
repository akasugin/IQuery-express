package com.express.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExpressQueryController {
    @RequestMapping(value = "/expressQuery")
    public String expressQuery(@RequestBody String data) throws IOException {
        // 根据request创建Bot
        System.out.println(data);
        ExpressQueryBot bot = new ExpressQueryBot(data);

        // 打开签名验证
        // bot.enableVerify();

        // 线下调试时，可以关闭签名验证
        bot.disableVerify();

        try {
//            // 调用bot的run方法
            String responseJson = bot.run();
            return responseJson;
//            // 设置response的编码UTF-8
//            response.setCharacterEncoding("UTF-8");
//            // 返回response
//            response.getWriter().append(responseJson);
        } catch (Exception e) {
            return "{\"status\":1,\"msg\":\"\"}";
        }
    }
}
