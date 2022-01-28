# Hadoop-MapReduce
<p align="justify">In this repository located files with realization of Hadoop MapReduce technology on Java</p>

<h1>О работе</h1>
<p align="justify">В этой работе я с одногруппниками в рамках учёбы в университете выполняли задания по <b>"Методам BigData"</b> — так называется сама дисциплина. Эти задания были на тему эффективной обработки данных больших объёмов. Мы изучали инструмент под названием <b>"Hadoop"</b>, который используют многие популярные компании, типа, <i>Facebook</i>, <i>Amazon</i>, <i>Yahoo</i> и многие другие коммерческие и некоммерческие объединения специалистов в этой области. Этот инструмент как раз и позволяет очень хорошо и быстро загрузить, обработать и сохранить разные данные на сервера организаций.</p>
<p>Преподаватель у нас по этому предмету <b>А.С. Лебедев</b> — очень умный и талантливый человек; он очень много знает про искусственный интеллект, BigData и про многие другие области математики и IT.</p>
<p>"Методы BigData" преподавались у нас на 4-м курсе 2021–2022 гг. Это действительно полезный предмет, ведь благодаря ему мы узнали многое про организацию хранения и способы обработки Больших Данных.<p>
<p>Мне удалось выполнить три лабораторные работы из пяти в течение этого семестра. Но есть и ребята, которые сделали намного больше и вложили в это дело очень много своего времени и усилий и реализовали все пять или четыре подобные работы. Респект таким трудягам!)</p>
<p>Ниже представлено общее описание этих трёх лабораторных работ, чтобы вы, дорогой читатель, были в курсе всего, что связано с BigData!</p>

<h1>Методы BigData</h1>
<h2>Оглавление</h2>
<ul>
 <li><a href="#theory">Теоретическое введение</a></li>
 <ol type="1">
  <li><a href="#theory1">История и главные черты Hadoop</a></li>
  <li><a href="#theory2">Модель программирования MapReduce в Hadoop</a></li>
  <li><a href="#theory3">Обработка реляционных данных в экосистеме Hadoop</a>
  <ol>
   <li><a href="#theory31">Hive</a></li>
   <li><a href="#theory32">Pig</a></li>
  </ol></li>
  <li><a href="#theory4">Алгоритм HITS и Spark</a></li>
 </ol>
 <li><a href="#work">Отчёт по второй лабораторной работе</a>
 <ul>
  <li><a href="#aim">Цель работы</a></li>
  <li><a href="#task">Задача работы</a></li>
  <li><a href="#main">Общие сведения для понимания кода этого репозитория</a></li>
 </ul></li>
 <li><a href="#ps">Примечание</a></li>
 <li><a href="#sources">Список использованной литературы</a></li>
</ul>
<h2 name="theory">Теоретическое введение</h2>
<h3 name="theory1">1. История и главные черты Hadoop</h3>
<p align="justify">Мы живем в эпоху, когда объемы данных, с которыми нужно работать
ежедневно, превзошли возможности одной сколь угодно мощной
вычислительной машины [<a href="#lit1">1</a>]. Большие данные сопряжены не только с двумя
фундаментальными проблемами их хранения и обработки, но, что более важно,
сложностями в их интерпретации и понимании, как превращать их в
конкурентное преимущество. Hadoop заполняет пробел на рынке, предоставляя
эффективные средства хранения и управления вычислительными ресурсами для
обработки значительных объемов данных. Это распределенная система, которая
предлагает способ распараллеливания и выполнения программ на кластере
машин. Hadoop был принят такими технологическими гигантами, как Yahoo,
Facebook и Twitter для удовлетворения своих потребностей в больших данных, и
он продолжает проникать во все отрасли промышленности.</p>

<p align="justify"><b>Hadoop</b> — это платформа, которая обеспечивает как распределенное
хранилище, так и вычислительные возможности. Первоначально Hadoop был
задуман для устранения проблемы масштабируемости, которая существовала в
Nutch — краулере с открытым исходным кодом и поисковой системе. В то время
Google опубликовал статьи, в которых описывалась его новая распределенная
 файловая система Google (GFS), а также <b>MapReduce</b> — вычислительная среда
для параллельной обработки. Успешная реализация концепций этих документов
в Nutch привела к его разделению на два отдельных проекта, второй из которых
стал Hadoop — проектом первого уровня Apache.</p>

