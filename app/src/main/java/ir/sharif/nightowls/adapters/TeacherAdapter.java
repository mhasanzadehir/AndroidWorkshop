package ir.sharif.nightowls.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ir.sharif.nightowls.R;
import ir.sharif.nightowls.listeners.CallItemListener;
import ir.sharif.nightowls.models.Teacher;
import ir.sharif.nightowls.viewholders.TeacherViewHolder;

/**
 * Created by mahdihs76 on 5/31/18.
 */

public class TeacherAdapter extends RecyclerView.Adapter<TeacherViewHolder> implements CallItemListener {

    private Activity activity;
    private List<Teacher> list;

    public TeacherAdapter(Activity activity, List<Teacher> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item, parent, false);
        return new TeacherViewHolder(view, this);
    }


    @Override
    public void onBindViewHolder(TeacherViewHolder holder, int position) {
        Teacher teacher = list.get(position);
        holder.nickNameTextView.setText(teacher.getNickName());
        holder.roomTextView.setText(teacher.getRoom());
        holder.roleTextView.setText(teacher.getRole());
        holder.image.setImageResource(teacher.getImageResId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void call(int position) {
        if (isPermissionGranted()) {
            Teacher teacher = list.get(position);
            Uri tellUri = Uri.parse(String.format("tel:%s", teacher.getPhoneNumber()));
            Intent intent = new Intent(Intent.ACTION_CALL, tellUri);
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity, "allow call permission and try again", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity.checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        } else {
            return true;
        }
    }

}
