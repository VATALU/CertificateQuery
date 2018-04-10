package org.vatalu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.vatalu.util.PdfUtil;

import javax.mail.internet.MimeMessage;
import java.util.concurrent.LinkedBlockingQueue;

@SpringBootApplication
@EnableAsync
public class Application {
    @Bean
    public ThreadPoolTaskExecutor getTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setKeepAliveSeconds(60000);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(20);
        return threadPoolTaskExecutor;
    }

    @Bean
    public LinkedBlockingQueue<MimeMessage> getLinkedBlockingQueue(){
        return new LinkedBlockingQueue<>();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
