package com.laioffer.vicabulary.ui.select;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laioffer.vicabulary.R;
import com.laioffer.vicabulary.database.DatabaseAdapter;
import com.laioffer.vicabulary.database.DatabaseHelper;
import com.laioffer.vicabulary.databinding.FragmentSelectBinding;
import com.laioffer.vicabulary.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment {
    private FragmentSelectBinding binding;

    public SelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSelectBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatabaseAdapter databaseAdapter = new DatabaseAdapter(getContext());
        List<Movie> movies = databaseAdapter.getAllMovies();
        SelectAdapter movieAdapter = new SelectAdapter(movies);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setAdapter(movieAdapter);
    }

}
