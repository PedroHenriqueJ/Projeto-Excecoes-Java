package model.entities;

// Essa classe é uma exceção personalizada para o domínio do problema.
// Ela estende a classe Exception e é usada para tratar erros específicos relacionados ao domínio da aplicação,
// como datas inválidas em reservas de hotel.

public class DomainException extends Exception {
    private static final long serialVersionUID = 1L;

    public DomainException (String message) {
        super(message);
    }
}
