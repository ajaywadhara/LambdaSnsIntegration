package com.wadhara;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wadhara.model.Employee;
import com.wadhara.model.Response;
import lombok.extern.log4j.Log4j2;

import java.net.HttpURLConnection;
import java.util.Optional;

/**
 * Hello world!
 *
 */
@Log4j2
public class HelloWorldLambda implements RequestHandler<SNSEvent, Response>
{
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public Response handleRequest(SNSEvent event, Context context) {
        try{
            Optional<SNSEvent.SNSRecord> snsRecord = event.getRecords().stream().findAny();
            if(snsRecord.isPresent()){
                final SNSEvent.SNS sns = snsRecord.get().getSNS();
                final String jsonMessage = sns.getMessage();
                final Employee employee = gson.fromJson(jsonMessage, Employee.class);
                log.info("Employee Object:{}", employee.toString());
            }
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
