package com.example.nav_drawer_experiment.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.nav_drawer_experiment.R;
import com.example.nav_drawer_experiment.databinding.FragmentGalleryBinding;
import com.example.nav_drawer_experiment.databinding.FragmentToolsBinding;
import com.example.nav_drawer_experiment.ui.gallery.GalleryViewModel;
import com.example.nav_drawer_experiment.ui.tools.ToolsViewModel;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private FragmentToolsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                new ViewModelProvider(this).get(ToolsViewModel.class);

        binding = FragmentToolsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTools;
        toolsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}