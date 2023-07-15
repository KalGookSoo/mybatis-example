package com.kalgooksoo.security.provider;


import java.util.Map;

public class FacebookUserDetail implements OAuth2UserDetail {

    private Map<String, Object> attributes;

    public FacebookUserDetail(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return (String) this.attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "facebook";
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
