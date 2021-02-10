# MIEI - 3ºAno - Sistemas Distribuídos

## Projeto SoundCloud

O trabalho pratico proposto consiste na implementação de uma plataforma para partilha de ficheiros de música sob a forma de cliente/servidor em **Java** utilizando sockets e threads. O servidor deve conseguir atender pedidos de vários clientes em simultâneo e continuar a responder devidamente. Por outro lado deve também limitar o numero operações simultâneas que podem ser efetuadas para não sobrecarregar o sistema e assegurar a manutenção de uma justiça relativa entre os diferentes utilizadores.

Algumas das funcionalidades que o sistema tem são as seguintes:

* Autenticação por parte do cliente que pretenda usar a plataforma
* Dar upload de musicas
* Dar download de musicas
* Mostrar uma lista com as musicas
* Mostrar uma lista com as musicas referentes a uma dada etiqueta

## Compilação e Testes

É aconselhável o uso de um **IDE** para a a compilação e execução do projeto. No caso de escolher o **intellij** é simplesmente criar um projeto com a opção de "from existing sources" e escolher a diretoria do repositório.
 
O projeto tem duas entidades que podem ser executadas :

* Servidor - Inicializado na classe **Server.java**
* Cliente - Inicializado na classe **Client.java** e é aconselhado editar as configurações de execução para permitir correr paralelamente.