<p align="justify">Собственно, Hadoop — это распределенная архитектура «главный-
 подчиненный», которая состоит из распределенной файловой системы Hadoop (<b>HDFS</b>) для хранения и <b>MapReduce</b> для обеспечения вычислительных
возможностей. Характерными чертами Hadoop являются разделение данных и
параллельные вычисления над большими наборами данных. Его хранилище и
вычислительные возможности масштабируются с добавлением узлов в кластер,
и могут обрабатывать петабайты данных в кластерах с тысячами улов.</p>

<p align="justify">HDFS — это компонент хранения Hadoop, распределенная файловая
система, вдохновленная статьей о файловой системе Google (GFS). HDFS
оптимизирована для обеспечения высокой пропускной способности и лучше
всего работает при чтении и записи больших файлов (гигабайт и больше). Для
поддержки этой пропускной способности HDFS использует необычно большие (для файловой системы) размеры блоков и оптимизацию локализации данных
для уменьшения сетевого ввода/вывода.</p>

<p align="justify">Масштабируемость и доступность также являются ключевыми
характеристиками HDFS, что отчасти достигается за счет репликации данных и
отказоустойчивости. HDFS реплицирует файлы заданное количество раз,
устойчив к программным и аппаратным сбоям, а также автоматически
реплицирует блоки данных на вышедших из строя узлах.</p>

<p align="justify">Как итог этого параграфа, можно обощить, что Hadoop — это технология, использующая множество одновременно работающих компьютеров (серверов или кластеров) для обработки и хранения большого объёма данных. Если вы хотите ускорить обработку или объём памяти, то расширяться вам будет лучше <i>не вертикально</i>, то есть с улучшением качества оборудования самих компьютеров — это весьма дорого по времени и бюджету — а расширяться вам следует <i>горизонтально</i>, иными словами путём увеличения количества машин. У Hadoop есть своя файловая система, которую называют <i>распределённой</i>, или работающей в сразу нескольких компьютерах — <i>HDFS</i> (<u>H</u>adoop <u>D</u>istributed <u>F</u>ile <u>S</u>ystem). А обрабатывают эти данные программисты с помощью технологии параллельного вычисления <i>MapReduce</i>, которая работает в два основных этапа, <i>Map</i> и <i>Reduce</i>, и которая включает в себя <i>многопоточность</i>.</p>

<h3 name="theory2">2. Модель программирования MapReduce в Hadoop</h3>
<p align="justify"><b>MapReduce</b> — модель программирования, ориентированная на обработку
 данных [<a href="#lit1">1</a>]. Эта модель проста, но не настолько, чтобы в ее контексте нельзя было
реализовать полезные программы. Hadoop позволяет запускать программы
MapReduce, написанные на различных языках. Все программы MapReduce
параллельны по своей природе, следовательно, крупномасштабный анализ
данных становится доступным для всех, у кого в распоряжении имеется
достаточно вычислительных машин. Достоинства MapReduce в полной мере
проявляются в работе с большими наборами данных.</p>
<p align="justify">Работа MapReduce основана на разбиении обработки данных на две фазы:
 фазу отображения (<b>map</b>) и фазу свертки (<b>reduce</b>). Каждая фаза использует в
качестве входных и выходных данных пары «ключ-значение», типы которых
могут быть выбраны программистом. Программист также задает две функции:
отображения и свертки:</p>

<p align="center"><code><b>map:</b> (k1, v1) → [(k2, v2)]</code>;<br>
 <code><b>reduce:</b> (k2, [v2]) → [(k3, v3)]</code>,</p>

<p align="justify"> где <code>k1</code>, <code>k2</code>, <code>k3</code> и <code>v1</code>, <code>v2</code>, <code>v3</code> — обозначения типов данных ключей и значений
соответственно. MapReduce гарантирует, что вход каждого reducer отсортирован
по ключу. Процесс, посредством которого система выполняет сортировку и
передает выходные данные map в reduce в качестве входных данных, известен как тасовка и сортировка (<b>Shuffle</b> and <b>Sort</b>). На этом этапе те пары «ключ-
значение», у которых ключ совпадает, объединяются:</p>

