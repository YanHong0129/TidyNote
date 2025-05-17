package com.example.tidynote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tidynote.entity.Note;
import com.example.tidynote.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@RestController
public class TidynoteApplication {

    private final NoteRepository noteRepository;

    TidynoteApplication(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TidynoteApplication.class);
        app.addListeners(new DynamicPortInitializer());
        app.run(args);
    }

    @Bean
    CommandLineRunner initializeApp(@Value("${server.port}") int port, NoteRepository noteRepository) {
        return args -> {
            if(noteRepository.count() == 0) {
                noteRepository.save(new Note(null, "Vue + Spring Boot", "This is a full-stack example."));
                noteRepository.save(new Note(null, "TidyNotes", "Simple note app with CRUD features."));
                noteRepository.save(new Note(null, "Welcome", "You're now connected to MySQL."));
                System.out.println("Sample notes seeded into the database.");
            } else {
                System.out.println("Notes are already present in the database.");
            }

            System.out.println("\nTidyNotes backend is running at: http://localhost:" + port + "/api/notes\n");
        };
    }

    
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
}