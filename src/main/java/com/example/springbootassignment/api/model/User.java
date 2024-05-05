//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Getter
//@Setter
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userId;
//
//    @Column(unique = true)
//    private String userName;
//    private String userPassword;
//    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    public User() {}
//
//    public User(String userName, String userPassword) {
//        this.userName = userName;
//        this.userPassword = encryptUserPassword(userPassword);
//    }
//
//    // Encrypt the password
//    private String encryptUserPassword(String password) {
//        return encoder.encode(password);
//    }
//
//    public static Boolean isAPasswordMatch(String secret, String encodedString) {
//        return encoder.matches(secret, encodedString);
//    }
//}