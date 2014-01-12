#*Tomasz Januszewski*

```
System operacyjny: Ubuntu 13.10
Procesor: Intel(R) Core(TM)2 Duo CPU @ 2.20GHz x 2
RAM: 4 GB
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
