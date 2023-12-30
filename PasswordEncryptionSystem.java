/**
 * @CLassname PasswordEncryptionSystem
 * @Description TODO
 * @Version 1.0.0
 * @Date §{DATE} §{TIME}
 * @Created by S{USER}
 */

    import java.util.Scanner;

    public class PasswordEncryptionSystem {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int choice;
            do {
                System.out.println("Password Encryption System:");
                System.out.println("1. Encrypt Password");
                System.out.println("2. Decrypt Password");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        encryptPassword(scanner);
                        break;
                    case 2:
                        decryptPassword(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 3);

            scanner.close();
        }

        private static void encryptPassword(Scanner scanner) {
            System.out.print("Enter the password to encrypt: ");
            int password = scanner.nextInt();

            if (password <= 0) {
                System.out.println("Invalid password. Please enter a number greater than 0.");
                return;
            }

            int encryptedPassword = encrypt(password);
            System.out.println("Encrypted password: " + encryptedPassword);
        }

        private static void decryptPassword(Scanner scanner) {
            System.out.print("Enter the password to decrypt: ");
            int encryptedPassword = scanner.nextInt();

            int decryptedPassword = decrypt(encryptedPassword);
            System.out.println("Decrypted password: " + decryptedPassword);
        }

        private static int encrypt(int password) {
            int[] digits = new int[4];
            int index = 3;
            while (password > 0 && index >= 0) {
                digits[index] = password % 10;
                password /= 10;
                index--;
            }

            for (int i = 0; i < 4; i += 2) {
                int temp = digits[i];
                digits[i] = digits[i + 1];
                digits[i + 1] = temp;
            }

            for (int i = 0; i < 4; i++) {
                digits[i] = (digits[i] + 5) % 10;
                digits[i] = (digits[i] * 2) % 10;
            }

            int encrypted = 0;
            for (int i = 0; i < 4; i++) {
                encrypted = encrypted * 10 + digits[i];
            }

            return encrypted;
        }

        private static int decrypt(int encryptedPassword) {
            int[] digits = new int[4];
            int index = 3;
            while (encryptedPassword > 0 && index >= 0) {
                digits[index] = encryptedPassword % 10;
                encryptedPassword /= 10;
                index--;
            }

            for (int i = 0; i < 4; i++) {
                digits[i] = (digits[i] + 5) % 10;
                digits[i] = (digits[i] * 2) % 10;
            }

            for (int i = 0; i < 2; i++) {
                int temp = digits[i];
                digits[i] = digits[i + 1];
                digits[i + 1] = temp;
            }

            int decrypted = 0;
            for (int i = 0; i < 4; i++) {
                decrypted = decrypted * 10 + digits[i];
            }

            return decrypted;
        }
    }



