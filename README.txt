
CASO DE USO 1

Liberar Sistema:
	Para libera��o do sistema criou-se um m�todo que recebe tr�s par�metros do tipo String,  verifica se o sistema j� foi liberado anteriormente ou n�o, por meio de uma vari�vel �boolean�, verifica se as chaves coincidem e, caso coincidam, � delegado ent�o a classe �BancoFuncionarios� (respons�vel por toda manipula��o e armazenamento dos objetos relacionados a funcion�rio) a cria��o da primeira conta, recebendo como par�metros nome e data de nascimento e retornando uma String correspondente a matricula da conta gerada, o �boolean� de libera��o do sistema � ent�o alterado para o estado �true� e a matricula � retornada pelo m�todo.

Realizar Login:
	Para a realiza��o do login,  foi criado uma vari�vel do tipo Funcion�rio na classe �Controller� que depende do m�todo �realizaLogin� para ser instanciada,este por sua vez recebe como par�metros duas Strings (matricula e senha) e delega a responsabilidade de validar o usu�rio para a classe BancoFuncionarios, que caso n�o seja validada lan�a uma exce��o do tipo �ControllerException� caso n�o seja encontrado a matricula referente a um usu�rio nos dados ou a senha n�o corresponda a matricula. Caso seja validada , ent�o � verificado se j� existe algu�m logado por meio do m�todo �verificaLogin� que tamb�m lan�a uma exce��o do tipo �ControllerException� caso j� exista algu�m logado.Caso n�o exista.  ent�o � delegado novamente um m�todo a classe �BancoFuncionarios� para associar a referencia do vari�vel do tipo Funcion�rio ao objeto presente nos dados que corresponda a matricula e senha fornecidas.

Cadastro de funcion�rios:
	Para essa fun��o foi criado um m�todo que recebe como par�metros  nome, cargo do funcion�rio a ser criado e data de nascimento , Ent�o por meio de uma estrutura condicional  � chamado um m�todo que verifica se o usu�rio que est� logado possui em sua lista  do tipo  �Permiss�es� o �Enum� referente a permiss�o de cadastro, caso n�o possua, � lan�ada uma exce��o do tipo �ControllerException�. Caso ele possua a permiss�o, ent�o � feito uma verifica��o para  garantir que o novo funcion�rio a ser criado n�o seja do tipo �Diretor� ou  um cargo inv�lido.Passado essas verifica��es , um novamente � delegado a um m�todo da  classe �BancoFuncion�rios� para a cria��o do novo funcion�rio com nome, cargo e data de nascimento, caso algum parametro seja inv�lido, � lan�ada uma exce��o do tipo �FuncionarioException �ou �DataInvalidaException�(ambas abaixo de ControllerException em hierarquia). Esse m�todo retorna a matricula referente ao novo funcion�rio cadastrado que por sua vez, � retornada novamente pelo m�todo de �cadastraFuncion�rios� do �Controller�. 
	Quando um funcion�rio � criado,  em seu construtor n�o abstrato, � chamado um m�todo sobrescrito que define no seu atributo �listadepermissoes�, justificando o uso de heran�a nesse caso(Pois todos os funcion�rios compartilham de mesmos estados porem o comportamento desse m�todo � distinto pra cada um deles).

CASO DE USO 2
	Para a atualiza��o de informa��es de funcion�rios, criou-se um m�todo que recebe a matr�cula do usu�rio (cuja verifica��o ser� realizada), o atributo a ser alterado e o novo valor. O sistema ent�o verificar� se o atributo � v�lido (pela implementa��o de um switch)  e a partir disso, delegar� para a classe Banco de Funcion�rios, que por sua vez realizar� a altera��o. Exce��es ser�o lan�adas caso a matr�cula n�o corresponda � nenhum funcion�rio ou caso o atributo seja inv�lido. 
Para a altera��o da senha, o sistema far� uma verifica��o da senha antiga e outra com a nova (se corresponde aos requisitos de tamanho e caracteres) e ent�o, ocorrer� a altera��o. Tal altera��o poder� ser realizada pela matr�cula (apenas se o usu�rio logado for o Diretor Geral) ou apenas para o usu�rio em si. Caso alguma verifica��o, seja da senha antiga ou da nova n�o passar, o sistema lan�ar� exce��o do tipo �FuncionarioException�. As verifica��es mais gen�ricas, como nome, senha, data, etc. s�o todas realizadas numa classe Util, cujos m�todos s�o utilizados no Controller, antes da delega��o para outras classes.

