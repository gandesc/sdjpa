package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = "guru.springframework.sdjpaintro.bootstrap")
public class SprigBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Order(1)
    @Commit // eq. to @Rollback(value=false)
    @Test
    void testJpaTestSlice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(Book.builder()
                .title("My Book")
                .isbn("1234")
                .publisher("Publisher")
                .build());

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestTransactions() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(3);
    }
}
