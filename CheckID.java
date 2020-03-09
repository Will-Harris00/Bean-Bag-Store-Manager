package beanbags;

public class CheckID {
    public static void CheckID(String id) throws IllegalIDException {
        if (id.length() == 8) {
            try {
                // long decimal = Long.parseLong(id, 16);
                // long decimal = Long.valueOf(id, 16);
                int decimal = Long.valueOf(id, 16).intValue();
                if (decimal < 0) {
                    throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a positive number");
                }
                System.out.println(decimal);
            } catch (NumberFormatException e) {
                throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a hexadecimal number");
            }
        } else {
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Hex is not eight characters in length");
        }
    }
}

