package com.example.hw_6_5_m.ui.fragment.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.example.hw_6_5_m.R;
import com.example.hw_6_5_m.base.BaseFragment;
import com.example.hw_6_5_m.databinding.FragmentMainBinding;
import com.example.hw_6_5_m.ui.fragment.main.viewmodel.LoveViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends BaseFragment<FragmentMainBinding> {

    LoveViewModel viewModel;
    public static final String KEY = "key";
    public static final String FNAME = "fname";
    public static final String SNAME = "sname";

    @Override
    protected FragmentMainBinding bind() {
        return FragmentMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        viewModel = new ViewModelProvider(requireActivity()).get(LoveViewModel.class);
    }

    @Override
    protected void setupObserver() {
        super.setupObserver();
        binding.btnCalculate.setOnClickListener(view -> init());
        toHistory();
    }

    private void toHistory() {
        binding.imgToHistory.setOnClickListener(view -> {
            Toast.makeText(getContext(), "work", Toast.LENGTH_SHORT).show();
            controller.navigate(R.id.historyFragment);
        });
    }

    private void init() {
        String firstName = binding.edFirstName.getText().toString().trim();
        String secondName = binding.edSecondName.getText().toString().trim();

        viewModel.getModel(firstName, secondName).observe(getViewLifecycleOwner(), loveModel -> {
            Toast.makeText(getContext(), "work", Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            bundle.putString(KEY, loveModel.percentage);
            bundle.putString(FNAME, firstName);
            bundle.putString(SNAME, secondName);
            controller.navigate(R.id.resultFragment, bundle);
        });
    }
}