<p align="center"><code>[(k2, v2)] → (k2, [v2])</code>,</p>

<p align="justify">затем разделяются между экземплярами reduce и сортируются по ключу. Каждый
экземпляр reduce получает все значения, связанные с одним и тем же ключом.</p>

 <p align="justify">Многие задания MapReduce ограничиваются по пропускной способности,
доступной в кластере, поэтому передачу данных между задачами отображения и
свертки желательно свести к минимуму. Hadoop позволяет пользователю задать
комбинирующую функцию, которая будет выполняться для выходных данных
отображения:</p>

<p align="center"><code><b>combine:</b> (k2, [v2]) → [(k2, v2)]</code>.</p>

<p align="justify">Выходные данные комбинирующей функции образуют ввод функции
свертки. Так как комбинирующая функция является оптимизацией, Hadoop не
предоставляет гарантий относительно того, сколько раз она будет вызвана для
конкретной записи выходных данных отображения, и будет ли вызвана вообще.
Другими словами, при вызове комбинирующей функции нуль, один или
несколько раз функция свертки должна выдавать одинаковый результат.</p>

<h3 name="theory3">3. Обработка реляционных данных в экосистеме Hadoop</h3>
<h4 name="theory31">3.1 Hive</h4>

<p align="justify"><b>Технология Hive</b> выросла из потребности в управлении и извлечении
информации из огромных объемов данных, ежедневно производимых Facebook
в стремительно растущей социальной сети [<a href="#lit1">1</a>]. Опробовав несколько разных систем,
группа разработки выбрала Hadoop для хранения и обработки информации, так
как эта технология была экономичной и удовлетворяла их потребности в
масштабировании.</p>

<p align="justify">Система Hive создавалась для того, чтобы аналитики, хорошо владеющие
SQL (но слабо разбирающиеся в программировании на Java), могли выполнять
запросы к гигантским объемам данных, хранимых Facebook в HDFS. Сегодня
Hive — успешный проект Apache, используемый во многих организациях как
универсальная и масштабируемая платформа обработки данных.</p>

<p align="justify">Взаимодействие с Hive в основном происходит через программную
оболочку, в которой вводятся команды на HiveQL — языке запросов Hive,
диалекте SQL. Хотя Hive во многих отношениях напоминает традиционные базы
данных, из тесной связи этой технологии с HDFS и MapReduce вытекает целый
ряд архитектурных различий, которые напрямую влияют на функциональность
Hive — которая, в свою очередь, влияет на возможное применение Hive.</p>

<p align="justify">В традиционных базах данных схема таблицы проверяется во время
загрузки данных. Если загружаемые данные не соответствуют схеме, они
отвергаются. Такой метод называется проверкой схемы при записи. С другой
стороны, Hive проверяет данные не при загрузке, а при выдаче запроса. Это
называется проверкой схемы при чтении.</p>

<p align="justify">У каждого из двух методов есть свои достоинства и недостатки. Проверка
схемы при чтении заметно ускоряет начальную загрузку, поскольку данные не
нужно читать, разбирать и сериализовать на диск во внутреннем формате базы
данных. Операция загрузки сводится к копированию или перемещению файла.
Кроме того, улучшается гибкость обработки данных: возможно использовать две
схемы для одного набора данных в зависимости от выполняемого анализа.</p>

<p align="justify">Проверка схемы при записи ускоряет выполнение запросов, потому что
база данных может проиндексировать столбцы и выполнить сжатие данных.
Вместе с тем процедура загрузки данных в базу выполняется медленнее. Кроме
того, схема часто неизвестна на стадии загрузки. В таком случае индексирование
невозможно, потому что запросы еще не были сформулированы. В таких
ситуациях достоинства Hive проявляются особенно ярко.</p>

<h4 name="theory32">3.2 Pig</h4>
<p align="justify">По аналогии с Hive, <b>Pig</b> была придумана для работы с базами данных в целях экономии времени для разработчиков.</p>

