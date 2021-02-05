package com.example.android.intentsexercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_SEND = "com.example.android.intentsexercise.EXTRA_SEND" ;
    private static final int REQUEST_ONE = 10;
    private static final int REQUEST_TWO = 20;
    TextView mHeader1ActivityOneTextView;
    TextView mHeader2ActivityOneTextView;
    TextView mRepliedMessageTextView;
    EditText mMessageSentEditText;
    Button sendButton1;
    Button sendButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeader1ActivityOneTextView = findViewById(R.id.header1_activity1_textView);
        mHeader2ActivityOneTextView = findViewById(R.id.header2_activity1_textView);
        mRepliedMessageTextView = findViewById(R.id.recieved_textView);
        mMessageSentEditText = findViewById(R.id.reply_textView);
        sendButton1 = findViewById(R.id.send_button1);
        sendButton2 = findViewById(R.id.send_button2);
    }

    public void sendMessage1(View view) {

        String message = mMessageSentEditText.getText().toString();
        Intent intentSend = new Intent(MainActivity.this, SecondActivity.class);
        intentSend.putExtra(EXTRA_SEND, message);

        startActivityForResult(intentSend, REQUEST_ONE);
    }

    public void sendMessage2(View view) {

        String message = mMessageSentEditText.getText().toString();
        Intent intentSend = new Intent(MainActivity.this, SecondActivity.class);
        intentSend.putExtra(EXTRA_SEND, message);

        startActivityForResult(intentSend, REQUEST_TWO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ONE ) {
            if (resultCode == RESULT_OK) {
                mHeader1ActivityOneTextView.setVisibility(View.VISIBLE);
                mHeader2ActivityOneTextView.setVisibility(View.VISIBLE);
                assert data != null;
                String reply1 = "REQUEST no: " + REQUEST_ONE + ", " + data.getStringExtra(SecondActivity.EXTRA_REPLY).toString();
                mRepliedMessageTextView.setText(reply1);
                mMessageSentEditText.setText("");
            }
        } else if (requestCode == REQUEST_TWO) {
            if (resultCode == RESULT_OK) {
                mHeader1ActivityOneTextView.setVisibility(View.VISIBLE);
                mHeader2ActivityOneTextView.setVisibility(View.VISIBLE);
                assert data != null;
                String reply2 = "REQUEST no: " + REQUEST_TWO + ", " + data.getStringExtra(SecondActivity.EXTRA_REPLY).toString();
                mRepliedMessageTextView.setText(reply2);
                mMessageSentEditText.setText("");
            }
        }
    }
}