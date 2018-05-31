package ir.sharif.nightowls;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import ir.sharif.nightowls.adapters.TeacherAdapter;
import ir.sharif.nightowls.models.Teacher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Alireza Ejlali", "Room:622", "Associate Professor ,  Comp.Architecture", "02166166621", R.mipmap.ejlali));
        teachers.add(new Teacher("Mahdieh Soleymani", "Room:821", "Assistant Professor ,  AI", "02166166654", R.mipmap.soleimani));
        teachers.add(new Teacher("Siavash Bayat-Sarmadi", "Room:621", "Assistant Professor ,  Comp.Architecture", "02166166614", R.mipmap.bayat));
        teachers.add(new Teacher("Rasool Jalili", "Room:806", "Associate Professor ,  IT", "02166166617", R.mipmap.jalili));
        teachers.add(new Teacher("Somayye Koohi", "Room:717", "Assistant Professor ,  Comp.Architecture", "02166166615", R.mipmap.koohi));
        teachers.add(new Teacher("Hamid Zarrabi-Zadeh", "Room:715", "Assistant Professor ,  Software", "02166166645", R.mipmap.zarrabi));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        TeacherAdapter adapter = new TeacherAdapter(this, teachers);
        recyclerView.setAdapter(adapter);

    }




}
