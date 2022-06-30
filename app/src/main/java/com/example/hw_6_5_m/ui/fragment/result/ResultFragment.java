package com.example.hw_6_5_m.ui.fragment.result;

import static com.example.hw_6_5_m.ui.fragment.main.MainFragment.FNAME;
import static com.example.hw_6_5_m.ui.fragment.main.MainFragment.KEY;
import static com.example.hw_6_5_m.ui.fragment.main.MainFragment.SNAME;

import android.os.Bundle;

import com.example.hw_6_5_m.R;
import com.example.hw_6_5_m.base.BaseFragment;
import com.example.hw_6_5_m.databinding.FragmentResultBinding;

public class ResultFragment extends BaseFragment<FragmentResultBinding> {

    @Override
    protected FragmentResultBinding bind() {
        return FragmentResultBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        initResult();
    }

    private void initResult() {
        if (getArguments() != null){
            String percentage = getArguments().getString(KEY);
            String firstName = getArguments().getString(FNAME);
            String secondName = getArguments().getString(SNAME);

            binding.txtFirstNameResult.setText(firstName);
            binding.txtSecondNameResult.setText(secondName);
            binding.txtResultResult.setText(percentage);

            binding.imgToHistoryResult.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("percentage", percentage);
                bundle.putString("firstName", firstName);
                bundle.putString("secondName", secondName);
                controller.navigate(R.id.historyFragment, bundle);
            });
        }
    }
}