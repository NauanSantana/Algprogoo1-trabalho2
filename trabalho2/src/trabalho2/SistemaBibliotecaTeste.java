package trabalho2;

public class SistemaBibliotecaTeste{

	public static void main(String[] args) {
        System.out.println();

        Biblioteca biblioteca = new Biblioteca();
        String [] autores = {"Diego"};

        System.out.println("============Cadastro Livro============");           
        biblioteca.cadastrarLivro("Livro", "EditoraNome", 2000, autores, 20);
        System.out.println();

         System.out.println("============Cadastro Livro============");           
        biblioteca.cadastrarLivro("Livro", "EditoraNome", 2000, autores, 20);
        System.out.println(); 

        System.out.println("============Cadastro Livro============");           
        biblioteca.cadastrarLivro("texto", "EditoraNome", 30001, autores, 200);
        System.out.println();

        System.out.println("============Imprimir informacoes livros============");           
        biblioteca.imprimeInformacoesLivros();
        System.out.println();

        System.out.println("============Livro cadastro============");
        System.out.println("Livro esta cadastrado " + biblioteca.livroEstaCadastrado(2000));
        System.out.println();

        System.out.println("============Cadastro de Usuario============");
        biblioteca.cadastrarUsuario("Devid M","00000000000","Campo Grande UFMS","1234-1234");
        System.out.println();

        System.out.println("============imprime Informacoes Usuarios============");
        biblioteca.imprimeInformacoesUsuarios();
        System.out.println();

        System.out.println("============ativarUsuario============");
        biblioteca.ativarUsuario("00000000000");
        System.out.println();

        System.out.println("============imprime Informacoes Usuarios============");
        biblioteca.imprimeInformacoesUsuarios();
        System.out.println();

        System.out.println("============desativarUsuario============");
        biblioteca.desativarUsuario("00000000000");
        System.out.println();

        System.out.println("============imprime Informacoes Usuarios============");
        biblioteca.imprimeInformacoesUsuarios();
        System.out.println(); 

        System.out.println("============usuarioEstaCadastrado============");
        System.out.println("usuario esta cadastrado "+biblioteca.usuarioEstaCadastrado("00000000000"));
        System.out.println();

        System.out.println("============imprime Informacoes Usuarios============");
        biblioteca.imprimeInformacoesUsuarios();
        System.out.println();

        System.out.println("============devolverLivro============");           
        biblioteca.devolverLivro(2000, "00000000000");
        System.out.println();

        System.out.println("============Imprimir informacoes livros============");           
        biblioteca.imprimeInformacoesLivros();
        System.out.println();

        System.out.println("============emprestarLivro============");           
        biblioteca.emprestarLivro(2000, "000000");
        System.out.println();

        System.out.println("============emprestarLivro============");           
        biblioteca.emprestarLivro(2000, "00000000000");
        System.out.println();

        System.out.println("============emprestarLivro============");           
        biblioteca.emprestarLivro(30001, "00000000000");
        System.out.println();

        System.out.println("============Imprimir informacoes livros============");           
        biblioteca.imprimeInformacoesLivros();
	}
}