<p align="justify">Создание приложений для MapReduce — дело достаточно трудоемкое. Написание всех функций, компилирование и упаковка занимают много времени. Чтобы облегчить работу компания Yahoo! разработала специализированный инструмент под названием Pig, повышающий уровень абстракции при обработке данных. Подробнее про Pig читайте в просторах Интернета, например тут:
<ul>
 <li>https://habr.com/ru/company/selectel/blog/215307/ — статья на Хабре от пользователя <b>fortyseven</b> 2014-го года;</li>
 <li>методичку преподавателя А.С. Лебедева (см. папку <i>"docs"</i> этого репозитория);</li>
 <li>или Википедию (к примеру тут, на английском: https://en.wikipedia.org/wiki/Apache_Pig).</li>
</ul></p>

<h3 name="theory4">4. Алгоритм HITS и Spark</h3>
<p align="justify">Про эти вещи, дорогой читатель, почитайте сами — я уже подустал печатать про это :)</p>
<p align="justify">Это тема остальных двух лабораторных работ, которые я не выполнил по обсуждаемому нами здесь предмету "Методы BigData".</p>
<p align="justify"> Вот некоторые из предлагаемых преподавателем источников:
<ul>
 <li>https://en.wikipedia.org/wiki/HITS_algorithm;</li>
 <li>http://pi.math.cornell.edu/~mec/Winter2009/RalucaRemus/Lecture4/lecture4.html;</li>
 <li>а вот на русском языке в Википедии: https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_HITS.</li>
</ul>
</p>

<h2 name="work">Отчёт по второй лабораторной работе</h2>
<p align="justify">Поскольку этот репозиторий содержит файлы Java-проекта от второй лабораторной работы на тему <b>"Разработки двух алгоритмов MapReduce"</b>, то дальше будут выкладки в основном по этой работе.</p>

<h3 name="aim">Цель работы</h3>
<p align="justify">Научиться реализовывать алгоритмы MapReduce на одном из языков программирования для понимания принципов работы этой технологии и, следовательно, всей системы Hadoop.</p>

<h3 name="task">Задача работы</h3>
<p align="justify">Необходимо решить задачу формирования списка рекомендованных товаров для пользователя интернет-магазина с применением алгоритма кросскорреляции (имея множество кортежей объектов, для каждой возможной пары объектов посчитать число кортежей, где они встречаются вместе).</p>

<p align="justify">
<ol>
<li>Реализовать два алгоритма на MapReduce:
 <ul>
  <li>Cross Correlation Pairs</li>
  <li>Cross Correlation Stripes</li>
  </ul>
 </li>
<li>Написать генератор базы данных интернет-заказов (или взять готовую). Учесть, что заказ состоит из произвольного количества позиций (товаров).</li>

<li>Обработать алгоритмом кросс-корреляции базу данных заказов (подсчитать количество вхождений каждой пары товаров).</li>

<li>Реализовать компонент советника, не применяя паттерн MapReduce. Вводится название товара. Выводятся 10 товаров, которые чаще всего покупают с заданным товаром. Чтение результатов работы алгоритма кросс-корреляции из HDFS реализовать вручную (для Java — c помощью FileSystem API, для Python — с помощью библиотеки pyhdfs).</li></ol></p>

<h3 name="main">Общие сведения для понимания кода в этом репозитории</h3>
<p align="justify">Как видно, я писал этот код на Java. Поэтому для его работы на вашем компьютере вам необходима Java-библиотека <b>org.apache.hadoop</b> (чтобы установить эти библиотеки, создайте проект в какой-нибудь IDE, к примеру IntelliJ IDEA, с автоустановщиком Java-библиотек <b>"maven"</b>; или просто добавьте к вам в проект <i>jar-файл</i>, который вы можете скачать, например, отсюда: https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-common/3.3.1).</p>

<p align="justify">В коде есть четыре файла:
<ol type="1">
 <li><code>CrossCorelation.java</code>: с реализацией первого алгоритма <i>"Cross Correlation Pairs"</i> (то есть реализация MapReduce в виде работы с парами: у меня в работе это пара двух объектов класса <code>Text</code> и <code>IntWritable</code>);</li>
 <li><code>CrossCorelation2.java</code>: это файл с исходным кодом уже второго алгоритма <i>"Cross Correlation Stripes"</i> — в нём нужно уже реализовывать с передачей между map и reduce объектов кастомного класса (мой такой класс находится в файле <code>Dict.java</code>);</li>
 <li><code>Dict.java</code>: файл с классом <code>Dict</code>, который представляет собой реализацию ассоциативного массива (<code>HashMap</code>) для его передачи между частями MapReduce;</li>
 <li><code>Main.java</code>: это главный класс <code>Main</code> с настройкой и запуском этих двух алгоритмов MapReduce.</li>