CASO DE USO 3
	
Cadastro de Pacientes:
	Para o cadastro de pacientes, foi elaborado um m�todo que recebe como par�metro as informa��es do paciente. Ent�o, por meio de uma estrutura condicional, � chamado um m�todo de verifica��o do Objeto Funcion�rio para verificar se ele possui ou n�o permiss�o para realizar tal fun��o. Caso n�o possua, � lan�ada uma exce��o do tipo �ControllerException�, caso possua, ent�o s�o feitos os m�todos de verifica��o dos par�metros fornecidos, para evitar o uso de par�metros inv�lidos. Caso algum par�metro desse seja inv�lido, ent�o ser�o lan�adas exce��es do tipo �PacienteException�  ou �DataInvalidaException� (ambos herdam de �ControllerException� na hierarquia). Passado os par�metros, ocorre ent�o uma delega��o para um m�todo da classe �BancoPacientes� (respons�vel por gerenciar manipular e armazenar tudo relacionado ao Objeto Pacientes). Esse m�todo cria um novo objeto do tipo paciente armazena o mesmo na estrutura de dados e retorna uma string referente a id do paciente criado, que por sua vez ser� retornada tamb�m pelo m�todo do �Controller�.

Cria��o  e ordena��o de Prontu�rios:
	Ao ser criado um novo paciente, automaticamente � gerado um prontuario com as informa��es do mesmo. Isso ocorre pois dentro do m�todo de constru��o do objeto paciente, � instanciado no atributo prontuario do tipo �Prontuario� um novo Objeto desse tipo, recebendo como par�metro todas as informa��es referentes ao paciente criado. 
Como se faz necess�ria a ordena��o dos prontu�rios em ordem alfab�tica, foi ent�o implementado o m�todo �compareTo� que compara os nomes entre dois prontuarios de pacientes distintos, assim sendo poss�vel aplicar o m�todo �Sort� pertencente ao �Collections�.

CASO DE USO 4	

	Foi criada uma classe Farm�cia, que encapsularia os m�todos e a cole��o (ArrayList) de medicamentos. A factory de medicamentos tamb�m foi implementada para a cria��o de medicamentos. O design de heran�a foi utilizado para a cria��o dos Medicamentos. O Medicamento Gen�rico cont�m todos os m�todos (com um getPreco que retorna o pre�o com o desconto de 40%) e o Medicamento de Refer�ncia herda de Gen�rico, fazendo uma sobrescrita nos m�todos getTipo e getPreco (que retorna o pre�o integral). Foi criado um enum para as categorias, que ser� usado para a verifica��o de validade em m�todos de acesso e altera��o. Como as categorias v�m separadas por v�rgula, criou-se um m�todo que faria a separa��o e por fim, a adi��o das categorias � um atributo do tipo String (para facilitar tanto para verificar se o medicamento pertencia a uma categoria, usando o contains, quanto para o retorno, visto que j� estaria no formato especificado). 
Para a busca de medicamentos por categoria, a Farm�cia primeiramente verifica se a categoria � valida e a partir disso cria uma nova String adicionando os medicamentos continham cuja categoria, separando-os por v�rgula. Para a busca por nome, o procedimento � semelhante. Ambos os m�todos de busca, caso n�o encontrem um medicamento que n�o corresponda ao atributo pesquisado, lan�am uma exce��o do tipo �Medicamento Exception�. Em rela��o � ordena��o, usou-se um construtor do Collections.sort que recebia um Comparator, possibilitando, assim, ordena��es distintas.

CASO DE USO 5

	Foi criado um Banco de �rg�os, semelhante ao Banco de Funcion�rios e Medicamentos, com uma cole��o (ArrayList) de objetos do tipo �rg�o. Antes da cria��o do �rg�o em sua factory correspondente, tamb�m � feita uma verifica��o de validade do tipo Sangu�neo, tamb�m usado em para pacientes (dessa forma, o m�todo verificador se encontra na classe Util). O Banco de �rg�os cont�m m�todos de busca por nome e tipo sangu�neo, que lan�am exce��es do tipo �Org�oException�, caso o �rg�o buscado n�o esteja cadastrado. 

CASO DE USO 6

