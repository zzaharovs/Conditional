package ru.netology.conditional.profile;

public class ProdProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }

}