</ol>
</p>

<p align="justify">Следует вам немного объяснить содержние кода. Вообще справочник по программированию MapReduce на Java есть на официальном сайте https://hadoop.apache.org/docs/current/api/index.html. Здесь есть описание всех методов и классов предоставляемого программисту API.</p>

<p align="justify">В Java для работы с Hadoop MapReduce предусмотрены специальные классы, созданные поверх основных, нативных (от англ. "native") классов Java, но пригодных для хранения и обработки уже непосредственно в Hadoop. Это классы например <code>IntWritable</code>, который хранит в себе обычное целое число, но пригодное для чтения и записи в систему HDFS; класс <code>Text</code>, который представляет собой обычную строку, но с возможностью сохранить её в HDFS.</p>

<p align="justify">"Обернуть" обычную Java-строку класса <code>String</code> в объект <code>Text</code> можно таким способом:</p>

<p align="center">
 <code>String str = <b>"Текст в Хадупе!"</b></code><br>
 <code>Text hdfs_str = new Text(str);</code>
</p>

<p align="justify">То есть <code>String</code> просто засовывается в конструктор класса <code>Text</code>.</p>

<p align="justify">Функции Map и Reduce реализуются в Java в виде классов с соответствующими методами. У меня в проекте это классы <code>MyMapper</code> и <code>MyReducer</code>:</p>

<table><tr><td>
<p align="left">
 <code>public static class <b>MyMapper</b> extends Mapper&lt;Object, Text, Text, IntWritable&gt; {</code><br>
        
  <code>&nbsp;&nbsp;&nbsp;&nbsp;public void <b>map</b>(Object key, Text value, Context context) throws IOException, InterruptedException {</code><br>
  <code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;КАКОЙ-ТО КОД МЕТОДА...</code><br>
        <code>&nbsp;&nbsp;&nbsp;&nbsp;}</code><br>
    <code>}</code><br><br>

  <code>public static class <b>MyReducer</b> extends Reducer&lt;Text, IntWritable, Text, IntWritable&gt; {</code><br>
    
  <code>&nbsp;&nbsp;&nbsp;&nbsp;public void <b>reduce</b>(Text key, Iterable&lt;IntWritable&gt; values, Context context) throws IOException, InterruptedException {</code><br>
      <code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;КАКОЙ-ТО КОД МЕТОДА...</code><br>
    <code>&nbsp;&nbsp;&nbsp;&nbsp;}</code><br>
  <code>}</code>
 </p>
 <p align="center" name="code1">Код 1 — Общий вид алгоритма MapReduce в Java</p></td></tr></table>

<p align="justify">И обратите внимание, что в параметризуемых типах данных в классе Map последние два стоят такие: <code>Text</code> и <code>IntWritable</code>, — это значит, что и в классе Reduce первые два типа данных должны быть помечены как <code>Text</code> и <code>IntWritable</code>. В точно таком же порядке следования. Это всё из-за того, что в терминологии MapReduce map — это входная функцияи этого алгоритма, которая после завершения своей работы передаёт частично обработанные данные функции reduce. И эти данные не изменяются в процессе передачи от map к reduce — следовательно, выходные типы данных класса Map в Java (и в любом другом языке программирования, работающим с MapReduce) должны совпадать с входными типами класса Reduce!</p>

<p align="justify">Иначе в процессе компиляции у вас выскочит ошибка, связанная с этим! Надеюсь, что в процессе компиляции, а не в процессе уже выполнения кода — я просто не помню :) В общем будьте с этим внимательны!</p>

