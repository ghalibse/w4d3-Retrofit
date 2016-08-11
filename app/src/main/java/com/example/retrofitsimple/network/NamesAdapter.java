package com.example.retrofitsimple.network;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitsimple.MainActivity;
import com.example.retrofitsimple.R;
import com.example.retrofitsimple.entities.Student;

import java.util.ArrayList;

/**
 * Created by evin on 8/10/16.
 */
public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ViewHolder> {

    private static final String TAG = "NamesAdapterTAG_";

    private ArrayList<Student> mStudents;
    private Context mContext;

    public NamesAdapter(ArrayList<Student> students, Context context) {
        mStudents = students;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = mStudents.get(position);

        TextView textView = holder.textViewName;
        textView.setText(student.getName());

        ImageView imageView = holder.imageViewName;
        Glide.with(mContext)
                .load(student.getImageName())
                .into(imageView);

        TextView ageView = holder.ageView;
        String ageTxt = "Age: ".concat(String.valueOf(student.getAge()));
        ageView.setText(ageTxt);

        TextView gradeView = holder.gradeView;
        String gradeTxt = "Grade: ".concat(String.valueOf(student.getGrade()));
        gradeView.setText(gradeTxt);

    }

    @Override
    public int getItemCount() {
        return mStudents == null
                ? 0
                : mStudents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView ageView;
        private  TextView gradeView;
        private  TextView textViewName;
        private  ImageView imageViewName;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.l_item_txt);
            imageViewName = (ImageView) itemView.findViewById(R.id.l_item_img);
            ageView = (TextView) itemView.findViewById(R.id.age_txt);
            gradeView = (TextView) itemView.findViewById(R.id.grade_txt);
        }
    }
}
