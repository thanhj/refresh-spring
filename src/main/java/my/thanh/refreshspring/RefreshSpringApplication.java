package my.thanh.refreshspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
public class RefreshSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefreshSpringApplication.class, args);
	}
}

@Entity
@Data
@NoArgsConstructor
class Cat {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Cat(String name){
        this.name = name;
    }
}

@RepositoryRestResource
interface CatRepository extends JpaRepository<Cat, Long> {

}