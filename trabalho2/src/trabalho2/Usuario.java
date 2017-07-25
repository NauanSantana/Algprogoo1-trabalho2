package trabalho2;

public class Usuario
{

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private boolean ativo;
    private Livro[] livrosEmprestados;

    /**
     * Construtor padrao da classe.
     *
     * @param cpf recebe o cpf do usuario
     * @param endereco recebe o endereco do usuario
     * @param nome recebe o nome do usuario
     * @param telefone recebera o telefone do usuario
     *
     */
    public Usuario(String nome, String cpf, String endereco, String telefone)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;

        setAtivo(true);
        livrosEmprestados = new Livro[3]; //Quatidade maxima de emprestimo de livro

    }

    /**
     * Metodo fara a impressao das informacoes do usuario no console (terminal)
     */
    public void imprimelnformacoesUsuario()
    {

        System.out.println("lnformacoes do Usuario");
        System.out.printf("Nome do usuario: %S.\n", getNome());
        System.out.printf("Numero do CPF: %S.\n", getCpf());
        System.out.printf("Endereco do usuario: %S.\n", getEndereco());
        System.out.printf("Numero do telefone: %S.\n", getTelefone());

        if (getAtivo())
            System.out.println("O cadastro esta ativo");
        else
            System.out.println("O cadastro nao esta ativo");
    }

    /**
     * Metodo que fara o emprestimo do livro para o usuario
     *
     * @param livro define o livro que sera emprestado
     * @return retornara um booleano dizendo se foi possivel(true) ou nao
     * (false) emprestar o livro
     */
    public boolean emprestaLivro(Livro livro)
    {
        boolean foiPossivelEmprestar = false;
        for (int i = 0; i < livrosEmprestados.length; i++) {
            if (livrosEmprestados[i] == null) {
                livrosEmprestados[i] = livro;
                foiPossivelEmprestar = true;
                break;
            }
        }
        return foiPossivelEmprestar;
    }

    /**
     * Metodo devolvera o livro que foi emprestado para o usuario
     *
     * @param codLivro define o codigo do livro que sera devolvido
     * @return retorna um booleano dizendo se foi possivel devolver(true) ou
     * nao(false) o livro
     */
    public boolean devolverLivro(int codLivro)
    {
        for (int i = 0; i < livrosEmprestados.length; i++) {
            if (livrosEmprestados[i].getCodigoLivro() == codLivro) {
                livrosEmprestados[i] = null;
                return true;
            }
        }
        return false;
    }

    /*
	Pré-condicoes: O atributo LivrosEmprestados deve ter valores associados
	Pos-condicoes: Imprime na tela as informações de todos os livros emprestados ao usuário  atualmente.
				   Caso não haja livros emprestados ao usuário, deve imprimir umamensagem informando isso.
     */
    public void listaLivrosEmprestados()
    {
        boolean pegouLivro = false;

        for (int i = 0; i < livrosEmprestados.length; i++) {
            if (livrosEmprestados[i] != null && !livrosEmprestados[i].getDisponivelParaEmprestimo()) {
                livrosEmprestados[i].imprimeInformacoesLivro();
                pegouLivro = true;
            }
        }

        if (!pegouLivro) {
            System.out.println("O usuario nao pegou nenhum livro");
        }
    }

    //Metodos GETS e SETS
    public String getNome()
    {
        return nome;
    }

    public String getCpf()
    {
        return cpf;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public boolean getAtivo()
    {
        return ativo;
    }

    public void setAtivo(boolean estaAtivo)
    {
        this.ativo = estaAtivo;
    }

    public Livro[] getLivrosEmprestados()
    {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(Livro[] livrosEmprestados)
    {
        this.livrosEmprestados = livrosEmprestados;
    }
}
