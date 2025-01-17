package com.example.prog7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtSpeak;
    Button btnSpeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSpeak = (EditText) findViewById(R.id.editText);
        btnSpeak = (Button) findViewById(R.id.btn_speak);
        btnSpeak.setOnClickListener(this);
        textToSpeech = new TextToSpeech(getBaseContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                    }
                });
        textToSpeech.setLanguage(Locale.UK);
    }

    public void onClick(View v) {
        String text = txtSpeak.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}