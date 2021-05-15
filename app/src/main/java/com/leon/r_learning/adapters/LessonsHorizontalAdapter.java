package com.leon.r_learning.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.leon.r_learning.R;
import com.leon.r_learning.activities.SectionActivity;
import com.leon.r_learning.enums.BundleEnum;
import com.leon.r_learning.layout.FitDoughnut;
import com.leon.r_learning.tables.Lesson;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LessonsHorizontalAdapter extends
        RecyclerView.Adapter<LessonsHorizontalAdapter.SimpleViewHolder> {

    private final Context context;
    private List<Lesson> lessons;
    private final int courseId;

    public LessonsHorizontalAdapter(Context context, List<Lesson> elements, int courseId) {
        this.context = context;
        this.lessons = elements;
        this.courseId = courseId;
        if (lessons == null) {
            lessons = new ArrayList<>();
        }
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final TextView textViewLessonTitle;
        public final RelativeLayout relativeLayoutAll;
        public final ImageView imageViewLessonIcon;
        public final FitDoughnut fitDoughnut;

        public SimpleViewHolder(View view) {
            super(view);
            textViewLessonTitle = view.findViewById(R.id.text_view_lesson_title);
            relativeLayoutAll = view.findViewById(R.id.relative_view_all);
            fitDoughnut = view.findViewById(R.id.fit_doughnut_res);
            imageViewLessonIcon = view.findViewById(R.id.image_view_lesson_icon);
        }
    }

    @NotNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).
                inflate(R.layout.item_lesson_h, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder holder, final int position) {
        holder.textViewLessonTitle.setText(lessons.get(position).getTitle());
        String backgroundName = "course" + courseId;
        holder.imageViewLessonIcon.setBackgroundResource(context.getResources().getIdentifier(backgroundName,
                "drawable", context.getPackageName()));

        String iconName = "z" + courseId + "_" + lessons.get(position).getId();
        holder.imageViewLessonIcon.setImageResource(context.getResources().getIdentifier(iconName,
                "drawable", context.getPackageName()));

        if (lessons.get(position).getResult() > 0) {
            holder.fitDoughnut.setVisibility(View.VISIBLE);
            holder.fitDoughnut.animateSetPercent(((float) lessons.get(position).getResult() * 10) - 0.01f);
        }

        holder.itemView.setOnClickListener(v -> {
//            if (lessons.get(position).getNumberOfSections() == 0) {
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
//                alertDialog.setTitle("Not available");
//                alertDialog.setMessage("Sorry, this lesson is not available yet. Try instead the lessons on Passwords, Viruses, VPN and GDPR.");
//                alertDialog.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
//                alertDialog.show();
//            } else {
//                Intent intent = new Intent(context, SectionActivity.class);
//                intent.putExtra(BundleEnum.SECTION_NUMBER.getValue(), 0);
//                intent.putExtra(BundleEnum.LESSON_ID.getValue(), lessons.get(position).getId());
//                context.startActivity(intent);
//            }
            Intent intent = new Intent(context, SectionActivity.class);
            intent.putExtra(BundleEnum.SECTION_NUMBER.getValue(), 0);
            intent.putExtra(BundleEnum.LESSON_ID.getValue(), lessons.get(position).getId());
            intent.putExtra(BundleEnum.COURSE_ID.getValue(), courseId);
            context.startActivity(intent);
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.lessons.size();
    }
}