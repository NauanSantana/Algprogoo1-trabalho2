package trabalho2;

public class Biblioteca
{

    private Usuario[] usuarios;
    private Livro[] livros;

    /**
     * Construtor padrao da classe
     */
    
    public Biblioteca()
    {
        usuarios = new Usuario[30];
        livros = new Livro[50];
    }

    /**
     * Metodo fara o cadastro dos livros de acordo com a capacidade biblioteca
     *
     * @param autores define a lista de autores do livro
     * @param codigo define op codigo do livro
     * @param editora define a editora do livro
     * @param nome define o nome do livro
     * @param paginas define a quantia de paginas do livro
     * @return retorna um valor boolean que referese a se o livro foi cadastrado
     * (true) ou nao (false)
     */
    public boolean cadastrarLivro(String nome, String editora, int codigo, String[] autores, int paginas)
    {
        boolean foiCadastrado = false;
        boolean jaEstaCadastrato = false;

        for (int i = 0; i < livros.length && livros[i] != null; i++) {
            if (livros[i].getCodigoLivro() == codigo) {
                jaEstaCadastrato = true;
                break;
            }
        }
        for (int i = 0; i < livros.length && !jaEstaCadastrato; i++) {
            if (livros[i] == null) {
                livros[i] = new Livro(nome, editora, codigo, autores, paginas);
                foiCadastrado = true;
                break;
            }
        }

        if (foiCadastrado) {
            System.out.println("Cadastro foi realizado com sucesso.");
        } else {
            System.out.println("Cadastro nao foi realizado com sucesso.");
        }

        return foiCadastrado;
    }

    /**
     * Fara o cadastro o emprestimo dos livros caso o livro esteja cadastrado e
     * o usuario seja valido.
     *
     * @param codigoLivro define o codigo do livro
     * @param cpfUsuario define o cpf do usuario que ira pegar o livro
     * @return retorna um valor booleano que dira se o imprestimo foi realizado
     * com sucesso(true) ou nao (false)
     */
    public boolean emprestarLivro(int codigoLivro, String cpfUsuario)
    {
        boolean livroCadastrado = false;
        boolean usuarioCadastrado = false;
        boolean livroPodeSerEmprestado = false;
        boolean foiPossivelEmprestar = false;
        Livro livroEmprestar = null;
        Usuario nomeUsuario = null;

        //Verifica se o livro, portador do codigo fornecido no parametro esta cadastrado e se esta disponivel para emprestimo
        for (int i = 0; i < livros.length && livros[i] != null; i++) {
            if (livros[i].getCodigoLivro() == codigoLivro) {
                livroCadastrado = true;
                livroPodeSerEmprestado = livros[i].getDisponivelParaEmprestimo();
                livroEmprestar = livros[i];
                break;
            }
        }

        //Verifica se o usuario, portador do CPF fornecido no parametro esta cadastrado
        for (int i = 0; i < usuarios.length && usuarios[i] != null; i++) {
            if (usuarios[i].getCpf().equals(cpfUsuario)) {
                usuarioCadastrado = true;
                nomeUsuario = usuarios[i];
                break;
            }
        }

        //Verifica se o  usuario ja atingiu o limite de emprestimo
        if (livroCadastrado && usuarioCadastrado && livroPodeSerEmprestado) {
            if (nomeUsuario.getCpf().equals(cpfUsuario)) {
                foiPossivelEmprestar = nomeUsuario.emprestaLivro(livroEmprestar);
            }
        }

        return foiPossivelEmprestar;
    }

    
    
    
    /**
     * Metodo que devolvera o livro
     */
    public boolean devolverLivro(int codigoLivro, String cpfUsuario)
    {
        boolean livroCadastrado = false, usuarioCadastrado = false, foiEmprestado = false;
        Livro livroEmprestado = null;
        Usuario nomeUsuario = null;

        //Verifica se o usuario, portador do CPF fornecido no parametro esta cadastrado
        for (int i = 0; i < usuarios.length && usuarios[i] != null; i++) {
            if (usuarios[i].getCpf().equals(cpfUsuario)) {
                usuarioCadastrado = true;
                nomeUsuario = usuarios[i];
                break;
            }
        }

        //Verifica se o livro, portador do codigo fornecido no parametro esta cadastrado
        for (int i = 0; i < livros.length && livros[i] != null && usuarioCadastrado; i++) {
            if (livros[i].getCodigoLivro() == codigoLivro) {
                livroCadastrado = true;
                livroEmprestado = livros[i];
            }
        }
        
        //verifica se o usuario pegou o livro
        for (int i = 0; i < nomeUsuario.getLivrosEmprestados().length && livroCadastrado && nomeUsuario.getLivrosEmprestados()[i] != null; i++) {
            if (nomeUsuario.getLivrosEmprestados()[i].getCodigoLivro() == livroEmprestado.getCodigoLivro())
                foiEmprestado = true;
        }

        //Verifica se o  usuario pegou emprestado o livro do codigo fornecido como parametro
        if (livroCadastrado && usuarioCadastrado && foiEmprestado) {
            if (livroEmprestado.getCodigoLivro() == codigoLivro) {
                livroEmprestado.setDisponivelParaEmprestimo(true);
                nomeUsuario.devolverLivro( livroEmprestado.getCodigoLivro());
                System.out.println("Devolvido com sucesso");
            }
        } else {
            System.out.println("Nao foi devolvido com sucesso");
        }

        return livroCadastrado && usuarioCadastrado && foiEmprestado;
    }

