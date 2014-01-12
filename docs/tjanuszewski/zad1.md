#*Tomasz Januszewski*


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
