package trabalho2;

public class Livro
{

    private String nomeLivro;
    private String editoraLivro;
    private int codigoLivro;
    private String[] autoresLivro;
    private int numeroPaginas;
    private boolean disponivelParaEmprestimo;

    /**
     * Construtor padrao da classe.
     *
     * @param autores define a lista de autores
     * @param codigo recebe o codigo do livro
     * @param editora recebe o nome da editora
     * @param nome recebe o nome do livro
     * @param paginas recebe a quantia de paginas
     */
    public Livro(String nome, String editora, int codigo, String[] autores, int paginas)
    {
        this.nomeLivro = nome;
        this.editoraLivro = editora;
        this.codigoLivro = codigo;
        this.autoresLivro = autores;
        this.numeroPaginas = paginas;

        setDisponivelParaEmprestimo(true);
    }

    /**
     * Metodo fara a impressao das informacoes do livro no console (terminal)
     */
    public void imprimeInformacoesLivro()
    {

        System.out.printf("Nome livro: %S.\n", getNomeLivro());
        System.out.printf("Editora do livro: %S.\n", getEditoraLivro());
        System.out.printf("Codigo do livro: %S.\n", getCodigoLivro());

        //So exibira na tela o conteudo do indice (nome do autor) se for diferente de null
        for (int i = 0; i < autoresLivro.length; i++) {
            if (autoresLivro[i] != null && autoresLivro[i] != "") {
                System.out.printf("Autor(a) %S.\n", autoresLivro[i]);
            }
        }

        System.out.printf("Numero de paginas: %S.\n", getNumeroPaginas());

        if (getDisponivelParaEmprestimo())
            System.out.println("O livro esta disponivel para emprestimo");
        else
            System.out.println("O livro nao esta disponivel para emprestimo");
    }

    /**
     * GETS and SETS
     */
    public boolean getDisponivelParaEmprestimo()
    {
        return disponivelParaEmprestimo;
    }

    public String getNomeLivro()
    {
        return nomeLivro;
    }

    public String getEditoraLivro()
    {
        return editoraLivro;
    }

    public int getCodigoLivro()
    {
        return codigoLivro;
    }

    public String[] getAutoresLivro()
    {
        return autoresLivro;
    }

    public int getNumeroPaginas()
    {
        return numeroPaginas;
    }

    public void setDisponivelParaEmprestimo(boolean disponibilidade)
    {
        this.disponivelParaEmprestimo = disponibilidade;

    }
}