Realiza��o de procedimentos:
Para suprir a especifica��o desse caso,  foram criados 3 m�todos no Controller com assinaturas distintas (todos com mesmo nome, por�m assinaturas diferentes): 

> Um para Procedimentos como Cirurgia Bari�trica e Redesigna��o Sexual (Procedimento, Id do paciente,  Medicamentos);
> Um para consultas cl�nicas (Procedimento, id do paciente);
> Um para transplante de �rg�os (Procedimento, Id do paciente, �rg�o, Medicamentos).

	Embora distintos, seus comportamentos na classe �Controller� eram bem semelhantes, todos verificam se o usu�rio logado possui permiss�o ou n�o por meio de uma estrutura condicional que chama um m�todo de verifica��o j� mencionado em alguns casos anteriores. Caso ele possua permiss�o,  ent�o s�o chamados os m�todos de verifica��o de procedimento e id do paciente para evitar dados inv�lidos (essas verifica��es s�o feitas pela classe Util). No caso do procedimento transplante de �rg�os, al�m desses m�todos de verifica��o , tamb�m � verificado se o nome do �rg�o � v�lido.
Feitas as verifica��es, os procedimentos de consulta cirurgia bari�trica e redesigna��o sexual delegam a classe �BancoPacientes� a fun��o de realizar o procedimento passando como par�metros o procedimento, o id do paciente e o nome do medico que esta realizando o procedimento.
Esse m�todo por sua vez analisa o tipo de procedimento e faz a instancia do Objeto do tipo �Iprocedimento� (Interface) de acordo com o tipo de procedimento (podendo ele ser do tipo das classes CirurgiaBariatrica, ConsultaClinica, Redesigna��o Sexual ou Transplante de �rg�os) que possuem o mesmo m�todo sobrescrito com comportamentos diferentes (polimorfismo), tal estilo foi adotado por n�o haver a necessidade de um alto acoplamento e reuso dos estados de cada um, mas existir a necessidade de sobrescrita de um m�todo.
	Enquanto o procedimento de transplante de �rg�os ir� verificar ainda se existe �rg�o dispon�vel compat�vel com o tipo sangu�neo do paciente , por meio de uma estrutura condicional  que lan�a �OrgaoException� caso n�o possua �rg�os compat�veis.

CASO DE USO 7

	Para o cart�o, foi criada uma interface �CartaoFidelidade�, que cont�m os m�todos:
	> Adicionar pontos;
	> Aplicar desconto;
	> GetPontosCart�o; 

	E as classes Padr�o, Master e Vip, ambas implementando a interface e sobrecarregando os m�todos da mesma (possibilitando o polimorfismo). Na classe paciente foi adicionado um atributo do tipo CartaoFidelidade que seria associado ao tipo de fidelidade atual do paciente. Tal atributo foi implementado para que mude dinamicamente, aplicando o conceito de Strategy. Ao realizar quaisquer procedimentos, ocorre uma verifica��o que, caso necess�rio, altera o tipo de fidelidade. Assim, os m�todos de pontos e de desconto se comportar�o de acordo com a fidelidade do paciente.
	As chamadas polim�rficas ocorrem quando o paciente chama algum m�todo da classe instanciada no atributo CartaoFidelidade.

CASO DE USO 8

Para gravar os dados dos prontu�rios de forma persistente, foi criado um m�todo �exportaFichaPaciente�  que recebe como par�metro o Id do paciente e apenas delega a fun��o � classe �BancoPaciente�. Esta, por sua vez, instancia o objeto referente ao Id fornecido e usa um m�todo pr�prio do Objeto Paciente �registrarInformacoesEmArquivo� que define o caminho e o nome do arquivo a ser gerado e instancia uma �Stream� do tipo �FileWriter� usando caminho como par�metro. Este ent�o  � usado como par�metro para instanciar o buffer , da� usa-se o m�todo �buffer.write� usando o m�todo sobrescrito �toString� como par�metro.

CASO DE USO 9
	Para salvar o estado do sistema de forma persistente e recuper�-lo ao reutilizar o mesmo, foram gerados dois m�todos:

	> InicializaSistema: na pr�pria �Facade� que tenta ler os dados de um arquivo �SOOS.dat� por meio da stream �ObjectInputReader� e instancia como um objeto do tipo �Controller�.
	> FechaSistema: que verifica se n�o h� mais ningu�m logado e caso n�o tenha, escreve um arquivo do tipo �Controller� com o nome �SOOS.dat�.