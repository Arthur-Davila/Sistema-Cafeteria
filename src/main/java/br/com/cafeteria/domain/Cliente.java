import jakarta.persistence.Entity;

@Entity
public class Cliente {
    @Id
    private Long id;
    private String nome;
    private String email;

    public Cliente(Long id, String nome, String email) {
        try {
            validate(id, nome, email);
            this.id = id;
            this.nome = nome;
            this.email = email;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erro ao criar cliente: " + e.getMessage());
        }
    }

    private void validate(Long id, String nome, String email) {
        
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
}