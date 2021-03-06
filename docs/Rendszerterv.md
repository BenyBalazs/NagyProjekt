# Rendszerterv

### 1. Bevezetés

A rendszerterv elkészítésének a célja, hogy a program fejlesztői részére pontos, átfogó, részletes leírást adjon a rendszerrel kapcsolatos összes fontos szakmai kérdést illetően. A továbbfejlesztett program egy kisvárosi autószerelőműhely mindennapi működését kívánja segíteni. A tervezők célja, hogy lecseréljék az eddigi papír alapú szervíz nyílvántartást, melyet a project elkészülte után kizárólag elektronikusan az alkalmazáson keresztül kívánnak vezetni. Ez az újítás nagyban elősegíti majd az alkalmazottak (autószerelők) munkáját, illetve hozzájárul a munkafolyamatok meggyorsításához is.
Célplatformunk cégünk, valamint munkatársank tulajdonában álló számítógépek valamint laptopok, melyek Windows 10 operációs rendszert használnak.
A digitalizálás hatására reményeink szerint sokkal átláthatóbb, könnyedén kezelhető alkalmazást kapunk, melyet munkatársaink előszeretettel használnak majd munkájuk során.

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

### 4. Ütemterv

#### 4.1 Mérföldkövek

A program elkészítésének főbb mérföldkövei:

##### 4.1.1 Sprint I.

- Trello regisztráció, ismerkedés a trello környezetével.
- Git repository elkészítése
- Fejlesztésben résztvevő tagok gitre történő regisztrációja, valamint projecthez való felvételük
- Követelményspecifikáció elkészítése
- Rendszerterv elkészítése
- Program prototípusának elékszítése

##### 4.1.2 Sprint II.

- Rendszer tesztjének felállítása
- Program adatbázisának elkészítése
- Program kontrollerének megírása
- Program tesztelése minimális funkciókkal

##### 4.1.3 További sprintek

- Program biztonságának növelése, felkészítése az éles használatra


### 5. Üzleti szereplők

A programot az éppen használó szerelő és adminisztrációs munkatárs. A szerelő műhely összes alkalmazottjának megvan a végzettsége és a tudása ahhoz, hogy a programot magabiztosan képes legyen használni. Az új munkatársak pedig betanításon esnek át, mielőtt használatba vennék az alkalmazást.

#### 5.1. Üzleti entitások

- A szoftvert használó adminisztációs munkatársak
- A szoftvert használó szerelők
- Azon munkatársak akik a későbbiekben kerülnek felvételre

### 6. Követelmények

#### 6.1 Funkcionális követelmények

- Könnyedén kezelhető rendszer
- Letisztult, könnyedén átlátható adatbázis rendszer
- Egyszerű lekérdezések generálása a rendszerből
- Egyszerűsített adatfelvétel és módosítás

#### 6.2 Nem funkcionális követelmények

- Egyszerű, könnyen kezelhető felhasználói felület
- Optimalizált betűméretek, színek és típusok

### 7. Funkcionális terv

Az alkalmazás célja, az autószerelő műhelyben zajló adminisztrációs folyamatok megkönnyítése. A jelenleg használt papír alapú javításnapló teljes lecserélése, teljes mértékben elektronikus formátumra. Terveink szerint a korábbi alkalmazásunk (kis project) elemei teljes mértékben integrálásra kerülnek, többek közt:

- új autó felvétele
- autó állapotának módosítása
- átvételre váró autók (kész autók.)

### 8. Rendszerszereplők

A rendszerben mindösszesen egy csoport szerepel, az autószerelők csoportja. 

Az alkalmazást az autószerelők csoportja fogja használni, mindennapi munkájuk folyamán. 


### 9. Rendszerhasználati esetek és lefutásai

