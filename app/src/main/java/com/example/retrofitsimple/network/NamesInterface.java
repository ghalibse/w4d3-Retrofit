package com.example.retrofitsimple.network;

import com.example.retrofitsimple.entities.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by evin on 8/10/16.
 */
public interface NamesInterface {

    //2. Add interface with endpoints
    @GET("/v2/57a4dfb40f0000821dc9a3b8")
    Call<ArrayList<Student>> retrieveStudents();

    @GET("/v2/57ab95a1120000c12173b6d4")
    Call<ArrayList<Student>> retrieveStudentsImages();
}
