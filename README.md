# DeltaLoto

DeltaLoto on lihtne loterii simulaator, mis on inspireeritud Delta koolimajast ja loteriist. See programm on loodud hariduslikel eesmärkidel, et tutvuda objektorienteeritud programmeerimisega.

## Klasside Struktuur

### Mängija
- **Kirjeldus:** Hoiab mängija andmeid, sealhulgas nime, rahalist seisu ja statistikat võidetud/kaotatud raha kohta.
- **Peamised Meetodid:**
  - Konstruktor, get- ja set-meetodid
  - Meetodid rahalise seisu uuendamiseks

### Loto
- **Kirjeldus:** Sisaldab mängu loogikat, nagu numbrite loosimine ja võitjate määramine.
- **Peamised Meetodid:**
  - Mängu alustamine
  - Numbrite loosimine
  - Võitjate määramine

### MänguHaldur
- **Kirjeldus:** Haldab mängu üldist voogu ja suhtlust `Mängija` ja `Loto` klasside vahel.
- **Peamised Meetodid:**
  - Mängu alustamine
  - Mängijate haldamine
  - Mängu lõpetamine

### Statistika
- **Kirjeldus:** Hoiab mängu statistikat, nagu mängude arv, võidud, kaotused jne.
- **Peamised Meetodid:**
  - Statistika haldamine ja kuvamine

### Kasutajaliides
- **Kirjeldus:** Haldab kogu kasutajaga suhtlemist, kasutades `JOptionPane` või `Scanner` klassi.
- **Peamised Meetodid:**
  - Kasutajalt sisendi küsimine
  - Tagasiside andmine


## Funktsionaalsus

- **Mängu Simulatsioon:** DeltaLoto simuleerib loterii loosimist, kus kasutaja saab valida numbreid ja näha, kas ta võidab.
- **Kasutajaliides:** Programm kasutab `JOptionPane` klassi, et küsida kasutajalt sisendit ja anda tagasisidet.
- **Juhuslikkus:** Kasutab `Random` klassi juhuslike numbrite genereerimiseks, et simuleerida loterii loosimist.

## Kasutamine

## Autorid

## Märkused

- Programm on loodud hariduslikel eesmärkidel ja ei ole mõeldud päris loterii simuleerimiseks.
