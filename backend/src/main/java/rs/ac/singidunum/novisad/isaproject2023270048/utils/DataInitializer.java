package rs.ac.singidunum.novisad.isaproject2023270048.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.ac.singidunum.novisad.isaproject2023270048.models.RoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.RoleRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.UserService;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserService userService, RoleRepository roleRepository) {
        return args -> {
        	if (roleRepository.count() == 0) {
        		roleRepository.save(new RoleModel("ADMIN"));
        		roleRepository.save(new RoleModel("USER"));
        	}
            if (userService.findAll().size() == 0) {
            	RoleModel role = roleRepository.findByName("ADMIN");
            	userService.register("admin@example.com", "admin", role);
                System.out.println("Database seeded with default admin user.");
            }
        };
    }
}
