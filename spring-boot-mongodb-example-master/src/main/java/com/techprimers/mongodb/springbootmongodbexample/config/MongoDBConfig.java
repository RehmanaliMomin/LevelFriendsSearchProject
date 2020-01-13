package com.techprimers.mongodb.springbootmongodbexample.config;

import com.techprimers.mongodb.springbootmongodbexample.document.Blog;
import com.techprimers.mongodb.springbootmongodbexample.document.User;
import com.techprimers.mongodb.springbootmongodbexample.repository.BlogRepository;
import com.techprimers.mongodb.springbootmongodbexample.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings -> {
            userRepository.save(new User("1", "Peter",new ArrayList<>(List.of("2","4","a","5"))));
            userRepository.save(new User("2", "Sam",new ArrayList<>(List.of("1","3","b"))));
            userRepository.save(new User("3", "Peter",new ArrayList<>(List.of("2","b","c"))));
            userRepository.save(new User("4", "Sam",new ArrayList<>(List.of("1","a"))));
            userRepository.save(new User("a", "Peter",new ArrayList<>(List.of("1","4"))));
            userRepository.save(new User("b", "Sam",new ArrayList<>(List.of("2","3"))));
            userRepository.save(new User("c", "Peter",new ArrayList<>(List.of("3"))));
          //  userRepository.save(new User("d", "Sam",new ArrayList<>(List.of("2","4","a","5"))));
           // userRepository.save(new User("e", "Peter",new ArrayList<>(List.of("2","4","a","5"))));
            userRepository.save(new User("5", "Sam",new ArrayList<>(List.of("1"))));
        };
    }
    
    @Bean
    CommandLineRunner commandLineRunner1(BlogRepository blogRepository) {
        return strings -> {
        	blogRepository.save(new Blog(1, "1","abc",new String[] {"1","5"}));
        	blogRepository.save(new Blog(2, "1","abc",new String[] {"1","4"}));
        	blogRepository.save(new Blog(3, "1","abc",new String[] {"1","2","a"}));
        	blogRepository.save(new Blog(4, "1","abc",new String[] {"3","2","7"}));
        	blogRepository.save(new Blog(5, "1","abc",new String[] {"1","4","6"}));
			
			 blogRepository.save(new Blog(6, "1","abc",new String[] {"3","c"}));
			/* * blogRepository.save(new Blog(5, "1","abc",new String[] {"d,1"}));
			 * blogRepository.save(new Blog(5, "1","abc",new String[] {"b,3"}));
			 */};
    }

}
