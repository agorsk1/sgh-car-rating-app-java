# Sgh car rating app
Praca zaliczeniowa Artur Górski

## Specyfikacja

 * POST /api/v1/car
   - Dodawanie nowego samochodu do bazy danych.
   - Wprowadzone dane są sprawdzane względem bazy danych pojazdów: https://vpic.nhtsa.dot.gov/api/.
   - Jeżeli samochód nie istnieje aplikacja zwraca błąd do użytkownika.
 * GET /api/v1/car
   - Wyświetla listę pojazdów z ich średnią oceną.
   - W wypadku jeżeli pojazd nie ma jeszcze ocen jest wyświetlane 0.
 * GET /api/v1/car/top
   - Pozwala wyświetlić listę top 5 najlepiej średnio ocenionych pojazdów.
   - W wypadku jeżeli jakiś pojazd nie ma jeszcze ocen jest wyświetlane 0.
 * POST /api/v1/rating
   - Pozwala ocenić pojazd w skali 1 - 5 gwiazdek
   - Jeżeli użytkownik już ocenił pojazd otrzymuje błąd


## Quick start

Przed proszę upewnić się czy posiadamy zainstalowany docker oraz docker-compose na komputerze lub bazę danych postgres.

Jeżeli korzystamy z docker'a przed uruchomieniem aplikacji spring trzeba wykonać:

docker-compose -f docker-compose.yaml up -d

Jeżeli korzystamy z postgresa lokalnie należy skonfigurowac połączenie w src.resources.application.properties

Następnie uruchamiamy spring'a:

./mvnw spring-boot:run


## Wykresy bpmn

### Dodanie nowego pojazdu

![alt text](docs/dodanie%20nowego%20pojazdu.png)

### Ocena pojazdu

![alt text](docs/ocena%20pojazdu.png)

### Top 5 pojazdów

![alt text](docs/Top%205%20ocenionych%20pojazdow.png)