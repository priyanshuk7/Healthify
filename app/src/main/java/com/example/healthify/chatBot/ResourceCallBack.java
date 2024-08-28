package com.example.healthify.chatBot;

public interface ResourceCallBack {
    void onResponse(String response);

    void onError(Throwable throwable);
}
