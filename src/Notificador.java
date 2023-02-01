import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

public class Notificador implements INotificador{

    private static Notificador instance;
    private String mensagem;

    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private Notificador(){
    }

    public static synchronized Notificador getInstance(){
        if (instance == null)
            instance = new Notificador();

        return instance;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    @Override
    public void adicionarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    @Override
    public String getMensagensComoArray() {
        Iterator<Pessoa> iterator = this.pessoas.iterator();
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter();
        sb.append('{');
        while(iterator.hasNext()){
            Pessoa p = iterator.next();
            sb.append(String.format("\"%s\"=received a message: -> \"%s\"",p.getNome(), this.getMensagem()));
            if(iterator.hasNext()){
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void limparPessoas() {
        this.pessoas.clear();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
