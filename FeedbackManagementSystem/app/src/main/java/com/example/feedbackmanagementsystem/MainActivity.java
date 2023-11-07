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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TraineeService traineeService;
    EditText edtName, edtEmail, edtPhone, edtGender;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = (EditText) findViewById(R.id.edtUpdateEmail);
        edtName = (EditText) findViewById(R.id.edtUpdateName);
        edtGender = (EditText) findViewById(R.id.edtUpdateGender);
        edtPhone = (EditText) findViewById(R.id.edtUpdatePhone);
        btnSave = (Button) findViewById(R.id.btnUpdate);
        btnSave.setOnClickListener(this);

        traineeService = TraineeRepository.getTraineeService();
    }

    @Override
    public void onClick(View view) {
        save();
    }

    private void save() {
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();
        String gender = edtGender.getText().toString();

        Trainee trainee = new Trainee(name, email, phone, gender);
        try {
            Call<Trainee> call = traineeService.createTrainees(trainee);
            call.enqueue(new Callback<Trainee>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if(response.body() != null){
                        Toast.makeText(MainActivity.this, "Save Successfully!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Save fail!", Toast.LENGTH_LONG).show();
                }
            });
        }catch(Exception e){
            Log.d("Error", e.getMessage());
        }
    }

}