<p align="justify">В официальной документации (см. https://hadoop.apache.org/docs/current/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html#MapReduce_-_User_Interfaces) сказано следующее насчёт этих входов и выходов функций MapReduce:</p>

<p align="center">Maps are the individual tasks that transform input records into <b>intermediate</b> records. The transformed intermediate records do not need to be of the same type as the input records. A given input pair may map to zero or many output pairs.<br><...><br>The number of maps is usually driven by the total size of the inputs, that is, the total number of blocks of the <b>input files</b>.</p>

<p align="justify">Переводя на русский язык, здесь разработчикам, применяющим MapReduce у себя в проекте, то есть всем нам интересующимся, сообщают, что выходные типы данных класса Map (то есть последние два параметризуемых типа в <a href="#code1">коде 1</a> в классе <code>MyMapper</code>) могут отличаться от его входных типов данных (то есть от первых двух типов в <a href="#code1">коде 1</a> в том же классе). Так и есть — <a href="#code1">код 1</a> успешно отрабатывает свою задачу несмотря на это различие типов.</p>

<p align="justify">Кроме этого, выходных типов данных вообще может не быть или их может быть намного больше. А последним предложением специалистам напоминают, что кол-во потоков, выделенных для фазы Map, напрямую зависит от количества обрабатываемых блоков памяти, в которых хранятся входные файлы. Этих блоков памяти может быть столько же сколько и самих входных файлов: здесь всё зависит от объёма этих входных файлов — занимают ли они один блок или несколько. То есть кол-во потоков, выполняющих функцию map, может варьироваться в разных ситуациях.</p>

<p align="justify">И здесь можно рассказать и о том, что в HDFS (см. если подзабыл, что это такое <a href="#theory1">введение</a>) данные хранятся в виде отдельных <b>фиксированных блоков</b>, которые <b>поточным образом</b> обрабатываются сразу на разных машинах. Причём один и тот же файл или каталог могут располагаться одновременно по частям на разных компьютерах, которые встроены в обрабатывающую систему Hadoop. Эти компьютеры, кстати говоря, ещё называют <b>узлами</b>.</p>

<p align="justify">Обрабатывающих потоков Reduce тоже может быть несколько. При этом их число может отличаться от числа map-потоков, и разработчик может самостоятельно указать их количество посредством метода <code>Job.setNumReduceTasks(int)</code>:</p>

<p align="center">Reducer reduces a set of intermediate values which share a key to a <b>smaller</b> set of values.<br>The number of reduces for the job is set by the user via <b>Job.setNumReduceTasks(int)</b>.</p>

<p align="justify">Также, если продолжать разговор о коде в этом репозитории, нужно упомянуть принципиальное отличие двух версий библиотек hadoop друг от друга и их несочетаемость в коде: это библиотека <code>org.apache.hadoop.mapreduce</code> и более старая — <code>org.apache.hadoop.mapred</code>! Если вы, читатель, импортируете их в свой код прямо вместе, то он так или иначе не заработает! Помните об этом — это две разные библиотеки, которые не предназначены для совместной работы. Как видите в коде этого репозитория, используется только библиотека <code>org.apache.hadoop.mapreduce</code> (читайте об этом также на stackoverflow: https://stackoverflow.com/questions/16269922/hadoop-mapred-vs-hadoop-mapreduce).</p>

<p align="justify">Это всё, что хотелось бы рассказать о программировании MapReduce в рамках этой статьи. Желаю Вам, дорогой интересующийся этой темой читатель, интересного времяпрепровождения и отличного настроения!</p>

<h2 name="ps">Примечание</h2>
<p align="justify">Про остальные две лабораторные работы: первую и третью, — смотрите в приложенных к репозиторию документах в папке "docs"! Там лежат отчёты по ним, предназначенные для показа преподавателю как результатов работы по "Методам BigData".</p>

<h2 name="sources">Список использованной литературы</h2>
<ol type="1">
 <li name="lit1">Лебедев А.С. Методы Big Data [Электронный ресурс]: Учебно-методическое пособие / Лебедев А.С., Магомедов Ш.Г. – М.: МИРЭА – Российский технологический университет, 2021. – 1 электрон. опт. диск (CD-ROM).</li>
 <li>Apache Pig // Wikipedia URL: https://en.wikipedia.org/wiki/Apache_Pig (дата обращения: 28.01.2022).</li>
 <li>Lecture #4: HITS Algorithm - Hubs and Authorities on the Internet // The Department of Mathematics URL: http://pi.math.cornell.edu/~mec/Winter2009/RalucaRemus/Lecture4/lecture4.html (дата обращения: 28.01.2022).</li>
 <li>Hadoop, часть 3: Pig, обработка данных // Хабр URL: https://habr.com/ru/company/selectel/blog/215307/ (дата обращения: 28.01.2022).</li>
</ol>
