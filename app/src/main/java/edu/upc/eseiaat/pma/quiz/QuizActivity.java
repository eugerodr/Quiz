package edu.upc.eseiaat.pma.quiz;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {

    private int ids_answers[] = {
        R.id.answer_1, R.id.answer_2, R.id.answer_3, R.id.answer_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView text_question = (TextView) findViewById(R.id.text_question);
        text_question.setText(R.string.question_content);

        String[] answers = getResources().getStringArray(R.array.answers);

        for (int i= 0; i<ids_answers.length; i++) {
            RadioButton rb = (RadioButton) findViewById(ids_answers[i]);
            rb.setText(answers[i]);
        }

        final int correct_answer = getResources().getInteger(R.integer.correct_answer);
        final RadioGroup group = (RadioGroup) findViewById(R.id.answer_group);

        Button btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int id = group.getCheckedRadioButtonId();
            int answer = -1;
            for (int i=0 ; i< ids_answers.length; i++) {
                if (ids_answers[i] == id) {
                    answer = i;
                }
            }
            if ( answer == correct_answer) {
                    Toast.makeText(QuizActivity.this,R.string.correct, Toast.LENGTH_SHORT).show();

            } else {
                    Toast.makeText(QuizActivity.this,R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
