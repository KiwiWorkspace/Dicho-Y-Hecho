package com.dichoyhecho.dichoyhecho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;
import java.util.Locale;

@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {

    //Usamos localResolve para la preferencia de idioma
    @Bean
    public LocaleResolver localeResolver() {
        /*Usamos cookieLocaleResolver para que se persista el idioma aun si el usuario cierra el navegador
                (se le añadio el "SAD_LANG", porque la funcion dejo de existir al parecer) y era para el nombre
        de la cookie en el navegador (era el 2) */
        CookieLocaleResolver resolver = new CookieLocaleResolver("SAD_LANG");

        // 1. Establecemos el ingles como idioma por defecto
        resolver.setDefaultLocale(Locale.ENGLISH);

        // 3.- Duración de la cookie (30 días btw)
        resolver.setCookieMaxAge(Duration.ofDays(30));

        // 4) Solo accesible por http (capa de seguridad)
        resolver.setCookieHttpOnly(true);
        return resolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        //Parametro que buscara en la url
        interceptor.setParamName("lang");
        return interceptor;
    }

    /* Registramos el interceptor dentro del ciclo de ejecución de Spring MVC
    para que evalue las rutas url de la plataforma ayiyi
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}