package com.project.homework4;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {

    // Các key để truyền dữ liệu qua Bundle, một cách làm an toàn
    private static final String ARG_IMAGE_RES_ID = "image_res_id";
    private static final String ARG_DETAILS_TEXT = "details_text";
    private static final String ARG_DESCRIPTION_TEXT = "description_text";

    // Phương thức factory để tạo một instance mới của Fragment với dữ liệu
    public static InfoFragment newInstance(int imageResId, String detailsText, String descriptionText) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RES_ID, imageResId);
        args.putString(ARG_DETAILS_TEXT, detailsText);
        args.putString(ARG_DESCRIPTION_TEXT, descriptionText);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // "Thổi phồng" layout XML vào View của Fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ProgressBar progressBar = view.findViewById(R.id.progress_bar_loading);
        ScrollView contentScrollView = view.findViewById(R.id.content_scroll_view);
        ImageView imageView = view.findViewById(R.id.image_info);
        TextView detailsTextView = view.findViewById(R.id.text_details_info);
        TextView descriptionTextView = view.findViewById(R.id.text_description_info);

        // Bắt đầu hiệu ứng loading
        progressBar.setVisibility(View.VISIBLE);
        contentScrollView.setVisibility(View.GONE);

        // Dùng Handler để giả lập việc tải dữ liệu mất một chút thời gian (vd: 500ms)
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (getArguments() != null && getActivity() != null) {
                // Lấy dữ liệu từ Bundle
                int imageResId = getArguments().getInt(ARG_IMAGE_RES_ID);
                String detailsText = getArguments().getString(ARG_DETAILS_TEXT);
                String descriptionText = getArguments().getString(ARG_DESCRIPTION_TEXT);

                // Gán dữ liệu vào các View
                imageView.setImageResource(imageResId);
                detailsTextView.setText(detailsText);
                descriptionTextView.setText(descriptionText);
            }

            // Kết thúc loading: ẩn ProgressBar và hiện nội dung
            progressBar.setVisibility(View.GONE);
            contentScrollView.setVisibility(View.VISIBLE);

        }, 500); // 500ms delay
    }
}