package pl.awojtowicz.fullstackprojekt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.awojtowicz.fullstackprojekt.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {


}
