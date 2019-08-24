package com.yscyber.duer.core;

import com.baidu.dueros.bot.BaseBot;
import com.baidu.dueros.data.request.IntentRequest;
import com.baidu.dueros.data.request.LaunchRequest;
import com.baidu.dueros.data.request.SessionEndedRequest;
import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.Reprompt;
import com.baidu.dueros.data.response.card.TextCard;
import com.baidu.dueros.data.response.directive.display.RenderTemplate;
import com.baidu.dueros.data.response.directive.display.templates.BodyTemplate1;
import com.baidu.dueros.model.Response;
import com.yscyber.duer.constant.*;
import com.yscyber.duer.entity.DuerCommunication;
import com.yscyber.duer.service.SimpleRouteService;
import com.yscyber.duer.service.ViewSpotDescriptionService;
import com.yscyber.duer.service.impl.SimpleRouteServiceImpl;
import com.yscyber.duer.service.impl.ViewSpotDescriptionServiceImpl;
import com.yscyber.duer.util.SocketUtil;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 
 */
public class NchuBot extends BaseBot {

    private SimpleRouteService simpleRouteService = new SimpleRouteServiceImpl();
    private ViewSpotDescriptionService viewSpotDescriptionService = new ViewSpotDescriptionServiceImpl();
    private SocketUtil socketUtil = new SocketUtil();

    private static final String NONE = "NONE";

    public NchuBot(HttpServletRequest request) throws IOException {
        super(request);
    }

    @Override
    protected Response onLaunch(LaunchRequest launchRequest) {
        OutputSpeech outputSpeech = new OutputSpeech(OutputSpeech.SpeechType.PlainText, OtherEnum.OPEN_SPEECH.getLanguage());
        Reprompt reprompt = new Reprompt(outputSpeech);
        return new Response(outputSpeech, new TextCard("欢迎使用"), reprompt);
    }

    @Override
    protected Response onSessionEnded(SessionEndedRequest sessionEndedRequest) {
        OutputSpeech outputSpeech = new OutputSpeech(OutputSpeech.SpeechType.PlainText, OtherEnum.CLOSE_SPEECH.getLanguage());
        return new Response(outputSpeech, new TextCard("感谢使用"));
    }

    /**
     * onIntent 底层可能是在不断循环执行该方法.
     *
     * @param intentRequest 请求体
     * @return 响应
     */
    @Override
    protected Response onInent(IntentRequest intentRequest) {
        if (IntentEnum.SIMPLE_NAVIGATION.getIntent().equals(intentRequest.getIntentName())) {
            if (getSlot(SlotEnum.SIMPLE_NAVIGATION_START_POINT.getSlot()) == null) {
                ask(SlotEnum.SIMPLE_NAVIGATION_START_POINT.getSlot());
                OutputSpeech outputSpeech = new OutputSpeech(OutputSpeech.SpeechType.PlainText, SimpleRouteBroadcastEnum.ASK_START_POINT.getTip());
                Reprompt reprompt = new Reprompt(outputSpeech);
                return new Response(outputSpeech, new TextCard(SimpleRouteBroadcastEnum.ASK_START_POINT.getTip()), reprompt);
            } else if (getSlot(SlotEnum.SIMPLE_NAVIGATION_END_POINT.getSlot()) == null) {
                ask(SlotEnum.SIMPLE_NAVIGATION_END_POINT.getSlot());
                OutputSpeech outputSpeech = new OutputSpeech(OutputSpeech.SpeechType.PlainText, SimpleRouteBroadcastEnum.ASK_END_POINT.getTip());
                Reprompt reprompt = new Reprompt(outputSpeech);
                return new Response(outputSpeech, new TextCard(SimpleRouteBroadcastEnum.ASK_END_POINT.getTip()), reprompt);
            } else {
                DuerCommunication duerCommunication = simpleRouteService.broadcastSimpleRoute(getSlot(SlotEnum.SIMPLE_NAVIGATION_START_POINT.getSlot()), getSlot(SlotEnum.SIMPLE_NAVIGATION_END_POINT.getSlot()));
                OutputSpeech outputSpeech = new OutputSpeech(OutputSpeech.SpeechType.PlainText, duerCommunication.getBroadcast() + OtherEnum.CONTINUE_SPEECH.getLanguage());
                if (!NONE.equals(duerCommunication.getKey())) {
                    // 发送码
                    socketUtil.connection();
                    socketUtil.sendMessage(duerCommunication.getKey());
                    socketUtil.disConnection();
                }
                return new Response(outputSpeech, new TextCard(duerCommunication.getBroadcast()));
            }
        } else if (IntentEnum.VIEWSPOT_DESCRIPTION.getIntent().equals(intentRequest.getIntentName())) {
            if (getSlot(SlotEnum.VIEWSPOT_DESCRIPTION_VIEW_SPOT.getSlot()) == null) {
                ask(SlotEnum.VIEWSPOT_DESCRIPTION_VIEW_SPOT.getSlot());
                OutputSpeech outputSpeech = new OutputSpeech(OutputSpeech.SpeechType.PlainText, ViewspotDescriptionBroadcastEnum.ASK_VIEW_SPOT.getTip());
                Reprompt reprompt = new Reprompt(outputSpeech);
                return new Response(outputSpeech, new TextCard(ViewspotDescriptionBroadcastEnum.ASK_VIEW_SPOT.getTip()), reprompt);
            } else {
                if (getSlot(SlotEnum.VIEWSPOT_DESCRIPTION_VIEW_SPOT.getSlot()) == null) {
                    ask(SlotEnum.VIEWSPOT_DESCRIPTION_VIEW_SPOT.getSlot());
                    OutputSpeech outputSpeech = new OutputSpeech(OutputSpeech.SpeechType.PlainText, ViewspotDescriptionBroadcastEnum.ASK_VIEW_SPOT.getTip());
                    Reprompt reprompt = new Reprompt(outputSpeech);
                    return new Response(outputSpeech, new TextCard(ViewspotDescriptionBroadcastEnum.ASK_VIEW_SPOT.getTip()), reprompt);
                } else {
                    DuerCommunication duerCommunication = viewSpotDescriptionService.broadcastViewSpotDescription(getSlot(SlotEnum.VIEWSPOT_DESCRIPTION_VIEW_SPOT.getSlot()));
                    OutputSpeech outputSpeech = new OutputSpeech(OutputSpeech.SpeechType.PlainText, duerCommunication.getBroadcast());
                    socketUtil.connection();
                    socketUtil.sendMessage(duerCommunication.getKey());
                    socketUtil.disConnection();
                    return new Response(outputSpeech, new TextCard(duerCommunication.getBroadcast()));
                }
            }
        }
        return null;
    }

}
