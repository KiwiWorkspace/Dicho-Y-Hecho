        package com.dichoyhecho.dichoyhecho.controller;

        import com.dichoyhecho.dichoyhecho.entity.Comments;
        import com.dichoyhecho.dichoyhecho.entity.Users;
        import com.dichoyhecho.dichoyhecho.repository.CommentRepository;
        import com.dichoyhecho.dichoyhecho.repository.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;

        import java.security.Principal;
        import java.util.List;

        @Controller
        public class HomeController {

            @Autowired
            private CommentRepository commentRepository;

            @Autowired
            private UserRepository userRepository;

            @GetMapping("/login")
            public String login() {
                return "login";
            }

            @GetMapping("/home")
            public String home(Model model, Principal principal) {

                Users user = userRepository.findByUserHandle(principal.getName()).orElse(null);

                model.addAttribute("user", user);
                model.addAttribute("username", principal.getName());
                return "home";
            }

            @GetMapping("/zona/{id}")
            public String verZona(@PathVariable("id") Integer id, Model model, Principal principal) {

                Users user = userRepository.findByUserHandle(principal.getName()).orElse(null);
                model.addAttribute("user", user);

                model.addAttribute("username", principal.getName());
                List<Comments> comentarios = commentRepository.findByIdZoneOrderByCommentDateAsc(id);
                model.addAttribute("allComments", comentarios);
                model.addAttribute("zonaActual", id);
                return "home";
            }

            @GetMapping("/")
            public String redirectToHome() {
                return "redirect:/home";
            }
        }