package de.ChrisGold.ChrisUtil;

public class Main {

    public static void main(String[] args) {

    }

    static void generateUnbox(){
        String base = "    public static %2$s[] box(%1$s[] unboxed) {\n" +
                "        %2$s[] boxed = new %2$s[unboxed.length];\n" +
                "        for (int i = 0; i < boxed.length; i++) {\n" +
                "            boxed[i] = unboxed[i];\n" +
                "        }\n" +
                "        return boxed;\n" +
                "    }";

        String[] boxTypes = {"Integer","Long","Double","Float","Character","Byte","Short"};
        String[] primitiveTypes = {"int","long","double","float","char","byte","short"};

        for (int i = 0; i < boxTypes.length; i++) {
            System.out.println(String.format(base, primitiveTypes[i], boxTypes[i]));
            System.out.println();
        }
    }
}
