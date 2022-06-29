

import java.util.*;



public class Main {
	

	

	public static void main(String[] args) {
		

		 ProdutoDAO dao = new ProdutoDAO();
		 
		 Produto prod = new Produto();
		 Scanner sc = new Scanner(System.in);
		 
		 
		int opcao;
	     
	     
	     do {
	    	 System.out.println();
	    	 System.out.println("Escolha dentre as ações: 1 - Inserir; 2 - Alterar; 3 - Consultar; 4 - Consultar pelo ID; 5 - Remover; 6 - Sair.");
		      opcao = Integer.parseInt(sc.next());
		      
		      
		      switch(opcao) {
			     case 1:
			    	 
			    	 //aqui eu instancio o scanner só pra descrição pra toda vez vir inicializada e vazia (da erro de interferencia)
			    	 //nextLine pra considerar a próxima linha e capturar todos os dados independente do espaço
			    	 
			    	 Scanner sc1 = new Scanner(System.in);
			    	 System.out.println("Digite a descricao:");
				     String desc = sc1.nextLine();
				     
				     System.out.println("Digite o valor:");				     
				     double valor = sc.nextDouble();
				    
				     
				     System.out.println("Digite a quantidade:");
				     int qtd = sc.nextInt();
				     
			    	 prod.setDesc(desc);
					 prod.setValor(valor);
					 prod.setQtd(qtd);
					 
					 dao.inserir(prod);
					 
					 break;
			     case 2:
			    	 System.out.println("Digite o id que sera alterado:");
				     int id = sc.nextInt();
				     
				     prod.setId(id);

				     if(!dao.buscarOne(prod).isEmpty()) {
				    	 Scanner sc2 = new Scanner(System.in);
				    	 System.out.println("Nova descrição:");
					     String NewDesc = sc2.nextLine();
					     
					     System.out.println("Novo valor:");
					     double NewValor = sc.nextDouble();
					     
					     System.out.println("Nova quantidade:");
					     int NewQtd = sc.nextInt();
					     
					     prod.setDesc(NewDesc);
					     prod.setValor(NewValor);
					     prod.setQtd(NewQtd);
					     prod.setId(id);
					     
					     dao.alterar(prod);
				    	 
				     }

				     break;
			     case 3:
			    	 
			    	 List<Produto>produtos = dao.buscar();
			    	 
			    	 for(Produto p : produtos) {
			    		 System.out.println(p.toString());
			    	 }
			    	 
			    	 dao.buscar();
			    	 break;
			    	 
			     case 4:
			    	 System.out.println("Digite o id que sera buscado:");
				     int idConsultar = sc.nextInt();
				     
				     prod.setId(idConsultar);
			    	 
			    	 System.out.print(dao.buscarOne(prod));

			    	break;
			    	
			     case 5:
			    	 
			    	 System.out.println("Digite o id em que será excluído o produto:");
				     int idRemover = sc.nextInt();
				     
				     prod.setId(idRemover);
				     
				     dao.remover(prod);
				     
			  
			    
			    	 
			     }
		      
		     
	     }while(opcao > 0 && opcao <6);
	     
	    
	    
			


	}
	
	
	
	
	
	 
	 
	
}