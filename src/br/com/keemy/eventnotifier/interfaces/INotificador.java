package br.com.keemy.eventnotifier.interfaces;

import br.com.keemy.eventnotifier.models.Pessoa;

public interface INotificador {

    void adicionarPessoa(Pessoa pessoa);
    void limparPessoas();
    String getMensagensComoArray();

}
