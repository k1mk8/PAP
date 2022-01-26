package com.example.citygym.ui.hometrainers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.citygym.databinding.FragmentHomeTrainersBinding;

public class HomeTrainersFragment extends Fragment {

    private HomeTrainersViewModel homeTrainersViewModel;
    private FragmentHomeTrainersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeTrainersViewModel =
                new ViewModelProvider(this).get(HomeTrainersViewModel.class);

        binding = FragmentHomeTrainersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}