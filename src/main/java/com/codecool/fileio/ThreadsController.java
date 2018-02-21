package com.codecool.fileio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class ThreadsController {

    ExecutorService executorService;

    public ThreadsController(){

    }
}
