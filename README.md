![GitHub Cards Preview](https://github.com/samirmaciel/Yu-Gi-Oh-App/blob/master/yugioh_banner_github.png)

# Yu-Gi-Oh
É uma série de mangá sobre um jogo de cartas, escrito e ilustrado por Kazuki Takahashi. A série foi originalmente publicada pela editora Shueisha na revista Weekly Shōnen Jump entre 1996 e 2004.[3] A trama segue a história de um menino chamado Yugi Muto, que remonta o antigo Enigma do Milênio, e desperta um espírito dentro de seu corpo com a personalidade de um jogador e que resolve seus conflitos usando o jogo de cartas. 


## UI Design
Design desenvolvido por eu mesmo. Link para o figma abaixo 👇👇

[![YUGIOHAPP](https://img.shields.io/badge/YUGIOhapp-FIGMA-blue.svg?style=for-the-badge&logo=figma)](https://www.figma.com/file/QZ6fxyANjmyblZLV2SxeE4/Yu-Gi-Oh-App?node-id=0%3A1)


## Desenvolvido com 🛠
- [Kotlin](https://kotlinlang.org/) - Linguagem oficial para desenvolvimento Android.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - Para processos assíncronos.
- [Componentes do Jetpack](https://developer.android.com/jetpack?gclid=CjwKCAjwxo6IBhBKEiwAXSYBs_TosuCaJ6xlf6W_tOM8rPcTpvqZbX_3q_PF04woOCkQu3PiRhB39RoCR7sQAvD_BwE&gclsrc=aw.ds) - Conjunto de bibliotecas que ajuda desenvolvedores a seguir as práticas recomendadas, reduzir códigos boilerplate e programar códigos que funcionam de maneira consistente em diferentes dispositivos e versões do Android.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Armazena dados relacionados à IU que não são destruídos nas alterações da IU. 
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - Biblioteca para abstração e mapeamento de objetos com SQlite.
- [Koin](https://insert-koin.io/) - biblioteca para gerenciamente de injeção de dependências.
- [MotionLayout](https://developer.android.com/training/constraint-layout/motionlayout?hl=pt-br) - O MotionLayout é um tipo de layout que ajuda a gerenciar movimento e widget de animação no seu app.

## Estrutura de pacotes 📦
    
    com.samirmaciel.payflow_kotlin # Root Package
    ├── modules                       
    │   ├── cardDetail
    |   |   ├── cardDetailFragment
    |   ├── home
    |   |   ├── MainActivity
    |   |   ├── MainViewModel
    |   |── myDeck
    |   |   ├── MyDeckFragment
    |   |   ├── MyDeckViewModel
    |
    ├── shared               
    │   ├── adapter  
    |   |   ├── CardRecyclerAdapter
    |   ├── data 
    |   |   ├── dataExternal
    |   |   |   ├── data_source
    |   |   |   |   ├── APIDataStore
    |   |   |   ├── model
    |   |   |   |   ├── CardEntity
    |   |   |   |   ├── CardImageEntity
    |   |   |   |   ├── CardPresenterEntity
    |   |   |   |   ├── CardPricesEntity
    |   |   |   |   ├── CardSetEntity
    |   |   |   |   ├── DataResponse
    |   |   |   ├── repository
    |   |   |   |   ├── RepositoryAPI
    |   |   ├── dataInternal
    |   |   |   ├── data_source
    |   |   |   |   ├── CardDao
    |   |   |   |   ├── Database
    |   |   |   ├── repository
    |   |   |   |   ├── CardRepositoryImpl
    |   ├── di
    |   |   ├── MainModule
    |   ├── domain
    |   |   ├── model
    |   |   |   ├── Card
    |   |   ├── repository
    |   |   |   ├── CardRepository
    |   |── ClickListener 
   
  
<br />

## Arquitetura 🗼
Para esse app foi utilizado o padrão [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch).

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png?hl=pt-br)
