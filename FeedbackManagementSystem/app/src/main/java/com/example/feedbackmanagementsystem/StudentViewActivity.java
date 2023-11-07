package com.example.feedbackmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.feedbackmanagementsystem.adapters.ListTraineeAdapter;
import com.example.feedbackmanagementsystem.models.Trainee;
import com.example.feedbackmanagementsystem.models.api.TraineeRepository;
import com.example.feedbackmanagementsystem.models.api.TraineeService;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentViewActivity extends AppCompatActivity {
    ArrayList<Trainee> listTrainees;
    TraineeService traineeService;
    ListView lvTrainee;
    ListTraineeAdapter listTraineeAdapter;
    Trainee updateTrainee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);
        listTrainees = new ArrayList<Trainee>();
        traineeService = TraineeRepository.getTraineeService();
        lvTrainee = (ListView) findViewById(R.id.lvTrainee);
        listTraineeAdapter = new ListTraineeAdapter(listTrainees);

        lvTrainee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Trainee trainee = (Trainee) listTraineeAdapter.getItem(position);
                Toast.makeText(StudentViewActivity.this, "Selected " + trainee.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        lvTrainee.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                updateTrainee = (Trainee) listTraineeAdapter.getItem(position);
//                Toast.makeText(StudentViewActivity.this, "Selected long press" + updateTrainee.getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        getTrainee();

        registerForContextMenu(lvTrainee);
    }

    private void getTrainee() {
        Call<Trainee[]> call = traineeService.getAllTrainees();
        call.enqueue(new Callback<Trainee[]>() {
            @Override
            public void onResponse(Call<Trainee[]> call, Response<Trainee[]> response) {
                Trainee[] trainees = response.body();

                if (trainees == null) {
                    return;
                }

                Arrays.stream(trainees).forEach(trainee -> {
                    listTrainees.add(trainee);
                });

//                Log.d("Trainee ids", listTrainees.toString());

                lvTrainee.setAdapter(listTraineeAdapter);
            }

            @Override
            public void onFailure(Call<Trainee[]> call, Throwable t) {
                Log.d("Error", t.toString());
            }
        });
    }

    private void deleteTrainee() {
        Call<Trainee> call = traineeService.deleteTrainees(updateTrainee.getId());
        call.enqueue(new Callback<Trainee>() {
            @Override
            public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                if(response.body() != null){
                    Toast.makeText(StudentViewActivity.this, "Delete successfully!", Toast.LENGTH_SHORT).show();
                    listTrainees.clear();
                    getTrainee();
                }
            }

            @Override
            public void onFailure(Call<Trainee> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trainee_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_add:
                Intent intent = new Intent(StudentViewActivity.this, MainActivity.class);
                startActivity(intent);
//                Toast.makeText(this, "Add selected", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.lvTrainee) {
            getMenuInflater().inflate(R.menu.trainee_actions, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuUpdate:
                Intent intent = new Intent(StudentViewActivity.this, UpdateActivity.class);
                intent.putExtra("UPDATE_TRAINEE", updateTrainee);
//                Toast.makeText(this, "Update selected trainee: " + updateTrainee.getName(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.menuDelete:
                deleteTrainee();
//                Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listTrainees.clear();
        getTrainee();
//        Log.d("ON RESUME", "View Trainee");
    }

}