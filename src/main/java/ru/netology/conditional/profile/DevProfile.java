package ru.netology.conditional.profile;

public class DevProfile implements SystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is developer";
    }
}
