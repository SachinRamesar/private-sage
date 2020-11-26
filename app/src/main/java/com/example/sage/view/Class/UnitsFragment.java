package com.example.sage.view.Class;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sage.R;
import com.example.sage.model.CapeSubject;
import com.example.sage.model.Class;
import com.example.sage.model.ClassSession;
import com.example.sage.model.CsecSubject;
import com.example.sage.model.Subject;
import com.example.sage.view.MainActivity;
import com.example.sage.view.subjectsMenu.RecyclerViewAdapter;
import com.example.sage.view.subjectsMenu.SubjectsMenu;

import java.util.ArrayList;
import java.util.List;

public class UnitsFragment extends Fragment {
    public static final String ARG_OBJECT = "Unit";

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    List<Class> specificClasses;
    List<Class> allClasses;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unit, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        int unitNum = args.getInt(ARG_OBJECT);

        String subjectName =  ((ViewClasses)getActivity()).subjectName;
        String subjectType =  ((ViewClasses)getActivity()).subjectType;

        specificClasses = new ArrayList<>();
        allClasses = MainActivity.getClasses();

        //temp
        /*
        allClasses.add(new Class(SubjectsMenu.subjects.get(0),10,"Test1",new ArrayList<ClassSession>(),11));
        allClasses.add(new Class(SubjectsMenu.subjects.get(0),12,"Test2",new ArrayList<ClassSession>(),12));
        allClasses.add(new Class(SubjectsMenu.subjects.get(0),20,"Test3",new ArrayList<ClassSession>(),13));
        allClasses.add(new Class(SubjectsMenu.subjects.get(1),50,"Test4",new ArrayList<ClassSession>(),14));
        allClasses.add(new Class(SubjectsMenu.subjects.get(1),70,"Test5",new ArrayList<ClassSession>(),66));
        allClasses.add(new Class(SubjectsMenu.subjects.get(1),50,"Test4",new ArrayList<ClassSession>(),24));
        allClasses.add(new Class(SubjectsMenu.subjects.get(1),70,"Test5",new ArrayList<ClassSession>(),74)); */



        if(subjectType.equals("CAPE")) {
            for(Class c: allClasses){
                Subject subject = c.getSubject();

                if(subject instanceof CapeSubject){
                    if(subject.getName().equals(subjectName)){
                        if( ((CapeSubject)subject).getUnitNumber()==unitNum ) {
                            specificClasses.add(c);
                        }
                    }

                }
            }
        } else if(subjectType.equals("CSEC")){
            for(Class c: allClasses) {
                Subject subject = c.getSubject();

                if(subject instanceof CsecSubject){
                    if(subject.getName().equals(subjectName)){
                        specificClasses.add(c);
                    }
                }
            }
        }

        recyclerView=(RecyclerView) view.findViewById(R.id.classRecyclerView);
        ViewClassesRecyclerViewAdapter recyclerViewAdapter = new ViewClassesRecyclerViewAdapter(getActivity(),specificClasses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);

        /*
        ((TextView) view.findViewById(android.R.id.text1))
                .setText(Integer.toString(args.getInt(ARG_OBJECT))); */


        /*
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UnitsFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

         */



    }

}