# Harmful Stonecutters

[![GitHub release](https://img.shields.io/github/release/haykam821/Harmful-Stonecutters.svg?style=popout&label=github)](https://github.com/haykam821/Harmful-Stonecutters/releases/latest)
[![CurseForge](https://img.shields.io/static/v1?style=popout&label=curseforge&message=project&color=6441A4)](https://www.curseforge.com/minecraft/mc-mods/harmful-stonecutters)
[![Discord](https://img.shields.io/static/v1?style=popout&label=chat&message=discord&color=7289DA)](https://discord.gg/eXcffmW)

Makes stonecutters damage entities that stand on them.

Harmful Stonecutters requires the [Fabric modloader](https://fabricmc.net/use/) and [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api).

## Installation

1. Install [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) if it is not installed.
2. Download Harmful Stonecutters from [CurseForge](https://www.curseforge.com/minecraft/mc-mods/harmful-stonecutters/files) or [GitHub](https://github.com/haykam821/Harmful-Stonecutters/releases).
3. Place the downloaded file in your `mods` folder.

## Usage

When this mod is installed, all stonecutters will harm entities that stand on top of them without sneaking.

### Tags

This mod allows control over the blocks that slice entities. By default all blocks that are instances of `StonecutterBlock` will slice entities, but blocks added to the `#harmfulstonecutters:safe_stonecutters` tag will be exempt from this.

Any block in the `#harmfulstonecutters:always_slicing` tag will slice entities, even if it is not an instance of `StonecutterBlock` or is in the `#harmfulstonecutters:safe_stonecutters` block tag.
