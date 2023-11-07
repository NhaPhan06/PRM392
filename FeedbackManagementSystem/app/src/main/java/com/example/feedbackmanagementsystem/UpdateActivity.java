package com.example.feedbackmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.feedbackmanagementsystem.models.Trainee;
import com.example.feedbackmanagementsystem.models.api.TraineeRepository;
import com.example.feedbackmanagementsystem.models.api.TraineeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    Trainee updateTrainee;
    EditText edtUpdateName, edtUpdatePhone, edtUpdateEmail, edtUpdateGender;
    Button btnUpdate;
    TraineeService traineeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        traineeService = TraineeRepository.getTraineeService();

        edtUpdateEmail = (EditText) findViewById(R.id.edtUpdateEmail);
        edtUpdateName = (EditText) findViewById(R.id.edtUpdateName);
        edtUpdatePhone = (EditText) findViewById(R.id.edtUpdatePhone);
        edtUpdateGender = (EditText) findViewById(R.id.edtUpdateGender);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        updateTrainee = (Trainee) getIntent().getSerializableExtra("UPDATE_TRAINEE");

        edtUpdateName.setText(updateTrainee.getName());
        edtUpdateGender.setText(updateTrainee.getGender());
        edtUpdatePhone.setText(updateTrainee.getPhone());
        edtUpdateEmail.setText(updateTrainee.getEmail());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTrainee();
            }
        });
    }

    private void updateTrainee() {
        String name = edtUpdateName.getText().toString();
        String email = edtUpdateEmail.getText().toString();
        String phone = edtUpdatePhone.getText().toString();
        String gender = edtUpdateGender.getText().toString();
        Trainee trainee = new Trainee(name, email, phone, gender);

        Call<Trainee> call = traineeService.updateTrainees(updateTrainee.getId(), trainee);
        call.enqueue(new Callback<Trainee>() {
            @Override
            public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                if(response.body() !=null) {
                    Toast.makeText(UpdateActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Trainee> call, Throwable t) {
                Log.d("UPDATE ERROR", t.toString());
            }
        });
    }
}