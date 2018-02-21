package com.codecool.fileio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.codecool.fileio")
public class FileIoApplication implements CommandLineRunner{

    private ThreadsController threadsController;

    public FileIoApplication(ThreadsController threadsController) {
        this.threadsController = threadsController;
    }

    public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FileIoApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        threadsController.toString();
    }
}
