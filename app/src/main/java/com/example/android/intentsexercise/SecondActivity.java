package com.example.android.intentsexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.intentsexercise.EXTRA_REPLY";
    TextView mHeader1ActivityTwoTextView;
    TextView mHeader2ActivityTwoTextView;
    TextView mReceivedMessageTextView;
    EditText mMessageReplyEditText;
    Button replyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mHeader1ActivityTwoTextView = findViewById(R.id.header1_activity2_textView);
        mHeader2ActivityTwoTextView = findViewById(R.id.header2_activity2_textView);
        mReceivedMessageTextView = findViewById(R.id.recieved_textView);
        mMessageReplyEditText = findViewById(R.id.reply_textView);
        replyButton = findViewById(R.id.reply_button);

        Intent receivedIntent = getIntent();
        String message = receivedIntent.getStringExtra(MainActivity.EXTRA_SEND);
        mReceivedMessageTextView.setText(message);
    }

    public void replyMessage(View view) {

        String reply = mMessageReplyEditText.getText().toString();
        Intent replyIntent = new Intent(SecondActivity.this, MainActivity.class);
        replyIntent.putExtra(EXTRA_REPLY, reply);

        setResult(RESULT_OK, replyIntent);
    }
}