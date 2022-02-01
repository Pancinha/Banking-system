import javax.swing.JOptionPane; import javax.swing.ImageIcon; import java.util.Arrays; public class Trabalho2 {

static int i, j;
static int a=0, b=0;
static int lin_maior = 0;
static int col_maior = 0;
static String nome;
static final Correntista correntista[][]= new Correntista[3][3];
static Double saldos[][]= new Double[3][3];
static {saldos[0][0]=0.0;
	saldos[0][1]=0.0;
	saldos[0][2]=0.0;
	saldos[1][0]=0.0;
	saldos[1][1]=0.0;
	saldos[1][2]=0.0;
	saldos[2][0]=0.0;
	saldos[2][1]=0.0;
	saldos[2][2]=0.0;
}	

static class Correntista {
	String nome;
	int conta;
}

public static void main(String[] args) {

	int conta;
	double resultado, recebimento, pagamento, maior_g;
	String auxiliar;

	int opção=1;
	while(opção>0 && opção<4){
		int menu;
		menu=Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma opção:\n\n 1 - Recebimento\n"
			+" 2 - Pagamento\n"
			+" 3 - Todas as contas, correntistas e saldos\n"
			+" 4 - Correntista mais rico\n"
			+" 5 - Todos os saldos ordenados em ordem crescente\n"
			+" 6 - Sair", "BEM VINDO!", 2));

		switch(menu){
			case 1:
				
				conta =Integer.parseInt(JOptionPane.showInputDialog("Qual o número de sua conta ?" , "Digite aqui:"));
				recebimento= Integer.parseInt(JOptionPane.showInputDialog("Quanto você deseja depositar?", "Digite aqui:"));
		
				resultado = recebimento(conta,recebimento);
				
				JOptionPane.showMessageDialog(null,""+nome+" seu saldo é de : "+resultado);
			
				opção=3;
				break;
				
			
			case 2:
				
				conta =Integer.parseInt(JOptionPane.showInputDialog("Qual o número de sua conta" ,"Digite aqui:"));
				pagamento = Integer.parseInt(JOptionPane.showInputDialog("Quanto você deseja sacar?" , "Digite aqui:"));
				
				resultado =pagamento(conta, pagamento);
				
				JOptionPane.showMessageDialog(null,""+nome +"seu saldo atual é de: " +resultado);

				opção=3;
				break;
			
			case 3:
				
				auxiliar = tdscontas();
				
				JOptionPane.showMessageDialog(null,""+auxiliar);
				
				opção=3;
				break;
				
			
			case 4:
				
				 maior_g=maisRico();
				
				JOptionPane.showMessageDialog(null, " \n Mais rico: "
					+ correntista[a][b].nome +
					"\n Saldo:"+
					+maior_g + 
					"\n Conta:"
					+correntista[a][b].conta);
				
				opção=3;
				break;
				

			
			case 5:
				bubble();
				
				opção=3;
				break;
				

			case 6:
				sair();
				
				opção=0;
		}
	}	
}



public static void submatriz(){
	
	for (i=0;i<3 ;i++ ) {
		for (j=0;j<3 ;j++ ) {
			correntista[i][j]= new Correntista();
		}
	}

	correntista[0][0].nome = "Tibúrcio";	
	correntista[0][0].conta=111;
	correntista[0][1].nome= "Ricardo";
	correntista[0][1].conta=222;
	correntista[0][2].nome= "João";		
	correntista[0][2].conta=333;
	correntista[1][0].nome= "Felisbino";		
	correntista[1][0].conta=444;									
	correntista[1][1].nome= "Seu Zé";
	correntista[1][1].conta=555;
	correntista[1][2].nome= "Dona Maria";		
	correntista[1][2].conta=666;
	correntista[2][0].nome= "Gedonstrocio";		
	correntista[2][0].conta=777;
	correntista[2][1].nome = "Batman";
	correntista[2][1].conta=888;
	correntista[2][2].nome="Homem de ferro";	
	correntista[2][2].conta=999;	
}





