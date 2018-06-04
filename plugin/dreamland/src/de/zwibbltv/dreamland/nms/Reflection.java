package de.zwibbltv.dreamland.nms;

import de.zwibbltv.dreamland.main.Main;

public final class Reflection {
    public static Class<?> getClass(PackageType type, String name){
        Class <?> clazz = null;
        try{
            clazz = Class.forName(type.getPath() + "." + Main.getInstance().version + "." + name);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return clazz;
    }

    public enum PackageType{
        NMS("net.minecraft.server"),
        OBC("org.bukkit.craftbukkit"),
        BFB("de.zwibbltv.dreamland.nms");
        private String path;

        PackageType(String path){
            this.path = path;
        }

        public String getPath() {
            return this.path;
        }
    }
}