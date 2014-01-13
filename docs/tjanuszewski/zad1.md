#*Tomasz Januszewski*

```
System operacyjny: Ubuntu 13.10 (do samego import Backtrack 5 RC2)
Procesor: Intel(R) Core(TM)2 Duo CPU @ 2.20GHz x 2
RAM: 4GB
Dysk: TOSHIBA MK4058GSX 400GB
Partycje: 46GB/Ext4, 2GB/swap
```

###Rozwiązania do zadań

* [Zadanie 1a](#zad1a)
* [Zadanie 1b](#zad1b)
* [Zadanie 1b](#zad1c)
* [Zadanie 1d](#zad1d)
* [Zadanie 1e](#zad1e)


##Parsowanie csvki

Train.csv zawiera znaki windowsowej karetki i muszą być usunięte, by mongo mogło poprawnie przeparsować dane.

Użyłem do tego polecenia:

```sh
cat Train.csv | tr "\n" " " | tr "\r" "\n" >  > transformed.csv
```

Wynikowy plik ma taką samą długość jak przerobiony, czyli 6.8GB.

##Import


```sh
root@bt:~/mongo# date; time mongoimport -d test -c train --type csv --headerline --file transformed.csv ; date
czw, 12 gru 2013, 14:49:24 CET
...
Thu Dec 12, 15:25:26.254 		Progress: 7253301883/7253917400	99%
Thu Dec 12, 15:25:26.254 			6033700	2951/second
Thu Dec 12, 15:25:26.322 check 9 6034197
Thu Dec 12 15:25:28.095 imported 6034196 objects
root@bt:~/mongo# 
czw, 12 gru 2013, 15:25:28 CET
```

```sh
mongo
use test
> db.train.count()
6034196
```
c)

Korzystając ze sterownika ze strony https://github.com/downloads/mongodb/mongo-java-driver/mongo-2.10.1.jar napisałem program w Javie do parsowania bazy.

[Mongo.java](../../scripts/tjanuszewski/Mongo.java)

czas trwania, ok 4 minut.


d)

```sh
tomasch@tomasch-pc:~/mongo$ date ;  time mongoimport -d test -c text --type csv --headerline --file text8 ; date
sob, 4 sty 2014, 10:50:22 CET
Sat Jan 4 10:51:39.510 imported 17005207 objects
real	1m16.973s
user	0m33.200s
sys	0m16.880s
sob, 4 sty 2014, 10:51:39 CET
```

```sh
> db.text.count()
17005207
```

```sh
> db.text8.distinct("word").length
253854
```

Różnych słów jest 253854.

###1 wyraz (najczęściej występujący) - 6.24% wszystkich wyrazów
```sh
> db.text8.aggregate([ 
    { $group: {  _id: "$word" , count:{ $sum: 1 } } }, 
    { $sort: { count: -1 } }, 
    { $limit: 1 } 
])
{ "result" : [ { "_id" : "the", "count" : 1061396 } ], "ok" : 1 }
```

###10 wyrazów - 24.73%
```sh
> db.text8.aggregate([ 
    { $group: {  _id: "$word" , count:{ $sum: 1 } } }, 
    { $sort: { count: -1 } }, 
    { $limit: 10 } 
])
{ "result" : [ { "_id" : "the", "count" : 4205965 } ], "ok" : 1 }
```

###100 wyrazów - 47.03%
```sh
> db.text8.aggregate([ 
    { $group: {  _id: "$word" , count:{ $sum: 1 } } }, 
    { $sort: { count: -1 } }, 
    { $limit: 100 } 
])
{ "result" : [ { "_id" : "the", "count" : 7998978 } ], "ok" : 1 }
```

###1000 wyrazów - 67.23%
```sh
> db.text8.aggregate([ 
    { $group: {  _id: "$word" , count:{ $sum: 1 } } }, 
    { $sort: { count: -1 } }, 
    { $limit: 10 } 
])
{ "result" : [ { "_id" : "the", "count" : 11433354 } ], "ok" : 1 }
```


