package com.kalgooksoo.security.provider;

public interface OAuth2UserDetail {
    public String getProviderId();
    public String getProvider();
    public String getEmail();
    public String getName();
}