/*1 – Inserir Recebimento (+): Solicite ao usuário o número da conta e depois o valor. Some o
recebimento ao saldo da conta deste usuário e depois mostre o saldo desta pessoa usando o
seguinte formato: “(CORRENTISTA) seu saldo atual é de: ”+ SALDO.*/
public static double recebimento(int a, double b){
	submatriz();
	double resul;
	
	resul =0.0;
	for (i=0;i<3 ;i++ ) {
		for (j=0;j<3 ;j++ ) {
			if (correntista[i][j].conta == a){						
				saldos[i][j]= saldos[i][j] + b;
				nome= correntista[i][j].nome;
				resul = saldos[i][j];									
			}
		}
	}
	return resul;		
}




/*2 – Inserir Pagamento (-): Solicite ao usuário o número da conta e depois o valor. Subtraia o
pagamento do salto atual e depois mostre o novo saldo desta pessoa usando o seguinte
formato: “(CORRENTISTA) seu saldo atual é de: ”+ SALDO.*/	
public static double pagamento(int a, double b){
	submatriz();
	
	double resul;
	resul=0.0;
	for (i=0;i<3 ;i++ ) {
		for (j=0;j<3 ;j++ ) {
			if (correntista[i][j].conta==a) {
				saldos[i][j]= saldos[i][j] - b;
				nome= correntista[i][j].nome;						
				resul= saldos[i][j];	
			}
		}
	}	
	return resul;
}



//3 – Mostre em apenas uma mensagem todos os Números de Conta, Correntistas e Saldos respectivos.
public static String tdscontas(){
	submatriz();
	
	String aux;
	aux="";
	for (i=0;i<3 ;i++ ) {
		for (j=0;j<3 ;j++ ) {
			aux += correntista[i][j].nome+" - "						
			+correntista[i][j].conta+" - "
			+saldos[i][j]+"\n";					
		}					
	}
	return aux;		
}




/*4 – Mostre em apenas uma mensagem o Número da Conta, o Nome do Correntista e o saldo
do correntista mais RICO.*/
public static double maisRico(){
	submatriz();

	double maior_g=0.0;
	for(i=0; i<3; i++){
		for (j=0; j<3; j++){
			if (saldos[i][j] > maior_g){
				maior_g = saldos[i][j];
				//passagem por referência								
				lin_maior = i;
				col_maior = j;
				a=i;
				b=j;	              
			}
		}
	}
	return maior_g;		
}




/*5 – Mostre em apenas uma mensagem todos os saldos ordenados do menor para o maior.
Para isso coloque todos os saldos dentro de um vetor e ordene usando BubbleSort.*/
public static void bubble(){
	submatriz();

	int troca, tamanho;
	double vetor[]= new double[9];
	tamanho = 0;
	for (i=0;i<3 ;i++ ) {
		for (j=0;j<3 ;j++) {
			vetor[tamanho] = saldos[i][j];
			tamanho++;					
		}				
	}			

	int troca2, fim, tamanho2;										
	double aux65;
	tamanho2=9;			
	troca2 = 1;
	fim = tamanho2- 1;
	
	while(troca2==1){
		troca2 = 0;
		for(i=0; i<fim;i++){
			if (vetor[i] > vetor[i+1]){
				aux65 = vetor[i];
				vetor[i] = vetor[i+1];
				vetor[i+1]=aux65;
				troca2 = 1;
			}
		}
		fim = fim - 1;
	}
	JOptionPane.showMessageDialog(null, Arrays.toString(vetor));
}




//Sair
public static void sair(){
	ImageIcon icon = new ImageIcon("/home/rafael/Downloads/cachorro.jpg");
	JOptionPane.showMessageDialog(null,"Isto é uma Função!!!\n"+"Até Logo!  ;) " , "Algoritmos ||", JOptionPane.INFORMATION_MESSAGE, icon);					
	
	System.exit(0);
}