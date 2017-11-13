package com.insyte.ems;

import com.insyte.ems.utils.executors.OctaveExecutor;

import java.util.List;

public class MainApp {
    public static void main(String[] args){
        OctaveExecutor executor = new OctaveExecutor();
        List<String> results = executor.Execute("..\\octave_example.m");
        for(String result : results){
            System.out.printf(result);
        }
    }
}
