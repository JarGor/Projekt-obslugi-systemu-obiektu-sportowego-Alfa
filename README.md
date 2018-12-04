Projekt realizowany jest jako RESTful API.

Zarówno skrypt do utworzenia bazy danych (sports-facility\src\main\resources\static\sql_scripts),jej schemat jak i manual prezentuj¹cy dzia³anie aplikacji, znajduj¹ siê w repozytorium.

Wykonany zostanie przy u¿yciu nastêpuj¹cych technologii:
- Java wraz z u¿yciem kilku z biblotek Spring'a,
- MySql 8.0.13.

Projekt zawiera³ bêdzie nastêpuj¹ce elementy:
- Rejestracja/edycja u¿ytkowników,
- Ograniczenie przez role dostêpu do odpowiednich endpoint'ów,
- Dodawanie/edycja klientów,
- Dodawanie/edycja pracowników,
- Dodawanie/edycja ofert obiektu sportowego,
- Przygotowywanie danych do sporz¹dzenia prostej faktury (pracownik sprzedaj¹cy ofertê, klient który j¹ kupuje, lista zakupionych ofert z ich cenami, data zakupu),
- Zapisywanie/edycja ustawieñ dla u¿ytkowników (w formie "nazwa ustawienia" - "wartoœæ"),
- Zarz¹dzanie jêzykami oraz list¹ statycznych tekstów w ró¿nych jêzykach (na podstawie kodów pañstw ISO 3166-1 alpha-3),
- Dodawanie/usuwanie plików oraz metadanych o tych plikach,
- Sporz¹dzanie change logów mieszcz¹cych siê w tablicy bazy danych,
- Rejestrowanie czasów wejœæ/wyjœæ klientów do/z obiektu sportowego.