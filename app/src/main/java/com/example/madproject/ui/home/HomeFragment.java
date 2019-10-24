package com.example.madproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.madproject.R;
import com.example.madproject.RemoteAcActivity;
import com.example.madproject.RemoteTvActivity;
import com.example.madproject.SecondActivity;
import com.example.madproject.ThirdActivity;

public class HomeFragment extends Fragment {
    private ImageButton Tv;
    private ImageButton Ac;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        Tv = (ImageButton) root.findViewById(R.id.button4);
        Ac = (ImageButton) root.findViewById(R.id.button5);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                Intent intent = new Intent(getActivity(), RemoteTvActivity.class);
                startActivity(intent);
            }
        });
        Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                Intent intent = new Intent(getActivity(),RemoteAcActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}