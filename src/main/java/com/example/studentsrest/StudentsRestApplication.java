package com.example.studentsrest;

import com.example.studentsrest.data.DataCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentsRestApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudentsRestApplication.class, args);

        DataCreator dataCreator = context.getBean(DataCreator.class);
        dataCreator.setNeedCreateData(false);
        dataCreator.createTestDataIfNeeded();
    }

}
