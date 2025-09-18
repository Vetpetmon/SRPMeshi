# Scape and Meshi
Dungeon Meshi, but for SRP. Sorry, Loneguy, we're making meals out of the parasites, it's canon and you cannot stop us.

Made by official SRP developers & artists.

> There's so many cursed foodstuff possibilities with SRP... It only makes sense that there's a separate mod that updates rapidly compared to the main mod.
> That way, we don't have to wait for SRP to update to see our stuff in action.
> Thus, I propose making energy drinks out of Yelloweye acid.   -モドローム, 2025

## Developers
- Main dev: Modoromu (モドローム) of SRP
- Placeholder artist: Modoromu (モドローム) of SRP
- Main artist: Bilebirda of SRP

## Bug Reporting

For reporting errors, please don't use Discord. Use GitHub Issues instead, and post logs and crashlogs through [mclo.gs](https://mclo.gs/).

## Contributing

Please read the [License](https://github.com/Vetpetmon/SRPMeshi/blob/main/LICENSE.txt) before contributing. Fork this repository, make your edits, explain your changes, and create a PR to [Vetpetmon/SRPMeshi](https://github.com/Vetpetmon/SRPMeshi). Only Modoromu may edit the License. Git will automatically handle technical credits.

*Modoromu will add credits to the [License](https://github.com/Vetpetmon/SRPMeshi/blob/main/LICENSE.txt) promptly after the merge. If you wish to not be credited, please inform the main dev (Modoromu) in the description of your PR. You will be anonymized upon request.*

**If you do not follow the instructions to fork and send a PR to the root repository, your contributions will not be accepted due to inability to grant technical credits. Internal (SRP team) contributions are excluded from this requirement & are permitted to contribute directly.**

## Mod Integrations & Interactions
<table class="tg"><thead>
  <tr>
    <th class="tg-0pky">Mod</th>
    <th class="tg-0pky">Feature</th>
    <th class="tg-0pky">Status</th>
  </tr></thead>
<tbody>
  <tr>
    <td class="tg-0pky" rowspan="2">Terrafirmacraft/Terrafirmagreg</td>
    <td class="tg-0pky">Nutrition stats</td>
    <td class="tg-0pky">Done, in balancing stage</td>
  </tr>
  <tr>
    <td class="tg-0pky">Firepit/Charcoal Forge recipes</td>
    <td class="tg-0pky">Done</td>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="3">Scape and Run: Parasites</td>
    <td class="tg-0pky">Loot drops (native)</td>
    <td class="tg-0pky">SRP Patreon Build Only</td>
  </tr>
  <tr>
    <td class="tg-0pky">Loot drops (1.9 support)</td>
    <td class="tg-0pky">Not started, may be covered by SRPMixins</td>
  </tr>
  <tr>
    <td class="tg-0pky">TFC nutrient data</td>
    <td class="tg-0pky">Patreon SRP builds only</td>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="2">Scape and Run: Parasites Extra</td>
    <td class="tg-0pky">Food Items</td>
    <td class="tg-0pky">Planned</td>
  </tr>
  <tr>
    <td class="tg-0pky">Loot drops (native)</td>
    <td class="tg-0pky">Planned</td>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="2">Deep Sea Danger</td>
    <td class="tg-0pky">Food Items</td>
    <td class="tg-0pky">Planned</td>
  </tr>
  <tr>
    <td class="tg-0pky">Loot drops (native)</td>
    <td class="tg-0pky">Planned</td>
  </tr>
  <tr>
    <td class="tg-0lax">Scape and Run Holiday</td>
    <td class="tg-0lax">Food Items</td>
    <td class="tg-0lax">Planned</td>
  </tr>
  <tr>
    <td class="tg-0lax">How Do I Prove It?</td>
    <td class="tg-0lax">No</td>
    <td class="tg-0lax">Never</td>
  </tr>
</tbody></table>

## Building (For Developers)

SRP Meshi does not come bundled with IDE run tasks, they will have to be added yourself.

In your IDE, run `setupDecompWorkspace`, wait until the provided Gradle Wrapper finishes the task before proceeding.

- To build the jar, run `build` through a Gradle task.
- To test the jar, run `runClient` and ensure server compatibility by running `runServer`.
- **Never** declare a version as complete without running `runServer` prior to release.

Notice for mod compatibility testing: Due to the nature of some mods, they cannot be tested in a debug (decomp, deobfuscated) environment; they will crash outright. Instead, use Curseforge or Prism instances to test the compatibility or integration modules.



# Changelog:

## 1.7
A large amount of balancing changes based on user feedback and Parafirmagreg SMP observations

- Many non-protein food values were bumped up (Terrafirmacraft integration)
- Raw meats rot faster (Terrafirmacraft integration)
- Living armor set now craftable
- Effect duration can now be multiplied via config option
- Added Firepit (Heat) recipes for items (Terrafirmacraft integration)

## 1.6
I regret to inform you that beckons are vegetarian-friendly.

- Added Raw Buglin (ID: raw_buglin) (Requires SRP config modifications)
- New textures by Bilebirda
- Roasted Buglin is now made by smelting Raw Buglin
- Added configs
- Configs are accessible in-game
- Effects can now be toggled, see independent toggles below
- Positive effects can be toggled
- Negative effects can be toggled
- AlwaysEdible can be toggled
- Terrafirmacraft integration
- Terrafirmacraft integration can be disabled in favor of CraftTweaker scripting

## 1.5
- Added Devourer Calamari (ID: srpmeshi:devourercala)
- Added Devourer Sushi

Don't worry if the new food items are currently unobtainable, official integration is on the way.
For pack makers, you can add Raw Vilebeef (ID: vilebeefr) and Devourer Calamari to the loot tables.


## 1.4
- Added Rotdog
- Added Vilebeef (ID: vilebeefr)
- Added Vilesteak 

## 1.3
- Fixed recipe for the Core Kebab
- Added Beckon Chicharrón
- Added zh_cn.lang (PLuMa nocTis)

## 1.2
- Made cooked & raw ground tendons wolf food
- Added membrane bread
- Added tendon sandwich & membrane bread alt
- Added summoner jelly sandwich & membrane bread alt
- Added core kebab
