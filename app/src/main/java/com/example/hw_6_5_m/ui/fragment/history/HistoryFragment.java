package com.example.hw_6_5_m.ui.fragment.history;

import android.annotation.SuppressLint;

import com.example.hw_6_5_m.R;
import com.example.hw_6_5_m.base.BaseFragment;
import com.example.hw_6_5_m.data.entity.historymodel.HistoryModel;
import com.example.hw_6_5_m.data.room.LoveDao;
import com.example.hw_6_5_m.databinding.FragmentHistoryBinding;
import com.example.hw_6_5_m.ui.fragment.history.historyadapter.HistoryAdapter;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {

    @Inject
    LoveDao loveDao;
    private final HistoryAdapter adapter = new HistoryAdapter();

    @Override
    protected FragmentHistoryBinding bind() {
        return FragmentHistoryBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        initAdapter();
        initResult();
        sortByAlphabet();
    }

    @Override
    protected void setupObserver() {
        super.setupObserver();
        toMenu();
    }

    private void toMenu() {
        binding.toMainHistory.setOnClickListener(v -> controller.navigate(R.id.mainFragment));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void sortByAlphabet() {
        adapter.addItem(loveDao.getAllLovesByAlphabet());
    }

    private void initResult() {
        if (getArguments() != null){
            String percentage = getArguments().getString("percentage");
            String firstName = getArguments().getString("firstName");
            String secondName = getArguments().getString("secondName");
            loveDao.addLove(new HistoryModel(firstName, secondName, percentage));
            sortByAlphabet();
        }
    }

    private void initAdapter() {
        binding.rvItem.setAdapter(adapter);
    }
}