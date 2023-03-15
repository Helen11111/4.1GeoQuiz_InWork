package com.example.geoquiz_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtView, txtAnswer, txtTimer, txtPoints;
    Button btn1, btn2, btn3, btn4;
    ImageView imgView;
    ImageButton imgBtnLeft, imgBtnRight;
    private int currentIndex = 0;
    int points;
    CountDownTimer countDownTimer;
    long millisUntilFinished;


    private Question[]  questionsBank = {
            new Question(R.string.quest1, R.drawable.img1),
            new Question(R.string.quest2, R.drawable.img2),
            new Question(R.string.quest3, R.drawable.img3),
            new Question(R.string.quest4, R.drawable.img4),
            new Question(R.string.quest5, R.drawable.img5)
    };

    private Answer[] answerBank = {
            new Answer(R.string.text_btn1, R.string.text_btn2,
                    R.string.text_btn3,R.string.text_btn4,
                    R.string.correct_toast, R.string.incorrect_toast,
                    R.string.incorrect_toast, R.string.incorrect_toast),
            new Answer(R.string.text_btn5, R.string.text_btn6,
                    R.string.text_btn7,R.string.text_btn8,
                    R.string.incorrect_toast, R.string.incorrect_toast,
                    R.string.incorrect_toast, R.string.correct_toast),
            new Answer(R.string.text_btn9, R.string.text_btn10,
                    R.string.text_btn11,R.string.text_btn12,
                    R.string.incorrect_toast, R.string.incorrect_toast,
                    R.string.incorrect_toast, R.string.correct_toast),
            new Answer(R.string.text_btn13, R.string.text_btn14,
                    R.string.text_btn15,R.string.text_btn16,
                    R.string.correct_toast, R.string.incorrect_toast,
                    R.string.incorrect_toast, R.string.incorrect_toast),
            new Answer(R.string.text_btn17, R.string.text_btn18,
                    R.string.text_btn19,R.string.text_btn20,
                    R.string.correct_toast, R.string.incorrect_toast,
                    R.string.incorrect_toast, R.string.incorrect_toast),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_quiz);

        txtView = findViewById(R.id.txt_1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        imgView = findViewById(R.id.iv_1);
        imgBtnLeft = findViewById(R.id.nextLeft_btn);
        imgBtnRight = findViewById(R.id.nextRight_btn);
        txtAnswer = findViewById(R.id.txt_answer);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        imgBtnLeft.setOnClickListener(this);
        imgBtnRight.setOnClickListener(this);

        points = 0;
        millisUntilFinished = 60000;

        startQuiz();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn1:
               int answer = answerBank[currentIndex].txtBtn1;
               txtAnswer.setText(answer);
               if(answer == R.string.correct_toast){
                   points++;
               }
               break;

            case R.id.btn2:
                int answer2 = answerBank[currentIndex].txtBtn2;
                txtAnswer.setText(answer2);
                if(answer2 == R.string.correct_toast){
                    points++;
                }
                break;

            case R.id.btn3:
                int answer3 = answerBank[currentIndex].txtBtn3;
                txtAnswer.setText(answer3);
                if(answer3== R.string.correct_toast){
                    points++;
                }
                break;

            case R.id.btn4:
                int answer4 = answerBank[currentIndex].txtBtn4;
                txtAnswer.setText(answer4);
                if(answer4 == R.string.correct_toast){
                    points++;
                }
                break;

            case R.id.nextLeft_btn:
                currentIndex = Math.abs(currentIndex - 1) % questionsBank.length;
                updateQuestion();
                updateAnswer();
                txtAnswer.setText("");
                break;
            case R.id.nextRight_btn:
                currentIndex = (currentIndex + 1) % questionsBank.length;
                updateQuestion();
                updateAnswer();
                txtAnswer.setText("");
                break;
        }

        txtPoints.setText("" + points);
    }

    private void updateQuestion() {

    }

    private void updateAnswer() {

    }

    private void startQuiz() {

    }


}