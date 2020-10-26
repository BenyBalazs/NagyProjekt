# Rendszerterv

### 2. A rendszer célja

A rendszer célja, hogy az autószerelő műhely egy korábbi szoftver verzióját továbbfejlessze. Ezáltal egy sokkal modernebb, fejlettebb, és funkciókban gazdagabb alkalmazás lesz, mely nagyban elősegíti a dolgozók munkáját. Ennek köszönhetően új lehetőségek nyílnak meg a dolgozók előtt és hatékonyabban tud működni a műhely.

### 3. A projekt tervezete

#### 3.1 A rendszer felépítése

Az adatbázis kapcsolathoz szükséges négy modell osztály,
amely létrehozza, fenntartja, és zárja az adatbáziskapcsolatot.
A felszedett adatokat megfelelően repzezentálva szolgáltatjuk, továbbá a felületen lehetőségük nyílik új munkák felvételére, a meglévő munkafolyamatok módosítására, továbbá a dolgozók kezelésére. A grafikus megjelenítést JavaFX segítségével valósítjuk meg. A program controller részének megvalósítását Java programozási nyelven terveztük el. A projekthez továbbá felhasználtuk a Maven nevű projekt menedzsment eszköztárat is.

#### 3.2 Projektmunkások és felelősségeik

A projektet készítő három személy teljesen egyenjogú szerepkörökkel rendelkezik. Mind hármuk kiveszi a részét a munka minden egyes fázisából és részéből. Mindnyájan egyenrangú fejlesztői a programnak.

| Név |   Szerepkör |
| -----------|--------- |
| Benyovszki Balázs Zoltán  | szoftverfejlesztő |
| Csontos Róbert  | szoftverfejlesztő |
| Kis Patrik    | szoftverfejlesztő |

### 5. Üzleti szereplők

A programot az éppen használó szerelő és adminisztrációs munkatárs. A szerelő műhely összes alkalmazottjának megvan a végzettsége és a tudása ahhoz, hogy a programot magabiztosan képes legyen használni. Az új munkatársak pedig betanításon esnek át, mielőtt használatba vennék az alkalmazást.

#### 5.1. Üzleti entitások

- A szoftvert használó adminisztációs munkatársak
- A szoftvert használó szerelők
- Azon munkatársak akik a későbbiekben kerülnek felvételre

### 6. Követelmények



### Archtekturális terv
   A rendszert felépítő szoftverkomponensek, a Java , Maven, Sql (mysql). Ezen szoftverkomponensek Java FX keretén belül kerülnek használatra.
   Az alrendszerek definiálása után, tulajdonságaikat felhasználva vezérlési és kommunikációs folyamatokat lehet létrehozni. A rendszer szerepe 
   az autók felvétele (irodavezető feladata) valamint a szerelők (autó javítási fázisai - javításra vár, javítás alatt, elkészült autó) közti kommunikáció megkönnyítése, elektronikus úton lehetővé tétele.
   Fontos továbbá a korai fejlesztési fázisok döntéseinek támogatása, a követelményrendszer függvényében. Ehhez szükségünk van különböző forrásokra mint pl: az autószerelő műhelynek üzleti valamint jelenlegi technológiai hátterére.
   Fejlesztőink ezen céljai valamint stratégiái által befolyásolt követelményei vezetnek különböző architektúrákhoz.
   Mint általában minden folyamatot , ezen folyamatot is egy ciklus körül képzeljünk el, mint a:
   - Szereplők
   - Követelmények
   - Technológiai környezet
   - Tervező(k) technológiával kapcsolatos tapasztalatai.
   
   Architektúra elemek:
   
   - Architektúrális minta
      - elemek, kapcsolatok, kényszerek
      - pl: kliens, adatbázis-szerver kapcsolat (minta)
   - Referencia modell
      - egyszerű funkcionális elosztás, adatfolyam kezelő megoldások
      - pl: adatbázis kezelő rendszer
   - Referencia architektúra
      - referencia modell leképezése a szoftver elemeire
      - pl: ISO-OSI architektúra
   ### 12.1. A rendszer bővíthetősége
   A rendszert minden esetben úgy kell megtervezni, hogy később könnyen módosítható és funkcionalitását teknitve akárki által bővíthető legyen. kollégáink is így fognak eljárni.
   
   ### 12.2. A rendszer biztonsági funkciói:
   A rendszer offline fut ezért csak az adatbáis és a kliens közötti biztonságos kommunikációt szükségek kiépíteni. Ezt kollégáink elvégzik.