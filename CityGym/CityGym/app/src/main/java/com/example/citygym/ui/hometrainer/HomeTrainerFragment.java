package com.example.citygym.ui.hometrainer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.citygym.databinding.FragmentHometrainerBinding;

public class HomeTrainerFragment extends Fragment {

    private com.example.citygym.ui.hometrainer.HomeTrainerViewModel HomeTrainerViewModel;
    private FragmentHometrainerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeTrainerViewModel =
                new ViewModelProvider(this).get(HomeTrainerViewModel.class);

        binding = FragmentHometrainerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}