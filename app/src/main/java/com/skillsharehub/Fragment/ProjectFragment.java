package com.skillsharehub.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skillsharehub.Adapter.CategoryAdapter;
import com.skillsharehub.Adapter.ProjectAdapter;
import com.skillsharehub.Model.CategoryModel;
import com.skillsharehub.Model.ProjectModel;
import com.skillsharehub.R;

import java.util.ArrayList;

public class ProjectFragment extends Fragment {

    private RecyclerView rvCategory, rvProjects;

    private ArrayList<CategoryModel> categoryList;
    private ArrayList<ProjectModel> projectList;

    private CategoryAdapter categoryAdapter;
    private ProjectAdapter projectAdapter;

    public ProjectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_project, container, false);

        init(view);

        loadCategories();
        setupCategoryRecycler();

        loadProjects();
        setupProjectRecycler();

        return view;
    }

    private void init(View view) {

        rvCategory = view.findViewById(R.id.rvCategory);
        rvProjects = view.findViewById(R.id.rvProjects);

        categoryList = new ArrayList<>();
        projectList = new ArrayList<>();
    }

    //================ CATEGORY =================//

    private void loadCategories() {

        addCategory("All", true);
        addCategory("AI/ML", false);
        addCategory("Web Dev", false);
        addCategory("Android", false);
        addCategory("DSA", false);
        addCategory("Other", false);

    }

    private void addCategory(String name, boolean selected) {

        categoryList.add(new CategoryModel(name, selected));

    }

    private void setupCategoryRecycler() {

        categoryAdapter = new CategoryAdapter(requireContext(), categoryList);

        rvCategory.setLayoutManager(
                new LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false));

        rvCategory.setAdapter(categoryAdapter);
    }

    //================ PROJECT =================//

    private void setupProjectRecycler() {

        projectAdapter = new ProjectAdapter(requireContext(), projectList);

        rvProjects.setLayoutManager(
                new LinearLayoutManager(requireContext()));

        rvProjects.setNestedScrollingEnabled(false);

        rvProjects.setAdapter(projectAdapter);
    }

    private void addProject(String title,
                            String author,
                            String description,
                            String category,
                            int likes,
                            String... technologies) {

        ArrayList<String> techList = new ArrayList<>();

        for (String tech : technologies) {
            techList.add(tech);
        }

        projectList.add(new ProjectModel(
                title,
                author,
                description,
                category,
                techList,
                likes
        ));
    }

    private void loadProjects() {

        addProject(
                "AI Chatbot with LangChain",
                "Arjun Mehta",
                "A conversational AI chatbot built using LangChain and OpenAI APIs.",
                "AI/ML",
                42,
                "Python",
                "LangChain",
                "OpenAI"
        );

        addProject(
                "E-Commerce App",
                "Priya Patel",
                "Full-stack e-commerce platform with payment integration.",
                "Web Dev",
                38,
                "React",
                "Node.js",
                "MongoDB"
        );

        addProject(
                "Skill Share Hub",
                "Neha Vaghela",
                "Project sharing platform for students.",
                "Android",
                95,
                "Java",
                "Firebase",
                "XML"
        );

        addProject(
                "DSA Visualizer",
                "Rahul Shah",
                "Visualization of sorting and searching algorithms.",
                "DSA",
                67,
                "C++",
                "STL",
                "Algorithms"
        );

        addProject(
                "Plant Disease Detection",
                "Karan Patel",
                "AI model to identify plant diseases using images.",
                "AI/ML",
                82,
                "Python",
                "TensorFlow",
                "CNN"
        );

    }
}