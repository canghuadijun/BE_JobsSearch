package com.example.JobsSearch.model;

import com.example.JobsSearch.model.util.OrganizationType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hiring_organization")
public class HiringOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    private String phoneNumber;

    private String website;

    private String address;

    private String introduction;

    @Enumerated(EnumType.STRING)
    private OrganizationType organizationType;

    public HiringOrganization() {
    }

    public HiringOrganization(User user) {
        this.user = user;
    }
    public HiringOrganization(User user, String name, String phoneNumber, String website, String address, String introduction, OrganizationType organizationType) {
        this.user = user;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.address = address;
        this.introduction = introduction;
        this.organizationType = organizationType;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public String getEmail() {
        return user.getEmail();
    }

    @Transient
    public void setEmail(String email) {
        user.setEmail(email);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationType) {
        this.organizationType = organizationType;
    }
}
