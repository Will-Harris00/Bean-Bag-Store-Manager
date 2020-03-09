/*
Exception handler for the ID of a new bean bag to see if it has a valid format.
*/

package beanbags;

public class CheckID {
    public static void CheckID(String id) throws IllegalIDException {
        if (id.length() == 8) {
            try {
                // long decimal = Long.parseLong(id, 16);
                // long decimal = Long.valueOf(id, 16);
                // Checks for a negative number (possible due to two's complement
                // representation).
                int decimal = Long.valueOf(id, 16).intValue();
                if (decimal < 0) {
                    throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a positive number");
                }
                // Checks for non-hexadecimal numbers.
            } catch (NumberFormatException e) {
                throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a hexadecimal number");
            }
            // Checks for IDs which don't have a length of 8.
        } else {
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Hex is not eight characters in length");
        }
    }
}
