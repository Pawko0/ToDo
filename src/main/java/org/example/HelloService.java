package org.example;

import java.util.Optional;

public class HelloService {
    public static final String FALLBACK_NAME = "world";
    public static final Lang FALLBACK_LANG = new Lang(1L, "Hello", "en");

    private LangRepository repository;

    HelloService(){
        this(new LangRepository());
    }

    public HelloService(LangRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name) {
        return prepareGreeting(name, FALLBACK_LANG.getId());
    }

    String prepareGreeting(String name, Long langId){
        var welcomeMSG = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMSG + " " + nameToWelcome + "!";
    }
}
