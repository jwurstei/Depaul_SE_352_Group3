package car_reservation.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index"; // Returns the index.html template for the homepage
    }

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("userForm", new User()); // Add an empty UserForm to the model
        model.addAttribute("errorMessage", null); // Initialize error message as null
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
    try {
        if (bindingResult.hasErrors()) {
            // If there are validation errors, return to the registration page with error messages
            return "register";
        }

        // Attempt to register the user
        userService.registerNewUser(user);

        // Set a success message in the model
        model.addAttribute("successMessage", "Registration successful! You can now log in.");

        // Redirect to the login page after successful registration
        return "redirect:/login";
    } catch (IllegalArgumentException e) {
        // Catch any exceptions and set the error message in the model
        model.addAttribute("errorMessage", e.getMessage());
        return "register"; // Return to the registration page with the error message
    }
}

}
