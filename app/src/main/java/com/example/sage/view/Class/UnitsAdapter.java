package com.example.sage.view.Class;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class UnitsAdapter extends FragmentStateAdapter {

    private final int TOTAL_TABS = 2;
    private static int count = 1;

    public UnitsAdapter(FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Fragment fragment;
        fragment = new UnitsFragment();

        Bundle args = new Bundle();

        // Our object is just an integer :-P
        args.putInt(UnitsFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getItemCount() {
        return TOTAL_TABS;
    }
}
