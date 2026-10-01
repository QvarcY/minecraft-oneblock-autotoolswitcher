<p align="center">
  <img src="assets/readme-hero.png" alt="Minecraft OneBlock AutoToolSwitcher by QvarcY" width="100%">
</p>

<p align="center">
  <a href="https://github.com/QvarcY/minecraft-oneblock-autotoolswitcher/actions/workflows/build.yml"><img alt="Build" src="https://github.com/QvarcY/minecraft-oneblock-autotoolswitcher/actions/workflows/build.yml/badge.svg"></a>
  <a href="https://github.com/QvarcY/minecraft-oneblock-autotoolswitcher/blob/main/LICENSE"><img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-22c55e"></a>
  <a href="https://buymeacoffee.com/craftin"><img alt="Buy Me a Coffee" src="https://img.shields.io/badge/Buy_Me_a_Coffee-support-FFDD00?logo=buymeacoffee&logoColor=000"></a>
  <a href="https://github.com/sponsors/QvarcY"><img alt="GitHub Sponsors" src="https://img.shields.io/badge/GitHub_Sponsors-support-EA4AAA?logo=githubsponsors&logoColor=fff"></a>
</p>

<p align="center">
  <a href="#latviski">Latviski</a> · <a href="#english">English</a>
</p>

> Lightweight client-side Fabric mod for OneBlock players who are tired of doing pickaxe → axe → shovel → pickaxe gymnastics every few seconds

**Available builds:** Minecraft 26.2 and Minecraft 26.3 · Fabric Loader 0.19.5+ · Java 25

Minecraft 26.2 has been validated on a real multiplayer OneBlock server · Minecraft 26.3 has a verified compatible build and will be multiplayer-tested when suitable servers update

## Demo

**LV:** Reāls Minecraft 26.2 multiplayer OneBlock tests — AutoToolSwitcher automātiski pārslēdzas starp piemērotāko pickaxe axe un shovel kamēr uzbrukuma poga paliek nospiesta

**EN:** Real Minecraft 26.2 multiplayer OneBlock test — AutoToolSwitcher automatically switches between the best available pickaxe axe and shovel while the attack button stays held

<p align="center">
  <img src="assets/minecraft-oneblock-autotoolswitcher-demo-mc26.2.gif" alt="Minecraft OneBlock AutoToolSwitcher multiplayer demo" width="800">
</p>

---

## Latviski

### Kas tas ir

Minecraft OneBlock AutoToolSwitcher ir neliels client-side Fabric mods kas automātiski izvēlas piemērotāko rīku no hotbar brīdī kad roc bloku

Tas radīts OneBlock spēles režīmam kur viens un tas pats bloks nepārtraukti pārvēršas citā resursā tomēr tas var būt noderīgs arī parastā Survival spēlē

### Ko tas dara

- pārbauda bloku uz kuru pašlaik sit
- pārskata hotbar slotus 1–9
- izvēlas piemērotāko pieejamo rīku
- dod priekšroku rīkam kas nodrošina pareizu dropu
- neizmanto gandrīz salūzušus rīkus ja tiem palikušas 5 vai mazāk izturības vienības
- pārslēdzas tikai kamēr tiešām roc bloku
- darbojas tikai klienta pusē
- ar `V` var ieslēgt vai izslēgt automātisko pārslēgšanu

### Uzstādīšana

#### 1. Uzstādi Fabric Loader

Uzstādi Fabric Loader Minecraft 26.2 versijai

#### 2. Uzstādi Fabric API

Lejupielādē Fabric API versiju kas paredzēta Minecraft 26.2 un ievieto to `mods` mapē

#### 3. Lejupielādē AutoToolSwitcher

No GitHub Releases lejupielādē jaunāko `minecraft-oneblock-autotoolswitcher-*.jar`

#### 4. Ievieto mod failu Minecraft `mods` mapē

Windows noklusētais ceļš parasti ir

```text
%AppData%\.minecraft\mods
```

Ja `mods` mapes nav izveido to pats

