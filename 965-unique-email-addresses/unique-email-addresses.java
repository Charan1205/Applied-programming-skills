import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        // Set to store the "normalized" email addresses
        Set<String> normalizedEmails = new HashSet<>();

        for (String email : emails) {
            // Split into local and domain parts
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex); // Keep the '@' with the domain

            // Rule 1: Everything after the first '+' in the local name is ignored
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }

            // Rule 2: Remove all '.' from the local name
            local = local.replace(".", "");

            // Reconstruct the email and add to the set
            normalizedEmails.add(local + domain);
        }

        // The size of the set represents the number of unique addresses
        return normalizedEmails.size();
    }
}