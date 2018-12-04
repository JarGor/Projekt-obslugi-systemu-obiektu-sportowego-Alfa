Projekt realizowany jest jako RESTful API.

Zar�wno skrypt do utworzenia bazy danych (sports-facility\src\main\resources\static\sql_scripts),jej schemat jak i manual prezentuj�cy dzia�anie aplikacji, znajduj� si� w repozytorium.

Wykonany zostanie przy u�yciu nast�puj�cych technologii:
- Java wraz z u�yciem kilku z biblotek Spring'a,
- MySql 8.0.13.

Projekt zawiera� b�dzie nast�puj�ce elementy:
- Rejestracja/edycja u�ytkownik�w,
- Ograniczenie przez role dost�pu do odpowiednich endpoint'�w,
- Dodawanie/edycja klient�w,
- Dodawanie/edycja pracownik�w,
- Dodawanie/edycja ofert obiektu sportowego,
- Przygotowywanie danych do sporz�dzenia prostej faktury (pracownik sprzedaj�cy ofert�, klient kt�ry j� kupuje, lista zakupionych ofert z ich cenami, data zakupu),
- Zapisywanie/edycja ustawie� dla u�ytkownik�w (w formie "nazwa ustawienia" - "warto��"),
- Zarz�dzanie j�zykami oraz list� statycznych tekst�w w r�nych j�zykach (na podstawie kod�w pa�stw ISO 3166-1 alpha-3),
- Dodawanie/usuwanie plik�w oraz metadanych o tych plikach,
- Sporz�dzanie change log�w mieszcz�cych si� w tablicy bazy danych,
- Rejestrowanie czas�w wej��/wyj�� klient�w do/z obiektu sportowego.