# Just Snail It - Summer internship exercise


## Comentários pessoais
Foram criados testes para os casos de matriz vazia, matriz com tamanho pequeno e um teste com uma matriz de tamanho 10000x10000.
Para matrizes de tamanho inferior ou igual a 25, o código executa o algoritmo apenas com uma thread que percorre a matriz de acordo com o enunciado.
Para matrizes maiores, cria duas threads, uma que igual à referida em cima (mas apenas procura metade da matriz) e e outra que começa do centro e percorre o caminho inverso (procura a outra metade da matriz), no final os dois arrays são combinados. Esta solução tem o propósito de otimizar o tempo para matrizes de maior tamanho e, visto que duas threads poderia prejudicar o runtime para matrizes pequenas, para estas, apenas uma thread é usada.


## O problema

O caracol está ligado ao mundo da matemática faz muito tempo e agora vamos tentar com que ele entre no mundo da programação.
O caracol não é o animal mais rapido, nem muitas vezes o mais eficiente, mas o teu código deverá sê-lo.

![alt text](image.svg?raw=true)

Deverá ser implementado um mecanismo de desenho de uma casca de caracol. Dada uma matriz NxN, esse mecanismo deve retornar os elementos da matriz organizados, dos mais exteriores para os interiores, percorrendo no sentido horário.
```
array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
getSnail(array) #=> [1,2,3,6,9,8,7,4,5]
```
O primeiro e único parâmetro do método é uma matriz de inteiros (int[][]) com os varios elementos.


## Regras

* O caminho deve começar na primeira posição da matriz ([0,0]) e seguir pelos ponteiros do relógio.
* A matriz vazia é representada por `[[]]`.


## O que é preciso fazer

* Implementar o método `getSnailShell` em `SnailShellPattern`.
* Implementar mais testes em `SnailShellPatternTest`

Vai ser valorizado a performance tanto para grandes matrizes como para pequenas, assim como o facto do código estar escrito de forma perceptível e organizada.

## Como correr os testes

* Instalar o mvn [https://maven.apache.org/install.html]
* Correr `mvn test`

## Dúvidas

Quaisquer dúvidas que tenhas, cria uma issue aqui no github :)

