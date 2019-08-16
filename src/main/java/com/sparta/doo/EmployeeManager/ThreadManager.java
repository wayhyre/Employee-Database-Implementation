package com.sparta.doo.EmployeeManager;

import com.sparta.doo.DataStorage.ThreadedReadFile;

import java.util.HashMap;

public class ThreadManager implements Runnable {

    @Override
    public void run() {
        ThreadedReadFile threadedReadFile = new ThreadedReadFile();
        threadedReadFile.setEmployees();
    }

}
