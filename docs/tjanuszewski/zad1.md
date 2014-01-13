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
