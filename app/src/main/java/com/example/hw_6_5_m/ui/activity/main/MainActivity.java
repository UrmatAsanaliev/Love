package com.example.hw_6_5_m.ui.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.hw_6_5_m.R;
import com.example.hw_6_5_m.data.pref.Prefs;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private NavHostController controller;
    @Inject
    Prefs prefs;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initController();
        initBoard();
    }

    private void initBoard() {
        if (!prefs.isShown()){
            toBoard();
            prefs.isShowed();
        }
    }


    private void toBoard() {
        controller.navigate(R.id.boardFragment);
    }

    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                this.getSupportFragmentManager()
                        .findFragmentById(R.id.fragmentContainerView);
        assert navHostController != null;
        controller = (NavHostController) navHostController.getNavController();
    }
}