    /*
	Pré-condicoes: Deve receber como parametro o codigo de um livro
	Pos-condicoes: Retornar true caso o livro esteja cadastrado na biblioteca ou false em caso contrario
     */
    public boolean livroEstaCadastrado(int codigo)
    {
        boolean foiCadastrado = false;

        for (int i = 0; i < livros.length && livros[i] != null; i++) {
            if (livros[i].getCodigoLivro() == codigo) {
                foiCadastrado = true;
            }
        }

        return foiCadastrado;
    }

    /*
	Pré-condicoes: As variáveis de instancia devem ter valores associados
	Pos-condicoes: Os dados sao organizados na ordem alfabetica de acordo com o nome do livro 
				   e os atributos sao exibidos
     */
    public void imprimeInformacoesLivros()
    {
        Livro aux;
        for (int i = 0; i < livros.length - 1; i++) {
            for (int j = i + 1; j < livros.length; j++) {

                //Organiza o vetor livros na ordem alfabética do nome do livro
                if (livros[i] != null && livros[j] != null) {
                    if (livros[i].getNomeLivro().trim().toUpperCase().compareTo(livros[j].getNomeLivro().trim().toUpperCase()) > 0) {
                        aux = livros[i];
                        livros[i] = livros[j];
                        livros[j] = aux;
                    }
                }
            }
        }

        //Exibi na tela os dados armazenados nas variáveis de instancia da classe Livro de acordo com o livro.
        for (int i = 0; i < livros.length && livros[i] != null; i++) {
            livros[i].imprimeInformacoesLivro();
        }
    }

    /*
	Pré-condicoes:Deve receber como parametros nome , numero do CPF, endereco e o telefone.
	Pos-condicoes: Retornar true caso o usuario tenha sido cadastrado com sucesso ou false caso a capacidade da biblioteca não 
		       permita um novo usuario. Exibi na uma mensagem informando se o cadastro foi realizado com sucesso ou nao.
     */
    public boolean cadastrarUsuario(String nome, String cpf, String endereco, String telefone)
    {
        boolean cadastroRealizado = false, usuarioJaEstaCadastrado = false;

        for (int i = 0; i < usuarios.length && !usuarioJaEstaCadastrado && usuarios[i] != null; i++) {
            if (usuarios[i].getCpf() != cpf) {
                usuarioJaEstaCadastrado = true;
                break;
            }
        }
        for (int i = 0; i < usuarios.length && !usuarioJaEstaCadastrado; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = new Usuario(nome, cpf, endereco, telefone);
                cadastroRealizado = true;
                break;
            }
        }

        if (cadastroRealizado)
            System.out.println("Cadastro foi realizado com sucesso.");
        else
            System.out.println("Cadastro nao foi realizado com sucesso.");

        return cadastroRealizado;
    }

    /*
	Pré-condicoes: Deve receber como parametro o numero do CPF do usuario a ser ativado.
	Pos-condicoes:
     */
    public void ativarUsuario(String cpf)
    {
        for (int i = 0; i < usuarios.length && usuarios[i] != null; i++) {
            if (usuarios[i].getCpf().equalsIgnoreCase(cpf) && usuarios[i] != null) {
                usuarios[i].setAtivo(true);
            }
        }
    }

    /*
	Pré-condicoes: Deve receber como parametro o numero do CPF do usuario a ser ativado.
	Pos-condicoes:
     */
    public void desativarUsuario(String cpf)
    {
        for (int i = 0; i < usuarios.length && usuarios[i] != null; i++) {
            if (usuarios[i].getCpf().equalsIgnoreCase(cpf) && usuarios[i] != null) {
                usuarios[i].setAtivo(false);
            }
        }
    }

    /*
	Pré-condicoes: Deve receber como parametro o CPF de um usuario
	Pos-condicoes: Retornar true caso o usuario esteja cadastrado na biblioteca ou false em caso contrario
     */
    public boolean usuarioEstaCadastrado(String cpf)
    {
        boolean estaCadastrado = false;

        for (int i = 0; i < usuarios.length && usuarios[i] != null; i++) {
            if (usuarios[i].getCpf().equalsIgnoreCase(cpf) && usuarios[i] != null) {
                estaCadastrado = true;
            }
        }
        return estaCadastrado;
    }

    /*
	Pré-condicoes: As variáveis de instancia devem ter valores associados
	Pos-condicoes: Os dados sao organizados na ordem alfabetica de acordo com o nome do usuario e os atributos sao exibidos
     */
    public void imprimeInformacoesUsuarios()
    {
        Usuario aux;

        //Organiza o vetor usuarios na ordem alfabética do nome do usuario
        for (int i = 0; i < (usuarios.length - 1); i++) {
            for (int j = (i + 1); j < usuarios.length; j++) {
                if (usuarios[i] != null && usuarios[j] != null) {
                    if (usuarios[i].getNome().trim().toUpperCase().compareTo(usuarios[j].getNome().trim().toUpperCase()) > 0) {
                        aux = usuarios[i];
                        usuarios[i] = usuarios[j];
                        usuarios[j] = aux;
                    }
                }
            }
        }

        //Exibi na tela os dados armazenados nas variáveis de instancia da classe Usuario de acordo com o usuario.
        for (int i = 0; i < usuarios.length && usuarios[i] != null; i++) {
            usuarios[i].imprimelnformacoesUsuario();
        }
    }
}
