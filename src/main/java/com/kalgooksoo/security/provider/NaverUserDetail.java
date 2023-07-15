package com.kalgooksoo.security.provider;

import java.util.Map;

public class NaverUserDetail implements OAuth2UserDetail {

    private Map<String, Object> attributes;

    public NaverUserDetail(Map<String, Object> attributes) {
        this.attributes = (Map<String, Object>) attributes.get("response");
    }

    @Override
    public String getProviderId() {
        return (String) this.attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "naver";
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
