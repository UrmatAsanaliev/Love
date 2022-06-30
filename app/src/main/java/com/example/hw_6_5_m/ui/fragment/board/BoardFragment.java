package com.example.hw_6_5_m.ui.fragment.board;

import com.example.hw_6_5_m.base.BaseFragment;
import com.example.hw_6_5_m.databinding.FragmentBoardBinding;
import com.example.hw_6_5_m.ui.fragment.board.boardadapter.BoardAdapter;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BoardFragment extends BaseFragment<FragmentBoardBinding> {


    @Override
    protected FragmentBoardBinding bind() {
        return FragmentBoardBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        initAdapter();
    }

    @Override
    protected void setupObserver() {
        super.setupObserver();
        initClicker();
    }

    private void initClicker() {
        binding.toMain.setOnClickListener(v ->
                navigateUp());
    }

    public void navigateUp(){
        controller.navigateUp();
    }

    private void initAdapter() {
        BoardAdapter adapter = new BoardAdapter();
        binding.vpBoard.setAdapter(adapter);
    }
}