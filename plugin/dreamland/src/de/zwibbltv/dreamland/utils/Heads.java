package de.zwibbltv.dreamland.utils;

import de.zwibbltv.dreamland.utils.ItemsUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Heads {
	Slime(       10, "Slime",       "slime", new ItemStack(Material.SLIME_BLOCK)),
    NetherWarts( 11, "NetherWarts", "netherwarts", new ItemStack(Material.QUARTZ)),
    Sponge(      12, "Sponge",      "sponge", new ItemStack(Material.SPONGE)),
    Cactus(      13, "Cactus",      "cactus", new ItemStack(Material.CACTUS)),
    Glass(       14, "Glass",       "glass", new ItemStack(Material.GLASS)),
    Leaves(      15, "Leaves",      "leaves", new ItemStack(Material.BIRCH_LEAVES)),
    TNT(         16, "TNT",         "tnt", new ItemStack(Material.TNT)),
    Globe(       19, "Globe",       "globe", ItemsUtils.getCustomSkull("YjFkZDRmZTRhNDI5YWJkNjY1ZGZkYjNlMjEzMjFkNmVmYTZhNmI1ZTdiOTU2ZGI5YzVkNTljOWVmYWIyNSJ9fX0")),
    BlackBalloon(20, "BlackBalloon","blackballoon", ItemsUtils.getCustomSkull("OTk2NzU0ZDMzMDQzNTM0NWFhZTNhOWYwNjNjZmNhNDJhZmIyOGI3YzVjNGJiOWYyOTRlZDI1MjdkOTYxIn19fQ")),
    WhiteBalloon(21, "WhiteBalloon","whiteballoon", ItemsUtils.getCustomSkull("Yjc4NTUxNjY5ODRhNzI1YmVjZmFjMWVhYjVjZmJkY2JlZTdlNDI2NDY2ZGRjM2JlZTRjNzFjZmQ3MmNiNTg4OCJ9fX0")),
    Illusion(    22, "Illusion",    "illusion", ItemsUtils.getCustomSkull("YjQ2MmRkZmE1NTNjZTc4NjgzYmU0NzdiOGQ4NjU0ZjNkZmMzYWEyOTY5ODA4NDc4Yzk4N2FiODhjMzc2YTAifX19")),
    Beachball(   23, "Beachball",   "beachball", ItemsUtils.getCustomSkull("NWE1YWIwNWVhMjU0YzMyZTNjNDhmM2ZkY2Y5ZmQ5ZDc3ZDNjYmEwNGU2YjVlYzJlNjhiM2NiZGNmYWMzZmQifX19")),
    Pokeball(    24, "Pokeball",    "pokeball", ItemsUtils.getCustomSkull("ZDQzZDRiN2FjMjRhMWQ2NTBkZGY3M2JkMTQwZjQ5ZmMxMmQyNzM2ZmMxNGE4ZGMyNWMwZjNmMjlkODVmOGYifX19")),
    RubiksCube(  25, "RubiksCube",  "rubikscube", ItemsUtils.getCustomSkull("OGYxYTI3N2JlYjllNGZhYTZlN2UzNTZjNzQ3ODZlOTY2MTU1NzM2YTY4NThiZjViYjVhZDI5ZGY1YmFiNjFhMSJ9fX0")),
    Globe2(      28, "Globe2",      "globe2", ItemsUtils.getCustomSkull("NGQ0OGU3NWZmNTVjYjU3NTMzYzdiOTA0YmU4ODdhMzc0OTI1ZjkzODMyZjdhZTE2Yjc5MjM5ODdlOTcwIn19fQ")),
    Eye(         29, "Eye",         "eye", ItemsUtils.getCustomSkull("MmNlZjg3NzcyYWZkODViNDY4ZjRjN2ZiOTU3MWUzMTQzNWVmNzY1YWQ0MTNmZTQ2MDI2MjE1MDQyM2UyMDIxIn19fQ")),
    Target(      30, "Target",      "target", ItemsUtils.getCustomSkull("ODZmY2FlZmExOTY2OWQ4YmUwMmNmNWJhOWE3ZjJjZjZkMjdlNjM2NDEwNDk2ZmZjZmE2MmIwM2RjZWI5ZDM3OCJ9fX0")),
    GreenOre(    31, "GreenOre",    "greenore", ItemsUtils.getCustomSkull("ZGM2YmFjZDM2ZWQ2MGY1MzMxMzhlNzU5YzQyNTk0NjIyMmI3OGVkYTZiNjE2MjE2ZjZkY2MwOGU5MGQzM2UifX19")),
    Firecharge(  32, "FireCharge",  "firecharge", ItemsUtils.getCustomSkull("OWMyZTlkODM5NWNhY2Q5OTIyODY5YzE1MzczY2Y3Y2IxNmRhMGE1Y2U1ZjNjNjMyYjE5Y2ViMzkyOWM5YTExIn19fQ")),
    CocoaPod(    33, "CocoaPod",    "cocoapod", ItemsUtils.getCustomSkull("NTA4M2VjMmIwMWRjMGZlZTc5YWEzMjE4OGQ5NDI5YWNjNjhlY2Y3MTQwOGRjYTA0YWFhYjUzYWQ4YmVhMCJ9fX0")),
    NetherPortal(34, "NetherPortal","netherportal", ItemsUtils.getCustomSkull("YjBiZmMyNTc3ZjZlMjZjNmM2ZjczNjVjMmM0MDc2YmNjZWU2NTMxMjQ5ODkzODJjZTkzYmNhNGZjOWUzOWIifX19"));

    private int slot;
    private String name;
    private String permission;
    private ItemStack item;

    Heads(int slot, String name, String permission, ItemStack item){
        this.item = item;
        this.name = name;
        this.permission = permission;
        this.slot = slot;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public String getName() {
        return this.name;
    }

    public String getPermission() {
        return "dreamland.balloons." + this.permission;
    }

    public int getSlot() {
        return this.slot;
    }
}