Ja izmanto atsevišķu launcher profilu vai citu launcher tad izmanto konkrētās instances `mods` mapi

#### 5. Palaid Minecraft ar Fabric profilu

Atver pasauli vai OneBlock serveri un turi nospiestu kreiso peles pogu uz bloka

Mods izvēlēsies piemērotāko rīku no hotbar

### Atbalstītās Minecraft versijas

- ✅ Minecraft 26.2 — pieejams builds un pārbaudīts reālā multiplayer OneBlock serverī
- ✅ Minecraft 26.3 — pieejams saderīgs builds un pārbaudīts ar CI build testu

### Vadība

`V` — ieslēgt vai izslēgt AutoToolSwitcher

Taustiņu var mainīt Minecraft sadaļā `Options → Controls → Key Binds`

### Multiplayer

Šis ir client-side mods un serverī nekas nav jāinstalē

Tomēr multiplayer serveriem var būt savi noteikumi par automātiskiem QoL rīkiem tāpēc pirms lietošanas pārbaudi konkrētā servera noteikumus

### Būvēšana no pirmkoda

Nepieciešams Java 25

```powershell
.\gradlew.bat build
```

Gatavais JAR būs mapē

```text
build\libs
```

### Atbalsti projektu

- ☕ **[Buy Me a Coffee](https://buymeacoffee.com/craftin)** — atbalsti projekta turpmāku izstrādi
- ❤️ **[GitHub Sponsors](https://github.com/sponsors/QvarcY)** — atbalsti QvarcY open-source projektus
- 🐙 **[QvarcY GitHub](https://github.com/QvarcY)** — citi projekti un eksperimenti

---

## English

### What is it

Minecraft OneBlock AutoToolSwitcher is a small client-side Fabric mod that automatically picks the most suitable tool from your hotbar while you are mining a block

It was built for OneBlock where the same block keeps turning into completely different resources but it can also be useful in regular Survival

### What it does

- checks the block you are currently mining
- scans hotbar slots 1–9
- selects the best available tool
- prefers tools that preserve the correct block drops
- avoids nearly broken tools with 5 or fewer durability points left
- switches only while you are actually mining
- runs entirely on the client
- press `V` to toggle automatic switching

### Installation

#### 1. Install Fabric Loader

Install Fabric Loader for Minecraft 26.2

#### 2. Install Fabric API

Download the Fabric API build for Minecraft 26.2 and place it in your `mods` folder

#### 3. Download AutoToolSwitcher

Download the latest `minecraft-oneblock-autotoolswitcher-*.jar` from GitHub Releases

#### 4. Put the mod in your Minecraft `mods` folder

The default Windows location is usually

```text
%AppData%\.minecraft\mods
```

Create the `mods` folder if it does not exist

If you use a launcher with separate instances use that instance's own `mods` folder instead

#### 5. Launch Minecraft with Fabric

Open your world or OneBlock server and hold the left mouse button on a block

The mod will choose the most suitable hotbar tool automatically

### Supported Minecraft versions

- ✅ Minecraft 26.2 — available build validated on a real multiplayer OneBlock server
- ✅ Minecraft 26.3 — available compatible build verified by CI

### Controls

`V` — toggle AutoToolSwitcher

You can change the key in `Options → Controls → Key Binds`

### Multiplayer

This is a client-side mod and nothing needs to be installed on the server

Multiplayer servers can have their own rules for automation and QoL mods so check the rules of the server you play on

### Building from source

Java 25 is required

```powershell
.\gradlew.bat build
```

The built JAR will be available in

```text
build\libs
```

### Support the project

- ☕ **[Buy Me a Coffee](https://buymeacoffee.com/craftin)** — support continued development
- ❤️ **[GitHub Sponsors](https://github.com/sponsors/QvarcY)** — support QvarcY's open-source work
- 🐙 **[QvarcY on GitHub](https://github.com/QvarcY)** — more projects and experiments

---

## License

MIT License

Created by [QvarcY](https://github.com/QvarcY)

Minecraft OneBlock AutoToolSwitcher is an independent community project and is not affiliated with Mojang or Microsoft
