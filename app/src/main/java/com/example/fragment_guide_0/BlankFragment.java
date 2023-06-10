package com.example.fragment_guide_0;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment_guide_0.databinding.FragmentBlankBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {



    private String name;
    private String lastname;
    private FragmentBlankBinding mBinding;

    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(String name, String lastname) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString("Clave1", name);
        args.putString("Clave2", lastname);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("Clave1");
            lastname = getArguments().getString("Clave2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     mBinding= FragmentBlankBinding.inflate(inflater,container,false);
     return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.name.setText(name);
        mBinding.lastname.setText(lastname);
    }
}