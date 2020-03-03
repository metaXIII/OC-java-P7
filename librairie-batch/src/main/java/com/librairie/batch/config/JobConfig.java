package com.librairie.batch.config;

import com.librairie.batch.job.CustomTask;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.librairie.batch.job.BatchConstant.JOB_NAME;

@Configuration
public class JobConfig {
    private final CustomTask customTask;

    public JobConfig(CustomTask customTask) {
        this.customTask = customTask;
    }

    @Bean
    protected Step customStep(StepBuilderFactory stepBuilders) {
        return stepBuilders
                .get("customStep")
                .tasklet(customTask)
                .build();
    }

    @Bean
    public Job customJob(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders) {
        return jobBuilders
                .get(JOB_NAME)
                .start(customStep(stepBuilders))
                .build();
    }
}
