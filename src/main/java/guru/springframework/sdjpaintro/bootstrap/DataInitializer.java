package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@RequiredArgsConstructor
@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = Book.builder()
                .title("Domain Driven Design")
                .isbn("123")
                .publisher("RandomHouse")
                .build();

        bookRepository.save(bookDDD);

        Book bookSIA = Book.builder()
                .title("Spring In Action")
                .isbn("234")
                .publisher("Orielly")
                .build();

        bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(b -> log.info("Book Title: " + b.getTitle() + " id: " + b.getId() ));
    }
}
