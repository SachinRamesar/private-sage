package com.example.sage.model;

import com.example.sage.R;

import java.util.ArrayList;
import java.util.List;

public class SubjectCatalogue {

    private static List<Subject> subjects = new ArrayList<>();

    public  static List<Subject> getSubjects(){
        return subjects;
    }

    public static void loadSubjects(){
        subjects.add(new CapeSubject("Accounting", R.drawable.cape_accounts,1));
        subjects.add(new CapeSubject("Accounting", R.drawable.cape_accounts,2));

        subjects.add(new CapeSubject("Agricultural Science",R.drawable.cape_agri_science,1));
        subjects.add(new CapeSubject("Agricultural Science",R.drawable.cape_agri_science,2));

        subjects.add(new CapeSubject("Animations and Game Design",R.drawable.cape_anim_and_game,1));
        subjects.add(new CapeSubject("Animations and Game Design",R.drawable.cape_anim_and_game,2));

        subjects.add(new CapeSubject("Art And Design",R.drawable.cape_art_and_design,1));
        subjects.add(new CapeSubject("Art And Design",R.drawable.cape_art_and_design,2));

        subjects.add(new CapeSubject("Biology",R.drawable.cape_biology,1));
        subjects.add(new CapeSubject("Biology",R.drawable.cape_biology,2));

        subjects.add(new CapeSubject("Caribbean Studies",R.drawable.cape_caribbean_studies,1));
        subjects.add(new CapeSubject("Caribbean Studies",R.drawable.cape_caribbean_studies,2));

        subjects.add(new CapeSubject("Chemistry",R.drawable.cape_chemistry,1));
        subjects.add(new CapeSubject("Chemistry",R.drawable.cape_chemistry,2));

        subjects.add(new CapeSubject("Communication Studies",R.drawable.cape_comm_studies,1));
        subjects.add(new CapeSubject("Communication Studies",R.drawable.cape_comm_studies,2));

        subjects.add(new CapeSubject("Digital Media",R.drawable.cape_digital_media,1));
        subjects.add(new CapeSubject("Digital Media",R.drawable.cape_digital_media,2));

        subjects.add(new CapeSubject("Economics",R.drawable.cape_economics,1));
        subjects.add(new CapeSubject("Economics",R.drawable.cape_economics,2));

        subjects.add(new CapeSubject("Electrical and Electronic Technology",R.drawable.cape_electrical,1));
        subjects.add(new CapeSubject("Electrical and Electronic Technology",R.drawable.cape_electrical,2));

        subjects.add(new CapeSubject("Environmental Science",R.drawable.cape_environ,1));
        subjects.add(new CapeSubject("Environmental Science",R.drawable.cape_environ,2));

        subjects.add(new CapeSubject("Food and Nutrition",R.drawable.cape_food_and_nutrition,1));
        subjects.add(new CapeSubject("Food and Nutrition",R.drawable.cape_food_and_nutrition,2));

        subjects.add(new CapeSubject("French",R.drawable.cape_french,1));
        subjects.add(new CapeSubject("French",R.drawable.cape_french,2));

        subjects.add(new CapeSubject("Geography",R.drawable.cape_geo,1));
        subjects.add(new CapeSubject("Geography",R.drawable.cape_geo,2));

        subjects.add(new CapeSubject("Green Engineering",R.drawable.cape_green_eng,1));
        subjects.add(new CapeSubject("Green Engineering",R.drawable.cape_green_eng,2));

        subjects.add(new CapeSubject("History",R.drawable.cape_history,1));
        subjects.add(new CapeSubject("History",R.drawable.cape_history,2));

        subjects.add(new CapeSubject("Information Technology",R.drawable.cape_info_tech,1));
        subjects.add(new CapeSubject("Information Technology",R.drawable.cape_info_tech,2));

        subjects.add(new CapeSubject("Integrated Mathematics",R.drawable.cape_inte_maths,1));
        subjects.add(new CapeSubject("Integrated Mathematics",R.drawable.cape_inte_maths,2));

        subjects.add(new CapeSubject("Law",R.drawable.cape_law,1));
        subjects.add(new CapeSubject("Law",R.drawable.cape_law,2));

        subjects.add(new CapeSubject("Literatures in English",R.drawable.cape_literature,1));
        subjects.add(new CapeSubject("Literatures in English",R.drawable.cape_literature,2));

        subjects.add(new CapeSubject("Building and Mechanical Engineering",R.drawable.cape_mechanical_eng,1));
        subjects.add(new CapeSubject("Building and Mechanical Engineering",R.drawable.cape_mechanical_eng,2));

        subjects.add(new CapeSubject("Management of Business",R.drawable.cape_mob,1));
        subjects.add(new CapeSubject("Management of Business",R.drawable.cape_mob,2));

        subjects.add(new CapeSubject("Performing Arts",R.drawable.cape_performing_arts,1));
        subjects.add(new CapeSubject("Performing Arts",R.drawable.cape_performing_arts,2 ));

        subjects.add(new CapeSubject("Physical Education",R.drawable.cape_physical_ed,1));
        subjects.add(new CapeSubject("Physical Education",R.drawable.cape_physical_ed,2));

        subjects.add(new CapeSubject("Physics",R.drawable.cape_physics,1));
        subjects.add(new CapeSubject("Physics",R.drawable.cape_physics,2));

        subjects.add(new CapeSubject("Pure Mathematics",R.drawable.cape_pure_maths,1));
        subjects.add(new CapeSubject("Pure Mathematics",R.drawable.cape_pure_maths,2));

        subjects.add(new CapeSubject("Sociology",R.drawable.cape_sociology,1));
        subjects.add(new CapeSubject("Sociology",R.drawable.cape_sociology,2));

        subjects.add(new CapeSubject("Spanish",R.drawable.cape_spanish,1));
        subjects.add(new CapeSubject("Spanish",R.drawable.cape_spanish,2));

        subjects.add(new CapeSubject("Tourism",R.drawable.cape_tourism,1));
        subjects.add(new CapeSubject("Tourism",R.drawable.cape_tourism,2));



        subjects.add(new CsecSubject("Additional Mathematics",R.drawable.csec_ad_maths));
        subjects.add(new CsecSubject("Biology",R.drawable.csec_biology));
        subjects.add(new CsecSubject("Chemistry",R.drawable.csec_chemistry));
        subjects.add(new CsecSubject("Economics",R.drawable.csec_economics));
        subjects.add(new CsecSubject("Electronic Document Preparation Management",R.drawable.csec_edpm));
        subjects.add(new CsecSubject("English A",R.drawable.csec_english_a));
        subjects.add(new CsecSubject("English B",R.drawable.csec_english_b));
        subjects.add(new CsecSubject("French",R.drawable.csec_french));
        subjects.add(new CsecSubject("Geography",R.drawable.csec_geography));
        subjects.add(new CsecSubject("History",R.drawable.csec_history));
        subjects.add(new CsecSubject("Home Economics",R.drawable.csec_home_ec));
        subjects.add(new CsecSubject("Human and Social Biology",R.drawable.csec_hsb));
        subjects.add(new CsecSubject("Industrial Technology",R.drawable.csec_industrial_tech));
        subjects.add(new CsecSubject("Information Technology",R.drawable.csec_info_tech));
        subjects.add(new CsecSubject("Integrated Science",R.drawable.csec_inte_science));
        subjects.add(new CsecSubject("Mathematics",R.drawable.csec_mathematics));
        subjects.add(new CsecSubject("Music",R.drawable.csec_music));
        subjects.add(new CsecSubject("Office Administration",R.drawable.csec_office_admin));
        subjects.add(new CsecSubject("Physical Education",R.drawable.csec_physical_education));
        subjects.add(new CsecSubject("Physics",R.drawable.csec_physics));
        subjects.add(new CsecSubject("Principles of Business",R.drawable.csec_business));
        subjects.add(new CsecSubject("Principles of Accounts",R.drawable.csec_accounts));
        subjects.add(new CsecSubject("Religion",R.drawable.csec_religion));
        subjects.add(new CsecSubject("Social Studies",R.drawable.csec_social_studies));
        subjects.add(new CsecSubject("Spanish",R.drawable.csec_spanish));
        subjects.add(new CsecSubject("Theatre Arts",R.drawable.csec_theatre_arts));
        subjects.add(new CsecSubject("Visual Arts",R.drawable.csec_visual_arts));

    }


}
