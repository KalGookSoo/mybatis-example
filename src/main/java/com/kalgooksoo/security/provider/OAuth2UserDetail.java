package com.kalgooksoo.security.provider;

public interface OAuth2UserDetail {
    String getProviderId();
    String getProvider();
    String getEmail();
    String getName();
}
