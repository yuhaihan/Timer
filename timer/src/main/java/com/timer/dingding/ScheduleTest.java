package com.timer.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import com.timer.util.LunarUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 钉钉打卡定时器
 * @author: Gavin
 * @create: 2019-12-13 10:07
 * @Copyright: 2018~2019-12-13 10:07 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Component
@Lazy(false)
public class ScheduleTest {

    /**
     * 每个周一,周二,周三,周四,周五早晨8：25点触发
     */
    @Scheduled(cron = "0 25 8 ? * MON-FRI")
    private void WorkInMorning(){
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=7a19ab34adee4c1ad938964c383a2d2d973e089ba2eec636ec92a0f47dac4f5f");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("亲, 早晨上班记得打卡,请在8：30之前完成打卡。\r\n"+"\r\n"+LunarUtil.getTime());
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll("true");
        request.setAt(at);
        try {
            OapiRobotSendResponse response = client.execute(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 每个周一,周二,周三,周四,周五中午12点触发
     */
    @Scheduled(cron = "0 0 12 ? * MON-FRI")
    private void WorkAtNoon(){
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=7a19ab34adee4c1ad938964c383a2d2d973e089ba2eec636ec92a0f47dac4f5f");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("亲, 中午下班记得打卡, 请在12：10之前完成打卡");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll("true");
        request.setAt(at);
        try {
            OapiRobotSendResponse response = client.execute(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 每个周一,周二,周三,周四,周五中午12点触发
     */
    @Scheduled(cron = "0 25 13 ? * MON-FRI")
    private void WorkInAfternoon(){
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=7a19ab34adee4c1ad938964c383a2d2d973e089ba2eec636ec92a0f47dac4f5f");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("亲, 下午上班记得打卡, 请在13：30之前完成打卡。");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll("true");
        request.setAt(at);
        try {
            OapiRobotSendResponse response = client.execute(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 每个周一,周二,周三,周四,周五中午18点触发
     */
    @Scheduled(cron = "0 0 18 ? * MON-FRI")
    private void workAtNight(){
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=7a19ab34adee4c1ad938964c383a2d2d973e089ba2eec636ec92a0f47dac4f5f");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("亲, 晚上下班记得打卡");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll("true");
        request.setAt(at);
        try {
            OapiRobotSendResponse response = client.execute(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


}
