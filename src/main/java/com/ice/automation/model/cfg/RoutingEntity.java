//package com.ice.automation.model.cfg;
//
//import com.ice.automation.commons.router.Channel;
//
//import javax.persistence.*;
//
//@Entity  @Component
//@Table(name = "cfg_routing")
//public class RoutingEntity {
//
//    @Id
//    @Enumerated(EnumType.STRING)
//    private Channel channel;
//    @Column(name = "request_creator")
//    private String requestCreator;
//    @Column(name = "request_processor")
//    private String requestProcessor;
//    @Column(name = "request_router")
//    private String requestRouter;
//    @Column(name = "response_creator")
//    private String responseCreator;
//
//    public Channel getChannel() {
//        return channel;
//    }
//
//    public void setChannel(Channel channel) {
//        this.channel = channel;
//    }
//
//    public String getRequestCreator() {
//        return requestCreator;
//    }
//
//    public void setRequestCreator(String requestCreator) {
//        this.requestCreator = requestCreator;
//    }
//
//    public String getRequestProcessor() {
//        return requestProcessor;
//    }
//
//    public void setRequestProcessor(String requestProcessor) {
//        this.requestProcessor = requestProcessor;
//    }
//
//    public String getRequestRouter() {
//        return requestRouter;
//    }
//
//    public void setRequestRouter(String requestRouter) {
//        this.requestRouter = requestRouter;
//    }
//
//    public String getResponseCreator() {
//        return responseCreator;
//    }
//
//    public void setResponseCreator(String responseCreator) {
//        this.responseCreator = responseCreator;
//    }
//}
