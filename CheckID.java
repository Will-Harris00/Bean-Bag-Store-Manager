// Exception handler for the ID of a new bean bag to see if it has a valid format.

package beanbags;

public class CheckID {
    public static void validId(String id) throws IllegalIDException {
        if (id.length() == 8) {
            // long decimal = Long.parseLong(id, 16);
            // long decimal = Long.valueOf(id, 16);
            int decimal = Long.valueOf(id, 16).intValue();
            if (decimal < 0) {
                throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a positive number");
            }
            // Checks for IDs which don't have a length of 8.
        } else {
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Hex is not eight characters in length");
        }
    }
}
