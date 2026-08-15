package com.company.ucell_service.handler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class LogSendHandler extends StreamHandler {
    @Override
    public synchronized void publish(LogRecord record) {

        try {
            String bodyMessage = """
                    {
                    "chat_id":"%s",
                    "text":"%s",
                    }
                    """.formatted(Secrets.chatId,getFormatter().format(record));
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(bodyMessage))
                    .uri(URI.create(Secrets.sendMessage))
                    .header("Content-Type","application/json")
                    .build();
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean isLoggable(LogRecord record) {
        super.isLoggable(record);
        return false;
    }
}
