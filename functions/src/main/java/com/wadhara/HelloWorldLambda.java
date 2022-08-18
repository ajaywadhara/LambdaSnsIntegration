package com.wadhara;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.wadhara.model.Response;
import lombok.extern.log4j.Log4j2;

import java.net.HttpURLConnection;

/**
 * Hello world!
 *
 */
@Log4j2
public class HelloWorldLambda implements RequestHandler<SNSEvent, Response>
{

    @Override
    public Response handleRequest(SNSEvent event, Context context) {
        try {
            //process SNS event
            event.getRecords()
                    .forEach(v -> log.info("Message received from SNS:{}",
                            v.getSNS().getMessage()));
            //message attributes
            //event.getRecords().forEach(v -> v.getSNS().getMessageAttributes());
            return Response.builder()
                    .httpCode(HttpURLConnection.HTTP_OK)
                    .message("OK.")
                    .build();
        } catch (Exception e){
            return Response.builder()
                    .httpCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
                    .message("Something went wrong.")
                    .build();
        }

    }
}
