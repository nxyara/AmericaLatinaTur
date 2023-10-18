Algoritmo "Cadastro"
//
// Descrição:Usando conceitos de programação estruturada (Vetor)
// criar em pseudocódigo um menu para simular um cadastro para
// uma agência de viagens com as seguintes funções:
// cadastro de cliente
// cadastro de destino
// criar também uma consulta para cada estrutura de dados.
//
// Autor(a)    : nayara brito
// Recode PRO 2023
Var

   nomecliente: vetor [1..10] de caractere
   email: vetor [1..10] de caractere
   destino: vetor [1..10] de caractere
   i: inteiro
   opcao: inteiro


Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...
   repita
      escreval ("----  AMERICA LATINA TUR  ----")
      escreval ("----                      ----")
      escreval ("---- SELECIONE UMA OPÇÃO: ----")
      escreval ("----                      ----")
      escreval ("Digite 1 para efetuar cadastro")
      escreval ("Digite 2 para consultar os dados")
      escreval ("Digite 3 para SAIR!")
      leia (opcao)

      Escolha (opcao)
      caso 1
         repita
            se i <= 10 entao
               escreval ("Digite nome para cadastro")
               leia (nomecliente [opcao])
               escreval ("Digite e-mail para cadastro")
               leia (email [opcao])
               escreval ("Digite seu destino")
               leia (destino [opcao])

               i <- i + 1
               escreval ("Cadastro efetuado!")
            senao
               escreval ("Limite de cadastro atingido!")
            fimse
            leia ()
         ate ( <> " ")

      caso 2
         para i de 1 ate 10 faça
            se nomecliente [i] <> "" entao
               escreval ("Nome:",nomecliente [i])
               escreval ("E-mail:",email [i])
               escreval ("Destino:",destino [i])
            fimse
         fimpara
         leia ()

      caso 3
      outrocaso
         escreval ("Opção inválida, digite novamente!")
      fimescolha

   ate opcao = 3

Fimalgoritmo