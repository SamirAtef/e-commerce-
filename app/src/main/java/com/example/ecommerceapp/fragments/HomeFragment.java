package com.example.ecommerceapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapters.CategoryAdapter;
import com.example.ecommerceapp.models.CategoryModel;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView catRecyclerview;
    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;
    FirebaseFirestore db;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        catRecyclerview = root.findViewById(R.id.rec_category);

        db = FirebaseFirestore.getInstance();


        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.banner1, "Discount On Shoes Items", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner2, "Discount On Perfumes", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner3, "70% OFF", ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(slideModels);

        catRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        categoryModelList = new ArrayList<>();
        createcollection();
        categoryAdapter = new CategoryAdapter(getContext(), categoryModelList);
        catRecyclerview.setAdapter(categoryAdapter);
        createcollection();
//        db.collection("Category")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//
//                                CategoryModel categoryModel = document.toObject(CategoryModel.class);
//                                categoryModelList.add(categoryModel);
//                                categoryAdapter.notifyDataSetChanged();
//
//                            }
//                        } else {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//
//                                CategoryModel categoryModel = document.toObject(CategoryModel.class);
//                                categoryModelList.add(categoryModel);
//
//                            }
//
//                        }
//                    }
//                });
        return root;
    }

    private void createcollection() {
        categoryModelList.add(new CategoryModel(R.drawable.baby_clothing, "Kids Collection", "kids"));
        categoryModelList.add(new CategoryModel(R.drawable.camera, "Camera Collection", "camera"));
        categoryModelList.add(new CategoryModel(R.drawable.dress, "Woman Collection", "woman"));
        categoryModelList.add(new CategoryModel(R.drawable.shirt, "Man Collection", "man"));
        categoryModelList.add(new CategoryModel(R.drawable.sneakers, "Shoes Collection", "shoes"));
        categoryModelList.add(new CategoryModel(R.drawable.watch, "Watch Collection", "watch"));


    }
}