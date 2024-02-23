package hex2ip;

public class Hex2IP {
    
    public void convertIpToHex(String ip) {
        String[] separatedIp = ip.split("\\.");
        String[] hexDec = new String[4];
        
        for (int i = 0; i < separatedIp.length; i++) {
            int decimal = Integer.parseInt(separatedIp[i]);
            String hexadecimal = Integer.toHexString(decimal).toUpperCase();
            
            if (hexadecimal.length() == 1) {
                hexadecimal = "0" + hexadecimal;
            }
            
            hexDec[i] = hexadecimal;
        }
        String hexCode = String.join("", hexDec);
        System.out.println("La IP: " + ip + " a Hexadecimal es: " + hexCode);
    }
    
    public void convertHexToIp(String hex) {
        int oct = hex.length() / 2;
        String[] octPairs = new String[oct];
        int[] decPairs = new int[oct];
        
        if (hex.length() < 8) {
            System.out.println("Ingresa un cadena hexadecimal valida (8 caracteres).");
        }
        
        for (int i = 0; i < oct; i++) {
            String pair = hex.substring(2 * i, 2 * i + 2);
            if (!pair.matches("[0-9A-Fa-f]{2}")) {
                System.out.println("La cadena hexadecimal contiene caracteres no válidos.");
                return;
            }
            octPairs[i] = pair;
        }
        
        for(int i = 0; i < oct; i++) {
            decPairs[i] = Integer.parseInt(octPairs[i], 16);
        }
        
        String ip = String.join(".", Integer.toString(decPairs[0]), Integer.toString(decPairs[1]), Integer.toString(decPairs[2]), Integer.toString(decPairs[3]));
        
        System.out.println("El dexadecimal: " + hex + " a direccion IP es: " + ip);
    }
    
    public static void main(String[] args) {
        boolean isParameterMissing;
        Hex2IP htip = new Hex2IP();
        
        switch (args.length) {
            case 0 -> {
                System.out.println("No se proporcionaron argumentos.");
                return;
            }
            case 1 -> isParameterMissing = true;
            default -> isParameterMissing = false;
        }
        
        if (args[0].equals("-hex") && !isParameterMissing) {
            htip.convertHexToIp(args[1]);
        }
        else if (args[0].equals("-ip") && !isParameterMissing){
            htip.convertIpToHex(args[1]);
        }
        else if (isParameterMissing){
            System.out.println("Segundo parametro vacio no permitido.");
        }
    }
}