Tulaj és autó hozzáadása a rendszerhez:
![Tulaj és autó hozzáadása a rendszerhez](https://raw.githubusercontent.com/BenyBalazs/NagyProjekt/master/docs/kepek/felvetel.png)

Autó státuszának módosítása a rendszerben:
![Autó státuszának módosítása a rendszerben](https://raw.githubusercontent.com/BenyBalazs/NagyProjekt/master/docs/kepek/statusz%20v%C3%A1lt%C3%A1s.png)

Szerelő hozzáadása a rendszerhez:
![Szerelő hozzáadása a rendszerhez](https://raw.githubusercontent.com/BenyBalazs/NagyProjekt/master/docs/kepek/szerelo.png)

Törlés a rendszerből:
![Törlés a rendszerből](https://raw.githubusercontent.com/BenyBalazs/NagyProjekt/master/docs/kepek/torles.png)

#### 9.1 Hardver és hálózati topológia:
A számítógépnek amin ezt a szoftvert használni kívánják el kell érnie a MySQL adatbázist ami lehet lokális is, de internetre telepített is, ezért javasolt az internetelérés biztosítása azon a számítógépen melyen a szoftvert használni kívánják.

A gépeknek nem feltétlenül kell erősnek lenniük azonban a szoftver használatához ssd javasolt. 

Az alacsony rendszerigény a következő: 
- 3GB RAM
- Működő processzor
- Integrált működő videókártya
- ssd
- megjelenítő

A szoftver célplatformja a Microsoft Windwos 10 operációs rendszer. Azonban a Java platformfüggetlen megvalósítása miatt a program képes futni a Java 15-el kompatibilis Linux rendszereken is.

### 10. Fejlesztő eszközök

   A project során használt fejlesztői eszközök:
   
   - Java 15
   - Maven 3
   - MySQL
   - JavaFx

### 11. Keretrendszer

   - Entity
   - Spring Boot
   - Afterburner.fx

### 12. Archtekturális terv
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
   
   ### 12.3 Adatbázis
   A program több táblát használ. Külön tároljuk az autókat a tulajdonosoktól. Így egy tulajnak lehet több autója is. Az autók adatait is elkülönítve tároljuk a hatékonyabb tárolás végett. A programban megjelent a szerelők tábla, hogy nyomon tudjuk követni min ki dolgozott. És a program lelke a repair tábla
   itt tartjuk számon a javításokat. a séma a következő.
   ![Séma-Tervezet](https://raw.githubusercontent.com/BenyBalazs/NagyProjekt/master/docs/kepek/adatbazis_sema.png)
   
   # 13 Implementációs terv
   A tervezés folyamán egy grafikus megjelenítési formát célszerű használni jelen esetben ez az UML az úgynevezett Unified Modeling Language osztálydiagrammjai lesznek. Célszerű használni továbbá a Rendszerhasználati esetek alatt található use case diagrammokat is.
   
   ### 13.1. Perzisztencia-osztályok:
   
   Az adatbáziskezelésben a perzisztenciát a java nyelvhez készített hybernate programkönyvtárat használjuk amit a Maven plugin importálásával adunk hozzá a programhoz. Perzisztencia osztályok: 
   - DBUtils
   - HibernateUtils
   
   ### 13.2. Üzleti logika osztályai:
   
   Az üzleti logika a háromrétegű adatkezelő alkalmazások középső rétege, amely meghatározza az alkalmazás működésének logikáját. A háromrétegű architektúra az alkalmazást három különálló rétegre osztja fel. E rétegek komponensei önállóan léteznek, és együttműködésük során egyidejűleg több különböző alkalmazásnak is a részei lehetnek. Az adatbázislogika az adatok nyers tárolását végzi. Semmilyen információval nem rendelkezik az adatok feldolgozásával vagy megjelenítésével kapcsolatban. Az ügyviteli (üzleti) logika az alkalmazás logikáját, működési szabályait határozza meg. Semmilyen információval nem rendelkezik az adatok tárolásával vagy megjelenítésével kapcsolatban. A felhasználói interfész feladata az ügyviteli logika által küldött adatok formázása és megjelenítése. Biztosítja a felhasználó hozzáférését az ügyviteli logika szolgáltatásaihoz. Sohasem kerül közvetlen kapcsolatba az adatbázissal, és nem végez semmilyen műveletet az adatokon.
   
   ### 14. Teszt terv:
   
   |  Kód |  Leírás |
   |---|---|
   | T1  | A program elindul  |
   | T2  | A program csatlakozik az adatbázishoz  |
   |  T3 | A program leellenörzi az adatbázist  |
   |  T4 | A legenerálja az adatbázist amennyiben az nem létezik  |
   |  T5 | A program helyreállítja az adatbázist ha az hiányos  |
   |  T6 | A program grafikus felülete megjelenik  |
   |  T7 | A program a kívánt css-el jelenik meg |
   |  T8 | A programot lehet méretezni  |
   |  T9 | A program a felvétel gombra kattintva a gomb elsötétül.  | 
   |  T10 | A hozzádás ablak megnyílik  |
   |  T11 | A hozzádásablak nem méretezhető  |
   |  T12 | A hozzádásablak a megfelelő stíluslappal jelenik meg.  |
   |  T13 | A hozzádásablak mögött lévő főmenü nem kattintható  |
   |  T14 | A meglévő tulaj/ új tulaj gombok közül csak az egyik választható |
   |  T15 | Meglévő tulaj esetén az új tulaj mezők elsötétülnek |
   |  T16 | új tulaj esetén a beviteli mezők aktívvá válnak.  |
   |  T17 | A beviteli mezőkbe lehet adatot bevinni.  |
   |  T18 | Hibás adatok esetén a program figyelmeztet.  |
   |  T19 | Üresenhagyott mezők esetén a program figyelmeztet. |
   |  T20 | Továbbgomb megnyomására a program továbblép az autó hozzádására.  |
   |  T21 | A beviteli mezők szerkeszthetőek az új aztó hozzádásánál.  |
   |  T22 | Mentésgom megnyomása esetén a program feltölti az adatbázisba az entitásokat  |
   |  T23 | A mentés gomb megnyomása után a program felugró ablakban informálja a felhasználót.  |
   |  T24 | Párbeszédablak bezárása után a program bezárja a hozzádásablakot  |
   |  T25 | A vezérlés visszaáll a főmenüre.  |
   |  T26 | A program az autók és tulajok gombra kattintva a gomb elsötétül.  |
   |  T27 | A program az autók és tulajok gombra kattintva betölti az autók és tulajok kezelésére szolgáló felületet.  |
   |  T28 | Az autók és tulajok felület a kívánt stílussal jelenik meg.  |
   |  T29 | A listába megfelelően betöltenek a tulajdonosok.  |
   |  T30 | A listába egy tulajra duplán kattintva megjelennek az autói a mellette lévő listában.  |
   |  T31 | A kereső mezőbe beírva egy nevet és a keresés gombra kattintva, a listában megjelenik az adott tulaj.  |
   |  T32 | A tulaj szerkesztése gombra kattintva megnyílik egy új ablakban a tulaj adatainak szerkesztésére szolgáló felület.  |
   |  T33 | Az autó törlése gombra bejön a megerősítő ablak, hogy törölni akarjuk-e az autót.  |
   |  T34 | Az autó törlésének megerősítése esetén, törlődik az autó.  |
   |  T35 | Az autó és munkafolyamatok szerkesztése gombra kattintva megnyílik egy új ablakban a munkafolyamatok kiválasztására szolgáló felület.  |
   |  T36 | A tulaj szerkesztő felülete megnyitáskor betölti a tulaj adatait.  |
   |  T37 | Lehetőség van a tulaj nevének módosítására.  |
   |  T38 | Lehetőség van a tulaj címének módosítására.  |
   |  T39 | Lehetőség van a tulaj telefonszámának módosítására.  |
   |  T40 | Lehetőség van a tulaj email címének módosítására.  |
   |  T41 | Lehetőség van a tulaj születési dátumának módosítására.  |
   |  T42 | A mentés gombra kattinta menti a tulaj módosított adatait és egy felugró ablakban értesít a sikeres mentésről.  |
   |  T43 | A tulaj törlése gombra kattintva egy felugró ablak megkérdezi hogy biztosan törli-e az adatokat.  |
   |  T44 | Ha megerősíti a felhasználó, akkor törli a tulaj adatait.  |
   |  T45 | A munkafolyamok felület amikor megnyílik betöltődnek az autó munkafolyamatai.  |
   |  T46 | A munkafolyamat kiválasztása után a munkafolyamat törlése gombra kattintva egy fugró ablakban megerősítés után, törlődik a munkafolyamat.  |
   |  T47 | A munkafolyamat kiválasztása után a szerkesztés gombra kattintva megnyílik a munkafolyamat szerkesztése felület.  |
   |  T48 | A munkafolyamat szerkesztése felületen a megnyitáskor betölt az autó adatai.  |
   |  T49 | Lehetőség van az autó adatainak módosítására.  |
   |  T50 | Lehetőség van a szerelés költségeinek a megadására.  |
   |  T51 | Lehetőség van a szerelés státuszainak módosítására.  |
   |  T52 | Egy listába megjeleníti a szerelőket, akik dolgoznak az autón.  |
   |  T53 | Lehetőség van új szerelő hozzáadására a szerelők közé.  |
   |  T54 | Lehetőség van szerelőt eltávolítani a munkafolyamatból.  |
   |  T55 | A mentésre kattintva menti a munkafolyamat módosításait.  |
   |  T56 | A program indítása után a megfelelő helyen megjelenik a dolgozó felvétel gomb  |
   |  T57 | Amennyiben a dolgozó felvétel gomb fölé visszük a cousor-t abban az esetben a szöveg pirosra vált   |
   |  T58 | A dolgozó felvétel gombra kattintva felugrik a megfelelő ablak   | 
   |  T59 | A név mező valid, képesek vagyunk beleírni a megfelelő adatokat   | 
   |  T60 | Az email mező valid, képesek vagyunk beleírni a megfelelő adatokat   | 
   |  T61 | A Telefonszám mező valid, képesek vagyunk beleírni a megfelelő adatokat   | 
   |  T62 | A Telefonszám mezőbe, csak a megfelelő formátumú telefonszámot tudjuk megadni   | 
   |  T63 | A születési dátum mező valid | 
   |  T64 | A születési dátum mező mellett található naptár ikonra kattintva megjelenik a naptár | 
   |  T65 | A naptárban a megfelelő dátumot kiválasztva, sikeresen megjelenik a születési dátum mező szövegdobozában | 
   |  T66 | A name mezőt kitöltve, értéke sikeresen mentésre kerül az adatbázisban |
   |  T67 | Az email mezőt kitöltve, értéke sikeresen mentésre kerül az adatbázisban | 
   |  T68 | A Telefonszám mezőt kitöltve, értéke sikeresen mentésre kerül az adatbázisban | 
   |  T69 | A születési dátum mezőt kitöltve, értéke sikeresen mentésre kerül az adatbázisban | 
   |  T70 | A mentés gombra kattintva, az összes megadott adat sikeresen mentésre kerül az adatbázisban | 
   |  T71 | Amennyiben a dolgozó gomb fölé visszük a cousor-t abban az esetben a szöveg pirosra vált | 
   |  T72 | A dolgozó gombra kattintva megjelenik a megfelelő ablak | 
   |  T73 | Az ablakban sikeresen kilistázásra kerülnek a korábban felvett szerelők | 
   |  T74 | A megjelenő listában a megfelelő szerelő fölé húzva a cousort, a szöveg pirosra vált | 
   |  T75 | A megfelelő listaelemre kattintva, a kijelölt sor háttere szürkére vált | 
   |  T76 | A szerkesztés gomb valid, a hozzá kapcsolódó funkció megfelelően működik | 
   |  T77 | A törlés gomb valid, a hozzá kapcsolódó funkció megfelelően működik | 
   |  T78 | A szerkesztés gomb csak akkor valid, amennyiben egy sor ki van jelölve | 
   |  T79 | A törlés gomb csak akkor valid, amennyiben egy sor ki van jelölve | 
   |  T80 | Egy sor kijelölése esetén a szerkesztés gombra kattintva felugrik a szerkesztési felület  | 
   |  T81 | A megjelenő szerkesztő felületben név mező valid, szerkeszthető  | 
   |  T82 | A megjelenő szerkesztő felületben email mező valid, szerkeszthető  |
   |  T83 | A megjelenő szerkesztő felületben telefonszám mező valid, szerkeszthető  | 
   |  T84 | A megjelenő szerkesztő felületben születési dátum mező valid, szerkeszthető  | 
   |  T85 | Az adatok sikeresen módosításra kerülnek az adatbázisban  | 
