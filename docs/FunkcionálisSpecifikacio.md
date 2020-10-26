# Funkcionális Specifikáció

### 1. Bevezetés

Cégünk telephelye Debrecentől 15 km-re található, egy kisebb városban. Mivel a környéken nem található olyan autószerelő műhely, mely ilyen széleskörű szolgáltatásokat nyújt, ezért cégünk vezetése a előrelépés mellett döntött, ennek megfelelően egy gyors és hatékony számítógépes rendszer fejlesztését tervezzük. Ezen igényekre támaszkodva továbbfejlesztjük a programot mellyel jelenleg dolgozunk. A továbbfejlesztés célja, hogy hatékonyabban lehessen a jelenleginél végezni az adminisztrációt, továbbá pontosabban is.

### 2. Használati Esetek
   - A Rendszerrel szeretnénk nyilvántartani ügyfeleinket. Sok visszatérő ügyfelünk van akiknek sokszor több autója is vav. Minket megbízható cégnek itéltek meg ezért rendszeresen mi végezzük az autóik szervizelését az egyszerű rutin szervíztől a komolyabb javításokig. Ezért szeretnénk, hogy a programban külön tudjuk kezelni az ügyfeleinket. Tárolni szeretnénk a nevüket és többféle elérhetőséget pl.: cím, email, telefonszám.
   - Az autókat is külön szeretnénk tárolni. A gépjárművek kereshetőek legyenek, rendszám és tulajdonos alapján. Az egyszerűbb adminisztráció elvégzése céljából.
   - Az autókhoz szeretnénk tárolni, hogy kik dolgoztak rajta. Nem szükséges történettel rendelkezni csak tudni szeretnénk, hogy egy autóval ki foglalkozott.
   - A programmal képepek legyünk számlázni az új navos előírásoknak megfelelően ezzel is megkönnyítve a munkánkat.
   - A számlán tüntesse fel a vevő adatait, a cég adatait valamint az árat áfával.
   - Ezeket a funkciókat tartalmazza de továbbra is elvárás, hogy a program könnyen kezelhető maradjon.
   
### 4. Jelenlegi üzleti feolyamatok modellje.
   Az adatok tárolására relációs adatbázist használunk melyben jelenleg 1 tábla van ezt mindenképpen javítani kell, hiszen az elszaporodó adatok lassítják a programot.
   A szoftver menüsorából az alábbi menüsorok érhetőek el.
    
   **Szerkesztés**: Tetszőlegesen kiválasztott autó szerkesztését teszi lehetővé. Itt módosítható az összes adat a legfontosabb az ár.
   **Új autó**: Itt van lehetőség új autó hozzűadására minden beviteli mező kitöltésével.
   **Javítás alatt**: Itt azokat az autókat lehet szerkeszteni amelyek jelenleg javítása alatt vannak vagy még nincs befejezve a javítás, de már dolgozott rajta valaki vagy akoz amelyekkel még sajnos nem tudtunk foglalkozni.
   **Összesítő**: Itt a végelszámolás kerül kiírásra a már elkészült illetve kifizetett javítások.

### 6. Képernyőtervek