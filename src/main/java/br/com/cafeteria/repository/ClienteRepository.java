import org.springframework.data.repository.CrudRepository;
import br.com.cafeteria.domain.Cliente;
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}