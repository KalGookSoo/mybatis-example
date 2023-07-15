package com.kalgooksoo.security.provider;


import java.util.Map;

public class GoogleUserDetail implements OAuth2UserDetail {

    private Map<String, Object> attributes;

    public GoogleUserDetail(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return (String) this.attributes.get("sub");
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getEmail() {
        return (String) this.attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) this.attributes.get("name");
    }
}
