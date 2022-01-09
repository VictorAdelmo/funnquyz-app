package com.example.yeah.methods;

import android.os.CountDownTimer;

public class Perguntas {

    private long tempoZerado;
    static final private int QUIZ_COUNT = 7;
    private static final long COUNT_DOWN_IN_MILLIS = 20000;
    private CountDownTimer countDownTimer;
    private boolean CountRun;

    public String[][] perguntasData(){
        //Pergunta,QuestaoCerta,Questao1,Questao2,Questao3
        String quizData[][] = {
                //Ciencias
                {"Qual o líquido encontrado em maior quantidade em nosso suor?",
                        "Água",
                        "Liquido amniótico",
                        "Sangue",
                        "Ar"},

                {"Em que órgão do aparelho reprodutor feminino o feto se desenvolve ?",
                        "No útero ",
                        "Na tuba uterina",
                        "Na vagina",
                        "No ovário"},

                {"O único crustáceo terrestre é o:",
                        "Tatuzinho de Jardim ",
                        "Camarão",
                        "Siri",
                        "Caranguejo"},

                {"Qual desses animais não vivem em grupos?",
                        "Tigre",
                        "Leão",
                        "Elefante",
                        "Zebra"},

                {"Como é chamada toda substância que pode queimar?",
                        "Combustível",
                        "Queimável",
                        "Queimante",
                        "Comburente"},

                {"Nos seres humanos qual órgão serve aos Sistemas Digestório e Respiratório?",
                        "Laringe",
                        "Faringe",
                        "Estômago",
                        "Pulmão"},

                {"Um escurecimento completo pode ser chamado de:",
                        "Blecaute",
                        "Paralisia",
                        "Pênalti",
                        "Gafieira"},

                {"Qual dessas ligações não é química?",
                        "Ligação DDD",
                        "Ligação covalente",
                        "Ligação iônica",
                        "Ligação sigma"},

                {"Que nome recebe o solo rico em matéria orgânica?",
                        "Humífero ",
                        "Argiloso",
                        "Arenoso",
                        "Impermeável"},

                {"O bronze é uma liga metálica constituída?",
                        "Estanho e cobre ",
                        "Ferro e zinco",
                        "Ouro e prata",
                        "Zinco e cobre"},

                {"Qual dos seguintes grupos se encontra no início de qualquer cadeia alimentar?",
                        "Produtores ",
                        "Destruidores",
                        "Decompositores",
                        "Consumidores"},

                {"Termo relativo a propagação de energia?",
                        "Radiação",
                        "Dispersão",
                        "Condensação",
                        "Evaporação"},

                {"Como é chamada a criação do bicho da seda para a fabricação de tecido?",
                        "Sericicultura ",
                        "Agricultura",
                        "Ovinocultura",
                        "Piscicultura"},

                {"É exemplo de uma mistura homogênea sólida:",
                        "Ar Atmosférico ",
                        "Refrigerante",
                        "Aço",
                        "Água Pura"},

                {"Transformação do sangue de líquido em sólido estancando os sangramentos:",
                        "Coagulação ",
                        "Correção",
                        "Reconstituição",
                        "Hemorragia"},

                {"Qual inseto picador é conhecido por seus pulos? ",
                        "Pulga",
                        "Mosquito",
                        "Besouro",
                        "Barata"},

                {"Qual o maior produtor de diamantes?",
                        "África do sul ",
                        "Arábia Saudita",
                        "Austrália",
                        "Áustria"},

                {"Não participa da fotossíntese:",
                        "Sal",
                        "Gás carbônico",
                        "Luz",
                        "Água"},

                {"O CFC existentes nos sprays deteriora a:",
                        "Camada de Ozônio",
                        "Calota polar",
                        "Camada de íons",
                        "Litosfera"},

                {"Dentre as fontes de energia citadas qual não é renovável?",
                        "Petróleo",
                        "Madeira",
                        "Água",
                        "Álcool"},

                {"Ataque cardíaco provocado pela obstrução dos vasos que irrigam o músculo do coração:",
                        "Enfarte",
                        "Sopro",
                        "Derrame",
                        "Arteriosclerose"},

                {"Na Avicultura se cria:",
                        "Aves",
                        "Caprinos",
                        "Bovinos",
                        "Suínos"},

                {"Quais órgãos compõem o sistema locomotor humano?",
                        "Ossos e Músculos",
                        "Pâncreas e intestinos",
                        "Pulmão e coração",
                        "Glândulas"},

                {"Como é chamada a parte líquida da terra?",
                        "Hidrosfera",
                        "Estratosfera",
                        "Biosfera",
                        "Atmosfera"},

                {"Quem distribui os nutrientes para o organismo?",
                        "Sangue",
                        "Pâncreas",
                        "Fígado",
                        "Estômago"},

                {"Como é chamado o estudo das condições atmosféricas?",
                        "Meteorologia",
                        "Geologia",
                        "Tecnologia",
                        "Geografia"},

                {"Qual é o nome científico do dente moedor ou triturador de alimentos?",
                        "Molar",
                        "Cortante",
                        "Permanente",
                        "Dente de leite"},

                {"Olfato, Paladar,  Audição , Tato e Visão fazem parte do sistema:",
                        "Sensorial",
                        "Digestivo",
                        "Cardíaco",
                        "Reprodutor"},

                {"O Cometa também pode ser chamado de:",
                        "Estrela da Tarde",
                        "Estrela da Manhã ",
                        "Estrela do Mar",
                        "Estrela de Rabo"},

                {"Qual dos produtos não é derivado da Cana de Açúcar?",
                        "Gasolina",
                        "Álcool",
                        "Rapadura",
                        "Cachaça"},

                {"Como são chamados os clarões de descargas elétricas observados em dia de temporal?",
                        "Relâmpago",
                        "Trovoada",
                        "Trovão",
                        "Estrondo"},

                {"Como se chama a agitação de um líquido na boca?",
                        "Gargarejo",
                        "Bocejo",
                        "Garrancho",
                        "Graveto"},

                {"Angora é uma espécie de :",
                        "Gato",
                        "Cavalo",
                        "Porco",
                        "Cachorro"},

                {"Em que órgão do aparelho respiratório se encontra as Cordas Vocais?",
                        "Laringe",
                        "Faringe",
                        "Traqueia",
                        "Pulmões"},

                {"Qual dos aparelhos citados não são movidos a eletricidade?",
                        "Moinho",
                        "Liquidificador",
                        "Ferro de passar",
                        "Geladeira"},

                {"Qual das características abaixo não pertence a água?",
                        "Colorida",
                        "Líquida",
                        "Inodora",
                        "Insipida"},

                {"Como é chamada a perturbação da fala caracterizado pela repetição de sílabas?",
                        "Gagueira",
                        "Mutismo",
                        "Rinite",
                        "Rouquidão"},

                {"Qual é o Líquido Lubrificante dos olhos?",
                        "Lágrima",
                        "Saliva",
                        "Suor",
                        "Urina"},

                {"Quais órgãos do corpo humano são responsáveis por filtrar o sangue?",
                        "Os rins ",
                        "Os pulmões",
                        "As veias",
                        "Os intestinos"},

                {"Hemorragia é o mesmo que:",
                        "Sangramento",
                        "Salivação",
                        "Envelhecimento",
                        "Defecação"},

                {"Onde se pratica o alpinismo?",
                        "Montanha",
                        "Rio",
                        "Mar",
                        "Praia"},

                {"Como é chamada a energia do vento?",
                        "Eólica ",
                        "Solar",
                        "Geotérmica",
                        "Ventosa"},

//////////////////////////////////////////////////////////////////////////////////////////////////////////
                //Geografia

                {"Qual a forma real da Terra?",
                        "Redonda",
                        "Geoide",
                        "Quadrada",
                        "A Terra Nao Tem Forma"},

                {"Qual é a capital do Canadá?",
                        "Ottawa",
                        "Moscou",
                        "Berlim",
                        "Cairo"},

                {"Qual destes não é um país segundo a ONU?",////
                        "Vaticano",////
                        "Maurícia",////
                        "Padânia",////
                        "Butão"},////

                {"Os vulcões são frequentemente considerados causadores de:",
                        "Poluição Térmica",
                        "Poluição Sonora",
                        "Poluição Natural",
                        "Poluição Luminosa"},

                {"O que é drenagem?",
                        "Colocar água",
                        "Engordar a Terra",
                        "Retirar a água",
                        "São minhocas"},

                {"A erosão eólica é feita pelo?",
                        "Vento",
                        "Mar",
                        "Gelo",
                        "Flores"},

                {"Qual a capital dos Emirados Árabes Unidos?",
                        "Abu Dhabi",
                        "Dubai",
                        "Marrocos",
                        "Árabia"},

                {"Quais desses países americanos não possuem litoral?",
                        "Paraguai e Bolívia",
                        "Costa Rica e Paraguai",
                        "Uruguai e Nicarágua",
                        "Panamá e Perú"},

                {"O Caribe é banhado por qual oceano?",
                        "Oceano Atlântico",
                        "Oceano Pacífico",
                        "Oceano Índico",
                        "Oceano Glacial Antártico"},

                {"Qual empresa abaixo é brasileira?",
                        "Nestlé",
                        "Samsung",
                        "Nvidia",
                        "HP"},

                {"Em que cidade fica localizada a Estátua da Liberdade?",
                        "Nova York",
                        "Inglaterra",
                        "Madrid",
                        "Paris"},

                {"O Arquipélago de Fernando de Noronha, no Brasil, pertence a que Estado?",
                        "Pernambuco",
                        "Espiríto Santo",
                        "Rio de Janeiro",
                        "Bahia"},

                {"Onde se localiza o Monte Evereste, o ponto mais alto do planeta Terra?",
                        "Nepal",
                        "Antártida",
                        "Russía",
                        "Japão"},

                {"Onde está a maior reserva de petróleo do mundo?",
                        "Venezuela",
                        "Estados Unidos",
                        "Emirados Arábes",
                        "Austrália"},

                {"A Lua é considerada:",
                        "Satélite",
                        "Cometa",
                        "Estrela",
                        "Planeta"},

                {"Os alemães podem ser considerados povos:",
                        "Germânicos",
                        "Africanos",
                        "Bretões",
                        "Hindus"},

                {"Qual a função das forças armadas em relação ao estado?",
                        "Defender",
                        "Legislar",
                        "Recrear",
                        "Passear"},

                {"Qual a capital do Brasil?",
                        "Brasília",
                        "Rio de Janeiro",
                        "São Paulo",
                        "Goiânia"},

                {"Qual a Capital dos Estados Unidos?",
                        "Washington",
                        "Miami",
                        "Los Angeles",
                        "Nova York"},

                {"Onde se Localiza a Torre Eiffel?",
                        "Paris",
                        "Inglaterra",
                        "Roma",
                        "Australía"},

                {"Onde se Localiza o Ponto Turístico Big Ben?",
                        "Londres",
                        "Amsterdãm",
                        "Roma",
                        "Paris"},
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //Entretenimento

                {"Qual o nome fictício de Walter de Breaking bad?",
                        "Heinsenberg",
                        "Derby",
                        "Flerton",
                        "MindSet"},

                {"O Super Herói Superman sobreviveu ou morreu no filme Batman vs Superman?",
                        "Sim",
                        "Não",
                        "Não Sei",
                        "Talvez"},

                {"Qual o nome do personagem principal de Madagascar?",
                        "Alex",
                        "Marty",
                        "Melman",
                        "Mort"},


                {"Nome do filme que os atores são Wiz Khalifa e Snoop Dog?",
                        "Mac e Devin no Colegial",
                        "Rappers no Colegial",
                        "WKSD Colegial",
                        "Irmãos de Bagunça"},

                {"Nome do filme de um filho bem sucedido e um pai louco e radical?",
                        "Este é o Meu Garoto",
                        "Mal Acompanhando",
                        "SuperBad",
                        "Ano 1"},

                {"Qual desses filmes o ator Jim Carrey participou?",
                        "Todo Poderoso",
                        "Vizinhos",
                        "Norbit",
                        "Zohan:Um Bom Agente"},

                {"Qual a morte de um desses rappers que fizeram uma série?",
                        "Tupac",
                        "Migos",
                        "Lil Pump",
                        "Travis Scott"},

                {"Qual o nome da menina com super poderes da série Stranger Things?",
                        "Onze",
                        "Super Onze",
                        "Miley",
                        "Lais"},

                {"No filme 12 anos de escravidão porque o homem negro conseguiu ser liberto?",
                        "Ele tinha Estudos",
                        "Ele Fugiu",
                        "Aboliram a Escravidão",
                        "Se Tornou um Grande Amigo do Senhor das Terras"},

                {"No filme Marley e Eu qual o nome da raça do cachorro Marley?",
                        "Labrador",
                        "São Bernardo",
                        "Pastor Alemão",
                        "Vira-Lata"},

                {"Qual o filme em que um comediante arrogante recebe uma notícia inesperada de seu medico?",
                        "Ta Rindo do que?",
                        "Seus Dinheiros, Suas Risadas",
                        "Comediante Fake",
                        "Nenhuma das Alternativas"},

                {"Qual o nome do filme do maior roubo ao banco da história dos EUA?      ",
                        "Gênios do Crime",
                        "Estratégia de Sucesso",
                        "La Casa de Papel",
                        "Assalto ao Banco"},

                {"No filme Ano Um, quais eram os grupos que existiam ? ",
                        "Hebreus,Romanos,Homem das Pedras ",
                        "Escravos,Senhores,Camponeses",
                        "Católicos,Evangélicos,Umbanda",
                        "Homem das Pedras,Animais,Burgueses"},

                {"O que os 3 Adolescentes de Project X roubaram que causou uma dos maiores polemicas da festa    ",
                        "Gnomo",
                        "Drogas",
                        "Armas",
                        "Carro de Luxo"},

                {"Qual o filme que aponta uma desigualdade grande que é baseado em fatos reais? ",
                        "Homens de Honra",
                        "O Impossível",
                        "Sempre ao Seu Lado",
                        "O Exorcismo"},

                {"O que aconteceu no filme Homem de Família, para que Dene Jensen desse atenção a sua família?",
                        "Seu filho pegou Câncer",
                        "Sua família sofreu um Acidente",
                        "Foi demitido de seu Emprego",
                        "Estava Morrendo de Câncer"},

                {"No filme UP Altas Aventuras qual é o nome do cachorro e da ave ?",
                        "Dug e Kevin",
                        "Russel e Kevin",
                        "Dug e Russel",
                        "Russel e Fredricksen"},

                {"Nome do filme que é um Crépusculo versão comédia ",
                        "Os Vampiros que se Mordam",
                        "Os Vampiros que se Matem",
                        "Crépusculo Paralelo",
                        "Não Existe"},

                {"Porque todo mundo não conseguia ficar muito tempo com Sandy Wexler?",
                        "Ele Sempre Tentava Agradar Todo Mundo",
                        "Era Chato",
                        "Era sem noção",
                        "Era Nervoso"},

                {"Qual foi a maior dificuldade do filme SuperBad?",
                        "Comprar Bebidas",
                        "Conquistar uma Menina",
                        "Ser Famoso",
                        "Enganar os Pais"},

                {"O que o Milionário do filme Intocáveis procurava em uma pessoa para ser seu novo empregado?",
                        "Uma pessoa fora dos Padrões",
                        "Uma pessoa Branca",
                        "Uma pessoa Responsável",
                        "Uma pessoa que não fosse irritante"},

                {"Porque o Senhor Incrível de Os Incríveis ficou acima do peso?",
                        "Leis que Bloquearam os Héróis de Salvar a Cidade",
                        "Ficou depressivo",
                        "Ficou Rico, e Abandonou sua Carreira de Hérói",
                        "Desisitiu depois de muita dor de cabeça"},

                {"No Filme Todo Poderoso, qual foi o motivo de Deus dar todos seus poderes?",
                        "Pelo fato dele ser Ateu e estar cansado da vida",
                        "Porque Deus queria impressionar ele",
                        "Porque eles fizeram acordos",
                        "Porque ele queria Salvar o Mundo"},

                {"No filme Deby e Loyd o que Loide fez para se vingar da trollagem de Deby",
                        "Fingiu por anos que estava doente",
                        "Fingiu que Morreu",
                        "Abandonou ele em uma Floresta sem Celular",
                        "Gastou todo Seu dinheiro com Viagra"},

                {"No filme Eu,Eu mesmo e Irene o policial Charlie sofre de qual doença ?",
                        "Bipolaridade",
                        "Toc",
                        "Autismo",
                        "Hiperatividade"},


                {"No filme Toy Story 3 porque Andy doou os brinquedos?",
                        "Ele foi para a Faculdade",
                        "Cresceu e perdeu o interesse nos brinquedos",
                        "Sua Mão obrigou ele a doar",
                        "Ele não doou"},

                {"No filme Morte no Funeral,o que mais chocou sua família em relação ao seu pai?",
                        "Ele era Gay",
                        "Ele era Nazista",
                        "Ele era Satanista",
                        "Ele era um Assassino"},

                {"No filme Morte te da Parabéns, qual é a mascara que o assassino usa?",
                        "Bebê",
                        "Palhaço",
                        "ET",
                        "Gnomo"},

                {"No filme, Só do que mal Casado, Eddie Cantrow foi iludido pelo amor de sua vida ou não?",
                        "Sim",
                        "Não",
                        "Um Pouco, mas se entenderam",
                        "Nenhuma das Alternativas"},

                {"Qual era o objetivo do pai no filme A Procura da Felicidade?",
                        "Conseguir um Lar e um Emprego a ele e seu filho",
                        "Reconquistar Sua Ex",
                        "Fazer coisas ilícitas para conseguir dinheiro",
                        "Encontrar Seus Pais Biológicos"},

                {"Qual era o hobby do Lobo de Wall Street?",
                        "Vender Coisas",
                        "Usar Drogas",
                        "Conquistar Mulheres",
                        "Mestre no Poker"},

                {"Como Harley chama Coringa?",
                        "Moinho",
                        "Liquidificador",
                        "Ferro de passar",
                        "Geladeira"},

                {"No filme Matilda,qual era o super poder de Matilda?",
                        "Moinho",
                        "Liquidificador",
                        "Ferro de passar",
                        "Geladeira"},

                {"No filme As Branquelas,qual era a profissão de Latrell Spancer ?",
                        "Jogador de Basquete",
                        "Atleta de Futebol Americano",
                        "Jogador de Vôlei",
                        "Fisiculturista"},

                {"No filme As Branquelas,Tiffany Wilson é leiloada,quem é que a comprou?",
                        "Latrell Spancer",
                        "A Outra Branquela",
                        "Um Mafioso Milionário",
                        "Um Asiático"},

                {"No filme Karate Kid,quando Dre chega no hotel na China,qual e o desenho q passa na TV?",
                        "Bob Esponja",
                        "Papa Léguas",
                        "Tom e Jerry",
                        "Pica-Pau"},

                {"No filme Up Altas Aventuras,qual o alimento preferido de Kevin?",
                        "Chocolate",
                        "Maçã",
                        "Balas",
                        "Salgadinho"},

                {"Qual a comida preferida dos Minions?",
                        "Banana",
                        "Lasanha",
                        "Laranja",
                        "Torta"},

                {"No filme Carros 2,onde ocorreu a última corrida?",
                        "Radiator Springs",
                        "Dubai",
                        "Tokyo",
                        "Roma"},

                {"No filme Se Beber Não Case,Stu perde o dente,como ele o perdeu?",
                        "Em Um Desafio",
                        "Estava tão Bebâdo que bateu na quina da mesa",
                        "Brigou com Mike Tyson",
                        "Ele nunca teve esse dente"},

                {"No filme Guardiões da Galáxia,qual é a única frase falada por Groot?",
                        "Eu sou Groot",
                        "Yeah!",
                        "Eba!",
                        "Ele não Falou Nada"},

                {"Deadpool foi diagnosticado com qual doença?",
                        "Câncer",
                        "HIV",
                        "Diabéte",
                        "Autismo"},

///////////////////////////////////////////////////////////////////////////////////////////////
                //Historia

                {"Quem foi escravizado durante 300 anos ?",
                        "Negros",
                        "Brancos",
                        "Japoneses",
                        "Chineses"},

                {"Quem foi o ditador do Nazismo?",
                        "Hitler",
                        "Al Capone",
                        "Stalin",
                        "Mao Tsé-Tung"},

                {"De quem foi a frase,Só Sei que Nada Sei ? ",
                        "Sócrates",
                        "Karl Marx",
                        "Platão",
                        "Aristóteles"},

                {"Quem inventou a Mais-Valia ?",
                        "Karl Marx",
                        "Montesquieu",
                        "Adam Smith",
                        "Bárbaros"},

                {"Onde a doença Ebóla surgiu ?",
                        "Afríca",
                        "Europa",
                        "América Latina",
                        "Asía"},

                {"Quem foi o primeiro Presidente Negro dos EUA ?",
                        "Barack Obama",
                        "Martin Luther King",
                        "Trump",
                        "Nelson Mandela"},

                {"Quem descobriu o Brasil ?",
                        "Pedro Alves Cabral",
                        "Jorge Washington",
                        "Indíos",
                        "Cristovão Colombo"},

                {"Quem inventou o Comunismo ?",
                        "Karl Marx",
                        "Adam Smith",
                        "Stalin",
                        "Hitler"},

                {"Qual era a principal atividade econômica da Mesopotâmia ?",
                        "Comércio",
                        "Pesca",
                        "Agricultura",
                        "Nenhuma das Alternativas"},

                {"Qual a Religião mais seguida na Atualidade ?",
                        "Cristianismo",
                        "Islãmismo",
                        "Budismo",
                        "Religiões Folclóricas"},

                {"Quem foi considerado o Maior Cantor de Pop do Mundo ?",
                        "Michael Jackson",
                        "Chris Brown",
                        "Madonna",
                        "Justin Bieber"},

                {"Onde surgiu a Peste Negra ?",
                        "Europa",
                        "Afríca",
                        "Asía",
                        "América Latina"},

                {"Quem foi considerado o maior cantor de Reggae do mundo ?",
                        "Bob Marley",
                        "Peter Tosh",
                        "Gregory Isaacs",
                        "Jimmy Cliff"},

                {"Quem foi o Líder da Revolução Chinesa ?",
                        "Mao Tsé-Tung",
                        "Kim Jong-Un",
                        "Stalin",
                        "Pol Pot"},

                {"Como era baseada a Economia do Feudalismo ?",
                        "Trocas",
                        "Dinheiro",
                        "Minérios",
                        "Nenhuma das Alternativas"},

                {"O que são as Pirâmides Egípcias ?",
                        "Túmulos",
                        "Casas",
                        "Obras de Enfeite",
                        "Prédios Diferenciados"},

                {"O Humano surgiu de qual espécie ?",
                        "Macacos",
                        "Gorilas",
                        "Dinossauros",
                        "Papagaio"},

                {"Qual foi o primeiro milagre feito por Jesus ?",
                        "Transformar Água em Vinho",
                        "Fazer Chover",
                        "Andar sobre as Águas",
                        "Fazer um cego ter visão"},

                {"Como foi descoberta a existência dos Dinossauros ?",
                        "Através dos Ossos",
                        "Fotografias",
                        "Teorias",
                        "Nosso DNA"},

                {"A Guerra do Peloponeso aconteceu entre quais Cidades ?",
                        "Esparta e Atenas",
                        "Roma e Berlim",
                        "Esparta e Roma",
                        "Inglaterra e Liverpool"},


        };
        return quizData;
    }

}
