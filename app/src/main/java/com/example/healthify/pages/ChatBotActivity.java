package com.example.healthify.pages;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.healthify.R;
import com.example.healthify.chatBot.GeminiResp;
import com.example.healthify.chatBot.ResourceCallBack;
import com.google.ai.client.generativeai.java.ChatFutures;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class ChatBotActivity extends AppCompatActivity {

    ImageView sendQuery,logo, appIcon;
    private TextInputEditText queryEditText;
    FloatingActionButton btnShowDia;
    private ProgressBar progressBar;
    private LinearLayout chatResponse;
    private ChatFutures chatModel;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat_bot);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.message_dialog);

        if(dialog.getWindow()!=null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(false);
        }

        sendQuery = dialog.findViewById(R.id.sendMessage);
        queryEditText = dialog.findViewById(R.id.queryEditText);
        btnShowDia = findViewById(R.id.showMsg);
        progressBar = findViewById(R.id.progressBar);
        chatResponse = findViewById(R.id.chatBotLinerLayout);
        appIcon = findViewById(R.id.appIcon);

        chatModel= getChatModel();

        btnShowDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        sendQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                progressBar.setVisibility(View.VISIBLE);
                appIcon.setVisibility(View.GONE);
                String query= queryEditText.getText().toString();

                queryEditText.setText("");

                chatBody("You", query);

                GeminiResp.getResponse(chatModel, query, new ResourceCallBack() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);
                        chatBody("AI",response);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        progressBar.setVisibility(View.GONE);
                        chatBody("AI", "Please try again.");
                    }
                });
            }
        });

    }

    private ChatFutures getChatModel(){

        GeminiResp model= new GeminiResp();
        GenerativeModelFutures modelFutures=model.getModel();

        return modelFutures.startChat();
    }

    private void chatBody(String username, String query) {
        LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.chat_msg,null);

        TextView name =view.findViewById(R.id.name_bot);
        TextView message =view.findViewById(R.id.agentMessage);
//        ImageView imageView = findViewById(R.id.icon);

        name.setText(username);
        message.setText(query);
//        imageView.setImageResource(R.drawable.robot);

        chatResponse.addView(view);

        ScrollView scrollView = findViewById(R.id.scrollView2);
        scrollView.post(()-> scrollView.fullScroll(View.FOCUS_DOWN));

    }
}